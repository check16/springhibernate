package com.asanast.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String handleExcepcion(Exception ex) {
		System.out.println(ex.toString());
		return "error";
	}
}
