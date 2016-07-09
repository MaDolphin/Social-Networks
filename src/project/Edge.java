package project;
public class Edge implements Comparable<Edge>{
	public int start,dest,weight;
	public Edge(int start,int dest,int weight){
		this.start=start;
		this.dest=dest;
		this.weight=weight;
	}
	public String toString(){
		return "("+start+","+dest+","+weight+")";
	}
	public int compareTo(Edge e) {
		if(this.start!=e.start)
			return this.start-e.start;
		return this.dest-e.dest;
	}
}