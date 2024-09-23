package com.pironeer.springCRUD.mapper;

import com.pironeer.springCRUD.dto.request.TopicCreateRequest;
import com.pironeer.springCRUD.repository.domain.Topic;

import java.time.LocalDateTime;

// 데이터 변환 역할을 수행하는 매퍼
// DTO인 TopicCreateRequest를 from 메서드를 통해 Topic 객체로 변환
// 새로운 Topic을 생성할 때 사용됨

public class TopicMapper {
    public static Topic from(TopicCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Topic.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
