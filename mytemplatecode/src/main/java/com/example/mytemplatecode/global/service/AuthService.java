package com.example.mytemplatecode.global.service;

import com.example.mytemplatecode.global.dto.response.JwtTokenSet;
import com.example.mytemplatecode.global.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
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
        return JwtTokenSet.builder().token(token).build();
    }

    // update, delete 시 토큰 유효성 확인
    public boolean isTokenValid(String token) {
        if (tokenBlackList.contains(token)) {
            return false;
        }
        return jwtUtil.isValidToken(token) && !jwtUtil.isExpired(token);

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

    // 토큰 블랙리스트 관리
    // 1시간마다 클린업
    private static final long ONE_HOUR = 60 * 60 * 1000;
    @Scheduled(fixedRate = ONE_HOUR)
    public void clearTokenBlackList() {
        tokenBlackList.clear();
    }
}
