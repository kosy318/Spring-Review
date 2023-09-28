package com.soo.user.repository;

import com.soo.user.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    // 동시성 문제로 ConcurrentHashMap을 써야하는데 예제이므로 그냥 Hashmap을 사용
    private static Map<Long, Member> store = new HashMap<>();
    // 동시성 문제로 AtomicLong같은 것을 사용해야하는데 예제이므로....
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 결과가 없는 경우 null을 리턴하도록 Optional 사용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
