package com.soo.user.controller;

import com.soo.user.domain.Member;
import com.soo.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// spring container 내부에 bean으로 관리됨
@Controller
public class MemberController {

    // 여러개 생성할 필요가 없어서 문제가 있음
//    private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    // @Autowired가 있으면 spring이 container에 있는 MemberService를 가져다 연결을 시킴
    // DI
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; // home 화면으로 보내기
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
