import java.io.*;
import java.util.Scanner;

public class Richest {
	
static final int  MAX_NUM_IN_RAM = 11;

	public static void main(String[] args) throws FileNotFoundException 
	{
		FileReader readFile = new FileReader("testdata.txt");
		MinHeap heap = readInNumbers(readFile);
		outputToFile(heap);
		
		//for(int i=0; i<MAX_NUM_IN_RAM;i++)
			//System.out.println(heap.removeRoot());
		
		System.out.println("all done!");
	}

	private static MinHeap readInNumbers(FileReader readFile) throws FileNotFoundException
	{
		int[] initalHeap = new int [MAX_NUM_IN_RAM+1];
		Scanner input = new Scanner(readFile);
		MinHeap heap = null;

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
					heap = new MinHeap(initalHeap); //create the initalHeap

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

		private static MinHeap compareWithRoot(int input, MinHeap heap)
		{
			if(input > heap.getRoot())
				heap.replaceRoot(input);
			return heap;
		}

		private static void outputToFile(MinHeap minHeap)
		{
			int[] output = new int[MAX_NUM_IN_RAM];
			for(int i=0; i<MAX_NUM_IN_RAM;i++)
			{
				output[i] = minHeap.removeRoot();
			}

			try {

				BufferedWriter writer = new BufferedWriter(new FileWriter("richest_output.txt"));
				for ( int i=0;i<output.length;i++)
				{      
					writer.write(output[i] + "\n");
					System.out.println(output[i]);
				}
				writer.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}

