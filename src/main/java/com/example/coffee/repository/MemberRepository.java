package com.example.coffee.repository;

import com.example.coffee.domain.Grade;
import com.example.coffee.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface MemberRepository{
    public Optional<Member> findById(String userId);

    public List<Member> findByGrade(Grade grade);

    public List<Member> findAllMember();

    public void save(Member member);

    public void deleteAll();
}
