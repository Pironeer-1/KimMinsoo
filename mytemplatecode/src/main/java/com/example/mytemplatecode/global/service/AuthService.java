package com.example.mytemplatecode.global.service;

import com.example.mytemplatecode.global.dto.response.JwtTokenSet;
import com.example.mytemplatecode.global.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final Set<String> tokenBlackList = new HashSet<>();

    public JwtTokenSet generateToken(Long userIdx) {
        String token = jwtUtil.createToken(userIdx);

        JwtTokenSet jwtTokenSet = JwtTokenSet.builder()
                .token(token)
                .build();

        return jwtTokenSet;
    }

    // update, delete 시 토큰 유효성 확인
    public boolean isTokenValid(String token) {
        if (tokenBlackList.contains(token)) {
            return false;
        }

        return jwtUtil.isValidToken(token);
    }

    // 회원 탈퇴 시 토큰 비활성화
    public void invalidateToken(Long userIdx) {
        String token = jwtUtil.createToken(userIdx);
        tokenBlackList.add(token);
    }

    // 로그아웃
    public void logout(String token) {
        if (jwtUtil.isValidToken(token)) {
            tokenBlackList.add(token);
        }
    }
}
