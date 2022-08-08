package com.monish.batchexample.steps;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String>{
	
	private String[] userInformation = {"testUSer1", "UserOrderedSomething","He is a new User"};

	private int count = 0;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		
		//
		
		
		// autowiring the jpa repo
		//read the data from repository
		
		//you will be just returning the Orders Object
		
		if(count < userInformation.length) {
			return userInformation[count++];
		}else {
			count=0;
		}
		return null;
	}

}
