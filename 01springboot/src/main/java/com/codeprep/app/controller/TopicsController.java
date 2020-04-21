package com.codeprep.app.controller;

import com.codeprep.app.io.TopicDTO;
import com.codeprep.app.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
public class TopicsController {

    private TopicService topicService;

    @GetMapping
    public List<TopicDTO> getTopics(){
        return  topicService.getTopicDTOS();
    }

    @GetMapping("/{id}")
    public TopicDTO getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

    @PutMapping
    public void addTopic(@RequestBody  List<TopicDTO> topicDTOS){
        topicService.addTopic(topicDTOS);
    }

    @PostMapping
    public void updateTopic(@RequestBody List<TopicDTO> topicDTOS){
        topicService.updateTopic(topicDTOS);
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
