/* Print the closest primes to a number 
   Input: 9
   Output: 7 or 11
   
   Input: 10
   Output: 11
   
   Input: 14
   Output: 13
*/

class ClosestPrime {
  public void main(int n){
    int i=0;
    while(true){
      if(Prime(n+i)){
        System.out.println(Prime(n+i));
        break;
      }
      if(Prime(n-i)){
        System.out.println(Prime(n-i));
        break;
      }
      i++;
    }
  }
  
