package com.soo.shop.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
