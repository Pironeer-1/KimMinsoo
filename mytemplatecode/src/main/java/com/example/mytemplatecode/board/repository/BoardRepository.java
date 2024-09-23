package com.example.mytemplatecode.board.repository;

import com.example.mytemplatecode.board.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BoardRepository {
    private final AtomicLong boardIdxGenerator = new AtomicLong();
    private final HashMap<Long, Board> boardMap = new HashMap<Long, Board>();

    // 게시글 저장
    public void save(Board board) {
        boardMap.put(boardIdxGenerator.incrementAndGet(), board);
    }

    // 게시글 단건 조회
    public Board findById(Long id) {
        return boardMap.get(id);
    }
}
