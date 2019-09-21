package sorting.algorithms.sort;

import java.util.List;

import sorting.algorithms.business.Sorter;

public class BubbleSorter<T extends Comparable<T>> extends Sorter<T> {

	@Override
	protected List<T> doSort(List<T> list) {
		
		if (list.size() <= 1) {
			return list;
		}
		
		boolean hasSwapped = true;
		
		do {
			hasSwapped = false;
			int index = 1;
			while (index < list.size()) {
				T previous = list.get(index - 1);
				T current = list.get(index);
				
				if (current.compareTo(previous) < 0) {
					list.set(index - 1, current);
					list.set(index, previous);
					hasSwapped = true;
				}
				index++;
			}
		} while (hasSwapped);
		
		return list;
	}

}
