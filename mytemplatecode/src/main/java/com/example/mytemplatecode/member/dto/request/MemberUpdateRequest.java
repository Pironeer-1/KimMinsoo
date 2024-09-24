package com.example.mytemplatecode.member.dto.request;

import com.example.mytemplatecode.global.exception.CustomException;
import com.example.mytemplatecode.global.exception.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;

public record MemberUpdateRequest(

        @Schema(description = "수정할 회원 id", example = "id")
        String memberId,

        @Schema(description = "수정할 password", example = "pwd")
        String password,

        @Schema(description = "수정할 회원 이름", example = "KimMinsoo")
        String name

) {
    public MemberUpdateRequest {
        // 필드 셋 중 하나는 NotNull
        if (memberId == null && password == null && name == null) {
            throw new CustomException(ErrorCode.INVALID_PARAMETER);
        }
    }

    // 각 필드에 대한 유효성 검사 메서드
    public boolean hasMemberId() {
        return memberId != null && !memberId.isEmpty();
    }

    public boolean hasPassword() {
        return password != null && !password.isEmpty();
    }

    public boolean hasName() {
        return name != null && !name.isEmpty();
    }
}