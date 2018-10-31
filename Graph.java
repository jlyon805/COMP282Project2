import java.util.*;

/*IMPORTANT NOTE:
 * MODIFY METHODS HAVING TODO ONLY.
 * DO NOT MODIFY OTHER METHODS IN THIS CLASS
 * */

public class Graph<V> implements GraphInterface<V>
{

	/** Construct an empty */
	public Graph() {}


	/** Create and returns an adjacency lists from edge arrays */
	public List<List<Edge>> createWeightedGraph(List<V> vertices,int[][] edges)
	{
		List<List<Edge>> neighbors = new ArrayList<>();
		
		/*TODO  ADD YOUR CODE IN THIS METHOD TO CREATE AN 
		 * ADJACENCY LIST FOR A GRAPH (V,E) HAVING V=vertices and E=edges
		 * 
		 * STORE THE ADJACENCY LIST IN neighbors LIST SUCH THAT neighbours.get(i)
		 * will give the list of all edges from vertex i (i.e. vertex with name vertices.get(i))
		 * AND RETURN neighbors LIST
		 * 
		 * CHECK STRUCTURE OF EDGE CLASS BEFORE IMPLEMENTING YOUR CODE FOR ADJACENCY LIST 
		 *  * */
		
		for(int i = 0; i < vertices.size(); i++){
			List<Edge> edgeList = new ArrayList<>();
			for(int j = 0; j < edges.length; j++){
				if(edges[i][0] == vertices.indexOf(i)){
					Edge e = new Edge(edges[i][0], edges[i][1], edges[i][2]);
					edgeList.add(e);
				}
			}
			neighbors.add(edgeList);
		}
		return neighbors;
	}




	/** Find single source shortest paths */
	public Tree getShortestPath(
			V sourceVertex,
			List<V> vertices,
			List<List<Edge>> neighbors)
	{
		/*TODO  ADD YOUR CODE IN THIS METHOD TO CREATE A SHORTEST PATH TREE SUCH THAT
		 * THE ROOT OF TREE IS sourceVertex AND PATH FROM sourceVertex (i.e. root) TO ANY OTHER NODE 
		 * IN THE TREE IS THE SHORTEST PATH FROM sourceVertex TO THAT NODE IN GRAPH defined BY ADJACENCY LIST neighbors 
		 * 
		 * RETURN THE TREE OBJECT
		 * 
		 * CHECK STRUCTURE OF TREE CLASS BEFORE IMPLEMENTING YOUR CODE FOR SHORTEST PATH TREE FROM VERTEX sourceVertex 
		 *  * */

		Tree shortestPath = null; //Temporarily null, will change once I figure this out

		return shortestPath;
	}






	/** Edge inner class inside the Graph class */
	/*EDGE CLASS STORES THE EDGE SUCH THAT u AND v ARE THE TWO VERTEX CONNECTED BY THE EDGE AND
	 * weight IS THE WEIGHT OF THE EDGE
	 * */
	public class Edge
	{
		public int u; // Starting vertex of the edge
		public int v; // Ending vertex of the edge
		public double weight; //Weight of the edge

		/** Construct an edge for (u, v, weight) */
		public Edge(int u, int v, double weight)
		{
			this.u = u; //Important
			this.v = v;
			this.weight=weight;
		}


	}


	/** Tree inner class inside the Graph class */
	/*TREE CLASS STORES THE TREE SUCH THAT root IS THE ROOT NODE OF TREE (i.e. sourceVertex FOR SHORTEST DISTANCE TREE)
	 * parent[i] STORES THE PARENT OF NODE i IN THE TREE
	 * NOTE: PARENT OF root is -1 (i.e. parent[root]=-1
	 * cost[i] is COST OF PATH FROM root (i.e. sourceVertex) to Node i
	 * */
	public class Tree
	{
		private int root; // The root of the tree
		private int[] parent; // Store the parent of each vertex, Parent of root node is -1
		private double[] cost; // cost of each vertex from root i.e. source


		/** Construct a tree with root, parent, cost */
		public Tree(int root, int[] parent, double[] cost)
		{
			this.root 	= root;//Important
			this.parent = parent;
			this.parent[root] = -1; // WHY?
			this.cost 	= cost;
		}

		/** Return the root of the tree */
		public int getRoot() {
			return root;//Important
		}


		/** Return the path of vertices from a vertex to the root */
		public List<V> getPath(int index, List<V> vertices)
		{
			ArrayList<V> path = new ArrayList<>();//Important

			do
			{
				path.add(vertices.get(index));
				index = parent[index];
			}
			while (index != -1);

			return path;
		}

		/** Print a path from the root to vertex v */
		public void printPath(int index,List<V> vertices)
		{
			List<V> path = getPath(index,vertices); //Important
			System.out.print("A path from " + vertices.get(root) + " to " +
					vertices.get(index) + ": ");

			for (int i = path.size() - 1; i >= 0; i--)
				System.out.print(path.get(i) + " ");
		}


		/** Print paths from all vertices to the source */
		public void printAllPaths(List<V> vertices)
		{
			System.out.println("All shortest paths from " +
					vertices.get(getRoot()) + " are:");//Important

			for (int i = 0; i < cost.length; i++)
			{
				printPath(i,vertices); // Print a path from i to the source

				System.out.println("(cost: " + cost[i] + ")"); // Path cost
			}
		}

	}


}