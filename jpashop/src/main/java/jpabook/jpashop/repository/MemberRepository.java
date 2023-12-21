package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    //자동으로 bean 관리 가능

    //jpa 표준 어노테이션
    @Autowired
    private final EntityManager em;

    public void save(Member member){
        em.persist(member); //jpa가 저장하는 로직 //
    }

    public Member findOne(Long id){
        return em.find(Member.class, id); //ip값 넘기면 찾아서 반환
    }

    public List<Member> findAll(){
        //전부 찾는 메소드
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
        //jpql(Entity 객체에 대한 쿼리-sql은 테이블), 뒤에는 반환타입
        //리스트로 반환해줌
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class) //parameter 바인딩
                .setParameter("name", name)
                .getResultList();
    }


}
