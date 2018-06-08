package com.jj.learn;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoinTest {

	private static final int sortNumbers = 400;
	
	public static void main(String[] args) {
		Integer n = 20;
		ForkJoinTask<Integer> result = ForkJoinPool.commonPool().submit(new Fibonacci(n));
		try {
			System.out.println("F(" + n + ")=" + result.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ForkAndJoinTest fjt = new ForkAndJoinTest();
		fjt.mergeSort();
		

	}
	
	private synchronized void mergeSort() {
		// merge sort
		long[] numbers = new long[sortNumbers];
		for (int i = 0; i < sortNumbers; i++) {
			numbers[i] = (long) (Math.random() * 100);
		}

		ForkJoinPool.commonPool().submit(
				new MergeSortAction(numbers, 0, sortNumbers - 1));

		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static class Fibonacci extends RecursiveTask<Integer> {
		final int n;
		private Fibonacci(Integer n) {
			this.n = n;
		}
		@Override
		protected Integer compute() {
			if (n <= 1) {
				return n;
			}
			
			Fibonacci f1 = new Fibonacci(n-1);
			f1.fork();
			
			Fibonacci f2 = new Fibonacci(n-2);
			return f2.compute() + f1.join();
		}
		
	}
	
	private static class MergeSortAction extends RecursiveAction {
		final long[] toBeSorted;
		final int start;
		final int end;
		private MergeSortAction(long[] toBeSorted, int start, int end) {
			this.toBeSorted = toBeSorted;
			this.start = start;
			this.end = end;
			
			//System.out.println("To be sorted:");
			//this.printArray(this.toBeSorted, start, end);
		}
		@Override
		protected void compute() {
			if (this.end - this.start <= THRESHOLD) {
				this.sortSequentially(this.start, this.end);
				return;
			}
			
			
			int mid = (this.end - this.start) / 2 + this.start;
			
			MergeSortAction a1 = new MergeSortAction(toBeSorted, start, mid);
			MergeSortAction a2 = new MergeSortAction(toBeSorted, mid+1, end);
			
			a1.fork();
			a2.fork();
			
			a1.join();
			a2.join();
			//invokeAll(a1, a2);
			
			merge(start, mid, end);
			
			System.out.println("Sorted:");
			this.printArray(this.toBeSorted, start, end);
			
		}
		
		private void merge(int start, int mid, int end) {
			System.out.println("merging...");
			long[] intermediate = Arrays.copyOf(this.toBeSorted, this.toBeSorted.length);
			int index = start;
			int i, j;
			for (i = start, j = mid+1; i <= mid && j <= end; index ++) {
				if (intermediate[i] <= intermediate[j]) {
					this.toBeSorted[index] = intermediate[i];
					i ++;
				} else {
					this.toBeSorted[index] = intermediate[j];
					j ++;
				}
			}
			if (i < mid) {
				for (int left = i; left <= mid; left ++) {
					this.toBeSorted[index] = intermediate[left];
					index ++;
				}
			}
			else if (j <= end) {
				for (int left = j; left <= end; left ++) {
					this.toBeSorted[index] = intermediate[left];
					index ++;
				}
			}
		}
		
		static final int THRESHOLD = 10;
	    private void sortSequentially(int lo, int hi) {
	    	Arrays.sort(this.toBeSorted, lo, hi+1);
	    	System.out.println("sequentially sorted ");
			this.printArray(toBeSorted, start, end);
			
	    }
		private void printArray(long[] a, int start, int end) {
			for (int i = start; i <= end; i ++) {
				System.out.print(a[i]  + ",");
			}
			System.out.println();
		}
	}
}
