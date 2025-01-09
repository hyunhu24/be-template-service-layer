package com.codestates.member.mapper;

import com.codestates.member.entity.Member;
import com.codestates.member.dto.MemberPatchDto;
import com.codestates.member.dto.MemberPostDto;
import com.codestates.member.dto.MemberResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member memberPostDtoToMember(MemberPostDto memberPostDto){
        Member member = new Member();
        member.setEmail(memberPostDto.getEmail());
        member.setName(memberPostDto.getName());
        member.setPhone(memberPostDto.getPhone());

        return member;
    }

    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto){
        Member member = new Member();
        member.setMemberId(memberPatchDto.getMemberId());
        member.setName(memberPatchDto.getName());
        member.setPhone(memberPatchDto.getPhone());

        return member;
    }

    public MemberResponseDto memberToMemberResponseDto(Member member){
        MemberResponseDto memberDto = new MemberResponseDto(
                member.getMemberId(),
                member.getEmail(),
                member.getName(),
                member.getEmail()
        );
        return memberDto;
    }
}
