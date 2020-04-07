package com.backdoor20.junit;

public class GreetingImpl implements Greeting {

	@Override
	public String greet(String name) {
		
		if(name.length()==0 || name ==null ) {
			throw new IllegalArgumentException();
		}
		
		return "Hello "+name;
	}

}
