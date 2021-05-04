/* Print all numbers between m and n where all digits of the number are prime */
class PrimeDigs{
  public void main(int m, int n){
    for(int i=m;i<=n;i++){
      if(Prime(m)){
        System.out.println(m);
      }
    }
  }
  
  // Helper function sending in each digit to check if its prime
  public boolean Prime(int n){
    boolean allPrime = false;
    int dig=0;
    while(n!=0){
      dig=n%10;
      if(PrimeDig(dig)){
        allPrime = true;
      }
      n/=10;
    }
    return allPrime;
  }
  
  // Checking for prime digits
  public boolean PrimeDig(int n){
    for(int i=2;i<n/2;i++){
      if(n%i==0){
        return false;
      }
    }
    return true;
  }
}
