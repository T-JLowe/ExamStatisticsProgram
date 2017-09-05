//Made by: Travis Lowe

import java.util.*;
import java.io.FileReader;
import java.io.IOException;


public class ESP 
{
	static int gradesMin(int [] grades) //gives the lowest score in the grade list
	{
		return grades[0]; //since array grades[] was sorted, so position 0 is the lowest
	}
	
	static int gradesMax(int [] grades, int l) //Gives the highest score in the grade list
	{
		return grades[l-1]; //int l is the length, subtracting one gives the last position in the array
	}
	
	static double gradesMean(int [] grades, Scanner fin, int l) //this calculates the average of the array
	{
		double avg = 0; //Setting the answer avg = 0
		for(int i=0; i<l; i++) //loops through the array adding each value to avg
		{
			avg += grades[i];
		}
		avg /= l; //divides avg by the amount of numbers used to give the average
		return avg;
	}
	
	static double gradesMedian(int [] grades, int l)  //this gives the median of the grades
	{
		double med = 0;
		if (l % 2 == 0) //checks if there are an even or odd amount of values in the array
		{
			med = ((double)grades[l/2] + (double)grades[l/2 - 1])/2; //if the number is even, dividing by 2 gives the higher median. so the (length/2)-1 is the lower median, add them together then divide by 2 two for the true median
		}
		else
		{
			med = grades[l/2]; //in the case it is odd, dividing by two gives the middle value
		}
		return med;
	}

	static int [] gradesDistribution(int [] grades, int l) //this gives the grade distribution, (how many A's, B's, etc.)
	{
		
		int[] gradeD = new int[5]; //array is created with 5 spots. 0=A's, 1=B's 2=C's, 3=D's, 4=F's
		for(int i=0; i<l; i++)
		{
			if (grades[i] >= 90) //if the grade is 90 or above, spot 0 is incremented by one, therefore adding an "A"
			{
				gradeD[0]++;
			}
			
			else if(grades[i] >= 80) //if the grade is 80 or above, spot 0 is incremented by one, therefore adding an "B"
			{
				gradeD[1]++;
			}
			
			else if(grades[i] >= 70) //Works the same as the others
			{
				gradeD[2]++;
			}
			
			else if(grades[i] >= 60) //Works the same as the others
			{
				gradeD[3]++;
			}
			
			else //Anything lower than 60 is an F, works the same as the others
			{
				gradeD[4]++;
			}
		}
		return gradeD;
	}

	static void printGradesInfo(int l, int [] grades, Scanner fin)
	{
		System.out.println("There are " + l + " scores in this file."); //Prints the amount of scores
		System.out.println("The lowest score in the file is " + gradesMin(grades) + "%"); //Prints lowest score
		System.out.println("The highest score in the file is " + gradesMax(grades, l) + "%"); //Prints highest score
		System.out.println("The average of the scores is " + gradesMean(grades, fin, l) +"%"); //Prints average of the scores
		System.out.println("The median of the scores is " + gradesMedian(grades, l) + "%"); //Prints the median of the scores
		System.out.println("The grade distribution is as follows:"); //The next 5 lines print the grade distribution
		System.out.println("    " + gradesDistribution(grades, l)[0] + " A's in the file");
		System.out.println("    " + gradesDistribution(grades, l)[1] + " B's in the file");
		System.out.println("    " + gradesDistribution(grades, l)[2] + " C's in the file");
		System.out.println("    " + gradesDistribution(grades, l)[3] + " D's in the file");
		System.out.println("    " + gradesDistribution(grades, l)[4] + " F's in the file"); 
		System.out.println("Thank you for using the grade calculator!"); //Thanks the user
	}	
	
	public static void main(String[] args) throws IOException
	{
		
		System.out.println("Welcome to the grade calculator! Enter the name of the text file containing the scores.");
		
		Scanner cin = new Scanner(System.in); //asking for the file name
		String file = cin.next();
		
		Scanner fin = new Scanner(new FileReader(file)); //reading in the file
		
		int l = fin.nextInt(); //takes the first line of the file and makes that the array length
		int [] grades = new int[l];

		for(int i=0; i<l; i++)  //looping to fill the array from the file
		{
			grades[i] = fin.nextInt();
		}
		Arrays.sort(grades); //sorts the array
		
		for(int i = 0; i<l; i++)
		{
			System.out.println(grades[i]);
		}
		
		printGradesInfo(l, grades, fin); //prints stats on the scores
		
		cin.close(); //closes cin
		fin.close(); //closes fin
	}
} 