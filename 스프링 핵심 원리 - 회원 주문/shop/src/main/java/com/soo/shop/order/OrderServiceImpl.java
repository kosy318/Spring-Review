package com.soo.shop.order;

import com.soo.shop.discount.DiscountPolicy;
import com.soo.shop.discount.FixDiscountPolicy;
import com.soo.shop.member.Member;
import com.soo.shop.member.MemberRepository;
import com.soo.shop.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
