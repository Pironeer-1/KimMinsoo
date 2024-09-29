package com.example.mytemplatecode.member.repository;

import com.example.mytemplatecode.member.entity.Member;

import java.util.Optional;

public interface MemberRepository {

    // Create member
    Member create(Member member);

    // Read by id
    Optional<Member> findById(Long id);

    // Read by memberId
    Optional<Member> findByMemberId(String memberId);

    // Check member by memberId
    boolean existByMemberId(String memberId);

    // Update member
    Member update(Member member);

    // Delete member
    void delete(Member member);
}