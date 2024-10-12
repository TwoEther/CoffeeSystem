package com.example.coffee.controller;

import com.example.coffee.domain.Member;
import com.example.coffee.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private MemberService memberService;
    @GetMapping(value = "/member")
    public ResponseEntity<Member> findMember(@RequestParam String userId){
        return ResponseEntity.ok(memberService.findMember(userId));
    }


}
