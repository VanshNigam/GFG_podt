class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Node temp= head;
        while(temp.next !=null){
            temp = temp.next;
        }
        
        Node start = head;
        
        while(start != null && temp != null && start != temp && temp.next != start){
              int sum = start.data + temp.data;
              if(sum == target){
                  ArrayList<Integer> pair = new ArrayList<>();
                  pair.add(start.data);
                  pair.add(temp.data);
                  
                  result.add(pair);
                  
                  start = start.next;
                  temp = temp.prev;
              } else if(sum<target){
                  start = start.next;
              }else{
                  temp = temp.prev;
              }
        }
        return result;
    }
}

