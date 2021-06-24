/* Print the reverse fibonacci series */

public class RevFib {
  public void main(int n) {
    int a[] = new int[n];
    a[0]=1;
    a[1]=1;
    for(int i=2;i<n;i++){
      a[i]=a[i-1]+a[i-2];
    }
    for(int i=n-1;i>=0;i--){
      System.out.println(a[i]);
    }
  }
}
    
