package com.java;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EnteranceView extends JFrame {

	private JPanel contentPane, contentPane2, contentPane3, contentPane4, contentPane5, contentPane6, contentPane7,
			contentPane8;
	private JLabel lblNewLabel;

	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JButton btnNewButton3;
	private final JLabel lblNewLabel1_1 = new JLabel("转运中心个数");
	private final JLabel lblNewLabel1_2 = new JLabel("需求者个数");
	private final JLabel lblNewLabel1_3 = new JLabel("托盘返还者个数");
	private final JLabel lblNewLabel2_1 = new JLabel("");
	private final JLabel lblNewLabel3_1 = new JLabel("");
	private final JLabel lblNewLabel4_1 = new JLabel("");
	private final JLabel lblNewLabel0_0 = new JLabel("");
	private final JLabel lblNewLabel5_1 = new JLabel("");
	private final JTextField jtf1_1 = new JTextField(), jtf1_2 = new JTextField(), jtf1_3 = new JTextField(),
			jtf2_1 = new JTextField(), jtf2_2 = new JTextField(), jtf3_1 = new JTextField(), jtf3_2 = new JTextField(),
			jtf4_1 = new JTextField(), jtf4_2 = new JTextField(),jtf4_3 = new JTextField(),jtf4_4 = new JTextField();

	private int Anum, Bnum, Dnum, clickcount = 0;

	public EnteranceView() {
		// TODO Auto-generated constructor stub
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

		view1init();

	}

	private void view1init() {

		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(null);
		contentPane2.setVisible(true);

		lblNewLabel1_1.setFont(new Font("������κ", Font.BOLD, 15));
		lblNewLabel1_1.setBounds(80, 50, 403, 50);
		contentPane2.add(lblNewLabel1_1);

		lblNewLabel1_2.setFont(new Font("������κ", Font.BOLD, 15));
		lblNewLabel1_2.setBounds(80, 100, 403, 50);
		contentPane2.add(lblNewLabel1_2);

		lblNewLabel1_3.setFont(new Font("������κ", Font.BOLD, 15));
		lblNewLabel1_3.setBounds(80, 150, 403, 50);
		contentPane2.add(lblNewLabel1_3);

		lblNewLabel2_1.setFont(new Font("������κ", Font.BOLD, 15));
		lblNewLabel2_1.setBounds(200, 10, 403, 50);
		contentPane2.add(lblNewLabel2_1);

		lblNewLabel3_1.setFont(new Font("������κ", Font.BOLD, 15));
		lblNewLabel3_1.setBounds(280, 10, 403, 50);
		contentPane2.add(lblNewLabel3_1);

		lblNewLabel4_1.setFont(new Font("������κ", Font.BOLD, 15));
		lblNewLabel4_1.setBounds(360, 10, 403, 50);
		contentPane2.add(lblNewLabel4_1);

		lblNewLabel5_1.setFont(new Font("������κ", Font.BOLD, 15));
		lblNewLabel5_1.setBounds(440, 10, 403, 50);
		contentPane2.add(lblNewLabel5_1);

		lblNewLabel0_0.setFont(new Font("������κ", Font.BOLD, 15));
		lblNewLabel0_0.setBounds(30, 10, 403, 50);
		contentPane2.add(lblNewLabel0_0);

		jtf1_1.setBounds(200, 50, 80, 50);
		jtf1_2.setBounds(200, 100, 80, 50);
		jtf1_3.setBounds(200, 150, 80, 50);
		jtf2_1.setBounds(280, 50, 80, 50);
		jtf2_2.setBounds(280, 100, 80, 50);
		jtf3_1.setBounds(360, 50, 80, 50);
		jtf3_2.setBounds(360, 100, 80, 50);
		jtf4_1.setBounds(440, 50, 80, 50);
		jtf4_2.setBounds(440, 100, 80, 50);

		contentPane2.add(jtf1_1);
		contentPane2.add(jtf1_2);
		contentPane2.add(jtf1_3);
		contentPane2.add(jtf2_1);
		contentPane2.add(jtf2_2);
		contentPane2.add(jtf3_1);
		contentPane2.add(jtf3_2);
		contentPane2.add(jtf4_1);
		contentPane2.add(jtf4_2);
		settext("", "个数", "", "", "", "转运中心个数", "需求者个数", "返还者个数");
		btnNewButton3 = new JButton("确定");
		btnNewButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				clickcount++;

				lblNewLabel0_0.setVisible(true);
				switch (clickcount) {
				case 1:
					Anum = Integer.valueOf(jtf1_1.getText().trim());
					Bnum = Integer.valueOf(jtf1_2.getText().trim());
					Dnum = Integer.valueOf(jtf1_3.getText().trim());
					settext("单位运费／元", "需求者1", "需求者2", "返还者1", "返还者2", "转运中心1", "转运中心2", "");
					break;

				case 2:
					settext("运输里程／km", "需求者1", "需求者2", "返还者1", "返还者2", "转运中心1", "转运中心2", "");
					break;
				case 3:
					settext("运输能力", "需求者1", "需求者2", "返还者1", "返还者2", "转运中心1", "转运中心2", "");
					break;
				case 4:
					settext("新进数量／成本", "数量", "成本", "", "", "转运中心1", "转运中心2", "");
					break;
				case 5:
					settext("库存限制／成本", "限制", "成本", "", "", "转运中心1", "转运中心2", "");
					break;
				case 6:
					settext("需求量／返还量", "需求者1", "需求者2", "返还者1", "返还者2", "数量", "", "");
					break;
				}

			}
		});
		btnNewButton3.setFont(new Font("������κ", Font.BOLD, 25));
		btnNewButton3.setBounds(123, 220, 195, 50);
		contentPane2.add(btnNewButton3);
	}

	private void settext(String H, String a1, String a2, String a3, String a4, String b1, String b2, String b3) {
		lblNewLabel1_1.setText(b1);
		lblNewLabel1_2.setText(b2);
		lblNewLabel1_3.setText(b3);
		lblNewLabel0_0.setText(H);
		lblNewLabel2_1.setText(a1);
		lblNewLabel3_1.setText(a2);
		lblNewLabel4_1.setText(a3);
		lblNewLabel5_1.setText(a4);
		if (b3.isEmpty()) {
			jtf1_3.setVisible(false);
		} else {
			jtf1_3.setVisible(true);
		}
		
		if (b2.isEmpty()) {
			jtf1_2.setVisible(false);
			jtf2_2.setVisible(false);
			jtf3_2.setVisible(false);
			jtf4_2.setVisible(false);
			if (a3.isEmpty()) {
				jtf3_2.setVisible(false);
				jtf3_1.setVisible(false);
			} else {
				jtf3_1.setVisible(true);
			}
			if (a4.isEmpty()) {
				jtf4_1.setVisible(false);
				jtf4_2.setVisible(false);
			} else {
				jtf4_1.setVisible(true);
			}
		} else {
			if (a3.isEmpty()) {
				jtf3_2.setVisible(false);
				jtf3_1.setVisible(false);
			} else {
				jtf3_2.setVisible(true);
				jtf3_1.setVisible(true);
			}
			if (a4.isEmpty()) {
				jtf4_1.setVisible(false);
				jtf4_2.setVisible(false);
			} else {
				jtf4_1.setVisible(true);
				jtf4_2.setVisible(true);
			}
			if (a2.isEmpty()) {
				jtf2_1.setVisible(false);
				jtf2_2.setVisible(false);
			} else {
				jtf2_1.setVisible(true);
				jtf2_2.setVisible(true);
			}
		}

		jtf1_1.setText("");
		jtf1_2.setText("");
		jtf1_3.setText("");
		jtf2_1.setText("");
		jtf2_2.setText("");
		jtf3_1.setText("");
		jtf3_2.setText("");
		jtf4_1.setText("");
		jtf4_2.setText("");
	}

}
