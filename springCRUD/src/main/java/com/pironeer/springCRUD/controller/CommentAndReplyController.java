package com.pironeer.springCRUD.controller;

import com.pironeer.springCRUD.dto.request.CommentCreateRequest;
import com.pironeer.springCRUD.dto.request.CommentUpdateRequest;
import com.pironeer.springCRUD.dto.request.ReplyCreateRequest;
import com.pironeer.springCRUD.dto.request.ReplyUpdateRequest;
import com.pironeer.springCRUD.dto.response.CommentResponse;
import com.pironeer.springCRUD.dto.response.ReplyResponse;
import com.pironeer.springCRUD.service.CommentService;
import com.pironeer.springCRUD.service.ReplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "댓글 및 대댓글(Comment & Reply)")
@RequestMapping("/api/comment")
public class CommentAndReplyController {
    private final CommentService commentService;
    private final ReplyService replyService;

    // 댓글 관련 엔드포인트
    @PostMapping()
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> createComment(
            @RequestParam Long topicId,
            @Valid @RequestBody CommentCreateRequest request) {
        commentService.save(topicId, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{commentId}")
    @Operation(summary = "댓글 단건 조회")
    public ResponseEntity<CommentResponse> getComment(@PathVariable Long commentId) {
        CommentResponse response = commentService.findById(commentId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/topic/{topicId}/comments")
    @Operation(summary = "특정 게시글의 전체 댓글 조회")
    public ResponseEntity<List<CommentResponse>> getCommentsForTopic(@PathVariable Long topicId) {
        List<CommentResponse> responses = commentService.findAllByTopicId(topicId);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{commentId}")
    @Operation(summary = "댓글 수정")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable Long commentId, @Valid @RequestBody CommentUpdateRequest request) {
        CommentResponse response = commentService.update(commentId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{commentId}")
    @Operation(summary = "댓글 삭제")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        commentService.deleteById(commentId);
        return ResponseEntity.ok("댓글 삭제 성공");
    }

    // 대댓글 관련 엔드포인트
    @PostMapping("/{commentId}/replies")
    @Operation(summary = "대댓글 작성")
    public ResponseEntity<?> createReply(@PathVariable Long commentId, @Valid @RequestBody ReplyCreateRequest request) {
        replyService.save(commentId, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{commentId}/replies")
    @Operation(summary = "댓글에 대한 대댓글 조회")
    public ResponseEntity<List<ReplyResponse>> getRepliesForComment(@PathVariable Long commentId) {
        List<ReplyResponse> responses = replyService.findAllByCommentId(commentId);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{commentId}/replies/{replyId}")
    @Operation(summary = "대댓글 수정")
    public ResponseEntity<ReplyResponse> updateReply(@PathVariable Long commentId, @PathVariable Long replyId, @Valid @RequestBody ReplyUpdateRequest request) {
        ReplyResponse response = replyService.update(commentId, replyId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{commentId}/replies/{replyId}")
    @Operation(summary = "대댓글 삭제")
    public ResponseEntity<?> deleteReply(@PathVariable Long commentId, @PathVariable Long replyId) {
        replyService.deleteById(commentId, replyId);
        return ResponseEntity.ok("대댓글 삭제 성공");
    }
}