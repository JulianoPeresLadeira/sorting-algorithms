package com.test.business.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.business.Sorter;

public class TestLog<T extends Comparable<T>> {

	private Map<Sorter<T>, List<TestResult>> resultMap;

	public TestLog() {
		this.resultMap = new HashMap<Sorter<T>,List<TestResult>>();
	}
	
	public void addResult(Sorter<T> sorter, TestResult testResult) {
		var resultList = this.resultMap.get(sorter);
		
		if (resultList == null) {
			resultList = new ArrayList<TestResult>();
			this.resultMap.put(sorter, resultList);
		}
		
		resultList.add(testResult);
	}
	
	public void log() {
		
		this.resultMap.entrySet().forEach(
			entry -> {
				
				boolean hasError = false;
				long avgRunTime = 0;
				
				for (var testResult : entry.getValue()) {
					hasError |= !testResult.success;
					avgRunTime += testResult.time;
				}
				
				avgRunTime /= entry.getValue().size();
				
				StringBuilder loggedValue = new StringBuilder();
				
				loggedValue.append(entry.getKey().getClass().getName());
				loggedValue.append(": ");
				
				loggedValue.append(hasError ? "ERROR - " : "OK - ");
				
				loggedValue.append("AvgRunTime: ");
				loggedValue.append(avgRunTime);
				
				System.out.println(loggedValue.toString());
			}
		);
	}
}
