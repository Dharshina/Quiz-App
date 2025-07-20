package com.project.quizproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quizproj.model.Question;
import com.project.quizproj.repository.QuestionRepository;

@Service
public class serviceClass {

	@Autowired 
	QuestionRepository repository;
	
	public List<Question> getAllQuestions() {
		return repository.findAll();
	}

	public List<Question> getByCategory(String category) {
		// TODO Auto-generated method stub
		return repository.findByCategory(category);
	}
	
	public String addQuestion(Question q) {
		repository.save(q);
		return "Success";
	}
}
