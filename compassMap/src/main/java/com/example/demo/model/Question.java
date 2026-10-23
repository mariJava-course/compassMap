package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    private String id;
    private String name;
    private String text;
    @Enumerated(EnumType.STRING)
    private Dimension dimension;
    @Column(name = "question_order")
    private int order;
    private double weight;
}
