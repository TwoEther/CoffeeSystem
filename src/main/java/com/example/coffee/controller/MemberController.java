package com.example.coffee.controller;

import com.example.coffee.domain.Member;
import com.example.coffee.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/member")
@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<Member> findMember(@RequestParam String userId){
        return ResponseEntity.ok(memberService.findMember(userId));
    }


}
