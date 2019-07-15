package com.test.business.testing;

import java.util.List;

import com.test.business.Sorter;

public class UnitTest<T extends Comparable<T>> {
	
	public Sorter<T> sorter;
	public List<T> input;

	public UnitTest (Sorter<T> sorter, List<T> input) {
		this.sorter = sorter;
		this.input = input;
	}
	
	public TestResult doAssert () {
		
		TestResult result = new TestResult();
		
		long startTime = System.nanoTime();
		List<T> output = sorter.sort(this.input);
		long endTime = System.nanoTime();
		
		result.time = Long.valueOf(endTime - startTime);
		
		if (output.size() < 2) {
			result.success = true;
		} else {
			boolean success = true;
			for (int i = 1; i < output.size(); i++) {
				if (output.get(i - 1).compareTo(output.get(i)) > 0) {
					success = false;
					break;
				}
			}
			result.success = success;
		}
	
		return result;
	}
}
