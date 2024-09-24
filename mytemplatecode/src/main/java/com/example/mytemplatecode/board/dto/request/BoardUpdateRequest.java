package com.example.mytemplatecode.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record BoardUpdateRequest (
        @NotNull
        @Schema(
                description = "게시글 ID",
                example = "1"
        )
        Long id,
        @Schema(
                description = "수정된 게시글 제목",
                example = "수정된 제목입니다"
        )
        String title,
        @Schema(
                description = "수정된 게시글 내용",
                example = "수정된 내용입니다"
        )
        String content) {

}