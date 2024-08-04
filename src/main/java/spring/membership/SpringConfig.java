package spring.membership;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.membership.repository.JpaMemberRepository;
import spring.membership.repository.MemberRepository;
import spring.membership.repository.MemoryMemberRepository;
import spring.membership.service.MemberService;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

//        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }

    @Bean
    public TimeTraceApp timeTraceAop() {
        return new TimeTraceApp();
    }

}
