class Solution {
    public int[] countBits(int n) {
        int f[] = new int[n+1];
        //  if num is even, f[i] = f[i/2] else f[i] = 1 + f[i/2];
        // x >> 1 is equal to x/2 and i&1 will tell if the number is even or odd since LSB will be 1
        for(int i = 1; i<= n; i++) f[i] = f[i >> 1] + (i&1);
        
        return f;
    }
}