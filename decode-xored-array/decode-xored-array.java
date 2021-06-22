class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int arr[] = new int[n +1];
        
        // set the first index to first 
        arr[0] = first;
        
        // since encoded[i] = arr[i] XOR arr[i+1], arr[i+1] = encoded[i] XOR arr[i]
        
        for(int i = 0 ; i< n; i++){
            arr[i+1] = encoded[i] ^ arr[i];
        }
        return arr;
    }
}