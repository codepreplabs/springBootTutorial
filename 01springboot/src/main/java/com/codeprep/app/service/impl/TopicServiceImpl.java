package com.codeprep.app.service.impl;

import com.codeprep.app.entity.Topic;
import com.codeprep.app.io.TopicDTO;
import com.codeprep.app.repo.TopicRepo;
import com.codeprep.app.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicRepo topicRepo;

    private ConversionService conversionService;

    @Override
    public List<TopicDTO> getTopicDTOS() {
        Iterable<com.codeprep.app.entity.Topic> iterable = topicRepo.findAll();
        Iterator<com.codeprep.app.entity.Topic> iterator = iterable.iterator();
        List<TopicDTO> topicDTOS = new ArrayList<>();
        while (iterator.hasNext()){
            com.codeprep.app.entity.Topic dbTopic = iterator.next();
            TopicDTO topicDTO = new TopicDTO(dbTopic.getId(), dbTopic.getName(), dbTopic.getDescription());
            topicDTOS.add(topicDTO);
        }
        return topicDTOS;
    }

    @Override
    public TopicDTO getTopic(Long id) {
        return conversionService.convert(topicRepo.findById(id), TopicDTO.class);
    }

    @Override
    public void addTopic(List<TopicDTO> topicDTOS) {
        for (TopicDTO topicDto: topicDTOS) {
            topicRepo.save(Objects.requireNonNull(conversionService.convert(topicDto, Topic.class)));
        }
    }

    @Override
    public void updateTopic(List<TopicDTO> topicDTOS) {
        for (TopicDTO topicDTO : topicDTOS) {
            Topic topic = conversionService.convert(topicDTO, Topic.class);
            if(topic != null){
                topicRepo.save(topic);
            }
        }
    }

    @Override
    public void deleteTopic(Long id) {
        topicRepo.deleteById(id);
    }

    @Autowired
    public void setTopicRepo(TopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
}
