package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentView {

    @Id
    private String id;

    //private Customer customer;
    private Instant timestamp;
    private int qtyQuestions;

    //private List<QuestionAndAnswer> questionsAndAnswers;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_FK")
    private CustomerProfile profile;


}
