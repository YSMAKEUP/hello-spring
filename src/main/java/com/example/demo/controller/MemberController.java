package com.example.demo.controller;
import org.springframework.ui.Model;


import com.example.demo.domain.Member;
import com.example.demo.service.Memberservice;
// 음
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final Memberservice memberservice;

    @Autowired
    public MemberController(Memberservice memberservice){
        this.memberservice = memberservice;
    }

    @GetMapping("/members/new")

    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(Memberform form){

        Member member = new Member();
        member.setName(form.getName());

        memberservice.join(member);
        System.out.println("가입자 이름 :  " +member.getName());

        return "redirect:/";


    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberservice.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
