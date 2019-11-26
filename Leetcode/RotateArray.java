public class RotateArray {
    public void rotate(int[] nums, int k) {
        int midPos = nums.length % 2 == 0 ? -1 : nums.length / 2;
        int positionAdjust = nums.length % 2 == 0 ? 0 : 1;
        for (int i = 0; i < k; i++) {
            int swapWith = (i + k + positionAdjust) % nums.length;
            swapPositions(nums, i, );
        }
    }

    // This will swap two positions in a given array, in-place
    // pos1 and pos2 must be indexes
    private void swapPositions(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}