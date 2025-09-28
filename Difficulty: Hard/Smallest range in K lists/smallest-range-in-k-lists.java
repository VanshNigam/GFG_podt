class Solution {
    static class Element {
        int value, row, col;

        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        // Initialize heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(new Element(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        while (true) {
            Element minElem = minHeap.poll();

            int currRange = max - minElem.value;
            if (currRange < end - start) {
                start = minElem.value;
                end = max;
            }

            // Move to the next element in the same row
            if (minElem.col + 1 < n) {
                int nextVal = arr[minElem.row][minElem.col + 1];
                minHeap.offer(new Element(nextVal, minElem.row, minElem.col + 1));
                if (nextVal > max) {
                    max = nextVal;
                }
            } else {
                break;  // We've reached the end of one of the lists
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(start);
        res.add(end);
        return res;
    }
}