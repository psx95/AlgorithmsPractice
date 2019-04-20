import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution1 {
    public static void main (String Args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the number of nodes");
        int number = sc.nextInt();
        System.out.println ("Create the nodes");
        HashMap<GraphNode<Integer>, ArrayList<GraphNode>> adjecencyList = new HashMap<>();
        for (int i =0; i < number; i++) {
            GraphNode<Integer> graphNode = new GraphNode<Integer>(sc.nextInt());        
            adjecencyList.put(graphNode, graphNode.adjecentNodes);
        }
        System.out.println("Enter Adjecent nodes for :");
        int counter = 1;
        for (Map<GraphNode<Integer>,ArrayList<GraphNode<Integer>>>.Entry entry : adjecencyList.entrySet()) {
            System.out.println ("Node "+counter + " Data" +(GraphNode<Integer>)(entry.getKey()).data);
            System.out.println ( "Enter number of adjecent Nodes ");
            int num = sc.nextInt();
            for (int i = 0; i< num; i++) {
                ArrayList<GraphNode<Integer>> arr = (ArrayList<GraphNode<Integer>>)(entry.getValue());
                
            }
        }
        sc.close();
        printMap(adjecencyList);
    } 

    private static void printMap (HashMap<GraphNode<Integer>,ArrayList<GraphNode<Integer>>> map) {
        for (Map.Entry<GraphNode<Integer>,ArrayList<GraphNode<Integer>>> entry : map.entrySet()) {
            System.out.print(entry.getKey()+ ": "+entry.getValue()+"\n");
        }
    }
}