package com.soo.shop.discount;

import com.soo.shop.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
    
}
