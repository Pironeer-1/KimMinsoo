package com.pironeer.springCRUD.service;

import com.pironeer.springCRUD.dto.request.CommentCreateRequest;
import com.pironeer.springCRUD.dto.request.CommentUpdateRequest;
import com.pironeer.springCRUD.dto.response.CommentResponse;
import com.pironeer.springCRUD.mapper.CommentMapper;
import com.pironeer.springCRUD.repository.CommentRepository;
import com.pironeer.springCRUD.repository.TopicRepository;
import com.pironeer.springCRUD.repository.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository; // 게시글이 없는 경우, 댓글 못 달게 하는 예외 처리 위함

    // 댓글 생성
    public CommentResponse save(Long topicId, CommentCreateRequest request) {
        topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        Comment comment = CommentMapper.from(topicId, request);
        Comment savedComment = commentRepository.save(comment);
        return CommentResponse.of(savedComment);
    }

    // 댓글 단건 조회
    public CommentResponse findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("COMMENT NOT FOUND"));
        return CommentResponse.of(comment);
    }

    // 특정 게시글 전체 댓글 조회
    public List<CommentResponse> findAllByTopicId(Long topicId) {
        List<Comment> comments = commentRepository.findAllByTopicId(topicId);
        if (comments.isEmpty()) {
            throw new RuntimeException("COMMENTS NOT FOUND");
        }
        return comments.stream().map(CommentResponse::of).toList();
    }

    // 댓글 수정
    public CommentResponse update(Long commentId, CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("COMMENT NOT FOUND"));
        Comment updatedComment = commentRepository.save(comment.update(request));
        return CommentResponse.of(updatedComment);
    }

    // 댓글 삭제
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

}
