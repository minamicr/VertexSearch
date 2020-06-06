import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NodeDistance3 {
	
	public void readDiagram(String finalNode) throws Exception {
		List<Node> verifiedNodes = new ArrayList<Node>();
		
		
		Node nodeA = new Node("A", 99999, null);
		Node nodeB = new Node("B", 99999, null);
		Node nodeC = new Node("C", 99999, null);
		Node nodeD = new Node("D", 99999, null);
		Node nodeE = new Node("E", 99999, null);
		Node nodeF = new Node("F", 99999, null);
		Node nodeG = new Node("G", 99999, null);

		List<Vertex> vertexA = new ArrayList<>(Arrays.asList(new Vertex(nodeE, 7), new Vertex(nodeC, 3), new Vertex(nodeB, 4)));
		nodeA.setVertex(vertexA);
		
		List<Vertex> vertexB = new ArrayList<>(Arrays.asList(new Vertex(nodeA, 4), new Vertex(nodeC, 6), new Vertex(nodeD, 6)));
		nodeB.setVertex(vertexB);
		
		List<Vertex> vertexC = new ArrayList<>(Arrays.asList(new Vertex(nodeE, 8), new Vertex(nodeA, 3), new Vertex(nodeB, 6) , new Vertex(nodeD, 11)));
		nodeC.setVertex(vertexC);
		
		List<Vertex> vertexD = new ArrayList<>(Arrays.asList(new Vertex(nodeE, 2), new Vertex(nodeF, 2), new Vertex(nodeB, 5),  new Vertex(nodeG, 10), new Vertex(nodeC, 11)));
		nodeD.setVertex(vertexD);
		
		List<Vertex> vertexE = new ArrayList<>(Arrays.asList( new Vertex(nodeD, 2), new Vertex(nodeG, 5), new Vertex(nodeA, 7), new Vertex(nodeC, 8)));
		nodeE.setVertex(vertexE);
		
		List<Vertex> vertexF = new ArrayList<>(Arrays.asList(new Vertex(nodeD, 2), new Vertex(nodeG, 3)));
		nodeF.setVertex(vertexF);
		
		List<Vertex> vertexG = new ArrayList<>(Arrays.asList( new Vertex(nodeF, 3), new Vertex(nodeE, 5), new Vertex(nodeD, 10)));
		nodeG.setVertex(vertexG);
		
		List<Node> nodes = new ArrayList<>(Arrays.asList(nodeC, nodeA, nodeB, nodeE, nodeD, nodeF, nodeG));
		
		calculateDistances(nodes, verifiedNodes);
		
		//nodes.forEach(System.out::println);
		
		System.out.println("Origin " + nodes.get(0) + "\nDestin " +  findNode(nodes, finalNode));
		
	}
	
	private Node findNode(List<Node> nodes, String nodeName) {
		return nodes.stream()
				.filter(node -> node.getName().equalsIgnoreCase(nodeName))
				.findFirst()
				.orElse(null);
	}
	
	private void calculateDistances(List<Node> nodes, List<Node> verifiedNodes) {
		
		initializeFirstNode(nodes);
		
		for (Node node: nodes) {
			
			//Order vertex by total crescent
			node.getVertex().sort(Comparator.comparingInt(Vertex::getTotalDistance));
			
			for (Vertex vertex: node.getVertex()) {
				if (!verifiedNodes.contains(vertex.getNode())) {
					if (isNewDistanceMinor(node, vertex)) {
						vertex.getNode().setTotalDistance(node.getTotalDistance() + vertex.getDistance());
						updateNodePath(node, vertex);
					}
				
				}
			}
			
			verifiedNodes.add(node);
		}
		
	}
	
	private void updateNodePath(Node node, Vertex vertex) {
		String originalPath = node.getPath() == null ? "" : node.getPath();
		vertex.getNode().setPath(originalPath + " " + node.getName() + "-" + vertex.getNode().getName() + " ");
	}
	
	
	private void initializeFirstNode(List<Node> nodes) {
		Node firstNode = nodes.get(0);
		firstNode.setPath("");
		firstNode.setTotalDistance(0);
		
		for (Vertex vertex: firstNode.getVertex()) {
			vertex.getNode().setTotalDistance(vertex.getDistance());
			updateNodePath(firstNode, vertex);
		}

	}
	
	private boolean isNewDistanceMinor(Node node, Vertex vertex) {
		if (vertex.getNode().getTotalDistance() > node.getTotalDistance() + vertex.getDistance()) 
			return true;
		else 
			return false;
	}
	
	public class Node {
		private String name;
		private Integer totalDistance;
		private String path;
		private List<Vertex> vertex;
		
		public Node() {};
		
		public Node(String name, Integer totalDistance, List<Vertex> vertex) {
			super();
			this.name = name;
			this.totalDistance = totalDistance;
			this.vertex = vertex;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getTotalDistance() {
			return totalDistance;
		}
		public void setTotalDistance(Integer totalDistance) {
			this.totalDistance = totalDistance;
		}
		public List<Vertex> getVertex() {
			return vertex;
		}
		public void setVertex(List<Vertex> vertex) {
			this.vertex = vertex;
		}

		
		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		@Override
		public String toString() {
			return "Node [name = " + name + ", path = " + path + ", totalDistance = " + totalDistance + "]";
		}
		
		
		
	}

	public class Vertex {
		private Node node;
		private Integer distance;
		
		
		public Vertex(Node node, Integer distance) {
			super();
			this.node = node;
			this.distance = distance;
		}
		
		public Node getNode() {
			return node;
		}
		public void setNode(Node node) {
			this.node = node;
		}
		public Integer getDistance() {
			return distance;
		}
		public void setDistance(Integer distance) {
			this.distance = distance;
		}
		
		public Integer getTotalDistance() {
			return node.getTotalDistance();
		}

		@Override
		public String toString() {
			return "Vertex [node=" + node.toString() + ", distance=" + distance + "]";
		}
		
		
		
	}
	
}
