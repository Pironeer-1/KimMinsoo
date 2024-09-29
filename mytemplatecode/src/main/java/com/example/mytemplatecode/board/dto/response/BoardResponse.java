package com.example.mytemplatecode.board.dto.response;

import com.example.mytemplatecode.board.entity.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardResponse(
        @NotNull
        @Schema(
                description = "게시글 ID",
                example = "1")
        Long id,
        @NotBlank
        @Schema(
                description = "게시글 제목",
                example = "제목입니다")
        String title,
        @Schema(
                description = "게시글 내용",
                example = "내용입니다")
        String content,
        @NotNull
        @Schema(
                description = "게시글 작성 시간",
                example = "2024-09-24 13:30:54")
                LocalDateTime createdAt,
        @NotNull
        @Schema(
                description = "게시글 수정 시간",
                example = "2024-09-24 13:30:54")
        LocalDateTime updatedAt) {
    public static BoardResponse of (Board board) {
        // Builder는 내부적으로 항상 새로운 객체를 생성한다
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreateAt())
                .updatedAt(board.getUpdateAt())
                .build();
    }
}

