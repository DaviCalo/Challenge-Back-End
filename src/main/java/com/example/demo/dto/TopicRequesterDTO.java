package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicRequesterDTO(
        @NotBlank()
        String titulo,
        @NotBlank()
        String mensagem,
        @NotBlank()
        String autor,
        @NotBlank()
        String curso
){}