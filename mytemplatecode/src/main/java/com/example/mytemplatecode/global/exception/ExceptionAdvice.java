package com.example.mytemplatecode.global.exception;

import com.example.mytemplatecode.global.dto.response.ErrorResponse;
import com.example.mytemplatecode.global.dto.result.ExceptionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static com.example.mytemplatecode.global.exception.ErrorCode.PARAMETER_GRAMMAR_ERROR;
import static com.example.mytemplatecode.global.exception.ErrorCode.PARAMETER_VALIDATION_ERROR;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 등록되지 않은 에러
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ErrorResponse<ExceptionResult.ServerErrorData> handleUntrackedException(Exception e) {
        ExceptionResult.ServerErrorData serverErrorData = ExceptionResult.ServerErrorData.builder()
                .errorClass(e.getClass().toString())
                .errorMessage(e.getMessage())
                .build();
        return ErrorResponse.of(ErrorCode.SERVER_UNTRACKED_ERROR.getErrorCode(), ErrorCode.SERVER_UNTRACKED_ERROR.getMessage(), serverErrorData);
    }

    /**
     * 커스텀 예외
     */
    @ExceptionHandler(CustomException.class)
    public ErrorResponse<?> handleCustomException(CustomException e) {
        return ErrorResponse.of(e.getErrorCode().getErrorCode(), e.getErrorCode().getMessage());
    }

    /**
     * 파라미터 검증 예외
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ErrorResponse<List<ExceptionResult.ParameterErrorData>> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<ExceptionResult.ParameterErrorData> list = new ArrayList<>();

        BindingResult bindingResult = e.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            ExceptionResult.ParameterErrorData parameterData = ExceptionResult.ParameterErrorData.builder()
                    .key(fieldError.getField())
                    .value(fieldError.getRejectedValue() == null ? null : fieldError.getRejectedValue().toString())
                    .reason(fieldError.getDefaultMessage())
                    .build();
            list.add(parameterData);
        }

        return ErrorResponse.of(PARAMETER_VALIDATION_ERROR.getErrorCode(), PARAMETER_VALIDATION_ERROR.getMessage(), list);
    }


    /**
     * 파라미터 문법 예외
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ErrorResponse<String> handleHttpMessageParsingExceptions(HttpMessageNotReadableException e) {
        return ErrorResponse.of(PARAMETER_GRAMMAR_ERROR.getErrorCode(), PARAMETER_GRAMMAR_ERROR.getMessage(), e.getMessage());
    }
}
