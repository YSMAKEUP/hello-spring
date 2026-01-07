package com.example.demo;

import com.example.demo.repository.JdbcTemplateMemberRepository;
import com.example.demo.service.Memberservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//자바 코드로 직접 스프링 빈 등록하기

@Configuration
public class SpringConfig{
        private final DataSource dataSource;

        public SpringConfig(DataSource dataSource){
            this.dataSource = dataSource;
        }

    @Bean
    public Memberservice memberService(){
        return new Memberservice(memberRepository());
    }

    @Bean
    public JdbcTemplateMemberRepository memberRepository(){
//        return new MemoryMemberRepository();
         return new JdbcTemplateMemberRepository(dataSource);
    }

}
