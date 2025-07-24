package com.project.quizproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizproj.model.Question;
import com.project.quizproj.model.QuestionWrapper;
import com.project.quizproj.model.ResponseWrapper;
import com.project.quizproj.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService qs;
	
	@PostMapping("/create")
	public ResponseEntity<List<Question>> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
		return qs.createQuiz(category,numQ, title );
		
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<List<QuestionWrapper>> fetchQuiz(@PathVariable Integer id ){
	
		return qs.fetchQuiz(id);
	}
	
	@PostMapping("/submit")
	public ResponseEntity<Integer> submitQuiz(@RequestBody List<ResponseWrapper> responses){
		return qs.submitQuiz(responses);
	}

}
