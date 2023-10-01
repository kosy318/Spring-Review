package com.soo.shop.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
