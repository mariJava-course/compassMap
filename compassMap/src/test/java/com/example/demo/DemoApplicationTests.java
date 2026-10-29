package com.example.demo;

import com.example.demo.model.Answer;
import com.example.demo.model.Customer;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionAndAnswer;
import com.example.demo.repository.QuestionAndAnswerRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.CustomerService;
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
	@Autowired
	private QuestionAndAnswerRepository repositoryQuestionAndAnswer;
	@Autowired
	private QuestionRepository repositoryQuestion;

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

	@Autowired
	QuestionAndAnswerRepository questionAndAnswerRepository;

	@Test
	void questionAndAnswerTentative(){

		// the test must fetch a question
		Question q1 = repositoryQuestion.findById("b2465fe1-cb9c-466e-9f51-5775e2590936").orElse(null);


		// and then create an empty questionAndAnswer
		QuestionAndAnswer qa1 = new QuestionAndAnswer();
		qa1.setId("qa-001");
		// set it with id q-001
		// set it with question
		qa1.setQuestion(q1);
		// set it with answer a-001
		qa1.setAnswer(new Answer("a-001", true));
		qa1.setScoreContribution(1.2);
		// and then save it
		questionAndAnswerRepository.save(qa1);
		// and then fetch it
		QuestionAndAnswer qa2 = questionAndAnswerRepository.findById("qa-001").orElse(null);

		System.out.println(qa2);

		// optionally, delete it



	}



}
