import java.io.*;
class FCTRL2
{
    public static void main(String args[]) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int dig[] = new int[200]; // array for storing each digit of the number
        int temp = 0;  // variable to store result of the subsequent multiplication
        int sum = 0;
        int res=0;  // result of multiplication
        // storing the number in the array
        int copy = 0;  // variable to store copy of number
        int count = 0; // counter to keep track of size of number
        int count1 = 0; // variable to track digits in array
        int counter = 0; // counter to keep track of each digit multiplied
        int copy2=0; // storing copy of number
        
        // Number of test cases
        int n = Integer.parseInt(br.readLine());
      for(int m=0;m<n;m++) {  
        // taking input for test case value
    
        int x = Integer.parseInt(br.readLine());
        // if the number is 0
        if(x==0) {
          System.out.println(1);
          break;
        }
        copy=x;
        count=0;
        counter=0;
        temp=0;
        count1=0;
        while(copy!=0){
            dig[count1] = copy%10;
            count1++;
            count++;
            copy/=10;
        }
        // performing the multiplication
        for(int i=1;i<x;i++) {
            // setting track numbers to default value after multiplication for next number
            counter=0; 
            temp=0;
          while(counter < count) {  
            res=dig[counter]*i + temp;   // the multiplication operation
            dig[counter] = res%10; // storing the digit of result since it always remains in position
            temp = res/10;  // storing the result that is to be added to next multiplication
            counter++;  // moving to next position of array
          }
          while(temp > 0) {
              dig[count] = temp%10;
              temp=temp/10;
              count++;
          }
            
            
        }
        if(counter==0)
          counter=1;
        // printing the result;
        for(int i=count-1;i>=0;i--) {
             System.out.print(dig[i]);
        }
        System.out.println();
        
    }
}
}
        

   
