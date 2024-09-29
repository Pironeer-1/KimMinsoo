package com.example.mytemplatecode.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;


public record MemberCreateRequest (

    @NotBlank
    @Schema(description = "회원 id", example = "id")
    String memberId,

    @NotBlank
    @Schema(description = "회원 password", example = "pwd")
    String password,

    @NotBlank
    @Schema(description = "회원 name", example = "KimMinsoo")
    String name
){
}
