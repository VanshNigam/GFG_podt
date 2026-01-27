class Solution {
    Node removeDuplicates(Node head) {
        
        Node temp=head;
        while(temp!=null)
        {
            Node nextNode=temp.next;
            
            while(nextNode!=null && temp.data == nextNode.data)
            {
                nextNode=nextNode.next;
            }
            
            temp.next=nextNode;
            if(nextNode!=null) nextNode.prev=temp;
            
            temp=temp.next;
        }
        return head;
    }
}