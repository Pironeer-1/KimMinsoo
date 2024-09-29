package com.example.mytemplatecode.board.controller;

import com.example.mytemplatecode.board.dto.request.BoardCreateRequest;
import com.example.mytemplatecode.board.dto.request.BoardUpdateRequest;
import com.example.mytemplatecode.board.dto.response.BoardResponse;
import com.example.mytemplatecode.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "게시글(Board)")
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping()
    @Operation(summary = "게시글 생성")
    public ResponseEntity<?> create(@Valid @RequestBody BoardCreateRequest request) {
        boardService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{boardId}")
    @Operation(summary = "게시글 단건 조회")
    public ResponseEntity<?> read(@PathVariable("boardId") Long id) {
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping()
    @Operation(summary = "게시글 전체 조회")
    public ResponseEntity<?> readAll() {
        List<BoardResponse> responses = boardService.findAll();
        return ResponseEntity.ok().body(responses);

    }

    // 클라이언트의 요청을 파라미터로 받아서, 일정한 형식을 가진 응답 객체에 담아서 리턴
    @PutMapping
    @Operation(summary = "게시글 수정")
    public ResponseEntity<?> update(@Valid @RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{boardId}")
    @Operation(summary = "게시글 삭제")
    public ResponseEntity<?> delete(@PathVariable("boardId") Long id) {
        boardService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
