import java.util.*;
public class ThreeSum
{
    public static void main (String Args[])
    {
        System.out.println ("Enter the number of elements");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println ("Enter the elements");
        int arr[] = new int[n];
        for (int i = 0 ; i < n ; i ++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println ("Result - " + Arrays.toString(threeSum(arr).toArray()));
        sc.close();
    }

    public static List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, ArrayList<Integer>> mapping = new HashMap<>();
        HashMap<String, Boolean> duplicateCheck = new HashMap<>();
        if (nums.length < 3)
            return result;
        for (int i = 0; i < nums.length; i++)
        {
            if (mapping.containsKey (nums[i]))
            {
                ArrayList<Integer> indices = mapping.get(nums[i]);
                indices.add(i);
                mapping.put(nums[i], indices);
            }
            else
            {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add (i);
                mapping.put(nums[i], indices);
            }
        }
        printHashMap(mapping);

        for (int i = 0; i < nums.length; i++)
        {
            int currNumber = nums[i];
            System.out.println ("Curr Number " + currNumber);
            for (int j = i + 1; j < nums.length; j++)
            {
                int secondNumber = nums[j];
                int thirdNumber = 0 - (currNumber + secondNumber);
                if (mapping.containsKey(thirdNumber))
                {
                    /*ArrayList<Integer> indices = mapping.get(0 - (currNumber + secondNumber));
                    System.out.println ("PAIRS - "+currNumber + ", "+secondNumber + ", "+(0-(currNumber + secondNumber)) + "Size "+indices.size());
                    if (indices.size() > 0)
                    {*/
                    if ((mapping.get(thirdNumber).size() > 2) || checkIfIndiciesClash(i,j, mapping.get(thirdNumber)))
                    {
                        List<Integer> resultSubset = new ArrayList<>();
                        resultSubset.add (currNumber);
                        resultSubset.add (secondNumber);
                        resultSubset.add (thirdNumber);
                        Collections.sort(resultSubset);
                        String equivalent = Arrays.toString(resultSubset.toArray());
                        System.out.println ("equivalent " + equivalent);
                        /*indices.remove(0);
                            mapping.put((0 - (currNumber + secondNumber)), indices);*/
                        if (!duplicateCheck.containsKey(equivalent))
                        {
                            result.add(resultSubset);
                            duplicateCheck.put(equivalent, true);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static void printHashMap (HashMap<Integer, ArrayList<Integer>> map)
    {
        System.out.println(Arrays.asList(map));
    }

    private boolean checkIfIndiciesClash (int i, int j, ArrayList<Integer> indices)
    {
        for (int o = 0; o < indices.size(); o++)
        {
        	int index = indices.get(o);
        	if (index == i || index == j)
        		return false;
        }
        return true;
    }
}