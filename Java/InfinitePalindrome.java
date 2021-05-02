/* Input - 78.     +87 = 165+561 = 726+627= 1353+3531=
Output - 4884

Input - 42.     +24=
Output = 66

Add the reverse of the number to itself until you get a palindrome */

class InfinitePalindrome{
  public void main(int n) {
    int copy = n;
    while(copy!=reverse(copy)){
      copy = copy + reverse(copy);
    }
  }
  public int reverse(int n){
    int copy = n;
    int rev=0;
    while(copy!=0){
      rev = (rev*10) + copy%10;
      copy/=10;
    }
    return rev;
  }
}
      
