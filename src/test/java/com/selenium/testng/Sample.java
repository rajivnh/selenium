package com.selenium.testng;

import org.testng.annotations.Test;

public class Sample {
	@Test
	public void scenerio1() {
		System.out.println("Hello " + Thread.currentThread().getId());
	}

	public void scenerio2() {
		System.out.println("World " + Thread.currentThread().getId());
	}
}
