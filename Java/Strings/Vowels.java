/* WAP to accept a string and find out the number of vowels */

public class Vowels {
  public void main(String s) {
    int v = 0;
    for(int i=0;i<s.length();i++) {
      char ch = s.charAt(i);
      if(ch == 'a' || ch == 'e' || ch == 'i' || ch =='o' || ch== 'u'){
        v++;
      }
      if(ch == 'A' || ch == 'E' || ch == 'I' || ch =='O' || ch== 'U'){
        v++;
      }
    }
    System.out.println("The number of vowels are "+ v);
  }
}
