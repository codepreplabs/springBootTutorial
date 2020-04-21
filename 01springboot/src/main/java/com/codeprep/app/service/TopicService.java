package com.codeprep.app.service;

import com.codeprep.app.io.TopicDTO;

import java.util.List;

public interface TopicService {

    public List<TopicDTO> getTopicDTOS();

    public TopicDTO getTopic(Long id);

    public void addTopic(List<TopicDTO> topicDTOS);

    public void updateTopic(List<TopicDTO> topicDTOS);

    public void deleteTopic(Long id);
}
