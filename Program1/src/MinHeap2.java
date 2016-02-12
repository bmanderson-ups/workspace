
public class MinHeap2 {

	public int[] heap;
	public int size;

	public MinHeap2(int[] array) 
	{
		size = array.length;
		heap = array;
		buildMaxHeap();

	}

	public void buildMaxHeap()
	{
		for(int index = (int) Math.floor(size/2); index>=1; index--)
		{
			heapify(index);
		}
	}

	private void heapify(int seat) {
		int temp;
		int leftChildIndex = leftChild(seat);
		int rightChildIndex = rightChild(seat);

		if (!isLeaf(seat)) {
			
			if (heap[leftChildIndex] < heap[seat]) // Left child is the smallest
			{
				temp = heap[leftChildIndex];
				heap[leftChildIndex] = heap[seat];
				heap[seat] = temp;
				heapify(leftChildIndex);
			}

			if (heap[rightChildIndex] < heap[seat]) // Right child is the smallest
			{
				temp = heap[rightChildIndex];
				heap[rightChildIndex] = heap[seat];
				heap[seat] = temp;
				heapify(rightChildIndex);
			}
		}

	}

	private boolean isLeaf(int seat) {
		if (leftChild(seat) == -1) // The left child doesn't exist
			return true;
		else
			return false;
	}

	/*
	 * Return the seat of parent node. Returns -1 if the parent does not exist.
	 *
	private int parent(int seat) {
		int parentSeat = (int) Math.floor(seat / 2);
		if (parentSeat < 1)
			return -1; // There is no parent!
		else
			return parentSeat;
	}

	/*
	 * Return the seat of left child node. Returns -1 if the left child does not
	 * exist.
	 */
	private int leftChild(int seat) {
		int LChildSeat = (seat * 2);
		if (LChildSeat > size)
			return -1; // There is no leftChild
		else
			return LChildSeat;
	}

	/*
	 * Return the seat of right child node. Returns -1 if the right child does
	 * not exist.
	 */
	private int rightChild(int seat) {
		int RChildSeat = (seat * 2 + 1);
		if (RChildSeat > size)
			return -1; // There is no leftChild
		else
			return RChildSeat;
	}

}
