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

    public Board update(BoardUpdateRequest request) {
        updateTitle(request.title());
        updateContent(request.content());
        this.updateAt = LocalDateTime.now();
        return this;
    }

    // 인스턴스 메서드로 변경, 객체에 직접 접근
    private void updateTitle(String title) {
        if (title != null && !title.isBlank()){
            this.title = title;
        }
    }

    private void updateContent(String content) {
        if (content != null && !content.isBlank()){
            this.content = content;
        }
    }
}
