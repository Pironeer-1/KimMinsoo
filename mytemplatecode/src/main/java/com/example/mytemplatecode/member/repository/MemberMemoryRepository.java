package com.example.mytemplatecode.member.repository;

import com.example.mytemplatecode.member.entity.Member;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberMemoryRepository implements MemberRepository {

    private final AtomicLong memberIdxGenerator = new AtomicLong(0);
    private final Map<Long, Member> memberMap = new HashMap<>();

    @Override
    // Create member
    public Member create (Member member) {
        Long id = memberIdxGenerator.incrementAndGet();
        member.setId(id);
        memberMap.put(id, member);
        return member;
    }

    @Override
    // Read by id
    public Optional<Member> findById(Long id) {
        Assert.notNull(id, "ID must not be null");
        return Optional.ofNullable(memberMap.get(id));
    }

    @Override
    // Read by memberId
    public Optional<Member> findByMemberId(String memberId) {
        return memberMap.values().stream()
                .filter(data -> data.getMemberId().equals(memberId))
                .findAny();
    }

    @Override
    // Check member by memberId
    public boolean existByMemberId(String memberId) {
        return memberMap.values().stream()
                .anyMatch(data -> data.getMemberId().equals(memberId));
    }

    @Override
    // Update member
    public Member update (Member member) {
        memberMap.replace(member.getId(), member);
        return member;
    }

    @Override
    // Delete member
    public void delete (Member member) {
        memberMap.remove(member.getId());
    }
}
