package com.test.sort;

import java.util.ArrayList;
import java.util.List;

import com.test.business.Sorter;

public class InsertionSorter<T extends Comparable<T>> extends Sorter<T> {

	@Override
	protected List<T> doSort(List<T> list) {

		if (list.size() <= 1) {
			return list;
		}

		List<T> sortedList = new ArrayList<T>();
		
		while (list.size() > 0) {
			T element = list.remove(0);
			this.orderedInsert(sortedList, element);
		}
		
		return sortedList;
	}
	
	private void orderedInsert(List<T> list, T element) {
		int index = 0;
		boolean inserted = false;
		while (!inserted) {
			if (index < list.size()) {
				
				if (element.compareTo(list.get(index)) < 1) {
					list.add(index, element);
					inserted = true;
				} else {
					index++;
				}
			} else {
				list.add(element);
				inserted = true;
			}
		}
	}

}
