class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        // since the Comparator value is null
        // it follows natural ordering
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for (int n : nums){
            minHeap.add(n);
            if(minHeap.size()>k)
                minHeap.poll();
            //keep the heap of size k and remove all the smaller elements
            //leaving at the end the kth smallest
        }
        
        return minHeap.poll();
    }
}