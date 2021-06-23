/* Print Fibonacci numbers up to nth term
 * n=10
 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 */

public class Fibonacci {
  public void main(int n) {
    if(n>=1){
      System.out.println(1+" ");
    }
    int a = 0;
    int b = 1;
    int c;
    for(int i=1;i<n;i++){
      c=a+b;
      System.out.println(c+ " ");
      a = b;
      b = c;
    }
  }
}
   
