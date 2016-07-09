package project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class MainFrm extends JFrame implements ActionListener {
	private JTable table = null;
	private String[] cols = { "编号","发件人","发件数量","收件数量"};
	private JButton Btn1 = new JButton("查询特殊人员");
	private JButton Btn2 = new JButton("查询单人圈子");
	private JButton Btn3 = new JButton("查询团体");
	private JButton Btn4 = new JButton("桥接人");
	import_email email = new import_email();
	String[] vertices = email.import_email_vertices();
	Edge[] edges=email.import_email_edges();
	AdjMatrixGraph<String> adjMatrixGraph = new AdjMatrixGraph<String>(vertices,edges);
	private void initTable() {		
		String[][] rows = new String[adjMatrixGraph.vertexCount()][4];
		for(int i=0;i<adjMatrixGraph.vertexCount();i++){
			rows[i][0]=String.valueOf(i+1);
			rows[i][1]=vertices[i];
			rows[i][2]=String.valueOf(adjMatrixGraph.outdegres()[i]);
			rows[i][3]=String.valueOf(adjMatrixGraph.indegres()[i]);
		}	
		table = new JTable(rows, cols);
	}
	public MainFrm(){
		JPanel jp = (JPanel) this.getContentPane();
		initTable();
		JScrollPane jsp_table = new JScrollPane(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		jp.add(jsp_table);
		JPanel jp_top = new JPanel();
		jp_top.add(Btn1);
		jp_top.add(Btn2);
		jp_top.add(Btn3);
		jp_top.add(Btn4);
		jp.add(jp_top, BorderLayout.NORTH);
		Btn1.addActionListener(this);
		Btn2.addActionListener(this);
		Btn3.addActionListener(this);
		Btn4.addActionListener(this);
		this.setTitle("社交网络分析系统");
		this.setSize(500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Btn1){
			new SpecialPersonFrm();
		}
		if(e.getSource()==Btn2){
			int row=table.getSelectedRow();
			if(row>-1){
				String str = String.valueOf(table.getValueAt(row, 1));
				new GroupFrm(str);
			}else JOptionPane.showMessageDialog(this, "请选择一个成员！");
		}
		if(e.getSource()==Btn3){
			new TeamGroupFrm();
		}	
		if(e.getSource()==Btn4){
			new ConnectorFrm();
		}	
	}
	public static void main(String[] args){
		new MainFrm();
	}
}