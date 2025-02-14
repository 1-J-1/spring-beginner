package spring.membership.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring.membership.domain.Member;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.cleanStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("String");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("S1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("S2");
        repository.save(member2);

        Member result = repository.findByName("S1").get();

        Assertions.assertThat(result).isEqualTo(member1);
        Assertions.assertThat(member1).isNotEqualTo(member2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("S1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("S2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
