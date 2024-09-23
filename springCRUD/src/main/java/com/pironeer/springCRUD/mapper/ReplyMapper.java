package com.pironeer.springCRUD.mapper;

import com.pironeer.springCRUD.dto.request.ReplyCreateRequest;
import com.pironeer.springCRUD.repository.domain.Reply;

import java.time.LocalDateTime;

public class ReplyMapper {
    public static Reply from (ReplyCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Reply.builder()
                .content(request.content())
                .createdAt(now)
                .build();
    }
}
