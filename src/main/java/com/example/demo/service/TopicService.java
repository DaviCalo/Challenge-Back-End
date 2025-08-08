package com.example.demo.service;

import com.example.demo.dto.TopicRequesterDTO;
import com.example.demo.model.Topic;
import com.example.demo.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Transactional
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public Topic findById(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.orElse(null);
    }

    public Topic updateTopic(@Valid TopicRequesterDTO topicDto, Long id) {
        Topic topicUpdate = topicRepository.getReferenceById(id);
        topicUpdate.updateInformation(topicDto);

        return topicUpdate;
    }

    @Transactional
    public Boolean deleteById(Long id){
        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

