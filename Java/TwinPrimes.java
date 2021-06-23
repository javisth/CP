/* Print all twin primes up to a limit */

public class TwinPrimes {
  public static void main(int limit) {
    for(int i=2;i<=limit-2;i++) {
      if(prime(i) && prime(i+2)){
        System.out.println(i+" "+(i+2));
      }
    }
  }
  public boolean prime(int n){
    for(int i=2;i<=n/2;i++){
      if(n%i==0){
        return false;
      }
    }
    return true;
  }
}
