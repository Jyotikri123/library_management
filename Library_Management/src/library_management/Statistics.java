/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

/**
 *
 * @author jyoti
 */
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Statistics extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	public static void main(String[] args) {
		new Statistics().setVisible(true);
	}

	public void issueBook() {
		try {
			Conn con = new Conn();
			String sql = "select * from issueBook";
			PreparedStatement st = con.c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void returnBook() {
		try {
			Conn con = new Conn();
			String sql = "select * from returnBook";
			PreparedStatement st = con.c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Statistics() {
		setTitle("Statistics");
		setBounds(400, 200, 810, 594);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 51, 708, 217);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(224, 255, 255));
		table.setForeground(new Color(128, 128, 0));
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
		panel.setForeground(new Color(0, 128, 128));
		panel.setBounds(26, 36, 737, 240);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 316, 717, 217);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setBackground(new Color(204, 255, 255));
		table_1.setForeground(new Color(153, 51, 0));
		table_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		scrollPane_1.setViewportView(table_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 204, 153), 2, true), "Return-Book-Details",
				TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 102, 51)));
		panel_1.setBounds(22, 299, 741, 240);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		
		JButton b3 = new JButton("Back");
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		b3.setForeground(Color.GRAY);
		b3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b3.setBounds(673, 11, 89, 23);
		contentPane.add(b3);

		issueBook();
		returnBook();
	}
}
