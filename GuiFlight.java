package flightTime;
import java.awt.EventQueue;
import flightTime.GraphData;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class GuiFlight {

	private JFrame frmFlightTimeApplication;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFlight window = new GuiFlight();
					window.frmFlightTimeApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFlightTimeApplication = new JFrame();
		frmFlightTimeApplication.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		frmFlightTimeApplication.getContentPane().setBackground(new Color(30, 144, 255));
		frmFlightTimeApplication.setTitle("Flight Time Application");
		frmFlightTimeApplication.setBounds(100, 100, 465, 320);
		frmFlightTimeApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFlightTimeApplication.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Flight Time Application");
		lblNewLabel.setBounds(132, 48, 174, 39);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightTimeApplication.getContentPane().add(lblNewLabel);
		
		JComboBox comboBoxOrigin = new JComboBox();
		comboBoxOrigin.setModel(new DefaultComboBoxModel(new String[] {"London", "Sydney", "Tokyo", "New York", "Berlin", "Hong Kong"}));
		comboBoxOrigin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBoxOrigin.setBounds(45, 112, 98, 28);
		frmFlightTimeApplication.getContentPane().add(comboBoxOrigin);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(45, 151, 257, 119);
		frmFlightTimeApplication.getContentPane().add(textArea);
		
		JComboBox comboBoxDestination = new JComboBox();
		comboBoxDestination.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBoxDestination.setModel(new DefaultComboBoxModel(new String[] {"London", "Sydney", "Tokyo", "New York", "Berlin", "Hong Kong"}));
		comboBoxDestination.setBounds(181, 112, 98, 28);
		frmFlightTimeApplication.getContentPane().add(comboBoxDestination);
		
		JLabel lblNewLabel_1 = new JLabel("Origin");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(58, 98, 65, 14);
		frmFlightTimeApplication.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Destination");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(195, 98, 65, 14);
		frmFlightTimeApplication.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnSearch.setBounds(335, 115, 89, 23);
		frmFlightTimeApplication.getContentPane().add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				int originboxselected = (int) comboBoxOrigin.getSelectedIndex();
				int destinationboxselected = (int) comboBoxDestination.getSelectedIndex();
				
				GraphData graphdata = new GraphData();
				textArea.setText(graphdata.getFlightInformation(originboxselected, destinationboxselected));
				
			}
		});

		
		JButton btnFullSearch = new JButton("Search all flights");
		btnFullSearch.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnFullSearch.setBounds(321, 161, 124, 23);
		frmFlightTimeApplication.getContentPane().add(btnFullSearch);
		btnFullSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				GraphData graphdata = new GraphData();
				LinkedList<String> allflightpaths = new LinkedList<String>();
				allflightpaths = graphdata.getallFlightInformation();	

				for (int i = 0; i < allflightpaths.size(); i++) {
				    System.out.println(allflightpaths.get(i));
				}
			}
		});
		
		
		
		JButton btnNewButton_2 = new JButton("Sort by flight time");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_2.setBounds(321, 209, 124, 23);
		frmFlightTimeApplication.getContentPane().add(btnNewButton_2);
		

	}
}
