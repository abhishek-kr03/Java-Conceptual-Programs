package com.multi_threading;

// Class Queue represents a queue data structure
class Queue{
	
	private int data = 0; // data to be produced and consumed
	boolean dataIsPresent = false; // flag to check if data is present in the queue
	
	// synchronized method to set data in the queue by the producer
	synchronized public void setData(int data ) {
		if(dataIsPresent == false) { // if no data is present, producer can produce data
			this.data = data;
			System.out.println("Producer produced the data " + data);
			dataIsPresent = true;
			notify(); // notify the consumer that data has been produced
		}
		else { // if data is already present, producer goes into waiting state
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// synchronized method to get data from the queue by the consumer
	synchronized public void getData() {
		if (dataIsPresent = true) { // if data is present, consumer can consume data
			System.out.println("Consumer consumed the data " + data);
			dataIsPresent = false;
			notify(); // notify the producer that data has been consumed
		}
		else { // if no data is present, consumer goes into waiting state
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// Producer class that extends Thread
class Producer extends Thread{
	Queue q; // Queue object
	public Producer(Queue q) {
		this.q = q;
	}
	@Override
	public void run() { // override run method of Thread class
		try {
			int i = 1;
			for ( ; ; ) { // infinite loop to continuously produce data
				q.setData(i++);
				Thread.sleep(1000); // producer giving delay for 1 second after producing data
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

// Consumer class that extends Thread
class Consumer extends Thread{
	Queue q; // Queue object
	public Consumer(Queue q) {
		this.q = q;
		
	}
	@Override
	public void run() { // override run method of Thread class
		try {
			for ( ; ; ) { // infinite loop to continuously consume data
				q.getData();
				Thread.sleep(1000); // consumer taking delay for 1 second after consuming data
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// Main class
public class Main {
	public static void main(String[] args) {
		Queue q = new Queue(); // create Queue object
		Producer p = new Producer(q); // create Producer object
		Consumer c = new Consumer(q); // create Consumer object
		
		p.start(); // start producer thread
		c.start(); // start consumer thread
	}
}
































