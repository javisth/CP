/* Print all palindromes between m and n */
class Palindromes{
  public void main(int m, int n){
    for(int i=m;i<=n;i++){
      //if the reverse of the number is equal to itself, its a palindrome
      if(reverse(i)==i){
        //if true print the number
        System.out.println(i);
      }
    }
  }
  public int reverse(int n){
    int copy=n;
    int rev=0;
    // Reversing the number
    while(copy!=0){
      //reversing the number by extracting last digit of the number and placing it in front
      rev=(rev*10)+(copy%10);
      //removing the last digit of the number
      copy/=10;
    }
    return rev;
  }
}
