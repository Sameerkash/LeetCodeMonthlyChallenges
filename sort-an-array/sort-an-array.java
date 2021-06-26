class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> n = new PriorityQueue<>();
        
        for(int i : nums)
            n.add(i);
        
        int i = 0;
        while(!n.isEmpty()){
            nums[i] = n.poll();
            i++;
        }
        return nums;
    }
}