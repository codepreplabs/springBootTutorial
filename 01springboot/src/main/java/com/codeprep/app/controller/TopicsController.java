package com.codeprep.app.controller;

import com.codeprep.app.io.Topic;
import com.codeprep.app.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
public class TopicsController {

    private TopicService topicService;

    @GetMapping
    public List<Topic> getTopics(){
        return  topicService.getTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

    @PutMapping
    public void addTopic(@RequestBody  List<Topic> topics){
        topicService.addTopic(topics);
    }

    @PostMapping
    public void updateTopic(@RequestBody List<Topic> topics){
        topicService.updateTopic(topics);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id){
        topicService.deleteTopic(id);
    }

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }
}
