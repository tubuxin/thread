package com.example.basic;

public class BasicThread {

	
	public static void main(String[] args) {
		
		Runnable r = () -> {
			while(TicketCenter.ticket>0) {
				saleticket();
			}
		};
	
		Thread t = new Thread(r,"thread-1");
		Thread t2 = new Thread(r,"thread-2");
		Thread t3 = new Thread(r,"thread-3");
		
		t.start();
		t2.start();
		t3.start();
	}

	private static void saleticket() {
		synchronized(BasicThread.class){
			if(TicketCenter.ticket>0) {
				System.out.println(Thread.currentThread().getName() + "操作后还剩下：" + TicketCenter.ticket--);
			}
		}
	}
	
}

class TicketCenter {
	public static int ticket = 500;
}
