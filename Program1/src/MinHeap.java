/*
 * A class that implements a index 1 minimum heap
 * @author Beth Anderson
 * CSCD 320 -Winter 2016
 */
public class MinHeap {

	private int[] heap;
	private int size; //number of items in the heap

	/*
	 * Create a min heap from an array that has base 1 indexing
	 */
	public MinHeap(int[] array) 
	{
		heap=array;
		this.size = heap.length-1;
		buildMinHeap();
	}

	/*
	 * Make the heap array a min heap
	 */
	public void buildMinHeap()
	{
		for(int seat=(size/2); seat>=1; seat--)
		{
			minHeapify(seat);
		}
	}

	/*
	 * Compare the root of the min heap with an input. If the input is larger than the root of the minheap,
	 * then replace the root.
	 */
	public void compareWithRoot(int input)
	{
		if(input > heap[1])
			replaceRoot(input);
	}

	/*
	 * Returns the underlying array of the heap
	 */
	public int[] getHeapArray()
	{
		return heap;
	}

	/*
	 * Sort the array underlying the heap in descending order
	 */
	public void heapSort()
	{
		for(int i= size; i > 1; i--)
		{
			swap(1,i);
			size --;
			minHeapify(1);
		}
	}

	/*
	 * Replace the root of the heap with a new value while maintaining the heap
	 */
	private void replaceRoot(int value)
	{
		heap[1]=value;
		minHeapify(1);
	}

	/*
	 * Heapify the heap starting from the inputed seat
	 */
	private void minHeapify(int seat)
	{
		if(!isLeaf(seat)) //if the seat is not a leaf node
		{
			int left = leftChild(seat);
			int right = rightChild(seat);
			int min;
			
			if(left != -1 && heap[left] < heap[seat]) //if the left child exits and is smaller than the seat
				min = left; //the min value is the left child
			else
				min = seat; // the min value is the right child

			if(right != -1 && heap[right] < heap[min]) //If the right child exists and is smaller than the min
				min = right;

			if(min != seat) //if the left or right child is smaller
			{
				swap(seat, min); //switch them
				if(left == min)	//if minimum was the left child
					minHeapify(left);
				if(right == min) //if the minimum was the right child
					minHeapify(right);
			}
		}
	}


	/*
	 * Check if the seat is a leaf node in the heap. Return true if the node is a leaf, false if not a leaf
	 */
	private boolean isLeaf(int seat) {
		if (leftChild(seat) == -1) // The left child doesn't exist
			return true;
		else
			return false;
	}

	/*
	 * Swap two elements in the heap
	 */
	private void swap(int seat1, int seat2)
	{
		int tmp;
		tmp = heap[seat1];
		heap[seat1] = heap[seat2];
		heap[seat2] = tmp;
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
		int RChildSeat = ((seat * 2) + 1);
		if (RChildSeat > size)
			return -1; // There is no rightChild
		else
			return RChildSeat;
	}


}
