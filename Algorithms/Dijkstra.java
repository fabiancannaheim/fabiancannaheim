import java.util.ArrayList;
import java.util.List;

import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraAlgorithm {

    Node A,B,C,D,E,F;
    Edge AB, AF, AE, BC, BD, CA, CF, DE, FE;

    public static void main (String[] args) {

        this.prepare();

        Queue<Node> queue = new PriorityQueue();
        A.distance = 0;
        A.mark = true;
        queue.add(A);
        while(!queue.isEmpty()) {
            Node currentNode = (Node) queue.poll();
            currentNode.mark = true;
            if (currentNode.equals(E)) break;
            for (Edge edge : currentNode.edges) {
                Node destination = edge.destination;
                if (!destination.mark) {
                    double distance = currentNode.distance + edge.weight;
                    if ((destination.previous == null) || (distance < destination.distance)) {
                        destination.distance = distance;
                        destination.previous = currentNode;
                        queue.add(destination);
                    }
                }
            }
        }

        Node node = E;
        do {
            System.out.print(node);
            node = node.previous;
        } while (node.previous != null);

    }

    private void prepare() {

        A = new Node("A");
        B = new Node("B");
        C = new Node("C");
        D = new Node("D");
        E = new Node("E");
        F = new Node("F");

        AB = new Edge(30, B);
        AF = new Edge(90,F);
        AE = new Edge(100,E);
        BC = new Edge(10,C);
        BD = new Edge(50,D);
        CA = new Edge(40,A);
        CF = new Edge(50,F);
        DE = new Edge(30,E);
        FE = new Edge(20,E);

        A.edges.add(AB);
        A.edges.add(AE);
        A.edges.add(AF);
        B.edges.add(BC);
        B.edges.add(BD);
        C.edges.add(CA);
        C.edges.add(CF);
        D.edges.add(DE);
        F.edges.add(FE);

    }

    class Node implements Comparable<Node>  {
        public String value;
        public boolean mark;
        public double distance;
        public Node previous;
        public List<Edge> edges;
        public Node (String value) {
            edges = new ArrayList<>();
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return (int)(distance - o.distance);
        }
        public String toString() {
            return value + " " + distance;
        }
    }

    class Edge {
        public double weight;
        public Node destination;
        public Edge(double weight, Node destination) {
            this.weight = weight;
            this.destination = destination;
        }
    }

}