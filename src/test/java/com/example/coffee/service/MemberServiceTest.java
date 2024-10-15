package com.example.coffee.service;

import com.example.coffee.domain.Grade;
import com.example.coffee.domain.Member;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    /*
        UserId : 이메일
     */

    @BeforeEach
    public void setUp(){
        memberService.deleteAll();
        Member member1 = new Member("user1@email.co.kr", "password1", Grade.ADMIN);
        Member member2 = new Member("user2@email.co.kr", "password1", Grade.OWNER);
        Member member3 = new Member("user3@email.co.kr", "password1", Grade.OWNER);
        Member member4 = new Member("user4@email.co.kr", "password1", Grade.ADMIN);
        Member member5 = new Member("user5@email.co.kr", "password1", Grade.ADMIN);

        memberService.saveMember(member1);
        memberService.saveMember(member2);
        memberService.saveMember(member3);
        memberService.saveMember(member4);
        memberService.saveMember(member5);
    }


    @DisplayName("회원가입시 중복 테스트")
    @Test
    public void 회원가입_중복_테스트() {
        Member member = new Member("user1@email.co.kr", "password1");
        assertThrows(DataIntegrityViolationException.class, () -> memberService.saveMember(member));
    }

    @DisplayName("회원 권한에 따른 분리 테스트")
    @Test
    public void 회원_권한에_따른_분리_테스트(){
        List<Member> findAdminGradeMembers = memberService.findByGrade(Grade.OWNER);
        assertThat(findAdminGradeMembers.size() == 2);
    }
}