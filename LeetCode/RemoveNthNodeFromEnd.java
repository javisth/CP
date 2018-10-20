
/*
 public class ListNode {
    int val;
   ListNode next;
    ListNode(int x) { val = x; }
 }
 */
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode temp = head;
        int c =0;
        int c1=1;
        int len=0;
        if(head==null)
            return head;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        if(c<=1){
            return null;
        }
        temp=head;
       if(c==n){
           head=head.next;
           return head;
        }
        
        len=c-n+1;
        while( temp!= null && len!=1){
            prev=temp;
            temp=temp.next;
            len--;
        }
        
        
        prev.next=prev.next.next;
        
        return head;
    }
}
