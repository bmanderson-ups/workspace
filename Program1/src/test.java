
public class test {

	public static void main(String[] args) {
		
		//int[] array = {3,1,4,5,7,8,2};
		int[] array = new int[50];
		for(int i = 0; i<array.length;i++)
		{
			array[i] = (int) (Math.random()*100);
		}
		
		MinHeap heap = new MinHeap(array);
		//heap.print();
		
		for(int i =0; i<array.length;i++)
		{
			System.out.println(heap.removeRoot());
		}
		//heap.heapSort();
		
		//int[] output = heap.returnHeapAsSortedArray();
		
		//for(int i=0;i<output.length;i++)
		{
			//System.out.println(output[i]);
		}
		
	}

}
