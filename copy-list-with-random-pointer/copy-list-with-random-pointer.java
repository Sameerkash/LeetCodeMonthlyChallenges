/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
    
    Node original=head;
    Node curOriginal=head;
    
    // step 1
    while(original.next != null ){
        Node copy=new Node(original.val);
        Node temp=original.next;
        original.next=copy;
        copy.next=temp;
        original=original.next.next;
    }
    original.next=new Node(original.val);
    
    //step 2
    while(curOriginal!= null && curOriginal.next != null){
        if(curOriginal.random != null){
            curOriginal.next.random=curOriginal.random.next;
        }
        curOriginal=curOriginal.next.next;
    }
    
    //step 3 and 4
    Node orig=head;
    Node copyCur=head.next;
    Node copyHead=head.next;
    
    while(orig.next != null && copyCur.next != null){
        orig.next=orig.next.next;
        copyCur.next=copyCur.next.next;
        orig=orig.next;
        copyCur=copyCur.next;
    }
    orig.next=null;
    
    return copyHead;
    }
}