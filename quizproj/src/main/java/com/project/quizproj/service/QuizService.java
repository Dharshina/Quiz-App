package com.project.quizproj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quizproj.model.Question;
import com.project.quizproj.model.QuestionWrapper;
import com.project.quizproj.model.Quiz;
import com.project.quizproj.model.ResponseWrapper;
import com.project.quizproj.repository.QuestionRepository;
import com.project.quizproj.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository qr;
	
	@Autowired
	QuestionRepository quesr;

	public ResponseEntity<List<Question>> createQuiz(String category, int numQ, String title) {
		List<Question> questions = quesr.findRandomQuestionsByCategory(category,numQ);
		
		Quiz qz = new Quiz();
		
		qz.setQuestions(questions);
		qz.setTitle(title);
		
		qr.save(qz);
		return new ResponseEntity<>(questions,HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> fetchQuiz(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = qr.findById(id);
		List<Question> questionfromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for(Question q: questionfromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(),q.getOption1(),q.getOption2(), q.getOption3(), q.getOption4());
		    questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> submitQuiz(List<ResponseWrapper> responses) {
		// TODO Auto-generated method stub
//		Question question = quesr.findById(id);
//		question
		int score=0;
		for(ResponseWrapper rw :responses) {
			String actualAnswer = rw.getRightAnswer();
			Optional<Question> op = quesr.findById(rw.getId());
			Question q = op.get();
			String expectedAnswer = q.getRightAnswer();
			if(actualAnswer.equals(expectedAnswer)) {
				score+=1;
			}
			System.out.println("Actual:"+actualAnswer+" Expected:"+expectedAnswer);
		}
		
		return new ResponseEntity<>(score,HttpStatus.OK);
	}

}
