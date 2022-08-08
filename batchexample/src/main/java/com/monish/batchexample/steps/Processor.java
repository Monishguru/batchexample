package com.monish.batchexample.steps;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String>{

	@Override
	public String process(String item) throws Exception {
		// TODO Auto-generated method stub
		return item.concat("-processed");
	}

}
