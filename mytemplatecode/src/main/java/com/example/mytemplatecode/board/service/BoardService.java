package com.example.mytemplatecode.board.service;

import com.example.mytemplatecode.board.dto.request.BoardCreateRequest;
import com.example.mytemplatecode.board.entity.Board;
import com.example.mytemplatecode.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardCreateRequest request) {
        Board board = Board.builder()
                .title(request.title())
                .content(request.content())
                .build();

        boardRepository.save(board);
    }
}
