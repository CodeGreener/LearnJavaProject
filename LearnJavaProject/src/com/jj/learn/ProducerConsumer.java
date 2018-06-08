package com.jj.learn;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

	abstract static class Producer<T> implements Runnable {
		private BlockingQueue<T> q = null;
		public Producer(BlockingQueue<T> q, T) {
			this.q = q;
		}
		
		public abstract T produce(T o) ;

		@Override
		public void run() {
			try {
				q.put(this.produce());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	static class Consumer<T> implements Runnable {
		private BlockingQueue<T> q = null;
		public Consumer(BlockingQueue<T> q) {
			this.q = q;
		}
		public void consume(T o) {
			//do something
			System.out.println("consuming " + o);
		}
		@Override
		public void run() {
			try {
				this.consume(q.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		BlockingQueue q = new LinkedBlockingQueue();
		Producer p = new Producer();
	}
}
