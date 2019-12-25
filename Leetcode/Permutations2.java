import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class Permutations2 {
    public List<List<Integer>> permute(int[] nums) {
        // create empty list of permutations
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();

        // create an empty List and add it to the permutations
        List<Integer> baseCase = new ArrayList<Integer>();
        permutations.add(baseCase);

        // iterate over all the numbers in the input array
        for (int num : nums) {
            // get ListIterator to iterate over all of the permutations
            ListIterator<List<Integer>> it = permutations.listIterator();

            // iterate over all of the permuations
            while (it.hasNext()) {
                // get the current permutation
                List<Integer> permutation = it.next();

                // remove the current permutation from the permutations list
                it.remove();

                // iterate over all the index positions in the current permutation list
                for (int i = 0; i < permutation.size() + 1; i++) {
                    // create a new permutation list
                    List<Integer> newPermutation = new ArrayList<>(permutation);

                    // insert the num at the current index position of the new permutation list
                    newPermutation.add(i, num);

                    // add the new permutation to the permutations list
                    it.add(newPermutation);
                }
            }
        }
        return permutations;
    }
}