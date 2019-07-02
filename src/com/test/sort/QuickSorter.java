package com.test.sort;

import java.util.ArrayList;
import java.util.List;

import com.test.business.Sorter;

public class QuickSorter<T extends Comparable<T>> extends Sorter<T> {

	@Override
	protected List<T> doSort(List<T> list) {

		if (list.size() <= 1) {
			return list;
		}

		T pivot = list.remove(0);
		
		List<T> less = new ArrayList<T>();
		List<T> more = new ArrayList<T>();
		List<T> same = new ArrayList<T>();
		
		same.add(pivot);
				
		for (T element : list) {
			if (element.compareTo(pivot) > 0) {
				more.add(element);
			} else if (element.compareTo(pivot) == 0) {
				same.add(element);
			} else {
				less.add(element);
			}
		}
		
		List<T> sorted = new ArrayList<T>();
		
		sorted.addAll(this.doSort(less));
		sorted.addAll(same);
		sorted.addAll(this.doSort(more));
		
		return sorted;
	}
	
}
