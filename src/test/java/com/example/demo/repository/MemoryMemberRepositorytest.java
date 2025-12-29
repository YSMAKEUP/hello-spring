package com.example.demo.repository;


import com.example.demo.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class MemoryMemberRepositorytest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member  member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(result, null);
      }
}
