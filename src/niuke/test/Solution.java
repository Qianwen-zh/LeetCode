package niuke.test;

public class Solution {
    //  1 * 2*3*4  1 *3*4 1*2 *4 1*2*3
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length+1];
        int[] C = new int[length+1];
        int[] D = new int[length];
        int n = 1;
        B[0] = 1;
        C[length-1] =1;
        for(int i=length-1;i>=0;i--){
            n *= A[i];
            if(i!=0){
                C[i-1] = n;
            }
        }
        n=1;
        for(int i=0;i<length;i++){
            n *= A[i];
            B[i+1] = n;
        }
        for(int i=0;i<length;i++){
            D[i] = B[i] * C[i];
        }
        return D;
    }

}
