package com.example.mytemplatecode.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record BoardCreateRequest (
        @NotNull
        @Schema(
                description = "게시글 제목",
                example = "제목입니다")
        String title,

        @Schema(
                description = "게시글 내용",
                example = "내용입니다")
        String content){

}