package com.example.demo.repository;


import com.example.demo.domain.Member2;

import  java.util.*;


public class MemoryMemberRepository2  implements MemberRepository2 {

    private static Map<Long, Member2> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member2 save(Member2 member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;

    }

    @Override
    public Optional<Member2> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member2> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member2> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearstore() {
        store.clear();
    }

}



