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

    /* @JsonIgnore
    @JoinColumn(name = "ANSWER_FK")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Answer answer; */

    private Double scoreContribution;
}
