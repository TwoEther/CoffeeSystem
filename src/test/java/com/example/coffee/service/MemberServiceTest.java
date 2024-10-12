package com.example.coffee.service;

import com.example.coffee.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    /*
        UserId : 이메일
     */
    @DisplayName("회원가입시 중복 테스트")
    @Test
    public void 회원가입_중복_테스트() {
        Member member1 = new Member("user1@email.co.kr", "password1");
        memberService.saveMember(member1);

        // 아이디가
        Member member2 = new Member("user1@email.co.kr", "password1");
        memberService.saveMember(member2);

    }
}