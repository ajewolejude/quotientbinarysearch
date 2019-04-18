import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.ArrayList;
class QuotientUsingBinarySearch {
  
  public static ArrayList<Integer> divide(int x, int y)
{
    // handle divisibility by 0
    if (y == 0)
    {
        System.out.println("Error!! Divisible by 0");
        
    }
 
    // store sign of the result
    int sign = 1;
    if ((x * y) < 0){
      sign = -1;
    }
 
    // convert both dividend and divisor to positive
    x = Math.abs(x);
    y = Math.abs(y);
 
    // initialize quotient by 0
    int quotient = 0;
    
    //create arraylist to store possible quotients
 	ArrayList<Integer> quots = new ArrayList<Integer>();
    
    // loop till dividend x is more than the divisor y
    while (x >= y)
    {
       x = x - y;        // perform reduction on dividend
      
       quotient++;        // increase quotient by 1
      //store in arraylist
      int signedQuot = sign * quotient;
      quots.add(signedQuot);
      
    }
 	
    //printf("Remainder is %d\n", x);
 
    return quots;
}
  
  
  //coverting the list to an array to be consumed by the Binary search
  public static int[] convertListToArray(ArrayList<Integer> list){
    int size  = list.size();
    int q[] = new int[size];
    for (int x=0; x<list.size(); x++){
      
    q[x] = list.get(x);
    
  }
    return q;
  }
  

   
    //Recursivebinarysearch
    public static int runBinarySearchRecursively(
  int[] sortedArray, int key, int low, int high,int originalLength ) {
    int middle = (low + high) / 2;
         
    if (high < low) {
        return -1;
    }
 
    if ( (sortedArray[middle] <= key) && (middle==originalLength)) {
        return sortedArray[middle];
    } else if (key < sortedArray[middle]) {
        return runBinarySearchRecursively(
          sortedArray, key, low, middle - 1, originalLength);
    } else {
        return runBinarySearchRecursively(
          sortedArray, key, middle + 1, high, originalLength);
    }
}
  
  public static void main(String[] args) {
    
    
    System.out.println("Enter numerator");
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    
    System.out.println("Enter denominator");
    int y = sc.nextInt();
    
   
    int realQuotient = (runBinarySearchRecursively( convertListToArray(divide(x,y)), x,0, convertListToArray(divide(x,y)).length-1, convertListToArray(divide(x,y)).length-1));
    System.out.println("Quotient is = "+ realQuotient);
    
    int rem = x- (y*realQuotient);
    System.out.println("Remainder is = "+ rem);
    
    
  }
}
