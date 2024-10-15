package com.example.coffee.service;

import com.example.coffee.domain.Grade;
import com.example.coffee.domain.Member;
import com.example.coffee.exception.NotFoundMemberException;
import com.example.coffee.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.coffee.exception.ErrorCode.NOT_FOUND_USER_ID;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member findMember(String id) {
        return memberRepository.findById(id).orElseThrow(() -> new NotFoundMemberException(NOT_FOUND_USER_ID.getMessage(), NOT_FOUND_USER_ID));
    }
    public List<Member> findAllMember(){
        return memberRepository.findAllMember();
    }

    public List<Member> findByGrade(Grade grade){
        return memberRepository.findByGrade(grade);
    }

    public void saveMember(Member member){
        memberRepository.save(member);
    }

    public void deleteAll(){
        memberRepository.deleteAll();
    }

}
