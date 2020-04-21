package com.codeprep.app.converter;

import com.codeprep.app.entity.Topic;
import com.codeprep.app.io.TopicDTO;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class TopicToTopicDTOConverter implements Converter<Topic, TopicDTO> {

    @Override
    public TopicDTO convert(Topic topic) {
        return new TopicDTO(topic.getId(), topic.getName(), topic.getDescription());
    }
}
