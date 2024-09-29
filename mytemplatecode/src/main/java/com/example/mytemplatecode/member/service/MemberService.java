package com.example.mytemplatecode.member.service;

import com.example.mytemplatecode.global.dto.response.JwtTokenSet;
import com.example.mytemplatecode.global.dto.result.SingleResult;
import com.example.mytemplatecode.global.exception.CustomException;
import com.example.mytemplatecode.global.exception.ErrorCode;
import com.example.mytemplatecode.global.service.AuthService;
import com.example.mytemplatecode.global.service.ResponseService;
import com.example.mytemplatecode.member.dto.request.MemberCreateRequest;
import com.example.mytemplatecode.member.dto.request.MemberDeleteRequest;
import com.example.mytemplatecode.member.dto.request.MemberLoginRequest;
import com.example.mytemplatecode.member.dto.request.MemberUpdateRequest;
import com.example.mytemplatecode.member.entity.Member;
import com.example.mytemplatecode.member.repository.MemberMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMemoryRepository memberMemoryRepository;
    private final AuthService authService;

    private void validateToken(String token) {
        if (!authService.isTokenValid(token)) {
            throw new CustomException(ErrorCode.JWT_ERROR_TOKEN);
        }
    }

    public SingleResult<JwtTokenSet> register (MemberCreateRequest request) {
        if (memberMemoryRepository.existByMemberId(request.memberId())) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }

        Member newMember = Member.builder()
                .memberId(request.memberId())
                .password(request.password())
                .name(request.name())
                .build();

        newMember = memberMemoryRepository.create(newMember);

        JwtTokenSet jwtTokenSet = authService.generateToken(newMember.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }

    public SingleResult<JwtTokenSet> login (MemberLoginRequest request) {
        Member member = memberMemoryRepository.findByMemberId(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        if (!member.getPassword().equals(request.password())) {
            throw new CustomException(ErrorCode.USER_WRONG_PASSWORD);
        }

        JwtTokenSet jwtTokenSet = authService.generateToken(member.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }

    public SingleResult<JwtTokenSet> update(String token, MemberUpdateRequest request) {

        validateToken(token);

        Member member = memberMemoryRepository.findByMemberId(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        if (request.hasMemberId()) {
            member.setMemberId(request.memberId());
        }
        if (request.hasPassword()) {
            member.setPassword(request.password());
        }
        if (request.hasName()) {
            member.setName(request.name());
        }

        // memberId 변경 요청시
        if (request.hasMemberId() && !request.memberId().equals(member.getMemberId())) {
            // Id 중복 확인
            if (memberMemoryRepository.existByMemberId(request.memberId())) {
                throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
            }
            member.setMemberId(request.memberId());
        }

        memberMemoryRepository.update(member);

        JwtTokenSet jwtTokenSet = authService.generateToken(member.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }

    public void logout(String token) {
        authService.logout(token);
    }

    public void delete(String token, MemberDeleteRequest request) {

        validateToken(token);

        Member member = memberMemoryRepository.findByMemberId(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        if (!member.getPassword().equals(request.password())) {
            throw new CustomException(ErrorCode.USER_WRONG_PASSWORD);
        }

        memberMemoryRepository.delete(member);

        authService.invalidateToken(member.getId());
    }
}
