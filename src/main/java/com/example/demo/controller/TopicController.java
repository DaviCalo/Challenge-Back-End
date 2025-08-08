package com.example.demo.controller;

import com.example.demo.dto.TopicRequesterDTO;
import com.example.demo.model.Topic;
import com.example.demo.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @PostMapping()
    public ResponseEntity<Topic> registerTopic(@RequestBody @Valid TopicRequesterDTO topicDto, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicService.createTopic(new Topic(topicDto));
        URI uri = uriComponentsBuilder.path("/api/topic/{id}").buildAndExpand(topic.getIdTopic()).toUri();
        return ResponseEntity.created(uri).body(topic);
    }

    @GetMapping()
    public ResponseEntity<List<Topic>> getAllTopic() {
        List<Topic> topics = topicService.getAllTopic();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> findById(@PathVariable Long id){
        Topic topic = topicService.findById(id);
        return ResponseEntity.ok(topic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateUser(@RequestBody @Valid TopicRequesterDTO topicDto, @PathVariable Long id){
        Topic responseDto = topicService.updateTopic(topicDto, id);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Boolean Topic = topicService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}