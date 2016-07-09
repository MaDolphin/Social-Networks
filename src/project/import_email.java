package project;
import java.io.*;
import java.util.*;
public class import_email {
	public Edge[] import_email_edges(){
		String[] vertices = this.import_email_vertices();
		String[][] temp =new String[999][2];
		Edge[] edges = null;
		int count=0;
		try{
			Scanner scanner = new Scanner(new FileInputStream("D:\\E-mail.txt"));
			while(scanner.hasNext()){
				temp[count][0] = scanner.next();
				temp[count][1] = scanner.next();
				count++;
			}
			edges=new Edge[count];
			for(int i=0;i<count;i++)
				edges[i] =new Edge(vertices_where(vertices,temp[i][0]),vertices_where(vertices,temp[i][1]),1);
		}
		catch(IOException e){
				e.printStackTrace();
		}
		return edges;
    }
	public String[] import_email_vertices(){
		String[] temp =new String[999];
		String[] vertices=null;
		int count=0;
		try{
			Scanner scanner = new Scanner(new FileInputStream("D:\\E-mail.txt"));
			while(scanner.hasNext()){
				String word = scanner.next();
				if(!this.isExists(temp,word,count)){
					temp[count]=word;
					count++;
				}
			}
			vertices=new String[count];
			for(int i=0;i<count;i++){
				vertices[i]=temp[i];
			}
		}
		catch(IOException e){
				e.printStackTrace();
		}
		return vertices;
    }
	public boolean isExists(String[] str,String word,int t){
		for(int i=0;i<t;i++){
			if(str[i].equals(word))
				return true;
		}
		return false;
	}
	public int vertices_where(String[] str,String word){
		for(int i=0;i<str.length;i++){
			if(str[i].equals(word))
				return i;
		}
		return -1;
	}
	public static void main(String[] args){
		import_email email = new import_email();
		String[] vertices=email.import_email_vertices();
		for(int i=0;i<vertices.length;i++){
			System.out.println(vertices[i]);
		}
		Edge[] edges=email.import_email_edges();
		for(int i=0;i<edges.length;i++){
			System.out.println(edges[i].start+" "+edges[i].dest+" "+edges[i].weight);
		}
	}
}