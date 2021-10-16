/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

 

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
Example 4:

Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can pick from trees [1,2,1,1,2].
*/

class Solution {
    public int totalFruit(int[] fruits) {
        // do some error checking
        if(fruits == null || fruits.length == 0)
            return 0;
        // make a max variable to store max, its at least 1 if the lenght is not 0
        int max = 1;
        // make a map to store type of fruit and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        // two pointer variables for sliding window
        int i = 0, j = 0;
        while(j < fruits.length){
            // add fruits into map as long as the map can get 2 fruits
            if(map.size()<=2){
                map.put(fruits[j], j);
                j++;
            }
            // as soon as the map gets a third fruit, we find the index of 1st fruit and stop considering it and move on to next window
            if(map.size() > 2){
                int min = fruits.length-1;
                for(int value: map.values()){
                    // get smallest index for the 1st fruits position
                    min = Math.min(min, value);
                }
                // get index of next fruit
                i = min + 1;
                // remove the 1st fruit
                map.remove(fruits[min]);
            }
            // find the maximum length between each window
            max = Math.max(max, j-i);
        }
        return max;
    }
}