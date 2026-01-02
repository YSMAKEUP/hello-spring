package com.example.demo.repository;

import com.example.demo.domain.Member2;

import java.util.List;
import java.util.Optional;

public interface MemberRepository2 {
    Member2 save(Member2 member);
    Optional<Member2> findById(Long id);
    Optional<Member2> findByName(String name);
    List<Member2>findAll();


}
