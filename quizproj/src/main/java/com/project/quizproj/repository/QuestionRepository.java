package com.project.quizproj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.quizproj.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

	List<Question> findByCategory(String category);
	
	@Query(value="Select * from Question q where q.category=:c order by Random() Limit :numQ", nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String c, int numQ);
	
}
