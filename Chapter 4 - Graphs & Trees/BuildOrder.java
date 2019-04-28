import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class BuildOrder {
    
    private static ArrayList<String> projects = new ArrayList<>();
    private static HashMap<String, ArrayList<String>> dependencyOn = new HashMap<>();
    private static HashMap<String, ArrayList<String>> dependencyTo = new HashMap<>();
    private static ArrayList<String> done = new ArrayList<>();
    private static Queue<String> curr_q = new LinkedList<>();

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

    private static int findBuildOrder () {
        HashMap<String, ArrayList<String>> sorted_dependencyOn = new HashMap<>();
        sorted_dependencyOn = dependencyOn.entrySet().stream().sorted(Map.Entry.comparingByValue()
        .collect(toMap(e -> e.getKey(), e -> e.getValue(), HashMap::new));
        for (Map.Entry<String, ArrayList<String>> entry : sorted_dependencyOn.entrySet()) {
            if (done.size() == 0 && entry.getValue().size() != 0) {
                return -1;                                            
            } 
            else if (entry.getValue().size() == 0){
                done.add(entry.getKey());
                curr_q.add(entry.getKey());
                continue;
            } else {
                curr_q.add(entry.getKey());
                //break;
            }        
            while (curr_q.size() != 0) {            
                String p = curr_q.remove();
                if (dependencyTo.containsKey(p)) {
                    for (String dependentProject : dependencyTo.get(key)) {
                        ArrayList<String> allDependents = sorted_dependencyOn.get(dependentProject);
                        allDependents.remove(dependentProject);
                        sorted_dependencyOn.put(dependentProject, allDependents);
                    }
                }
            }
        }
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