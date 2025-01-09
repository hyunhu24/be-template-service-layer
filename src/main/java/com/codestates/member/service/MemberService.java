package com.codestates.member.service;

import com.codestates.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    //postMember
    public Member createMember(Member member){
        //전달받은 member 객체를 Data Access 계층에 전달하여
        //DB 에 저장하고 저장한 Member 객체를 다시 Controller 로 반환

        //일단 저장은 했다 치고
        return member;
    }

    //patchMember
    public Member updateMember(Member member){
        //전달받은 member 객체를 보고 DB 에 있는 원래 회원 정보를 가져와서
        //변경해야 할 부분만 변경한 새로운 MEmber 를 만들고,
        //새로만든 member를 DB 에 저장하고
        //저장한 member 를 반환
        return member;
    }

    //getMember
    public Member findMember(long memberId){
        //DB에 조회했다 치고가 안되니까 더미데이터 만들기
        Member member = new Member(memberId, "test@test.com", "test", "010-1234-5678");

        return member;
    }

    //getMembers
    public List<Member> findMembers(){
        //DB에 조회했다 치고가 안되니까 더미데이터 만들기
        List<Member> members = List.of(
            new Member(1, "test@test.com", "test", "010-1234-5678"),
            new Member(2, "test2@test.com", "test2", "010-2234-5678")
        );

        return members;
    }

    //deleteMember
    public void deleteMember(long memberId){
    }
}
