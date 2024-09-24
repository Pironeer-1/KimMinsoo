package com.example.mytemplatecode.member.controller;

import com.example.mytemplatecode.global.dto.response.JwtTokenSet;
import com.example.mytemplatecode.global.dto.response.SuccessResponse;
import com.example.mytemplatecode.global.dto.result.SingleResult;
import com.example.mytemplatecode.member.dto.request.MemberCreateRequest;
import com.example.mytemplatecode.member.dto.request.MemberLoginRequest;
import com.example.mytemplatecode.member.dto.request.MemberUpdateRequest;
import com.example.mytemplatecode.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "회원(Member)")
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원가입")
    public SuccessResponse<SingleResult<JwtTokenSet>> register (@Valid @RequestBody MemberCreateRequest request) {
        SingleResult<JwtTokenSet> result = memberService.register(request);
        return SuccessResponse.ok(result);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public SuccessResponse<SingleResult<JwtTokenSet>> login (@Valid @RequestBody MemberLoginRequest request) {
        SingleResult<JwtTokenSet> result = memberService.login(request);
        return SuccessResponse.ok(result);
    }

    @PutMapping
    @Operation(summary = "유저 정보 수정")
    public SuccessResponse<SingleResult<JwtTokenSet>> update (@Valid @RequestBody MemberUpdateRequest request) {
        SingleResult<JwtTokenSet> result = memberService.update(request);
        return SuccessResponse.ok(result);
    }

//    @DeleteMapping
//    @Operation(summary = "회원 탈퇴")
//    public SuccessResponse<void> delete() {
//        memberService.delete();
//        return SuccessResponse.ok();
//    }
}
