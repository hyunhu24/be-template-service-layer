package com.codestates.member.controller;

import com.codestates.member.dto.MemberPatchDto;
import com.codestates.member.dto.MemberPostDto;
import com.codestates.member.dto.MemberResponseDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v2/members")
@Validated
public class MemberController {
    //null 값이 아니라는거 final
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    //Bean 으로 등록하지 않았을때는 아래 방법 @Component 등록후 위에 방법
//    private final MemberMapper memberMapper = new MemberMapper();

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
//        Member member = new Member();
//        member.setEmail(memberDto.getEmail());
//        member.setName(memberDto.getName());
//        member.setPhone(memberDto.getPhone());

        Member member = memberService.createMember(memberMapper.memberPostDtoToMember(memberDto));
        MemberResponseDto responseDto = memberMapper.memberToMemberResponseDto(member);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);

//        Member member = new Member();
//        member.setName(memberPatchDto.getName());
//        member.setPhone(memberPatchDto.getPhone());
        Member member = memberMapper.memberPatchDtoToMember(memberPatchDto);
        Member memberEntity = memberService.updateMember(member);
        MemberResponseDto responseDto = memberMapper.memberToMemberResponseDto(memberEntity);
        // No need Business logic

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Member member = memberService.findMember(memberId);
        MemberResponseDto responseDto = memberMapper.memberToMemberResponseDto(member);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // No need Business logic
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
        List<MemberResponseDto> responseDtos = members.stream()
                .map(member -> memberMapper.memberToMemberResponseDto(member))
                .collect(Collectors.toList());

//        List<MemberResponseDto> responseDtos = new ArrayList<>();
//        for(Member member: members){
//            MemberResponseDto responseDto = memberMapper.memberToMemberResponseDto(member);
//            responseDtos.add(responseDto);
//        }

        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        System.out.println("# deleted memberId: " + memberId);
        // No need business logic
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 회원 정보는 구현해야 할 실습이 없습니다!
}
