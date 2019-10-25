public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int nonZeroPointer = 0;
        int zeros = 0;
        for (int i = 0; i <nums.length; i++) {
            int currNum = nums[i];
            if (currNum == 0) {
                zeros++;
            } else {
                // increment the non zero pointer
                if (i > nonZeroPointer) {
                    nums[nonZeroPointer] = nums[i];
                }
                nonZeroPointer++;
            }
        }
        for (int i = nums.length - zeros; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}