package com.pironeer.springCRUD.service;

import com.pironeer.springCRUD.dto.request.TopicUpdateRequest;
import com.pironeer.springCRUD.dto.response.TopicResponse;
import com.pironeer.springCRUD.mapper.TopicMapper;
import com.pironeer.springCRUD.repository.domain.Topic;
import com.pironeer.springCRUD.dto.request.TopicCreateRequest;
import com.pironeer.springCRUD.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


// Service
// 각종 로직을 처리하는 부분
// Django의 view 내부 메서드들을 따로 빼서 모아놓은 곳이라고 생각하면 편함


@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public void save(TopicCreateRequest request) { // 게시물 생성
        topicRepository.save(TopicMapper.from(request));
    }

    public TopicResponse findById(Long id) { // 단건 조회
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        return TopicResponse.of(topic);
    }

    public List<TopicResponse> findAll() { // 모두 조회
        List<Topic> topics = topicRepository.findAll();
        return topics.stream().map(TopicResponse::of).toList();
    }

    public TopicResponse update(TopicUpdateRequest request) { // 게시물 수정
        Topic topic = topicRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        topicRepository.save(topic.update(request));
        return TopicResponse.of(topic);
    }

    public void deleteById(Long id) { // 게시물 삭제
        topicRepository.deleteById(id);
    }



}
