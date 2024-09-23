package com.example.mytemplatecode.board.controller;

import com.example.mytemplatecode.board.dto.request.BoardCreateRequest;
import com.example.mytemplatecode.board.dto.request.BoardUpdateRequest;
import com.example.mytemplatecode.board.dto.response.BoardResponse;
import com.example.mytemplatecode.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody BoardCreateRequest request) {
        boardService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> read(@PathVariable("boardId") Long id) {
        BoardResponse response = boardService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping()
    public ResponseEntity<?> readAll() {
        List<BoardResponse> responses = boardService.findAll();
        return ResponseEntity.ok().body(responses);

    }

    // 클라이언트의 요청을 파라미터로 받아서, 일정한 형식을 가진 응답 객체에 담아서 리턴
    @PutMapping
    public ResponseEntity<?> update(@RequestBody BoardUpdateRequest request) {
        BoardResponse response = boardService.update(request);
        return ResponseEntity.ok().body(response);
    }
}
