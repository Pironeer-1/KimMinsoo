package com.example.mytemplatecode.board.dto.response;

import com.example.mytemplatecode.board.entity.Board;

import java.time.LocalDateTime;

public record BoardResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
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
