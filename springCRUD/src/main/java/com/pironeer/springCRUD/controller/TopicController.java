package com.pironeer.springCRUD.controller;

import com.pironeer.springCRUD.dto.request.TopicUpdateRequest;
import com.pironeer.springCRUD.dto.response.TopicResponse;
import com.pironeer.springCRUD.dto.request.TopicCreateRequest;
import com.pironeer.springCRUD.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Controller
// Django의 view와 유사
// Django는 view 내부에 메서드를 직접 정의하지만, Spring은 그렇지 않다
// 보통 Service 디렉토리를 파서 거기다가 모든 로직을 정리하고, Controller에서는 갖다 쓰기만 함
// 코드 간결성을 위함

@RestController
@RequiredArgsConstructor
@Tag(name = "게시물(Topic)")
@RequestMapping("/api/topic")
public class TopicController    {
    private final TopicService topicService;

    @PostMapping
    @Operation(summary = "게시물 작성")
    public ResponseEntity<?> create(@Valid @RequestBody TopicCreateRequest request) {
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{topicId}")
    @Operation(summary = "게시물 단건 조회")
    public ResponseEntity<TopicResponse> read(@Valid @PathVariable("topicId") Long id) {
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public ResponseEntity<List<TopicResponse>> readAll() {
        List<TopicResponse> responses = topicService.findAll();
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping()
    @Operation(summary = "게시물 수정")
    public ResponseEntity<TopicResponse> update(@Valid @RequestBody TopicUpdateRequest request) {
        TopicResponse response = topicService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{topicId}")
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<?> delete(@Valid @PathVariable("topicId") Long id) {
        topicService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
