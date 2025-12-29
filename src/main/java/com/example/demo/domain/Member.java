package com.example.demo.domain;

public class Member {


     //회원의 id, name이 필요하기 때문에
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id =id;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
