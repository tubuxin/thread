package com.example.test;

import java.util.LinkedList;
import java.util.List;

public class ProductPool {
	
	private List<Product> list;
	
	private int maxSize;
	
	private int totalSize;
	
	public ProductPool(int maxSize) {
		list = new LinkedList<Product>();
		this.maxSize = maxSize;
	}
	
	/**
	 * 生产产品
	 */
	public synchronized void push(Product product) {
		
		if(list.size() ==  maxSize) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName()+"生产产品：" + product.getName());
		list.add(product);
		++totalSize;
		this.notifyAll(); 
	}
	
	
	/**
	 * 消费产品
	 */
	public synchronized void pop() {
		
		if(list.size()==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product pro = list.remove(0);
		System.out.println(Thread.currentThread().getName()+"消费产品：" + pro.getName());
		this.notifyAll();
	
		
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	
	
	

}
