import java.util.*;

public class BuildOrder {
    
    private static ArrayList<String> projects = new ArrayList<>();
    private static HashMap<String, ArrayList<String>> dependencyOn = new HashMap<>();
    private static HashMap<String, ArrayList<String>> dependencyTo = new HashMap<>();

    public static void main (String Args[]) {
        System.out.println ("Enter the number of projects");
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        System.out.println ("Enter the project titles");        
        for (int i = 0; i<n ;i++) 
        {
            projects.add(sc.next());
        }
        System.out.println ("Enter the project dependencies");        
        for (int i = 0;  i < n; i++) {
            System.out.println ("Enter dependencies for project " + projects.get(i));
            String dependencies = sc.nextLine();
            String[] _dep = dependencies.split("\\s+");
            dependencyOn.put(projects.get(i), new ArrayList<String>(Arrays.asList(_dep)));
        }
        createReverseDependencyMap();
    }

    private static void createReverseDependencyMap() {
        for (Map.Entry<String, ArrayList<String>> entry : dependencyTo.entrySet()) {
            String key = entry.getKey();
            for (String project : entry.getValue()) {
                if (dependencyTo.containsKey(project)) {
                    ArrayList<String> temp = dependencyTo.get(project);
                    temp.add(key);
                } else {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(key);
                    dependencyTo.put(project, temp);
                }
            }
        }
    }
}