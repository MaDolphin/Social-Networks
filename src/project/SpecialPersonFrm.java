package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SpecialPersonFrm extends JFrame implements ActionListener{
	import_email email = new import_email();
	String[] vertices = email.import_email_vertices();
	Edge[] edges=email.import_email_edges();
	AdjMatrixGraph<String> adjMatrixGraph = new AdjMatrixGraph<String>(vertices,edges);
	JButton btn_add = new JButton("关闭窗口");
	JLabel lb_mainperson = new JLabel("核心人物");
	JLabel lb_activeperson = new JLabel("活跃人物");
	JLabel lb_marginalperson = new JLabel("边缘人物");
	JTextField txt_mainperson = new JTextField();
	JTextField txt_activeperson = new JTextField();
	JTextField txt_marginalperson = new JTextField();
	public SpecialPersonFrm() {
		txt_mainperson.setText(adjMatrixGraph.mainperson());
		txt_activeperson.setText(adjMatrixGraph.activeperson());
		txt_marginalperson.setText(adjMatrixGraph.marginalperson());
		JPanel jp = (JPanel) this.getContentPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.setLayout(new GridLayout(3, 2, 5, 10));
		jp1.add(lb_mainperson);
		jp1.add(txt_mainperson);
		jp1.add(lb_activeperson);
		jp1.add(txt_activeperson);
		jp1.add(lb_marginalperson);
		jp1.add(txt_marginalperson);
		jp2.add(btn_add);
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.SOUTH);
		btn_add.addActionListener(this);
		this.setSize(300, 170);
		this.setVisible(true);
		this.setTitle("特殊人物信息");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_add) {
			dispose();
		}
	}
}

