package project;
public class AdjMatrixGraph<T> {
	protected SeqList<T> vertexlist;
	protected int[][] adjmatrix;
	protected int[] visit;
	private final int MAX_WEIGHT=99999;
	public AdjMatrixGraph(int size){
		size=size<10?10:size;
		this.vertexlist=new SeqList(size);
		this.adjmatrix=new int[size][size];
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				this.adjmatrix[i][j]=(i==j)?0:MAX_WEIGHT;
	}
	public AdjMatrixGraph(T[] vertices,Edge[] edges){
		this(vertices.length);
		if(vertices==null)
			return;
		for(int i=0;i<vertices.length;i++)
			insertVertex(vertices[i]);
		if(edges!=null)
			for(int j=0;j<edges.length;j++)
				insertEdge(edges[j]);
	}
	public int vertexCount(){
		return this.vertexlist.length();
	}
	public int getWeight(int i,int j){
		return this.adjmatrix[i][j];
	}
	public T get(int i){
		return this.vertexlist.get(i);
	}
	public String toString(){
		String str="顶点集合："+this.vertexlist.toString()+"\n 邻接矩阵 \n";
		int n=this.vertexCount();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				str+=this.adjmatrix[i][j]==MAX_WEIGHT?" ∞":" "+this.adjmatrix[i][j];
			str+="\n";
		}
		return str;
	}
	public int insertVertex(T x){
		this.vertexlist.append(x);
		if(this.vertexCount()>this.adjmatrix.length){
			int temp[][]=adjmatrix,i,j;
			this.adjmatrix=new int[temp.length*2][temp.length^2];
			for(i=0;i<temp.length;i++){
				for(j=0;j<temp.length;j++)
					this.adjmatrix[i][j]=temp[i][j];
				for(j=temp.length;j<temp.length*2;i++)
					this.adjmatrix[i][j]=MAX_WEIGHT;
				}
			for(i=temp.length;i<temp.length*2;i++)
				for(j=0;j<temp.length*2;j++)
					this.adjmatrix[i][j]=(i==j)?0:MAX_WEIGHT;
		}
		return this.vertexlist.length()-1;
	}
	public void insertEdge(Edge edge){
		this.insertEdge(edge.start,edge.dest,edge.weight);
	}
	public void insertEdge(int i,int j,int weight){
		int n=this.vertexCount();
		if(i>=0&&i<n&&j>=0&&i!=j){
			if(this.adjmatrix[i][j]==MAX_WEIGHT)
				this.adjmatrix[i][j]=0;
			this.adjmatrix[i][j]+=weight;
		}
	}
	public int[] outdegres(){
		int[] temp = new int[this.adjmatrix.length];
		for(int i=0;i<this.adjmatrix.length;i++){
			for(int j=0;j<this.adjmatrix[0].length;j++){
				if(this.adjmatrix[i][j] !=MAX_WEIGHT)
					temp[i]=temp[i]+this.adjmatrix[i][j];
			}
		}
		return temp;
	}
	public int[] indegres(){
		int[] temp = new int[this.adjmatrix.length];
		for(int i=0;i<this.adjmatrix[0].length;i++){
			for(int j=0;j<this.adjmatrix.length;j++){
				if(this.adjmatrix[j][i] !=MAX_WEIGHT)
					temp[i]=temp[i]+this.adjmatrix[j][i];
			}
		}
		return temp;
	}
	public String activeperson(){
		int max=-1;
		int line=-1;
		for(int i=0;i<this.outdegres().length;i++){
			if(this.outdegres()[i]>max){
				max=this.outdegres()[i];
				line=i;
			}
		}
		return (String)this.get(line);
	}
	public String mainperson(){
		int[] temp = new int [this.outdegres().length];
		int max=-1;
		int line=-1;
		for(int i=0;i<this.outdegres().length;i++)
			temp[i]=this.outdegres()[i]+this.indegres()[i];
		for(int i=0;i<temp.length;i++){
			if(temp[i]>max){
				max=this.outdegres()[i];
				line=i;
			}
		}
		return (String)this.get(line);
	}
	public String marginalperson(){
		int[] temp = new int [this.outdegres().length];
		int min=99999;
		int line=-1;
		for(int i=0;i<this.outdegres().length;i++)
			temp[i]=this.outdegres()[i]+this.indegres()[i];
		for(int i=0;i<temp.length;i++){
			if(temp[i]<min){
				min=temp[i];
				line=i;
			}
		}
		return (String)this.get(line);
	}
	public boolean isExist(String[] temp,String str,int t){
		for(int i=0;i<t;i++){
			if(temp[i].equals(str))
				return true;
		}
		return false;
	}
	public String[] group_one(String[] vertices,String str){
		String[] init=this.group(vertices, str);
		int count=0;
		while(init[count]!=null)
			count++;
		String[] temp=new String[count];
		for(int i=0;i<count;i++)
			temp[i]=init[i];
		return temp;
	}
	public String[] Connecter(){
		int count=0;
		for(int i=0;i<this.visit.length;i++){
			if(visit[i]>=2){
				count++;
			}
		}
		String[] connector = new String[count];
		count=0;
		for(int i=0;i<this.visit.length;i++){
			if(visit[i]>=2){
				connector[count]=(String)this.get(i);
				count++;
			}
		}
		return connector;
	}
	public String[] group(String[] vertices,String str){
		String[] temp = new String[vertices.length];
		int location=-1;
		int count=0;
		for(int i=0;i<vertices.length;i++){
			if(vertices[i].equals(str)){
				location=i;break;
			}
		}
		for(int i=0;i<vertices.length;i++)
			if(this.adjmatrix[location][i]!=0 && this.adjmatrix[location][i]!=MAX_WEIGHT){
				temp[count]=(String)this.get(i);
				count++;
			}
		for(int i=0;i<vertices.length;i++)
			if(this.adjmatrix[i][location]!=0 && this.adjmatrix[i][location]!=MAX_WEIGHT){
				if(!this.isExist(temp, (String)this.get(i),count)){
					temp[count]=(String)this.get(i);
					count++;
				}
			}
		return temp;
	}
	public String[][] teamgroup(){
		int[][] temp = this.team();
		int count=0;
		for(int i=0;i<temp.length;i++)
			if(!(temp[i][0]==0 || temp[i][1]==0))
				count++;
		String [][] group=new String [count][temp.length/2];
		int t=count;count=0;
		for(int i=0;i<temp.length && count<t;i++){
			if(!(temp[i][0]==0 || temp[i][1]==0)){
				for(int j=0;temp[i][j]!=0;j++){
					group[count][j]=(String)this.get(temp[i][j]-1);
				}
				count++;
			}
		}
		return group;
	}
	public int[][] team(){
		visit = new int[this.vertexCount()];
		int[][] temp = new int[this.vertexCount()][this.vertexCount()];
		for(int i=0;i<this.vertexCount();i++){
			if(visit[i]==0){
				temp[i][0]=i+1;
				visit[i]++;
				int t=1;
				for(int j=0;j<this.vertexCount();j++){
					if(this.isConnection(temp, i, j, t)){
						temp[i][t]=j+1;
						visit[j]++;
						t++;
					}
				}
			}
		}
		return temp;
	}
	public boolean isConnection(int[][] temp,int i,int j,int t){
		int flag=0;
		for(int m=0;m<t;m++){
			if(this.adjmatrix[temp[i][m]-1][j]!=0 && this.adjmatrix[temp[i][m]-1][j]!=MAX_WEIGHT && this.adjmatrix[j][temp[i][m]-1]!=0 && this.adjmatrix[j][temp[i][m]-1]!=MAX_WEIGHT){
				flag++;
			}
		}
		if(flag==t)
			return true;
		else return false;
	}
}