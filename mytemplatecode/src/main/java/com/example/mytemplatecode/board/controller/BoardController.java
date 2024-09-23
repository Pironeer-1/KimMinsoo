package com.example.mytemplatecode.board.controller;

import com.example.mytemplatecode.board.dto.request.BoardCreateRequest;
import com.example.mytemplatecode.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseEntity<?> create(@RequestBody BoardCreateRequest request) {
        boardService.save(request);
        return ResponseEntity.ok().build();
    }
}
