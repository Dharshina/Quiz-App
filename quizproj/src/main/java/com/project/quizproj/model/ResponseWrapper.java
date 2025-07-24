package com.project.quizproj.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseWrapper {
	
	int id;
	String rightAnswer;

}
