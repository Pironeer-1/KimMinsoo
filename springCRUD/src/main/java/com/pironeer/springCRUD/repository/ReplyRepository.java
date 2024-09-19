package com.pironeer.springCRUD.repository;

import com.pironeer.springCRUD.repository.domain.Comment;
import com.pironeer.springCRUD.repository.domain.Reply;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ReplyRepository {
    private final AtomicLong replyIdxGenerator = new AtomicLong(0);
    private final Map<Long, Reply> replyMap = new HashMap<>();

    public void save(Reply reply){
        if (reply.getId() == null) {
            Long id = replyIdxGenerator.incrementAndGet();
            reply.setId(id);
            replyMap.put(id, reply);
        } else {
            replyMap.replace(reply.getId(), reply);
        }
    }

    public Optional<Reply> findById(Long commentId, Long replyId) {
        Assert.notNull(commentId, "COMMENT ID MUST NOT BE NULL");
        Assert.notNull(replyId, "REPLY ID MUST NOT BE NULL");
        return Optional.ofNullable(replyMap.get(replyId))
                .filter(reply -> reply.getCommentId().equals(commentId));
    }


    public List<Reply> findAllByCommentId(Long commentId){
        return replyMap.values().stream()
                .filter(reply -> reply.getCommentId().equals(commentId))
                .collect(Collectors.toList());
    }

    public void deleteById(Long commentId, Long replyId) {
        Assert.notNull(commentId, "COMMENT ID MUST NOT BE NULL");
        Assert.notNull(replyId, "REPLY ID MUST NOT BE NULL");
        Reply reply = replyMap.get(replyId);
        if (reply != null && reply.getCommentId().equals(commentId)) {
            replyMap.remove(replyId);
        }
    }
}
