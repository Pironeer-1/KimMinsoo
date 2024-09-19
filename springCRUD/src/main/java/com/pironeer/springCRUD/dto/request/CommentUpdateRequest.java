package com.pironeer.springCRUD.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CommentUpdateRequest (
        @Schema(
                description = "수정된 댓글", example = "댓글 수정입니다")
        String content) {

}
