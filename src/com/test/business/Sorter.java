package com.test.business;

import java.util.ArrayList;
import java.util.List;

public abstract class Sorter<T extends Comparable<T>> {

	public final List<T> sort(List<T> list) {

		if (!this.isValidInput(list)) {
			return null;
		}
		
		List<T> clonedList = new ArrayList<T>(list);
		
		return this.doSort(clonedList);
	}
	
	public boolean isValidInput(List<T> list) {
		return list != null;
	}
	
	protected abstract List<T> doSort(List<T> list);
}
