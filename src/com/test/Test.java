package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.business.Sorter;
import com.test.business.testing.TestResult;
import com.test.business.testing.UnitTest;
import com.test.sort.InsertionSorter;

public class Test {

	public static void main(String[] args) {
		Sorter<Integer> sorter = new InsertionSorter<Integer>();
		
		List<UnitTest<Integer>> tests = new ArrayList<UnitTest<Integer>>();
		
		tests.add(new UnitTest<Integer>(sorter, new ArrayList<Integer>()));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {1,2,3})));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {1,2,3,3,2,1})));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {-1,-2,-3,-4})));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {12,31,23,12,312,3,123,12,23,5,345,4,645,3456,324,5453,634,345,5,4326,45,34,5324,534,3})));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {1,2,1,2,3,12,312,31,2,31,23,123,1,23,123,12,31,23,12,312,3,123,12,23,5,345,4,645,3456,324,5453,634,345,5,4326,45,34,5324,534,3})));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {31,23,12,312,3,123,12,23,5,345,4,645,3456,324,5453,634,345,5,4326,45,34,5324,534,3})));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {123,12,31,23,12,312,3,123,12,23,5,345,4,645,3456,324,5453,634,345,5,4326,45,34,5324,534,3})));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {3,123,12,23,5,345,4,645,3456,324,5453,634,345,5,4326,45,34,5324,534,3})));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {2,3,12,312,31,2,31,23,123,1,23,123,12,31,23,12,312,3,123,12,23,5,345,4,645,3456,324,5453,634,345,5,4326,45,34,5324,534,3})));
		tests.add(new UnitTest<Integer>(sorter, Test.from(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70})));

		tests.forEach(test -> {
			TestResult res = test.doAssert();
						
			System.out.println(res.success + " - " + res.time);
		});
	}
	
	private static List<Integer> from (int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for (int x : arr) {
			list.add(x);
		}
		return list;
	}
}
