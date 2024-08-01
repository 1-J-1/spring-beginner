package spring.membership.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.membership.domain.Member;
import spring.membership.repository.MemberRepository;
import spring.membership.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.cleanStore();
    }

    @Test
    public void join() {
        Member member = new Member();
        member.setName("testing");
        Long memberId = memberService.join(member);

        Member result = memberService.findOne(memberId).get();
        Assertions.assertThat(member.getId()).isEqualTo(result.getId());
    }

    @Test
    public void validateMember(){
        Member member1 = new Member();
        member1.setName("t1");

        Member member2 = new Member();
        member2.setName("t1");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class,()->memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("this name is already taken");

//        try{
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("this name is already taken");
//        }
    }
}
