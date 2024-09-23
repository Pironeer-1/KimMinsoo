package com.example.mytemplatecode.board.service;

import com.example.mytemplatecode.board.dto.request.BoardCreateRequest;
import com.example.mytemplatecode.board.dto.request.BoardUpdateRequest;
import com.example.mytemplatecode.board.dto.response.BoardResponse;
import com.example.mytemplatecode.board.entity.Board;
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
        Board board = Board.builder()
                .title(request.title())
                .content(request.content())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        boardRepository.save(board);
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
        updateTitle(request.title(), board);
        updateContent(request.content(), board);
        board.setUpdateAt(LocalDateTime.now());
        boardRepository.update(board);
        return BoardResponse.of(board);
    }

    private static void updateTitle(String title, Board board) {
        if (title != null && !title.isBlank()){
            board.setTitle(title);
        }
    }

    private static void updateContent(String content, Board board) {
        if (content != null && !content.isBlank()){
            board.setContent(content);
        }
    }

}
