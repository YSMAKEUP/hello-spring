package com.example.demo;
import com.example.demo.repository.*;

import com.example.demo.service.Memberservice;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//자바 코드로 직접 스프링 빈 등록하기

@Configuration
public class SpringConfig{
        private final DataSource dataSource;
        private final EntityManager em;

        public SpringConfig(DataSource dataSource, EntityManager em){
            this.dataSource = dataSource;
            this.em = em;
        }

    @Bean
    public Memberservice memberService(){
        return new Memberservice(memberRepository());
    }

    @Bean
    public JdbcTemplateMemberRepository memberRepository(){
////        return new MemoryMemberRepository();
//         return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
