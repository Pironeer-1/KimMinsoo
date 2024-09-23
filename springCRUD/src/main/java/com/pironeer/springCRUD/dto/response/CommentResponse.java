package com.pironeer.springCRUD.dto.response;

import com.pironeer.springCRUD.repository.domain.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentResponse(
        @Schema(
                description = "댓글 ID",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long id,

        @Schema(
                description = "댓글이 속한 게시글 ID",
                example = "100",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long topicId,

        @Schema(
                description = "댓글 내용",
                example = "댓글 내용입니다.",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String content,

        @Schema(
                description = "댓글 작성 시간",
                example = "2024-03-15T10:30:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        LocalDateTime createdAt
) {
    public static CommentResponse of(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .topicId(comment.getTopicId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}