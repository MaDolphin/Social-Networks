package project;
public class Test {
	public static void main(String[] args){
		import_email email = new import_email();
		String[] vertices = email.import_email_vertices();
		Edge[] edges=email.import_email_edges();
		AdjMatrixGraph<String> adjMatrixGraph = new AdjMatrixGraph<String>(vertices,edges);
		System.out.println(adjMatrixGraph.toString());
		System.out.println(" 核心人物："+adjMatrixGraph.mainperson());
		System.out.println(" 边缘人物："+adjMatrixGraph.marginalperson());
		System.out.println(" 活跃人物："+adjMatrixGraph.activeperson());
		System.out.println();
		System.out.println("charlie17@mail.com的圈子");
		for(int i=0;i<adjMatrixGraph.group_one(vertices, "charlie17@mail.com").length;i++)
			System.out.print(" "+adjMatrixGraph.group_one(vertices, "charlie17@mail.com")[i]);
		System.out.println();
		System.out.println();
		System.out.println("小团体矩阵：");
		for(int i=0;i<adjMatrixGraph.vertexCount();i++){
			for(int j=0;j<adjMatrixGraph.vertexCount();j++){
				System.out.print(" "+adjMatrixGraph.team()[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("小团体成员：");
		for(int i=0;i<adjMatrixGraph.teamgroup().length;i++){
			for(int j=0;j<adjMatrixGraph.teamgroup()[i].length;j++){
				System.out.print(" "+adjMatrixGraph.teamgroup()[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("桥接人：");
		for(int i=0;i<adjMatrixGraph.Connecter().length;i++)
			System.out.print(" "+adjMatrixGraph.Connecter()[i]);
	}
}
