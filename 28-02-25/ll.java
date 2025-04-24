// Cliff Shaw is working on the singly linked list.
// He is given a list of boxes arranged as singly linked list,
// where each box is printed a positive number on it.

// Your task is to help Mr Cliff to find the given list is equivalent to 
// the reverse of it or not. If yes, print "true", otherwise print "false"

// Input Format:
// -------------
// Line-1: space separated integers, boxes as list.

// Output Format:
// --------------
// Print a boolean a value.


// Sample Input-1:
// ---------------
// 3 6 2 6 3

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 3 6 2 3 6

// Sample Output-2:
// ----------------
// false

import java.util.*;
class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
class ll{
    public static Node createLinkedList(int[] arr){
        if(arr.length==0) return null;
        Node head=new Node(arr[0]);
        Node curr=head;
        for(int i=1;i<arr.length;i++){
            curr.next=new Node(arr[i]);
            curr=curr.next;
        }
        return head;
    }
   public static boolean checkpalindrome(Node head){
       Stack<Integer> s=new Stack<>();
       Node temp1=head;
       while(temp1!=null){
           s.push(temp1.val);
           temp1=temp1.next;
       }
       Node temp2=head;
       while(temp2!=null){
           int temp=s.pop();
           if(temp!=temp2.val){
               return false;
           }
           temp2=temp2.next;
       }
      return true;
   }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        int[] arr=new int[input.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(input[i]);
        }
        
        Node original=createLinkedList(arr);
        System.out.println(checkpalindrome(original));
    }
}
