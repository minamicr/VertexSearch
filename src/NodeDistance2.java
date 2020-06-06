import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NodeDistance2 {
	

	public void createDiagram() {
		List<Node> shortPath;
		shortPath = new ArrayList<Node>();
		
		Node nodeA = new Node("A", 0, false);
		Node nodeB = new Node("B", 0, false);
		Node nodeC = new Node("C", 0, false);
		Node nodeD = new Node("D", 0, false);
		Node nodeE = new Node("E", 0, false);
		Node nodeF = new Node("F", 0, false);
		Node nodeG = new Node("G", 0, false);
		
		

		
	}

	
	private class Node {
		private String name;
		private Integer distance;
		private boolean visited;
		
		Node (String name) {
			this.name = name;
		}

		
		public Node(String name, Integer distance, boolean visited) {
			super();
			this.name = name;
			this.distance = distance;
			this.visited = visited;
		}


		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}

		public Integer getDistance() {
			return distance;
		}

		public void setDistance(Integer distance) {
			this.distance = distance;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		
		
		
	}
	
	private class NodeLink {
		private Node originNode;
		private List<Node> destinNode;
		
		public NodeLink(Node originNode, List<Node> destinNodde) {
			super();
			this.originNode = originNode;
			this.destinNode = destinNodde;
		}
		public Node getOriginNode() {
			return originNode;
		}
		public void setOriginNode(Node originNode) {
			this.originNode = originNode;
		}

		
		public List<Node> getDestinNode() {
			return destinNode;
		}
		public void setDestinNode(List<Node> destinNode) {
			this.destinNode = destinNode;
		}
	}
}
