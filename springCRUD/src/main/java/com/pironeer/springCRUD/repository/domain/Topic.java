package com.pironeer.springCRUD.repository.domain;

import com.pironeer.springCRUD.dto.request.TopicUpdateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

// 도메인(모델)
// Django의 model과 비슷한 역할
// 객체의 데이터 구조를 정의
// Django는 모델 선언만으로도 ORM이 자동으로 일어나지만(즉 DB 스키마가 생성)
// Spring은 따로 맵핑을 해줘야 함

@Data
public class Topic { // 게시글
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Topic(
            Long id,
            String title,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Topic update(TopicUpdateRequest request) {
        this.title = request.title();
        this.content = request.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }

}

