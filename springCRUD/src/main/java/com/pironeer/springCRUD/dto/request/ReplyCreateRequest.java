package com.pironeer.springCRUD.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record ReplyCreateRequest(
        @Schema(
                description = "대댓글 내용", example = "대댓글입니다")
        String content) {

}
