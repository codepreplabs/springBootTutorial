package com.codeprep.app.converter;

import com.codeprep.app.entity.Topic;
import com.codeprep.app.io.TopicDTO;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class TopicDTOToTopicConverter implements Converter<TopicDTO, Topic> {
    @Override
    public Topic convert(TopicDTO topicDTO) {
        Topic topic = new Topic(topicDTO.getId(), topicDTO.getName(), topicDTO.getDescription());
        System.out.print(topic);
    return topic;
    }
}
