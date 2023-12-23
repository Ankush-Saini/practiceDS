// you can also use imports, for example:

import java.util.*;
/*Zemoso Technologies
For ex, given nums = [10, 1, 3, 1, 2, 2, 1, 0, 4], there are three non-overlapping segments, each whose sum is equal to 4: (1, 3), (2, 2), (0, 4).
Expected output = 3
*/
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        Map<Integer, List<Integer[]>> indices = new HashMap<>();
        int sum = 0, max = 0;

        for (int i = 0; i < A.length - 1; i++) {
            sum = A[i] + A[i + 1];
            Integer[] arr = new Integer[2];
            arr[0] = i;
            arr[1] = i + 1;
            if (indices.get(sum) != null && isOverLapping(arr, indices.get(sum))) {
                continue;
            }
            if (indices.containsKey(sum)) {
                List<Integer[]> temp = indices.get(sum);
                temp.add(arr);
                indices.put(sum, temp);
            } else {
                List<Integer[]> temp = new ArrayList<>();
                temp.add(arr);
                indices.put(sum, temp);
            }
            // System.out.println(i+ " "+ sum+ " "+indices.get(sum));
            if (max < indices.get(sum).size()) {
                max = indices.get(sum).size();
            }
        }
        // System.out.println(indices);
        return max;
    }

    private boolean isOverLapping(Integer indices[], List<Integer[]> oldIndices) {
        Set<Integer> values = new HashSet<>();
        for (Integer[] oldIndex : oldIndices) {
            values.add(oldIndex[0]);
            values.add(oldIndex[1]);
        }
        if (values.contains(indices[0]) || values.contains(indices[1]))
            return true;
        return false;
    }
}
