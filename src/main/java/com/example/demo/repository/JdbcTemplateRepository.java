package com. example.demo.repository;
import com.example.demo.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplateMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate; //jdbc를 만들기 위해서 접근제어 방식을 설정

    public JdbcTemplateMemberRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);//
    }

    @Override
    public  Member save(Member member){
        SimpleJdbcInsert JdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id"); //멤버 테이블에 데이터를 넣고 ,값을 넣은 후 id값을 돌려받겠다.

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name",member.getName()); //컬럼 이름과 멤버의 가져온 이름을 매칭.

        Number key = jdbcTemplate.executeAndReturnKey(new MapSqlParameterSource(parameters));//sql문을 통해서 피라미터를 받아 sql문으로 반환하여 number key로 반환.
        member.setId(key.longValue()); //키 값을 id 값으로 가져온다?
        return member;
    }

    @Override
    public Optional<Member>findById(Long id){
        List<Member> result = jdbcTemplate.query("select * from member where id = ?",memberRowMapper(),id);
            return result.stream().findAny();

    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
    }

    @Override
    public  Optional<Member> findByName (String name){
        List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(),name);
        return  result.stream().findAny();
    }
     private  RowMapper<Member> memberRowMapper(){
        return ((rs, rowNum) -> {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                return member;
        };

     }
}
