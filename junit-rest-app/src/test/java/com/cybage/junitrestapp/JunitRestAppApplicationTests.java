package com.cybage.junitrestapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JunitRestAppApplicationTests {

	@Test
	public void demoTestMethod(){
		Assertions.assertTrue(true);
	}

}
