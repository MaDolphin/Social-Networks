package project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class TeamGroupFrm extends JFrame implements ActionListener {
	private JTable table = null;
	private String[] cols = {" "," "," "," "," "," "};
	private JButton Btn = new JButton("关闭窗口");
	import_email email = new import_email();
	String[] vertices = email.import_email_vertices();
	Edge[] edges=email.import_email_edges();
	AdjMatrixGraph<String> adjMatrixGraph = new AdjMatrixGraph<String>(vertices,edges);
	private void initTable() {		
		String[][] rows = new String[adjMatrixGraph.teamgroup().length][6];
		for(int i=0;i<adjMatrixGraph.teamgroup().length;i++){
			for(int j=0;adjMatrixGraph.teamgroup()[i][j]!=null;j++){
				rows[i][j]=adjMatrixGraph.teamgroup()[i][j];
			}
		}	
		table = new JTable(rows, cols);
	}
	public TeamGroupFrm(){
		JPanel jp = (JPanel) this.getContentPane();
		initTable();
		JScrollPane jsp_table = new JScrollPane(table);
		table.setAutoResizeMode(1);
		jp.add(jsp_table);
		JPanel jp_top = new JPanel();
		jp_top.add(Btn);
		jp.add(jp_top, BorderLayout.SOUTH);
		Btn.addActionListener(this);
		this.setTitle("团体信息");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Btn){
			dispose();
		}
	}
}
