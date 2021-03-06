package arrays;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    static int[] arrs = {1,2,3,6,7,9};
    public static void main(String[] args) {
        for(List<Integer> integers: combinationSum(arrs, 100)){
            System.out.println("\n--------------------------------");
            for(Integer integer: integers){
                System.out.print(integer + " ");
            }
        }
    }
}
