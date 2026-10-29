package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    // order of the question
    // order is a reserved keyword in H2,
    // so Hibernate's generated DDL will fail at: order integer not null.
    @Column(name = "question_order")
    private int order;
    private double weight;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<QuestionAndAnswer> questionAndAnswerlist = new ArrayList<>();

    public String toString() {
        return String.format(
                "Question[id=%s, name='%s', text='%s', dimension='%s', order='%s', weight='%s']",
                id, name, text, dimension, order, weight);
    }
}
