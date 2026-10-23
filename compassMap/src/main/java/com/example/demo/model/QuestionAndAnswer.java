package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAndAnswer {

//    @Id
    private String id;
    private Question question;
    private Answer answer;
    private Double scoreContribution;

    // methods
    public String toString() {
        return String.format(
                "QuestionAndAnswer[id=%s, question='%s', answer='%s', scoreContribution='%s']",
                id, question, answer, scoreContribution);
    }
}
