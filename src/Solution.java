import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */

    static public void main(String [] args){

        Solution s = new Solution();
        int [] nums = {1,2,3};
        System.out.println(s.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutations = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        if(nums == null){
            return result;
        }
        if(nums.length == 0){
            result.add(permutations);
            return result;
        }
        helper(nums,set,permutations,result);
        return result;
    }

    public void helper(int[] nums, Set<Integer> set, List<Integer> permutations ,List<List<Integer>> result){

        if(permutations.size() == nums.length){
            result.add(new ArrayList<>(permutations));
            return;
        }
        for(int i = 0 ; i < nums.length ; i ++){

            if(set.contains(nums[i])){
                continue;
            }
            permutations.add(nums[i]);
            set.add(nums[i]);
            helper(nums,set,permutations,result);
            permutations.remove(permutations.size()-1);
            set.remove(nums[i]);
        }
    }
}