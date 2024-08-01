package spring.membership.service;

import spring.membership.domain.Member;
import spring.membership.repository.MemberRepository;
import spring.membership.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){

    }
}
