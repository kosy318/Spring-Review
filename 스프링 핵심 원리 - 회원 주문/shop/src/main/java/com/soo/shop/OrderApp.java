package com.soo.shop;

import com.soo.shop.member.Grade;
import com.soo.shop.member.Member;
import com.soo.shop.member.MemberService;
import com.soo.shop.member.MemberServiceImpl;
import com.soo.shop.order.Order;
import com.soo.shop.order.OrderService;
import com.soo.shop.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(order);
    }

}
