

class Solution {
    public static int countLoopLength(Node nodeinloop)
    {
        Node temp = nodeinloop;
        int count = 1;
        while(temp.next != nodeinloop)
        {
            count++;
            temp=temp.next;
        }
        return count;
    }
    public int lengthOfLoop(Node head) {
            Node slow = head;
            Node fast =head;
             while(fast != null && fast.next != null)
             {
                 slow = slow.next;
                 fast = fast.next.next;
                 
                 
                 if(slow == fast)
                 {
                     return countLoopLength(slow);
                 }
             }
        return 0;
        
    }
    
}

