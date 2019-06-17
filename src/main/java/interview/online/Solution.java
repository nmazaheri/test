package interview.online;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
    static String ERROR_INPUT_SYNTAX = "E1";
    static String ERROR_INPUT_LOGIC = "E2";
    static String ERROR_NO_POSSIBLE_ROUTE = "E3";

    public static void main(String args[]) throws Exception {
        String[] arguments = handleArgs();
        String result = getShortestPath(arguments);
        System.out.println(result);
    }

    private static String[] handleArgs() {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        while (scanner.hasNext()) {
            result.add(scanner.next());
        }
        scanner.close();
        return result.stream().toArray(String[]::new);
    }

    static String getShortestPath(String[] args) {
        Graph graph = new Graph();
        try {
            String error = graph.init(args);
            if (error != null) {
                return error;
            }

            String[] requirements = args[args.length - 1].split(",");
            int minDistance = Integer.parseInt(requirements[1]);
            Node start = graph.getNode(requirements[0].charAt(0));
            Node end = graph.getNode(requirements[0].charAt(3));
            if (start == null || end == null) {
                // undefined nodes
                return ERROR_INPUT_LOGIC;
            }

            error = graph.calculateShortestPath(start);
            if (error != null) {
                return error;
            }

            if (minDistance >= end.distance) {
                return end.getPath();
            } else {
                return ERROR_NO_POSSIBLE_ROUTE;
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            return Solution.ERROR_INPUT_SYNTAX;
        }
    }
}

class Graph {
    private static String REGEX_PATTERN = "\\[([A-Z]),([A-Z]),([0-9]+)]";
    private HashMap<Character, Node> nodes = new HashMap<>();

    public String init(String[] data) throws NumberFormatException {
        for (int i = 0; i < data.length - 1; i++) {
            Pattern pattern = Pattern.compile(REGEX_PATTERN);
            Matcher m = pattern.matcher(data[i]);
            boolean found = m.find();
            if (!found || m.groupCount() != 3) {
                return Solution.ERROR_INPUT_SYNTAX;
            }
            Node start = addNode(m.group(1));
            Node end = addNode(m.group(2));
            int distance = Integer.parseInt(m.group(3));

            if (getNode(start).addDestination(end, distance) || getNode(end).addDestination(start, distance)) {
                // duplicate path definition
                return Solution.ERROR_INPUT_LOGIC;
            }
        }
        return null;
    }

    public Node getNode(Node node) {
        return getNode(node.getName());
    }

    public Node getNode(Character node) {
        return nodes.get(node);
    }

    public Node addNode(String data) {
        Node node = new Node(data.charAt(0));
        nodes.putIfAbsent(node.getName(), node);
        return getNode(node);
    }

    public void printNodes() {
        for (Node node : nodes.values()) {
            System.out.println(node + " " + node.getAdjacentNodes());
        }
    }

    public String calculateShortestPath(Node start) {
        Queue<Node> nodesToCheck = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        start.distance = 0;
        start.shortestPath.add(start);
        nodesToCheck.add(start);

        while (!nodesToCheck.isEmpty()) {
            Node current = nodesToCheck.poll();
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);

            for (Map.Entry<Node, Integer> adjacentNodeDistanceEntry : current.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacentNodeDistanceEntry.getKey();
                nodesToCheck.add(adjacentNode);

                final int totalDistance = current.distance + adjacentNodeDistanceEntry.getValue();
                if (adjacentNode.distance == null || totalDistance < adjacentNode.distance) {
                    adjacentNode.shortestPath = new LinkedList<>(current.shortestPath);
                    adjacentNode.shortestPath.add(adjacentNode);
                    adjacentNode.distance = totalDistance;
                } else if (totalDistance == adjacentNode.distance) {
                    // more then one shortest path found
                    return Solution.ERROR_INPUT_LOGIC;
                }
            }
        }
        if (visited.size() != this.nodes.size()) {
            // disconnected graph
            return Solution.ERROR_INPUT_LOGIC;
        }
        return null;
    }
}

class Node {
    private Character name;
    List<Node> shortestPath = new LinkedList<>();
    Integer distance = null;
    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(Character name) {
        this.name = name;
    }

    public Character getName() {
        return name;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public String getPath() {
        return String.join("->", shortestPath.stream().map(Node::toString).collect(Collectors.toList()));
    }

    public boolean addDestination(Node destination, int distance) {
        boolean alreadyExists = adjacentNodes.containsKey(destination);
        adjacentNodes.put(destination, distance);
        return alreadyExists;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}