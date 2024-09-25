package com.example.mytemplatecode.member.controller;

import com.example.mytemplatecode.global.dto.response.JwtTokenSet;
import com.example.mytemplatecode.global.dto.response.SuccessResponse;
import com.example.mytemplatecode.global.dto.result.SingleResult;
import com.example.mytemplatecode.member.dto.request.*;
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
    public SuccessResponse<SingleResult<JwtTokenSet>> register(@Valid @RequestBody MemberCreateRequest request) {
        SingleResult<JwtTokenSet> result = memberService.register(request);
        return SuccessResponse.ok(result);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public SuccessResponse<SingleResult<JwtTokenSet>> login(@Valid @RequestBody MemberLoginRequest request) {
        SingleResult<JwtTokenSet> result = memberService.login(request);
        return SuccessResponse.ok(result);
    }

    @PutMapping
    @Operation(summary = "유저 정보 수정")
    public SuccessResponse<SingleResult<JwtTokenSet>> update(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody MemberUpdateRequest request) {
        // "Bearer " 제거
        token = token.substring(7);
        SingleResult<JwtTokenSet> result = memberService.update(token, request);
        return SuccessResponse.ok(result);
    }

    @DeleteMapping
    @Operation(summary = "회원 탈퇴")
    public SuccessResponse<Void> delete(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody MemberDeleteRequest request) {
        // "Bearer " 제거
        token = token.substring(7);
        memberService.delete(token, request);
        return SuccessResponse.ok();
    }
}