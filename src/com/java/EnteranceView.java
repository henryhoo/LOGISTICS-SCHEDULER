package com.java;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EnteranceView extends JFrame {

	private JPanel contentPane, contentPane2;
	private JLabel lblNewLabel;

	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JButton btnNewButton3;
	private JTable jt;
	private JScrollPane sp;

	private String[] columnNames = {"初始化","个数"};
	private Object[][] data ={{"转运中心个数",""},{"需求者个数",""},{"返还者个数",""}};
	

	private int Anum, Bnum, Dnum, clickcount = 0;

	public EnteranceView() {
		// TODO Auto-generated constructor stub
		entanceinit();
		view1init();
	}

	private void updatejtable(Object[][] data,String[] columnNames ) {
		jt = new JTable(data,columnNames);
		
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		jt.setVisible(true);
		sp = new JScrollPane(jt);
		sp.setBounds(0, 0, 400, 200);
		contentPane2.add(sp);
		
	}
	
	private void view1init() {

		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(null);
		contentPane2.setVisible(true);
		updatejtable(data,columnNames);
		
		btnNewButton3 = new JButton("确定");
		btnNewButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				clickcount++;
				switch (clickcount) {
				case 1:
					Anum=(int) Integer.valueOf((String) jt.getValueAt(0, 1));
					Bnum=(int) Integer.valueOf((String) jt.getValueAt(0, 1));
					Dnum=(int) Integer.valueOf((String) jt.getValueAt(0, 1));
					String[] temp = new String[Bnum+Dnum-1];
					Object[][] tempdata =new Object[Anum-1][Bnum+Dnum-1];
					for (int i = 0; i < temp.length; i++) {
						String t = "需求者"+String.valueOf(i);
						temp[i]= t;
					}
					temp[0]="单位运费／元";
					for (int i = 0; i < Anum-1; i++) {
						for (int j = 1; j < Bnum+Dnum-1; j++) {
							String t = "";
							tempdata[i][j]=t;
						}
						String t = "转运中心"+String.valueOf(i);
						tempdata[i][0]=t;
					}
					jt = new JTable(tempdata,temp);
					sp.add(jt);
					jt.updateUI();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				}

			}
		});
		btnNewButton3.setFont(new Font("������κ", Font.BOLD, 25));
		btnNewButton3.setBounds(123, 220, 195, 50);
		contentPane2.add(btnNewButton3);
	}

	private void entanceinit() {
		// TODO Auto-generated method stub
		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u6258\u76D8\u4F18\u5316\u8C03\u5EA6\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("������κ", Font.BOLD, 30));
		lblNewLabel.setBounds(21, 10, 403, 50);
		contentPane.add(lblNewLabel);

		btnNewButton = new JButton("\u8FDB\u5165\u8BA1\u7B97\u754C\u9762");
		btnNewButton.setFont(new Font("������κ", Font.BOLD, 25));
		btnNewButton.setBounds(123, 94, 195, 50);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				contentPane.setVisible(false);
				setContentPane(contentPane2);
				setTitle("计算界面");
				setBounds(400, 200, 600, 300);
			}
		});
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int value = JOptionPane.showConfirmDialog(contentPane, "确认退出吗", "警告", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (value == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setFont(new Font("������κ", Font.BOLD, 25));
		btnNewButton_1.setBounds(123, 175, 195, 50);
		contentPane.add(btnNewButton_1);
	}

}
