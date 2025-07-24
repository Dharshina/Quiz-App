package com.project.quizproj.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizproj.model.Question;
import com.project.quizproj.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionService sc;
	ArrayList<String> questions = new ArrayList<>(Arrays.asList("What is the capital of India", "What is the color of sky", "Who is the President of India"));
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Question>> display() {
	//return questions;
		return sc.getAllQuestions();
		
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsCategory(@PathVariable String category){
		return sc.getByCategory(category);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question q) {
		 return sc.addQuestion(q);
		//return "Added successfully";
	}
	
	
	
}
 