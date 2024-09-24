package com.example.mytemplatecode.board.repository;

import com.example.mytemplatecode.board.entity.Board;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardRepository {
    private final AtomicLong boardIdxGenerator = new AtomicLong(0);
    private final HashMap<Long, Board> boardMap = new HashMap<>();

    // 게시글 저장
    public void save(Board board) {
        Long boardId = boardIdxGenerator.incrementAndGet();
        board.setId(boardId);
        boardMap.put(boardId, board);
    }

    // 게시글 수정
    // 기존 save 메서드에 합쳐져 있던 것 분리
    public void update(Board board) {
        boardMap.replace(board.getId(), board);
    }

    // 게시글 단건 조회
    public Optional<Board> findById(Long id) {
        Assert.notNull(id, "ID must not be null!");
        return Optional.ofNullable(boardMap.get(id));
    }

    // 게시글 전체 조회
    public List<Board> findAll() {
        return boardMap.values().stream().toList();
    }

    // 게시글 삭제
    public void deleteById(Long id) {
        Assert.notNull(id, "ID must not be null!");
        boardMap.remove(id);
    }
}
