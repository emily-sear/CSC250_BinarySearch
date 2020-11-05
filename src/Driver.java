import java.util.Random;
public class Driver
{
	public static void main(String[] args)
	{
		Random r = new Random();
		int[] ar = new int[100];
		
		//fill up our array with random numbers between 0 and 1000
		for(int i =0; i < ar.length; i++)
		{
			ar[i] = r.nextInt(1000);
		}
		//Driver.displayArray(ar);
		
		int[] ar2 = {2,3,1,5};
		Driver.displayArray(ar2);
		Driver.merge(ar2, 0, 1, 2, 3);
		Driver.displayArray(ar2);
		
		//System.out.println(Driver.factorialIterative(5));
		//System.out.println(Driver.factorialRecursion(5));
	}
	
	static void mergeSort(int[] ar, int begin, int end)
	{
		if(begin != end)
		{
			int begin1 = begin;
			int end1 = begin + (end - begin) /2; 
			int begin2 = end1 + 1;
			int end2 = end;
			Driver.mergeSort(ar, begin1, end1);
			Driver.mergeSort(ar, begin2, end2);
			Driver.merge(ar, begin1, end1, begin2, end2);
			
		}
	}
	
	static void merge(int[] ar, int begin1, int end1, int begin2, int end2)
	{
		//assuming that everything from begin1 to begin 2 are already sorted and the same from end1 and end2
		//Can't just take the length of the array that is passed in, because you could just be looking at a certain section 
		
		int[] temp = new int[(end2 - begin1) + 1];
		int pos1 = begin1;
		int pos2 = begin2;
		
		//fills up temp with a sorted list 
		for(int i = 0; i < temp.length; i++)
		{
			if(pos1 <= end1 && pos2 <= end2)
			{
				if(ar[pos1] < ar[pos2])
				{
					temp[i] = ar[pos1];
					pos1++;
				}
				else
				{
					temp[i] = ar[pos2];
					pos2++;
				}
			}
			else
			{
				//either pos1 or pos2 is off the end of their list and the other guy is the default winner
				if(pos1 > end1)
				{
					temp[i] = ar[pos2];
					pos2++;
				}
				else
				{
					temp[i] = ar[pos1];
					pos1++;
				}
			}
		}
		
		//copy temp back over ar from begin1 to end2
		int tempCounter = 0;
		for(int j = begin1; j <= end2; j++)
		{
			//arrays are passed by address so these are permanant changes
			ar[j] = temp[tempCounter];
			tempCounter++;
		}
	}
	
	static int factorialIterative(int val)
	{
		int temp = 1;
		for(int i = val; i >= 1; i--)
		{
			temp = temp * i;
		}
		return temp;
	}
	
	static int factorialRecursion(int val)
	{
		//in line if statement 
		//recursion uses a lot of memory 
		return val == 1 ? 1: val*factorialRecursion(val-1);  //String a = val % 2 == 0? "Hello" : "Word";
		
		//this does the same thing as the code above
		/**
		if(val == 1)
		{
			return 1;
		}
		else
		{
			return val * factorialRecursion(val - 1);
		}
		**/
	}
	
	static void displayArray(int[] ar)
	{
		 for(int i = 0; i < ar.length; i++)
		 {
			 System.out.println(ar[i]);
		 }
	}
}
