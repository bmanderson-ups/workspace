import java.io.*;
import java.util.Scanner;

public class OldRichest {
	
static final int  MAX_NUM_IN_RAM = 10000;

	public static void main(String[] args) throws FileNotFoundException 
	{
		FileReader readFile = new FileReader("num.txt");
		OldMinHeap heap = readInNumbers(readFile);
		heap.heapSort();
		//for(int i=0;)
		outputToFile(heap);
		
		
		//for(int i=0; i<MAX_NUM_IN_RAM;i++)
			//System.out.println(heap.removeRoot());
		
		System.out.println("all done!");
	}

	private static OldMinHeap readInNumbers(FileReader readFile) throws FileNotFoundException
	{
		int[] initalHeap = new int [MAX_NUM_IN_RAM+1];
		Scanner input = new Scanner(readFile);
		OldMinHeap heap = null;

		if(input.hasNext()) //There is at least one number in the file
		{
			int i=1;
			try {
				while(input.hasNext() && i<(MAX_NUM_IN_RAM+1)) //input 10 numbers into the heap
					{
							initalHeap[i] = input.nextInt();
							i++;
					}

				if(heap == null) //we haven't created a heap yet
					heap = new OldMinHeap(initalHeap); //create the initalHeap

				while(input.hasNext())	//While there are numbers in the file
					{
						heap = compareWithRoot(input.nextInt(),heap); //Compare them with the root	
					}
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				input.close();
				
			}
		return heap;
		}

		private static OldMinHeap compareWithRoot(int input, OldMinHeap heap)
		{
			if(input > heap.getRoot())
				heap.replaceRoot(input);
			return heap;
		}

		private static void outputToFile(OldMinHeap heap)
		{
			int[] output = heap.getHeapArray();
			//int[] output = new int[MAX_NUM_IN_RAM];
			//for(int i=0; i<MAX_NUM_IN_RAM;i++)
			{
				//output[i] = minHeap.removeRoot();
			}

			try {

				BufferedWriter writer = new BufferedWriter(new FileWriter("numoutput"));
				for ( int i=1;i<output.length;i++)
				{      
					writer.write(output[i] + "\n");
					//System.out.println(output[i]);
				}
				writer.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}

