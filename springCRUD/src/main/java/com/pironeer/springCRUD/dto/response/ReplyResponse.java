package com.pironeer.springCRUD.dto.response;

import com.pironeer.springCRUD.repository.domain.Reply;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReplyResponse(
        @Schema(
                description = "대댓글 id",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long id,
        @Schema(
                description = "댓글 id",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long commentId,
        @Schema(
                description = "대댓글 내용",
                example = "대댓글 내용입니다",
                type = "String",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String content,
        @Schema(
                description = "대댓글 작성 시간",
                example = "2024-10-13 10:10:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        LocalDateTime createdAt)
{        public static ReplyResponse of(Reply reply) {
                return ReplyResponse.builder()
                        .id(reply.getId())
                        .commentId(reply.getCommentId())
                        .content(reply.getContent())
                        .createdAt(reply.getCreatedAt())
                        .build();
        }
}
