package com.example.demo.service;

import com.example.demo.model.QuestionAndAnswer;
//import com.example.demo.repository.QuestionAndAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionAndAnswerService {

    // we are using here DEPENDENCE INJECTION
//    @Autowired
//    private QuestionAndAnswerRepository questionAndAnswerRepository;

/*    public Iterable<QuestionAndAnswer> getAllQuestionAndAnswers() {
        return questionAndAnswerRepository.findAll();
    }*/

    public QuestionAndAnswer createQuestionAndAnswer (QuestionAndAnswer questionAndAnswer){
        // SET ID questionAndAnswer to UUID
        questionAndAnswer.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
//        QuestionAndAnswer createdQuestionAndAnswer = questionAndAnswerRepository.save(questionAndAnswer);
//        System.out.println("Service created questionAndAnswer: " +  createdQuestionAndAnswer);
//        return createdQuestionAndAnswer;

        //System.out.println("Service created questionAndAnswer: " +  questionAndAnswer);
        return questionAndAnswer;
    }

/*    public void deleteQuestionAndAnswer (String id){
      questionAndAnswerRepository.deleteById(id);

    }

    public QuestionAndAnswer getQuestionAndAnswerById(String id){

        Optional<QuestionAndAnswer> foundQuestionAndAnswer = questionAndAnswerRepository.findById(id);

        return foundQuestionAndAnswer.orElse(null);
    }*/

/*    public Iterable<QuestionAndAnswer> saveAll(Iterable<QuestionAndAnswer> questionAndAnswers) {
        // SET ID questionAndAnswer to UUID
        for (QuestionAndAnswer questionAndAnswer : questionAndAnswers) {
            questionAndAnswer.setId(UUID.randomUUID().toString());
        }
        return questionAndAnswerRepository.saveAll(questionAndAnswers);
    }

    public void deleteAllQuestionAndAnswers() {
        questionAndAnswerRepository.deleteAll();
    }

    public long countQuestionAndAnswers() {
        return questionAndAnswerRepository.count();
    }

    public QuestionAndAnswer updateQuestionAndAnswer(QuestionAndAnswer incoming) {
        if (incoming.getId() == null) {
            return null;
        }
        QuestionAndAnswer existing = getQuestionAndAnswerById(incoming.getId());
        if (existing == null) {
            return null;
        }
        // merge only non-null fields from incoming (partial update semantics)
        if (incoming.getQuestion() != null) {
            existing.setQuestion(incoming.getQuestion());
        }
        if (incoming.getAnswer() != null) {
            existing.setAnswer(incoming.getAnswer());
        }
        if (incoming.getScoreContribution() >= 0) {
            existing.setScoreContribution(incoming.getScoreContribution());
        }
        return questionAndAnswerRepository.save(existing);
    }

 */
}
