
public class Main {
	public static void main (String args[]) {
		NodeDistance3 nd = new NodeDistance3();
		try {
			nd.readDiagram("G");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
