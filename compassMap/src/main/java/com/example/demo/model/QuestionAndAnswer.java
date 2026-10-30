package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class QuestionAndAnswer {

    @Id
    private String id;

    @JsonIgnore
    @JoinColumn(name = "QUESTION_FK")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Question question;


    /*@ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;*/

    /*@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "answer_id")
    private Answer answer;*/

    /*@JsonIgnore
    @JoinColumn(name = "ANSWER_FK")
    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Answer answer;*/

    private Double scoreContribution;
}
