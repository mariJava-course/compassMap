package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.QuestionAndAnswerRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.QuestionAndAnswerService;
import com.example.demo.service.QuestionService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	//@Autowired
	//private CustomerRepository customerRepository;

	@Autowired
	private CustomerService customerService;

	@Test
	void contextLoads() {
	}

	@Test
	void findCustomerById (){

		Customer customerFound1 = customerService.getCustomerById("64c7be39-d974-419f-a766-a6063346676b");
		System.out.println("Customer found 1 : " + customerFound1 );

		Customer customerFound2 = customerService.getCustomerById("banana");
		System.out.println("Customer found 2 : " + customerFound2 );
	}

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionAndAnswerService questionAndAnswerService;

	@Autowired
	private QuestionAndAnswerRepository questionAndAnswerRepository;

	@Test
	void createQuestions() {
		Question newQuestion = new Question();
		newQuestion.setText("Do you know to code?");
		newQuestion.setOrder(10);
		newQuestion.setWeight(0.3) ;
		newQuestion.setDimension(Dimension.KNOWS_CODE);
		questionService.createQuestion(newQuestion);

		Question newQuestion2 = new Question();
		newQuestion2.setText("Do you want to learn to code?");
		newQuestion2.setOrder(11);
		newQuestion2.setWeight(0.2) ;
		newQuestion2.setDimension(Dimension.WANTS_TO_LEARN);
		questionService.createQuestion(newQuestion2);



		QuestionAndAnswer newQuestionAndAnswer = new QuestionAndAnswer();
		newQuestionAndAnswer.setQuestion(newQuestion);
		//newQuestionAndAnswer.setAnswer(null);
		//newQuestionAndAnswer.setAnswer(new Answer("a-001", true));
		newQuestionAndAnswer.setScoreContribution(1.2);
		// by repository
		//questionAndAnswerRepository.save(newQuestionAndAnswer);
		// by service
		questionAndAnswerService.createQuestionAndAnswer(newQuestionAndAnswer);

	}



	/*
	@Test
	void deleteCustomerById(){

		customerService.deleteCustomer("8b4ca0f7-5de0-4ab2-a431-a849f158cd62");
	}


	@Test
	void javaFakerCreateObjects(){


		Faker faker = new Faker();

		//String name = faker.name().fullName(); // Miss Samanta Schmidt
		//String firstName = faker.name().firstName(); // Emory
		//String lastName = faker.name().lastName(); // Barton

		//String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

		//String titleBook = faker.book().title();

		Customer newCustomer = new Customer();

		for (int i= 0; i < 1000; i++){

			// id?
			newCustomer.setFirstName( faker.name().firstName()  );
			newCustomer.setLastName(  faker.name().lastName());

			customerService.createCustomer(newCustomer);
		}
	} */



}
