package com.example.demo.model;

import com.example.demo.dto.TopicRequesterDTO;
import com.example.demo.utils.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long idTopic;

    @Column(unique = true, nullable = false)
    private String titulo;

    @Column(name = "mensagem", nullable = false)
    private String mensagem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "curso", nullable = false)
    private String curso;

    @Column(name = "resposta")
    private String resposta;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Topic(@Valid TopicRequesterDTO topicDto) {
        this.titulo = topicDto.titulo();
        this.status = StatusEnum.CRIADO;
        this.autor = topicDto.autor();
        this.curso = topicDto.curso();
    }

    public void updateInformation(@Valid TopicRequesterDTO topicDto) {
        if (topicDto.titulo() != null) {
            this.titulo = topicDto.titulo();
        }

        if (topicDto.autor() != null) {
            this.autor = topicDto.autor();
        }

        if (topicDto.curso() != null) {
            this.curso = topicDto.curso();
        }
    }
}