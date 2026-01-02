package com.example.demo.service;

import com.example.demo.domain.Member2;
import com.example.demo.repository.MemberRepository2;
import com.example.demo.repository.MemoryMemberRepository2;


import java.util.List;
import java.util.Optional;


public class Memberservice2 {
    //MemberRepository은 인터페이스이기 때문에 구현체인 MemoryMemberRepository로 객체를 생성.
    private final MemberRepository2 memberRepository = new MemoryMemberRepository2();

    public Long join(Member2 member){
        validdateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validdateDuplicateMember(Member2 member) {
        memberRepository.findByName(member.getName())
                .ifPresent( member2 -> {
                    try {
                        throw new IllegalAccessException("DLAL");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

    }

    public List<Member2> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member2>findOne (Long memberId){
        return memberRepository.findById(memberId);
    }

}
