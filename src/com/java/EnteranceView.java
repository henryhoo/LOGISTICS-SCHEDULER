package com.java;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EnteranceView extends JFrame {

	private JPanel contentPane, contentPane2;
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
			jtf4_1 = new JTextField(), jtf4_2 = new JTextField(), jtf4_3 = new JTextField(), jtf3_3 = new JTextField(),
			jtf2_3 = new JTextField();
	private String[] titles = new String[8];

	private int Anum, Bnum, Dnum, clickcount = 0;// transport center number,
													// consumer number, deliver
													// number
	private double transfee[][] = new double[3][4];// transfer fee per
													// distance(km)
	private double transdis[][] = new double[3][4];// distance of each center
													// and individual(km)
	private int transabt[][] = new int[3][4];// transport ability of each line
	private int newtray[] = new int[3];// price for buying new trays
	private double trayprice[] = new double[3];// price per tray
	private int inlimit[] = new int[3];// storage limit for center
	private double inprice[] = new double[3];// storage price per tray
	private int goal[] = new int[4];// transport goal for each individual

	private double[][] transprice;// transport price without buying new tray
	private double[][] transaddprice;// transport price with buying new tray

	private void view1init() {
		// init swing component
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
		jtf2_3.setBounds(280, 150, 80, 50);
		jtf3_1.setBounds(360, 50, 80, 50);
		jtf3_2.setBounds(360, 100, 80, 50);
		jtf3_3.setBounds(360, 150, 80, 50);
		jtf4_1.setBounds(440, 50, 80, 50);
		jtf4_2.setBounds(440, 100, 80, 50);
		jtf4_3.setBounds(440, 150, 80, 50);

		contentPane2.add(jtf1_1);
		contentPane2.add(jtf1_2);
		contentPane2.add(jtf1_3);
		contentPane2.add(jtf2_1);
		contentPane2.add(jtf2_2);
		contentPane2.add(jtf3_1);
		contentPane2.add(jtf3_2);
		contentPane2.add(jtf4_1);
		contentPane2.add(jtf4_2);
		contentPane2.add(jtf4_3);
		contentPane2.add(jtf2_3);
		contentPane2.add(jtf3_3);
		// first page
		settext("", "个数", "", "", "", "转运中心个数", "需求者个数", "返还者个数");
		btnNewButton3 = new JButton("确定");
		btnNewButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				clickcount++;// record pf the click amount, which is used to
								// identify which page should be display to user
				lblNewLabel0_0.setVisible(true);
				switch (clickcount) {
				// second page
				case 1:
					// get last page's input
					Anum = jtf1_1.getText().isEmpty() ? 1 : Integer.valueOf(jtf1_1.getText());
					Bnum = jtf1_2.getText().isEmpty() ? 1 : Integer.valueOf(jtf1_2.getText());
					Dnum = jtf1_3.getText().isEmpty() ? 1 : Integer.valueOf(jtf1_3.getText());
					for (int i = 0; i < titles.length; i++) {
						titles[i] = "";
					}
					for (int i = 5; i < 5 + Anum; i++) {
						titles[i] = "转运中心" + String.valueOf(i - 4);
					}
					for (int i = 1; i < 1 + Bnum; i++) {
						titles[i] = "需求者" + String.valueOf(i);
					}
					for (int i = 3; i < 3 + Dnum; i++) {
						titles[i] = "返还者" + String.valueOf(i - 2);
					}
					titles[0] = "单位运费／元";
					settext(titles[0], titles[1], titles[2], titles[3], titles[4], titles[5], titles[6], titles[7]);
					break;
				// third page
				case 2:
					transfee = new double[][] {
							{ jtf1_1.getText().isEmpty() ? -1 : Double.valueOf(jtf1_1.getText()),
									jtf2_1.getText().isEmpty() ? -1 : Double.valueOf(jtf2_1.getText()),
									jtf3_1.getText().isEmpty() ? -1 : Double.valueOf(jtf3_1.getText()),
									jtf4_1.getText().isEmpty() ? -1 : Double.valueOf(jtf4_1.getText()) },
							{ jtf1_2.getText().isEmpty() ? -1 : Double.valueOf(jtf1_2.getText()),
									jtf2_2.getText().isEmpty() ? -1 : Double.valueOf(jtf2_2.getText()),
									jtf3_2.getText().isEmpty() ? -1 : Double.valueOf(jtf3_2.getText()),
									jtf4_2.getText().isEmpty() ? -1 : Double.valueOf(jtf4_2.getText()) },
							{ jtf1_3.getText().isEmpty() ? -1 : Double.valueOf(jtf1_3.getText()),
									jtf2_3.getText().isEmpty() ? -1 : Double.valueOf(jtf2_3.getText()),
									jtf3_3.getText().isEmpty() ? -1 : Double.valueOf(jtf3_3.getText()),
									jtf4_3.getText().isEmpty() ? -1 : Double.valueOf(jtf4_3.getText()) } };
					for (int i = 0; i < titles.length; i++) {
						titles[i] = "";
					}
					for (int i = 5; i < 5 + Anum; i++) {
						titles[i] = "转运中心" + String.valueOf(i - 4);
					}
					for (int i = 1; i < 1 + Bnum; i++) {
						titles[i] = "需求者" + String.valueOf(i);
					}
					for (int i = 3; i < 3 + Dnum; i++) {
						titles[i] = "返还者" + String.valueOf(i - 2);
					}
					titles[0] = "运输里程／km";

					settext(titles[0], titles[1], titles[2], titles[3], titles[4], titles[5], titles[6], titles[7]);
					break;
				// 4th page
				case 3:
					transdis = new double[][] {
							{ jtf1_1.getText().isEmpty() ? 1 : Double.valueOf(jtf1_1.getText()),
									jtf2_1.getText().isEmpty() ? 1 : Double.valueOf(jtf2_1.getText()),
									jtf3_1.getText().isEmpty() ? 1 : Double.valueOf(jtf3_1.getText()),
									jtf4_1.getText().isEmpty() ? 1 : Double.valueOf(jtf4_1.getText()) },
							{ jtf1_2.getText().isEmpty() ? 1 : Double.valueOf(jtf1_2.getText()),
									jtf2_2.getText().isEmpty() ? 1 : Double.valueOf(jtf2_2.getText()),
									jtf3_2.getText().isEmpty() ? 1 : Double.valueOf(jtf3_2.getText()),
									jtf4_2.getText().isEmpty() ? 1 : Double.valueOf(jtf4_2.getText()) },
							{ jtf1_3.getText().isEmpty() ? 1 : Double.valueOf(jtf1_3.getText()),
									jtf2_3.getText().isEmpty() ? 1 : Double.valueOf(jtf2_3.getText()),
									jtf3_3.getText().isEmpty() ? 1 : Double.valueOf(jtf3_3.getText()),
									jtf4_3.getText().isEmpty() ? 1 : Double.valueOf(jtf4_3.getText()) } };
					for (int i = 0; i < titles.length; i++) {
						titles[i] = "";
					}
					for (int i = 5; i < 5 + Anum; i++) {
						titles[i] = "转运中心" + String.valueOf(i - 4);
					}
					for (int i = 1; i < 1 + Bnum; i++) {
						titles[i] = "需求者" + String.valueOf(i);
					}
					for (int i = 3; i < 3 + Dnum; i++) {
						titles[i] = "返还者" + String.valueOf(i - 2);
					}
					titles[0] = "运输能力";

					settext(titles[0], titles[1], titles[2], titles[3], titles[4], titles[5], titles[6], titles[7]);
					break;
				// 5th page
				case 4:
					transabt = new int[][] {
							{ jtf1_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_1.getText()),
									jtf2_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf2_1.getText()),
									jtf3_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf3_1.getText()),
									jtf4_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf4_1.getText()) },
							{ jtf1_2.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_2.getText()),
									jtf2_2.getText().isEmpty() ? 0 : Integer.valueOf(jtf2_2.getText()),
									jtf3_2.getText().isEmpty() ? 0 : Integer.valueOf(jtf3_2.getText()),
									jtf4_2.getText().isEmpty() ? 0 : Integer.valueOf(jtf4_2.getText()) },
							{ jtf1_3.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_3.getText()),
									jtf2_3.getText().isEmpty() ? 0 : Integer.valueOf(jtf2_3.getText()),
									jtf3_3.getText().isEmpty() ? 0 : Integer.valueOf(jtf3_3.getText()),
									jtf4_3.getText().isEmpty() ? 0 : Integer.valueOf(jtf4_3.getText()) } };
					for (int i = 0; i < titles.length; i++) {
						titles[i] = "";
					}
					for (int i = 5; i < 5 + Anum; i++) {
						titles[i] = "转运中心" + String.valueOf(i - 4);
					}
					titles[0] = "新进数量／成本";

					settext(titles[0], "数量", "成本", titles[3], titles[4], titles[5], titles[6], titles[7]);
					break;
				// 6th page
				case 5:
					newtray = new int[] { jtf1_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_1.getText()),
							jtf1_2.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_2.getText()),
							jtf1_3.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_3.getText()), };
					trayprice = new double[] { jtf2_1.getText().isEmpty() ? -1 : Double.valueOf(jtf2_1.getText()),
							jtf2_2.getText().isEmpty() ? -1 : Double.valueOf(jtf2_2.getText()),
							jtf2_3.getText().isEmpty() ? -1 : Double.valueOf(jtf2_3.getText()), };
					for (int i = 0; i < titles.length; i++) {
						titles[i] = "";
					}
					for (int i = 5; i < 5 + Anum; i++) {
						titles[i] = "转运中心" + String.valueOf(i - 4);
					}
					titles[0] = "库存限制／成本";
					settext(titles[0], "限制", "成本", titles[3], titles[4], titles[5], titles[6], titles[7]);
					break;
				// 7th page
				case 6:
					inlimit = new int[] { jtf1_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_1.getText()),
							jtf1_2.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_2.getText()),
							jtf1_3.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_3.getText()) };
					inprice = new double[] { jtf2_1.getText().isEmpty() ? -1 : Double.valueOf(jtf2_1.getText()),
							jtf2_2.getText().isEmpty() ? -1 : Double.valueOf(jtf2_2.getText()),
							jtf2_3.getText().isEmpty() ? -1 : Double.valueOf(jtf2_3.getText()) };
					for (int i = 0; i < titles.length; i++) {
						titles[i] = "";
					}
					for (int i = 1; i < 1 + Bnum; i++) {
						titles[i] = "需求者" + String.valueOf(i);
					}
					for (int i = 3; i < 3 + Dnum; i++) {
						titles[i] = "返还者" + String.valueOf(i - 2);
					}
					titles[0] = "需求量／返还量";

					settext(titles[0], titles[1], titles[2], titles[3], titles[4], "数量", titles[6], titles[7]);
					break;
				// the last click of button, first check the data's
				// creditability, and then begin calculate the output.
				default:
					// get last input at first
					goal = new int[] { jtf1_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf1_1.getText()),
							jtf2_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf2_1.getText()),
							jtf3_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf3_1.getText()),
							jtf4_1.getText().isEmpty() ? 0 : Integer.valueOf(jtf4_1.getText()) };
					// check if exceed the transport ability
					for (int i = 0; i < goal.length; i++) {
						if (goal[i] > transabt[0][i] + transabt[1][i] + transabt[2][i]) {

							int value = JOptionPane.showConfirmDialog(contentPane, "超出运输能力，请重新输入", "警告",
									JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (value == JOptionPane.OK_OPTION) {
								clickcount = 0;
								settext("", "个数", "", "", "", "转运中心个数", "需求者个数", "返还者个数");
								contentPane2.updateUI();
								break;
							}
							if (value == JOptionPane.CANCEL_OPTION) {
								break;
							}

						}
					}
					// check if exceed the storage ability
					if ((goal[0] + goal[1]) > (inlimit[1] + inlimit[2] + inlimit[0])
							|| (goal[3] + goal[2]) > (inlimit[1] + inlimit[2] + inlimit[0])) {

						int value = JOptionPane.showConfirmDialog(contentPane, "超出库存能力，请重新输入", "警告",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (value == JOptionPane.OK_OPTION) {
							clickcount = 0;
							settext("", "个数", "", "", "", "转运中心个数", "需求者个数", "返还者个数");
							contentPane2.updateUI();
							break;
						}
						if (value == JOptionPane.CANCEL_OPTION) {
							break;
						}

					}
					// calculate the transport price, which is distance *
					// fee/distance in first page
					transprice = new double[][] {
							{ transdis[0][0] * transfee[0][0], transdis[0][1] * transfee[0][1],
									transdis[0][2] * transfee[0][2], transdis[0][3] * transfee[0][3] },
							{ transdis[1][0] * transfee[1][0], transdis[1][1] * transfee[1][1],
									transdis[1][2] * transfee[1][2], transdis[1][3] * transfee[1][3] },
							{ transdis[2][0] * transfee[2][0], transdis[2][1] * transfee[2][1],
									transdis[2][2] * transfee[2][2], transdis[2][3] * transfee[2][3] } };

					// use the data we get to initialize PriceMap
					PriceMap[] transmap = new PriceMap[12];
					for (int i = 0; i < transprice.length; i++) {
						for (int j = 0; j < transprice[i].length; j++) {
							transmap[4 * i + j] = new PriceMap(transprice[i][j], i * 100 + j,
									j <= 1 ? "需求者" + (j + 1) : "返还者" + (j - 1));
						}
					}
					// sort the data according to price in order to generate
					// output later
					for (int i = 0; i < transmap.length; i++) {
						for (int j = i + 1; j < transmap.length; j++) {
							if (transmap[i].price > transmap[j].price) {
								PriceMap temp = transmap[i];
								transmap[i] = transmap[j];
								transmap[j] = temp;
							}
						}
					}

					output(transmap, goal, inlimit);
					//// situation that need additional tray
					// if (newtray[1] + newtray[2] + newtray[3] < goal[1] +
					// goal[2] + goal[3] + goal[4]) {
					// transaddprice = new double[][] {
					// { trayprice[0] + transdis[0][0] * transfee[0][0],
					// trayprice[0] + transdis[0][1] * transfee[0][1],
					// trayprice[0] + transdis[0][2] * transfee[0][2],
					// trayprice[0] + transdis[0][3] * transfee[0][3] },
					// { trayprice[1] + transdis[1][0] * transfee[1][0],
					// trayprice[1] + transdis[1][1] * transfee[1][1],
					// trayprice[1] + transdis[1][2] * transfee[1][2],
					// trayprice[1] + transdis[1][3] * transfee[1][3] },
					// { trayprice[2] + transdis[2][0] * transfee[2][0],
					// trayprice[2] + transdis[2][1] * transfee[2][1],
					// trayprice[2] + transdis[2][2] * transfee[2][2],
					// trayprice[2] + transdis[2][3] * transfee[2][3] } };
					//
					//
					// }
					//// situation that no need of additional tray
					// if (newtray[1] + newtray[2] + newtray[3] >= goal[1] +
					// goal[2] + goal[3] + goal[4]) {
					//
					// }

				}

			}
		});
		btnNewButton3.setFont(new Font("������κ", Font.BOLD, 25));
		btnNewButton3.setBounds(123, 220, 195, 50);
		contentPane2.add(btnNewButton3);
	}

	private void output(PriceMap[] map, int[] goal, int[] inlimit) {
		// out put method for no additional tray, user sorted Pricemap as
		// reference to try the lowest possible output in advanced
		double sum =0 ;
		File file = new File("output.txt"); // create output file
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		for (int i = 0; i < 12; i++) {
			if (map[i].price >= 0) {
				int tgoal = goal[map[i].whos % 100];
				int tlmit = inlimit[map[i].whos / 100];
				if (tgoal > 0 && tlmit > 0) {
					if (tgoal >= tlmit) {
						try {
							
							String s = new String(
									"转运中心" + map[i].whos / 100 + " ---" + (map[i].whos % 100 <= 1 ? "送至" : "获取") + tlmit
											+ "件,花费" + tlmit * map[i].price + "----   " + map[i].name + "\n");
							fileWriter.append(s);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						sum = sum+tlmit * map[i].price;
						System.out.println(	"转运中心" + map[i].whos / 100 + " ---" + (map[i].whos % 100 <= 1 ? "送至" : "获取") + tlmit
								+ "件,花费" + tlmit * map[i].price + "----   " + map[i].name);
						tgoal = tgoal - tlmit;
						tlmit = 0;
						inlimit[map[i].whos / 100] = tlmit;
						goal[map[i].whos % 100] = tgoal;
					} else {
						try {
							
							String s = new String(
									"转运中心" + map[i].whos / 100 + " ---" + (map[i].whos % 100 <= 1 ? "送至" : "获取") + tgoal
											+ "件,花费" + tlmit * map[i].price + "----   " + map[i].name + "\n");
							fileWriter.append(s);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						sum = sum+tlmit * map[i].price;
						System.out.println("转运中心" + map[i].whos / 100 + " ---" + (map[i].whos % 100 <= 1 ? "送至" : "获取") + tgoal
								+ "件,花费" + tlmit * map[i].price + "----   " + map[i].name );
						tlmit = tlmit - tgoal;
						tgoal = 0;
						inlimit[map[i].whos / 100] = tlmit;
						goal[map[i].whos % 100] = tgoal;
					}
				}
			}
		}
		System.out.println("总花费"+sum);
		try {
			fileWriter.append("总花费"+sum);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void settext(String H, String a1, String a2, String a3, String a4, String b1, String b2, String b3) {
		// integration of the method of update each page according to
		// columnheads and rowheads
		lblNewLabel1_1.setText(b1);
		lblNewLabel1_2.setText(b2);
		lblNewLabel1_3.setText(b3);
		lblNewLabel0_0.setText(H);
		lblNewLabel2_1.setText(a1);
		lblNewLabel3_1.setText(a2);
		lblNewLabel4_1.setText(a3);
		lblNewLabel5_1.setText(a4);
		if (a1.isEmpty()) {
			jtf1_1.setVisible(false);
		} else {
			jtf1_1.setVisible(true);
		}
		if (a2.isEmpty()) {
			jtf2_1.setVisible(false);
		} else {
			jtf2_1.setVisible(true);
		}
		if (a3.isEmpty()) {
			jtf3_1.setVisible(false);
		} else {
			jtf3_1.setVisible(true);
		}
		if (a4.isEmpty()) {
			jtf4_1.setVisible(false);
		} else {
			jtf4_1.setVisible(true);
		}
		if (b2.isEmpty()) {
			jtf1_2.setVisible(false);
			jtf2_2.setVisible(false);
			jtf3_2.setVisible(false);
			jtf4_2.setVisible(false);
		} else {
			if (a1.isEmpty()) {
				jtf1_2.setVisible(false);
			} else {
				jtf1_2.setVisible(true);
			}
			if (a2.isEmpty()) {
				jtf2_2.setVisible(false);
			} else {
				jtf2_2.setVisible(true);
			}
			if (a3.isEmpty()) {
				jtf3_2.setVisible(false);
			} else {
				jtf3_2.setVisible(true);
			}
			if (a4.isEmpty()) {
				jtf4_2.setVisible(false);
			} else {
				jtf4_2.setVisible(true);
			}
		}
		if (b3.isEmpty()) {
			jtf1_3.setVisible(false);
			jtf2_3.setVisible(false);
			jtf3_3.setVisible(false);
			jtf4_3.setVisible(false);
		} else {
			if (a1.isEmpty()) {
				jtf1_3.setVisible(false);
			} else {
				jtf1_3.setVisible(true);
			}
			if (a2.isEmpty()) {
				jtf2_3.setVisible(false);
			} else {
				jtf2_3.setVisible(true);
			}
			if (a3.isEmpty()) {
				jtf3_3.setVisible(false);
			} else {
				jtf3_3.setVisible(true);
			}
			if (a4.isEmpty()) {
				jtf4_3.setVisible(false);
			} else {
				jtf4_3.setVisible(true);
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
		jtf4_3.setText("");
		jtf3_3.setText("");
		jtf2_3.setText("");
	}

	public EnteranceView() {
		// TODO Auto-generated constructor stub
		// set up the entrance page and link it with main pages
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

}
