package com.codeprep.app.service.impl;

import com.codeprep.app.io.Topic;
import com.codeprep.app.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic(1L, "Spring Boot", "A bootstrap project for spring apps"),
            new Topic(2L, "Spring MVC", "Project to create web apps using spring"),
            new Topic(3L, "Spring AOP", "project to handle cross cutting concerns")
    ));

    @Override
    public List<Topic> getTopics() {
        return topics;
    }

    @Override
    public Topic getTopic(Long id) {
        if(id != null){
            for (Topic topic: topics) {
                if(id.equals(topic.getId())){
                    return topic;
                }
            }
        }
        return null;
    }

    @Override
    public void addTopic(List<Topic> topics) {
        if(!CollectionUtils.isEmpty(topics)){
            this.topics.addAll(topics);
        }
    }

    @Override
    public void updateTopic(List<Topic> topics) {
        for (Topic topic: topics) {
            for (int i = 0; i < this.topics.size(); i++) {
                if(topic.getId().equals(this.topics.get(i).getId())){
                    this.topics.set(i, topic);
                }
            }
        }
    }

    @Override
    public void deleteTopic(Long id) {
        Iterator<Topic> iterator = this.topics.iterator();
        while(iterator.hasNext()){
            Topic topic = iterator.next();
            if(topic.getId().equals(id)){
                iterator.remove();
            }
        }
    }
}
