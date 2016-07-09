package project;
public class Test {
	public static void main(String[] args){
		import_email email = new import_email();
		String[] vertices = email.import_email_vertices();
		Edge[] edges=email.import_email_edges();
		AdjMatrixGraph<String> adjMatrixGraph = new AdjMatrixGraph<String>(vertices,edges);
		System.out.println(adjMatrixGraph.toString());
		System.out.println(" �������"+adjMatrixGraph.mainperson());
		System.out.println(" ��Ե���"+adjMatrixGraph.marginalperson());
		System.out.println(" ��Ծ���"+adjMatrixGraph.activeperson());
		System.out.println();
		System.out.println("charlie17@mail.com��Ȧ��");
		for(int i=0;i<adjMatrixGraph.group_one(vertices, "charlie17@mail.com").length;i++)
			System.out.print(" "+adjMatrixGraph.group_one(vertices, "charlie17@mail.com")[i]);
		System.out.println();
		System.out.println();
		System.out.println("С�������");
		for(int i=0;i<adjMatrixGraph.vertexCount();i++){
			for(int j=0;j<adjMatrixGraph.vertexCount();j++){
				System.out.print(" "+adjMatrixGraph.team()[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("С�����Ա��");
		for(int i=0;i<adjMatrixGraph.teamgroup().length;i++){
			for(int j=0;j<adjMatrixGraph.teamgroup()[i].length;j++){
				System.out.print(" "+adjMatrixGraph.teamgroup()[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("�Ž��ˣ�");
		for(int i=0;i<adjMatrixGraph.Connecter().length;i++)
			System.out.print(" "+adjMatrixGraph.Connecter()[i]);
	}
}
