package com.pironeer.springCRUD.service;

import com.pironeer.springCRUD.dto.request.ReplyCreateRequest;
import com.pironeer.springCRUD.dto.request.ReplyUpdateRequest;
import com.pironeer.springCRUD.dto.response.ReplyResponse;
import com.pironeer.springCRUD.mapper.ReplyMapper;
import com.pironeer.springCRUD.repository.CommentRepository;
import com.pironeer.springCRUD.repository.ReplyRepository;
import com.pironeer.springCRUD.repository.domain.Comment;
import com.pironeer.springCRUD.repository.domain.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final CommentRepository commentRepository;

    // 대댓글 생성
    public void save(Long commentId, ReplyCreateRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("COMMENT NOT FOUND"));
        Reply reply = ReplyMapper.from(request);
        reply.setCommentId(commentId);
        replyRepository.save(reply);
    }

    // 대댓글 단건 조회
    public ReplyResponse findById(Long commentId, Long replyId) {
        Reply reply = replyRepository.findById(commentId, replyId)
                .orElseThrow(() -> new RuntimeException("REPLY NOT FOUND"));
        return ReplyResponse.of(reply);
    }

    // 특정 댓글에 대한 대댓글 전체 조회
    public List<ReplyResponse> findAllByCommentId(Long commentId) {
        List<Reply> replies = replyRepository.findAllByCommentId(commentId);
        if (replies.isEmpty()) {
            throw new RuntimeException("REPLIES NOT FOUND");
        }
        return replies.stream().map(ReplyResponse::of).toList();
    }

    // 대댓글 수정
    public ReplyResponse update(Long commentId, Long replyId, ReplyUpdateRequest request) {
        Reply reply = replyRepository.findById(commentId, replyId)
                .orElseThrow(() -> new RuntimeException("REPLY NOT FOUND"));
        replyRepository.save(reply.update(request));
        return ReplyResponse.of(reply);
    }

    // 대댓글 삭제
    public void deleteById(Long commentId, Long id) {
        replyRepository.deleteById(commentId, id);
    }
}