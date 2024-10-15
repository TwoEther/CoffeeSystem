package com.example.coffee.repository;

import com.example.coffee.domain.Grade;
import com.example.coffee.domain.Member;
import com.example.coffee.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.coffee.domain.QMember.member;
@Repository
public class MemberRepositoryImpl implements MemberRepository{
    @PersistenceContext
    private EntityManager em;
    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Member> findById(String userId) {
        List<Member> findMembers = queryFactory.selectFrom(member)
                .where(member.userId.eq(userId))
                .fetch();
        return Optional.ofNullable(findMembers.isEmpty() ? null : findMembers.get(0));
    }

    @Override
    public List<Member> findByGrade(Grade grade) {
        return queryFactory.selectFrom(member)
                        .where(member.grade.eq(grade))
                .fetch();
    }


    @Override
    public List<Member> findAllMember() {
        return queryFactory.selectFrom(member)
                .fetch();
    }

    @Override
    @Transactional
    public void save(Member member) {
        em.persist(member);

    }

    @Transactional
    @Override
    public void deleteAll() {
        /*
            bulk 연산은 영속성과 별개로 db에 바로 Update를 하기 때문에,
            연산 이후 영속성 context와 db 값이 차이가 생김
            영속성 context가 우선순위를 가지기 때문에 bulk연산 이후에는 em.flush() em.clear 수행
         */
        queryFactory.delete(member).execute();
        em.flush();
        em.clear();
    }

}
