package com.example.mytemplatecode.board.repository;

import com.example.mytemplatecode.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    // 게시글 저장
    void save(Board board);

    // 게시글 수정
    void update(Board board);

    // 게시글 단건 조회
    Optional<Board> findById(Long id);

    // 게시글 전체 조회
    List<Board> findAll();

    // 게시글 삭제
    void deleteById(Long id);
}