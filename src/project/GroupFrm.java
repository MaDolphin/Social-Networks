package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GroupFrm extends JFrame implements ActionListener{
	import_email email = new import_email();
	String[] vertices = email.import_email_vertices();
	Edge[] edges=email.import_email_edges();
	AdjMatrixGraph<String> adjMatrixGraph = new AdjMatrixGraph<String>(vertices,edges);
	JButton btn_add = new JButton("关闭窗口");
	JTextArea txt= new JTextArea();
	public GroupFrm(String str) {
		String temp=null;
		for(int i=0;i<adjMatrixGraph.group_one(vertices, str).length;i++){
			if(temp==null)
				temp= adjMatrixGraph.group_one(vertices, str)[i];
			else temp=temp+"\n"+adjMatrixGraph.group_one(vertices, str)[i];
		}
		txt.setText(temp);
		JPanel jp = (JPanel) this.getContentPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(txt);
		jp2.add(btn_add);
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.SOUTH);
		btn_add.addActionListener(this);
		this.setSize(200, 250);
		this.setVisible(true);
		this.setTitle("圈子信息");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			dispose();
		}
	}
}

