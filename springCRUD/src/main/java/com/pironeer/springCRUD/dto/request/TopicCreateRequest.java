package com.pironeer.springCRUD.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;


// DTO
// Django의 form과 비슷한 역할
// Django와 달리 response와 request를 따로 정의한다

public record TopicCreateRequest(
    @NotBlank
    @Schema(
            description = "게시물 제목", example = "제목입니다")
    String title,

    @Schema(
            description = "게시물 내용", example = "내용입니다")
    String content) {

    }