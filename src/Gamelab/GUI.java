package Gamelab;

import java.awt.BorderLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI  extends JFrame implements ActionListener{
	public JTextArea TextArea;
	private JPanel panel;
	private JLabel label;
	private JTextField Text;
	private JButton Execute;

	
	public GUI() {
		buildworld();
	}
	private void buildworld() {
		setTitle("House Game");
		setLayout(new BorderLayout()); // Set 3*3 grid layout
		
		label = new JLabel("What would you like to do? ");
		TextArea = new JTextArea();
		Text = new JTextField();
		Execute = new JButton("Execute");
		panel = new JPanel(new GridLayout(3,1));
		
		
		panel.add(label);
		panel.add(Text);
		panel.add(Execute);
		
		add(TextArea, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		Execute.addActionListener(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500); // sets window's size
		setVisible(true); // Make window visible
		setLocationRelativeTo(null); //centers window
		setVisible(true); // Make window visible
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String s = Text.getText();
		game.processCommand(s);
		game.print(game.currentRoom);
		//game.loadRoomdesc();
		game.print(game.currentRoom.getdescription());
		Text.setText("");
		
		
	}
	public void print(Object obj) {
		TextArea.append(obj.toString()+"\n");
	}
}

//exam is on inheritance and exceptions
