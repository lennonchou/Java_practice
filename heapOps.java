private void percolateUp(int i) {
	//minHeap
	while (i > 0) {
		int parent = (i - 1) / 2;
		if (array[parent] > array[i]) {
			swap(array, parent, i);
		} else {
			break;
		}
		i = parent;
	}

}

private void percolateDown(int i) {
	while (2 * i + 1 < size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int candidate = left;
		if (right < size && array[right] < array[candidate]) {
			candidate = right;
		}
		if (array[i] > array[candidate]) {
			swap(array, i, candidate);
		} else {
			break;
		}
		i = candidate;
	}
}