package com.example.demo;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.Memberservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바 코드로 직접 스프링 빈 등록하기

@Configuration
public class SpringConfig {

    @Bean
    public Memberservice memberService(){
        return new Memberservice(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
