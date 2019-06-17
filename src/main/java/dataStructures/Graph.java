package dataStructures;

import java.util.Arrays;

public class Graph {
    int[][] adjMatrix;
    int adjMatrixSize;
    boolean[] visited;

    public Graph(int[][] mat) {
        adjMatrixSize = mat.length;
        adjMatrix = mat;
        visited = new boolean[adjMatrixSize];
    }

    public void DFS() {
        System.out.println("DFS");
        clearVisited();

        Stack s = new Stack();
        s.push(0);
        while (!s.isEmpty()) {
            int nextNode = s.pop();
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                System.out.println("nextNode = " + nextNode);

                for (int i = 0; i < adjMatrixSize; i++)
                    if (adjMatrix[nextNode][i] > 0 && !visited[i])
                        s.push(i);
            }

        }
    }

    public void BFS() {
        System.out.println("BFS");
        clearVisited();

        Queue q = new Queue();
        q.add(0);

        while (!q.isEmpty()) {
            int nextNode = q.remove();

            if (!visited[nextNode]) {
                visited[nextNode] = true;
                System.out.println("nextNode = " + nextNode);

                for (int i = 0; i < adjMatrixSize; i++)
                    if (adjMatrix[nextNode][i] > 0 && !visited[i])
                        q.add(i);
            }
        }
    }

    void clearVisited() {
        Arrays.fill(visited, false);
        //        for (int i = 0; i < visited.length; i++)
        //            visited[i] = false;
    }

}
