package com.pironeer.springCRUD.repository;

import com.pironeer.springCRUD.repository.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(0);
    private final Map<Long, Comment> commentMap = new HashMap<>();

    public Comment save(Comment comment){
        if (comment.getId() == null) {
            Long id = commentIdxGenerator.incrementAndGet(); // 1부터 시작
            comment.setId(id);
            commentMap.put(id, comment); // 새로운 comment 객체 추가
        } else {
            commentMap.replace(comment.getId(), comment); // 아니면 수정
        }
        return comment;
    }

    public Optional<Comment> findById(Long id){
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.ofNullable(commentMap.get(id));
    }

    public List<Comment> findAllByTopicId(Long topicId) {
        return commentMap.values().stream()
                .filter(comment -> comment.getTopicId().equals(topicId)) // 게시글 id와 같은 경우만 필터링
                .collect(Collectors.toList()); // 리스트 형태로 변환해서 반환
    }

    public void deleteById(Long id){
        Assert.notNull(id, "ID MUST NOT BE NULL");
        commentMap.remove(id);
    }
}
