package com.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u6258\u76D8\u4F18\u5316\u8C03\u5EA6\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华文新魏", Font.BOLD, 30));
		lblNewLabel.setBounds(21, 10, 403, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u8FDB\u5165\u8BA1\u7B97\u754C\u9762");
		btnNewButton.setFont(new Font("华文新魏", Font.BOLD, 25));
		btnNewButton.setBounds(123, 94, 195, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int value = JOptionPane.showConfirmDialog(contentPane, "你确认？", "请确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (value == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setFont(new Font("华文新魏", Font.BOLD, 25));
		btnNewButton_1.setBounds(123, 175, 195, 50);
		contentPane.add(btnNewButton_1);
	}
}

