package com.example.mytemplatecode.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record MemberDeleteRequest(

        @NotNull
        @Schema(description = "계정 삭제 대상 확인을 위한 id")
        String memberId,

        @NotNull
        @Schema(description = "계정 삭제 확인을 위한 비밀번호", example = "currentPwd")
        String password
) {
}
