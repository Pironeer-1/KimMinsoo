package com.example.mytemplatecode.global.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ExceptionResult {

    @Builder
    @Getter
    @Setter
    public static class ServerErrorData {
        @Schema(description = "오류 발생 클래스", example = "org.example.XX")
        private String errorClass;

        @Schema(description = "오류 메시지")
        private String errorMessage;
    }
}
