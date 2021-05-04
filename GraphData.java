package flightTime;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphData {

	GraphWeighted graphWeighted = new GraphWeighted(true);
	LinkedList<NodeWeighted> nodes = new LinkedList<NodeWeighted>();

	public GraphData() {

		nodes.add(new NodeWeighted(0, "London"));
		nodes.add(new NodeWeighted(1, "Sydney"));
		nodes.add(new NodeWeighted(2, "Tokyo"));
		nodes.add(new NodeWeighted(3, "New York"));
		nodes.add(new NodeWeighted(4, "Berlin"));
		nodes.add(new NodeWeighted(5, "Hong Kong"));

		// Our addEdge method automatically adds Nodes as well.
		// The addNode method is only there for unconnected Nodes,
		// if we wish to add any
		graphWeighted.addEdge(nodes.get(0), nodes.get(1), 21);
		graphWeighted.addEdge(nodes.get(0), nodes.get(2), 12);
		graphWeighted.addEdge(nodes.get(0), nodes.get(3), 7);
		graphWeighted.addEdge(nodes.get(0), nodes.get(5), 12);
		graphWeighted.addEdge(nodes.get(1), nodes.get(0), 21);
		graphWeighted.addEdge(nodes.get(1), nodes.get(2), 9);
		graphWeighted.addEdge(nodes.get(1), nodes.get(5), 9);
		graphWeighted.addEdge(nodes.get(2), nodes.get(1), 9);
		graphWeighted.addEdge(nodes.get(2), nodes.get(0), 12);
		graphWeighted.addEdge(nodes.get(2), nodes.get(5), 4);
		graphWeighted.addEdge(nodes.get(3), nodes.get(0), 7);
		graphWeighted.addEdge(nodes.get(3), nodes.get(2), 13);
		graphWeighted.addEdge(nodes.get(3), nodes.get(4), 8);
		graphWeighted.addEdge(nodes.get(3), nodes.get(5), 16);
		graphWeighted.addEdge(nodes.get(4), nodes.get(0), 2);
		graphWeighted.addEdge(nodes.get(4), nodes.get(1), 19);
		graphWeighted.addEdge(nodes.get(4), nodes.get(3), 8);
		graphWeighted.addEdge(nodes.get(5), nodes.get(0), 12);
		graphWeighted.addEdge(nodes.get(5), nodes.get(1), 9);
		graphWeighted.addEdge(nodes.get(5), nodes.get(2), 4);
		graphWeighted.addEdge(nodes.get(5), nodes.get(3), 16);

	}

	private NodeWeighted getnodefromindex(int index) throws Exception {
		for (NodeWeighted nodeWeighted : nodes) {
			if (nodeWeighted.n == index) {
				return nodeWeighted;
			}
		}
		throw new Exception("Can't find Location");

	}

	public String getFlightInformation(int indexfrom, int indexto) {

		try {
			NodeWeighted nodefrom = getnodefromindex(indexfrom);
			NodeWeighted nodeto = getnodefromindex(indexto);

			return graphWeighted.DijkstraShortestPath(nodefrom, nodeto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public LinkedList<String> getallFlightInformation() {
		LinkedList<String> allflightpaths = new LinkedList<String>();
	
		
		for (NodeWeighted nodefrom : nodes) {
			for (NodeWeighted nodeto : nodes) {
				if (nodefrom != nodeto) {
				allflightpaths.add(graphWeighted.DijkstraShortestPath(nodefrom, nodeto)) ;
				} else {
					System.out.println("this is a test");
					
				}
			}
		}
		return allflightpaths;

	}

}
