class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node temp=head;
        Node insert=new Node(data);
        
        Node prev=head;
        if(head==null)return insert;
        if(head.data>data){
            while(temp.next!=head)
                 temp=temp.next;
            temp.next=insert;
            insert.next=head;
            return insert;
        }
        
        while(temp.next!=head){
            if(temp.data>data)break;
            prev=temp;
            temp=temp.next;
        }
        if(temp.data>data){
            Node t=prev.next;
            prev.next=insert;
            insert.next=t;
        }
        else{
            temp.next=insert;
            insert.next=head;
        }
        return head;
    }
}