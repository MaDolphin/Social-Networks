package project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class ConnectorFrm extends JFrame implements ActionListener{
	import_email email = new import_email();
	String[] vertices = email.import_email_vertices();
	Edge[] edges=email.import_email_edges();
	AdjMatrixGraph<String> adjMatrixGraph = new AdjMatrixGraph<String>(vertices,edges);
	JButton btn = new JButton("关闭窗口");
	JTextArea txt= new JTextArea();
	public ConnectorFrm() {
		String temp=null;
		adjMatrixGraph.teamgroup();
		for(int i=0;i<adjMatrixGraph.Connecter().length;i++){
			if(temp==null)
				temp= adjMatrixGraph.Connecter()[i];
			else temp=temp+"\n"+adjMatrixGraph.Connecter()[i];
		}
		txt.setText(temp);
		JPanel jp = (JPanel) this.getContentPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(txt);
		jp2.add(btn);
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.SOUTH);
		btn.addActionListener(this);
		this.setSize(200, 150);
		this.setVisible(true);
		this.setTitle("桥接人信息");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			dispose();
		}
	}
	public static void main(String[] args){
		new ConnectorFrm();
	}
}

