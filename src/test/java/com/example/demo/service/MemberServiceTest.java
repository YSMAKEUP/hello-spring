package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import  com.example.demo.service.Memberservice;

public class MemberServiceTest {



    Memberservice memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
//        memberService = new Memberservice();
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearstore();
    }



    @Test
    void 회원가입(){
        //given (상황 세팅) -> 테스트에 필요한 데이터,객체 생성 , 초기상태
        Member member = new Member();
        member.setName("hello");

        //when(행동) -> 실제로 검증하고 싶은 행위
        Long saveId = memberService.join(member);

        //then(검증) --> 결과 검증
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외(){

        //given (상황 세팅) -> 테스트에 필요한 데이터,객체 생성 , 초기상태
        Member member1 = new Member();
        member1.setName("변우석");

        Member member2 = new Member();
        member2. setName("변우석");

        //when(행동) -> 실제로 검증하고 싶은 행위
        //중복 회원인지 아닌지
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class , () -> memberService. join(member2));
        assertThat( e.getMessage()).isEqualTo("이미 있는데?");





        //        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


        //then(검증) --> 결과 검증




    }
}
