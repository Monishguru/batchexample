package com.monish.batchexample.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		// TODO Auto-generated method stub
		for(String userInformation :items) {
			System.out.println("Data Written"+userInformation);
		}
		
	}

}
