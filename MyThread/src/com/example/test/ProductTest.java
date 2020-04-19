package com.example.test;

public class ProductTest {

	public static void main(String[] args) {
		
		
		
		ProductPool pool = new ProductPool(15);
		
		Runnable r = () -> {
			int index = 0;
			while(true) {
				pool.push(new Product(++index+"ºÅ"));
			}
		};
		
		Runnable r2 = () -> {
			while(true) {
				pool.pop();
			}
		};
		
		Thread producer = new Thread(r,"producer");
		Thread consumer = new Thread(r2,"consumer");
		
		producer.start();
		consumer.start();
		
		
		
	}
	
	
}
