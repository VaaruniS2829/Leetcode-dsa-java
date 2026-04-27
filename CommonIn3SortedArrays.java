import java.util.*;

class Solution {
    ArrayList<Integer> commonElements(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < A.length && j < B.length && k < C.length) {
            
            if (A[i] == B[j] && B[j] == C[k]) {
                
                // Avoid duplicates
                if (result.isEmpty() || result.get(result.size() - 1) != A[i]) {
                    result.add(A[i]);
                }
                
                i++;
                j++;
                k++;
            } 
            else if (A[i] < B[j]) {
                i++;
            } 
            else if (B[j] < C[k]) {
                j++;
            } 
            else {
                k++;
            }
        }
        return result;
    }
}
