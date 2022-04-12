package com.group.exam.board.utils;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.group.exam.board.command.QuestionAdayCommand;
import com.group.exam.board.service.BoardService;

@Component
public class SchedulerQuestion{
	
	@Autowired
	private BoardService boardService;
	
	@Scheduled(cron = "0/10 * * * * ?")
	
	//(cron = " 0 0 12 1/1 * ? ") //매일 한 번
	public QuestionAdayCommand autoQuestion() {


		
		return boardService.questionAday(1);
		
		
	}
}
