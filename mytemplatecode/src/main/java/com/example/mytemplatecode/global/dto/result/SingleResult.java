package com.example.mytemplatecode.global.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SingleResult<T>{
    @Schema(description = "단일 데이터")
    private T data;
}
