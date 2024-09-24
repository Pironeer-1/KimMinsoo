package com.example.mytemplatecode.board.service;

import com.example.mytemplatecode.board.dto.request.BoardCreateRequest;
import com.example.mytemplatecode.board.dto.request.BoardUpdateRequest;
import com.example.mytemplatecode.board.dto.response.BoardResponse;
import com.example.mytemplatecode.board.entity.Board;
import com.example.mytemplatecode.global.mapper.BoardMapper;
import com.example.mytemplatecode.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시글 저장
    public void save(BoardCreateRequest request) {
        boardRepository.save(BoardMapper.from(request));
    }

    // 게시글 단건 조회
    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return BoardResponse.of(board);
    }

    // 게시글 전체 조회
    public List<BoardResponse> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardResponse::of).toList();
    }

    // 게시글 수정
    public BoardResponse update(BoardUpdateRequest request) {
        Board board = boardRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        boardRepository.update(board.update(request));
        return BoardResponse.of(board);
    }

    // 게시글 삭제
    // id에 해당하는 글이 없는 경우 예외 처리
    public void deleteById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID " + id + "에 해당하는 게시글을 찾을 수 없습니다."));
        boardRepository.deleteById(id);
    }

}
