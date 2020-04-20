package com.codeprep.app.service;

import com.codeprep.app.io.Topic;

import java.util.List;

public interface TopicService {

    public List<Topic> getTopics();

    public Topic getTopic(Long id);

    public void addTopic(List<Topic> topics);

    public void updateTopic(List<Topic> topics);

    public void deleteTopic(Long id);
}
