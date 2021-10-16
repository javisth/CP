/*
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

If it cannot be done, return -1.

Example 1:
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:
Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
*/

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // declare return type
        int result = 0;
        // combinations of rotations where you compare swaps with 1st element of 
        // either top or bottom array
        int count1 = findRotations(tops, bottoms, tops[0]);
        int count2 = findRotations(bottoms, tops, tops[0]);
        int count3 = findRotations(tops, bottoms, bottoms[0]);
        int count4 = findRotations(bottoms, tops, bottoms[0]);
        // find the minimum of all 4 combinations
        result = Math.min((Math.min(count1, count2)), (Math.min(count3, count4)));
        // return the count
        result = (result == Integer.MAX_VALUE)? -1: result;
        return result;
    }
    
    public int findRotations(int[] tops, int[] bottoms, int value){
        int count = 0;
        for(int i = 0; i< tops.length; i++){
            // if any element is the same as value in my top array, i dont care
            if(tops[i] == value){
                continue;
            }
            // if an element in bottom array is same as value, i can swap it
            else if(bottoms[i] == value){
                count++;
            }
            // if i find nothing i return max value
            else{
                return Integer.MAX_VALUE;
            }
        }
        // return count
        return count;
    }
}