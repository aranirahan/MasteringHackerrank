import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DataType {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int myIntegerNumber;
        double myDoubleNumber;
        String myString;

        /* Read and save an integer, double, and String to your variables.*/
        myIntegerNumber = i + scan.nextInt();
        myDoubleNumber = d + scan.nextDouble();
        String scanString = scan.nextLine();
        scanString = scan.nextLine();
        myString = s + scanString;
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */
        System.out.println(myIntegerNumber);

        /* Print the sum of the double variables on a new line. */
        System.out.println(myDoubleNumber);
		
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(myString);

        scan.close();
    }
}