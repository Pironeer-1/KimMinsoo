package com.pironeer.springCRUD.dto.response;

import com.pironeer.springCRUD.repository.domain.Topic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TopicResponse(
        @Schema(
                description = "게시물 ID",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(
                description = "게시물 제목",
                example = "제목입니다",
                type = "String",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String title,
        @Schema(
                description = "게시물 내용 ",
                example = "내용입니다",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String content,
        @Schema(
                description = "게시물 생성 시간",
                example = "2024-10-10 10:10:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDateTime createdAt,
        @Schema(
                description = "게시물 수정 시간",
                example = "2024-10-13 10:10:00",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDateTime updatedAt) {
    public static TopicResponse of (Topic topic) {
        return TopicResponse.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .content(topic.getContent())
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .build();
    }
}
