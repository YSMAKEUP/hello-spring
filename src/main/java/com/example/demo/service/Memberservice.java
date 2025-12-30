package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class Memberservice {
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    public Long join (Member member){
        //같은 이름이 있는지 중복 회원 x
        validdateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validdateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                        throw new IllegalAccessException("이미 있는데?");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
