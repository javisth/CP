/* WAP to accept a sentence and find out the number of words in it */

public class Sentence {
  public void main(String s){
    int sp = 0;
    s = s + " ";
    // count number of spaces
    for(int i=0;i<s.length();i++){
      char ch = s.charAt(i);
      if(ch==" "){
        sp++;
      }
    }
    System.out.println("The number of words are "+ sp);
  }
}
