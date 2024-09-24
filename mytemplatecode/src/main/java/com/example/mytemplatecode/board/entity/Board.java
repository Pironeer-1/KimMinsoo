package com.example.mytemplatecode.board.entity;

import com.example.mytemplatecode.board.dto.request.BoardUpdateRequest;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Board {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @Builder
    public Board(
            Long id,
            String title,
            String content,
            LocalDateTime createAt,
            LocalDateTime updateAt
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    // 메서드를 따로 만들지 않고 직접 객체의 필드값들에 접근하여 수정
    public Board update(BoardUpdateRequest request) {
        this.title = request.title();
        this.content = request.content();
        this.updateAt = LocalDateTime.now();
        return this;
    }
}
