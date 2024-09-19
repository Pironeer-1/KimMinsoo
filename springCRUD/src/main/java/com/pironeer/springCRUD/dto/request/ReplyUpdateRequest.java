package com.pironeer.springCRUD.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record ReplyUpdateRequest(
        @Schema(
                description = "대댓글 수정", example = "대댓글 수정입니다.")
        String content) {
}
