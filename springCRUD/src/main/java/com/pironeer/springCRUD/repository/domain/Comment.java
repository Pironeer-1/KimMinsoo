package com.pironeer.springCRUD.repository.domain;

import com.pironeer.springCRUD.dto.request.CommentUpdateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private Long topicId; // 어떤 게시글의 댓글인지
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Comment(Long id, Long topicId, String content, LocalDateTime createdAt) {
        this.id = id;
        this.topicId = topicId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment update(CommentUpdateRequest request) {
        this.content = request.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }


}
