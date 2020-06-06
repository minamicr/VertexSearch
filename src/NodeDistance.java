import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NodeDistance {
	

	public void createDiagram() {
		List<Node> shortPath;
		shortPath = new ArrayList<Node>();
		
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		
		NodeLink linkAE = new NodeLink(nodeA, nodeE, 7);
		NodeLink linkAB = new NodeLink(nodeA, nodeB, 4);
		NodeLink linkAC = new NodeLink(nodeA, nodeC, 3);
		NodeLink linkBA = new NodeLink(nodeA, nodeC, 4);
		NodeLink linkBC = new NodeLink(nodeB, nodeC, 6);
		NodeLink linkBD = new NodeLink(nodeB, nodeD, 5);
		NodeLink linkCA = new NodeLink(nodeC, nodeA, 3);
		NodeLink linkCB = new NodeLink(nodeC, nodeB, 6);
		NodeLink linkCD = new NodeLink(nodeC, nodeD, 11);
		NodeLink linkCE = new NodeLink(nodeC, nodeE, 8);
		NodeLink linkDB = new NodeLink(nodeD, nodeB, 5);
		NodeLink linkDC = new NodeLink(nodeD, nodeC, 11);
		NodeLink linkDE = new NodeLink(nodeD, nodeE, 2);
		NodeLink linkDF = new NodeLink(nodeD, nodeF, 2);
		NodeLink linkDG = new NodeLink(nodeD, nodeG, 10);
		NodeLink linkEG = new NodeLink(nodeE, nodeG, 5);
		NodeLink linkEA = new NodeLink(nodeE, nodeA, 7);
		NodeLink linkEC = new NodeLink(nodeE, nodeC, 8);
		NodeLink linkED = new NodeLink(nodeE, nodeD, 2);
		NodeLink linkFG = new NodeLink(nodeF, nodeG, 3);
		NodeLink linkFD = new NodeLink(nodeF, nodeD, 2);
		NodeLink linkGF = new NodeLink(nodeG, nodeF, 3);
		NodeLink linkGD = new NodeLink(nodeG, nodeD, 10);
		NodeLink linkGE = new NodeLink(nodeG, nodeE, 5);
		
		List<NodeLink> links = new ArrayList<NodeLink>();
		links.add(linkAE);
		links.add(linkAB);
		links.add(linkAC);
		links.add(linkBA);
		links.add(linkBC);
		links.add(linkBD);
		links.add(linkCA);
		links.add(linkCB);
		links.add(linkCD);
		links.add(linkCE);
		links.add(linkDB);
		links.add(linkDC);
		links.add(linkDE);
		links.add(linkDF);
		links.add(linkDG);
		links.add(linkEG);
		links.add(linkEA);
		links.add(linkEC);
		links.add(linkED);
		links.add(linkFG);
		links.add(linkFD);
		links.add(linkGF);
		links.add(linkGD);
		links.add(linkGE);
		
		List<NodeLink> linksA = links.stream().filter(n -> n.originNode.equals(nodeA)).collect(Collectors.toList());
		List<NodeLink> linksB = links.stream().filter(n -> n.originNode.equals(nodeB)).collect(Collectors.toList());
		List<NodeLink> linksC = links.stream().filter(n -> n.originNode.equals(nodeC)).collect(Collectors.toList());
		List<NodeLink> linksD = links.stream().filter(n -> n.originNode.equals(nodeD)).collect(Collectors.toList());
		List<NodeLink> linksE = links.stream().filter(n -> n.originNode.equals(nodeE)).collect(Collectors.toList());
		List<NodeLink> linksF = links.stream().filter(n -> n.originNode.equals(nodeF)).collect(Collectors.toList());
		List<NodeLink> linksG = links.stream().filter(n -> n.originNode.equals(nodeG)).collect(Collectors.toList());
		
		NodeLink minA = linksA.stream().min(Comparator.comparing(NodeLink::getDistance)).orElseThrow(NoSuchElementException::new);
		NodeLink minB = linksB.stream().min(Comparator.comparing(NodeLink::getDistance)).orElseThrow(NoSuchElementException::new);
		NodeLink minC = linksC.stream().min(Comparator.comparing(NodeLink::getDistance)).orElseThrow(NoSuchElementException::new);
		NodeLink minD = linksD.stream().min(Comparator.comparing(NodeLink::getDistance)).orElseThrow(NoSuchElementException::new);
		NodeLink minE = linksE.stream().min(Comparator.comparing(NodeLink::getDistance)).orElseThrow(NoSuchElementException::new);
		NodeLink minF = linksF.stream().min(Comparator.comparing(NodeLink::getDistance)).orElseThrow(NoSuchElementException::new);
		NodeLink minG = linksG.stream().min(Comparator.comparing(NodeLink::getDistance)).orElseThrow(NoSuchElementException::new);
		
		System.out.println(linksA);
		System.out.println(linksB);
		System.out.println(linksC);
		System.out.println(linksD);
		System.out.println(linksE);
		System.out.println(linksF);
		System.out.println(linksG);
		
		System.out.println("minimo A " + minA);
		System.out.println("minimo B " + minB);
		System.out.println("minimo C " + minC);
		System.out.println("minimo D " + minD);
		System.out.println("minimo E " + minE);
		System.out.println("minimo F " + minF);
		System.out.println("minimo G " + minG);
		
		
	}

	
	private class Node {
		private String name;
		private boolean visited;
		
		Node (String name) {
			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
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
		private Node destinNode;
		private Integer distance;
		
		public NodeLink(Node originNode, Node destinNodde, Integer distance) {
			super();
			this.originNode = originNode;
			this.destinNode = destinNodde;
			this.distance = distance;
		}
		public Node getOriginNode() {
			return originNode;
		}
		public void setOriginNode(Node originNode) {
			this.originNode = originNode;
		}
		public Node getDestinNodde() {
			return destinNode;
		}
		public void setDestinNodde(Node destinNodde) {
			this.destinNode = destinNodde;
		}
		public Integer getDistance() {
			return distance;
		}
		public void setDistance(Integer distance) {
			this.distance = distance;
		}
		@Override
		public String toString() {
			return "NodeLink [" + originNode.name + " -> " + destinNode.name + " = " + distance
					+ "]";
		}
		
		
	}
}
