package com.example.mytemplatecode.board.dto.response;

import com.example.mytemplatecode.board.entity.Board;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record BoardResponse(
        @Schema(
                description = "게시글 ID",
                example = "1")
        Long id,
        @Schema(
                description = "게시글 제목",
                example = "제목입니다")
        String title,
        @Schema(
                description = "게시글 내용",
                example = "내용입니다")
        String content,
        @Schema(
                description = "게시글 작성 시간",
                example = "2024-09-24 13:30:54")
                LocalDateTime createdAt,
        @Schema(
                description = "게시글 수정 시간",
                example = "2024-09-24 13:30:54")
        LocalDateTime updatedAt) {
    public static BoardResponse of (Board board) {
        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getCreateAt(),
                board.getUpdateAt()
        );
    }
}
