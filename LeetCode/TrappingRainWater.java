/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
*/


class TrappingRainWater {
    public int trap(int[] height) {
        int left = height[0];
        int sum = 0;
        int maxH = getMaxHeightIdx(height); // we want the max height
        // we want to traverse all the elements
        for (int i = 1; i < maxH; i++) { // i to maxH
            if (height[i] >= left) 
                left = height[i];
            else 
                sum += left - height[i];
        }

        int right = height[height.length - 1];
        for (int i = height.length - 2; i > maxH; i--) {
            // maxH + 1 to height.length - 1
            if (height[i] >= right)
                right = height[i];
            else 
                sum += right - height[i];
        }
        return sum;
    }

    private static int getMaxHeightIdx(int[] A) {
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[max])
                max = i;
        }
        return max;
    }
}