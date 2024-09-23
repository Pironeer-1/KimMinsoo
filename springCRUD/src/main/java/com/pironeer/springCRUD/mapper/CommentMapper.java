package com.pironeer.springCRUD.mapper;

import com.pironeer.springCRUD.dto.request.CommentCreateRequest;
import com.pironeer.springCRUD.repository.domain.Comment;
import java.time.LocalDateTime;


public class CommentMapper {
    public static Comment from(Long topicId, CommentCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Comment.builder()
                .topicId(topicId)
                .content(request.content())
                .createdAt(now)
                .build();
    }         
}

             