package sorting.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

import sorting.algorithms.business.Sorter;

public class MergeSorter<T extends Comparable<T>> extends Sorter<T> {

	enum MergeStep {
		LEFT,
		RIGHT
	}

	@Override
	protected List<T> doSort(List<T> list) {

		if (list.size() <= 1) {
			return list;
		}
		
		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();
		
		Integer mergeIndex = list.size() / 2;		
		
		for (int i = 0; i < list.size(); i++) {
			if (mergeIndex > 0) {
				left.add(list.get(i));
				mergeIndex--;
			} else {
				right.add(list.get(i));
			}
		}
		
		List<T> sortedLeft = this.doSort(left);
		List<T> sortedRight = this.doSort(right);
		
		return this.merge(sortedLeft, sortedRight);
	}

	private List<T> merge(List<T> left, List<T> right) {
				
		Integer leftIndex = 0;
		Integer rightIndex = 0;
		
		List<T> sortedArr = new ArrayList<T>();
		
		while (leftIndex < left.size() || rightIndex < right.size()) {
			
			MergeStep step = null;
			
			if (leftIndex == left.size()) {
				step = MergeStep.RIGHT;
			} else if (rightIndex == right.size()) {
				step = MergeStep.LEFT;
			} else {
				T leftElement = left.get(leftIndex);
				T rightElement = right.get(rightIndex);
				
				if (leftElement.compareTo(rightElement) < 0) {
					step = MergeStep.LEFT;
				} else {
					step = MergeStep.RIGHT;
				}
			}
			
			if (step == MergeStep.LEFT) {
				sortedArr.add(left.get(leftIndex));
				leftIndex++;
			} else {
				sortedArr.add(right.get(rightIndex));
				rightIndex++;				
			}
		}
		
		return sortedArr;
	}
}
