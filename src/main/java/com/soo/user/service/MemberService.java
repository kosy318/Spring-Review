package com.soo.user.service;

import com.soo.user.domain.Member;
import com.soo.user.repository.MemberRepository;
import com.soo.user.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // DI
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return 전체 회원 리스트
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 멤버 아이디에 해당하는 Member를 리턴해주는 함수
     * @param memberId: 멤버 아이디 값
     * @return 멤버 아이디에 해당하는 Member, 없으면 null
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
