package com.pironeer.springCRUD.repository.domain;

import com.pironeer.springCRUD.dto.request.ReplyUpdateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reply {
    private Long id;
    private Long commentId; // 어떤 댓글의 대댓글인지
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Reply(Long id, Long commentId, String content, LocalDateTime createdAt) {
        this.id = id;
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Reply update(ReplyUpdateRequest request) {
        this.content = request.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }

}
