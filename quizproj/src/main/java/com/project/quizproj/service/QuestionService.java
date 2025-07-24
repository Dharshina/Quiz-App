package com.project.quizproj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quizproj.model.Question;
import com.project.quizproj.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired 
	QuestionRepository repository;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getByCategory(String category) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(repository.findByCategory(category), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
		
	
	public ResponseEntity<String> addQuestion(Question q) {
		try {
		repository.save(q);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}catch(Exception e){
		e.printStackTrace();
	}
	return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
}
	
}
