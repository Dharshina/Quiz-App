package com.project.quizproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.quizproj.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	
	
}
