package com.example.mytemplatecode.board.service;

import com.example.mytemplatecode.board.dto.request.BoardCreateRequest;
import com.example.mytemplatecode.board.dto.response.BoardResponse;
import com.example.mytemplatecode.board.entity.Board;
import com.example.mytemplatecode.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시글 저장
    public void save(BoardCreateRequest request) {
        Board board = Board.builder()
                .title(request.title())
                .content(request.content())
                .build();

        boardRepository.save(board);
    }

    // 게시글 단건 조회
    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id);
        return BoardResponse.of(board);
    }

}
