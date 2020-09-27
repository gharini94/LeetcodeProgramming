import java.util.*;
public class cycleDG{
	public static boolean detectCycle(int numCourses, int[][] prerequisites){
		List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        
        int[] indegree = new int[numCourses];
        for(int[] e: prerequisites) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        //System.out.println("3: "+graph[3]);
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }
        System.out.println("init queue: "+queue);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("queue: "+queue);
            for(int c : graph[current]) {
                indegree[c]--;
                if(indegree[c] == 0)
                    queue.add(c);
            }
            numCourses--;
        }
        System.out.println("courses: "+numCourses);
        return numCourses == 0;
	}
	public static void main(String[] args) {
		int n = 5;
		int dep[][]={{0,2},{1,3},{3,2},{3,4}};
		System.out.println(detectCycle(n, dep)?"possible":"not possible");
	}
}