package dataStructures.test;

import dataStructures.Graph;

/**
 * Created by nav on 5/25/15.
 */
public class GraphTest {
    public static void main(String[] args) {
        int[][] conn = {
        //        0  1  2  3  4  5  6  7  8
                { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
                { 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
                { 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
                { 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
                { 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
                { 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
                { 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
                { 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8

        Graph graph = new Graph(conn);
        graph.DFS();
        graph.BFS();

    }
}

