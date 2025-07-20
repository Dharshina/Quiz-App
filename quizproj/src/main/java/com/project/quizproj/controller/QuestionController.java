package com.project.quizproj.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizproj.model.Question;
import com.project.quizproj.service.serviceClass;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private serviceClass sc;
	ArrayList<String> questions = new ArrayList<>(Arrays.asList("What is the capital of India", "What is the color of sky", "Who is the President of India"));
	
	
	@GetMapping("/all")
	public List<Question> display() {
		
	//return questions;
		return sc.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public List<Question> getQuestionsCategory(@PathVariable String category){
		return sc.getByCategory(category);
	}

	@PostMapping("/add")
	public Question addQuestion(@RequestBody Question q) {
		 sc.addQuestion(q);
		 return q;
		//return "Added successfully";
	}
	
}
 