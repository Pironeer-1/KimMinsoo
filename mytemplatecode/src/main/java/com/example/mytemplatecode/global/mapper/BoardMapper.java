package com.example.mytemplatecode.global.mapper;

import com.example.mytemplatecode.board.dto.request.BoardCreateRequest;
import com.example.mytemplatecode.board.entity.Board;

import java.time.LocalDateTime;

public class BoardMapper {
    public static Board from(BoardCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Board.builder()
                .title(request.title())
                .content(request.content())
                .createAt(now)
                .updateAt(now)
                .build();
    }
}
