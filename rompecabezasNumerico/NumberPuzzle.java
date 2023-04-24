package rompecabezasNumerico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumberPuzzle extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	
	List<String> values = Arrays.asList("1", "2", "3", "4","5","6", "7", "8", "9","10","11", "12", "13", "14","15"," ");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberPuzzle frame = new NumberPuzzle();
                    frame.shuffleButtons();
                    frame.swapButtons();
                    frame.checkForWin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NumberPuzzle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 5, 5, 5));
		
		JButton btnNewButton = new JButton();
		
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton();
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton();
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton();
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton();
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton();
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton();
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton();
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton();
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton();
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton();
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton();
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton();
		panel.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton();
		panel.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton();
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton();
		panel.add(btnNewButton_15);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnReiniciar = new JButton("R E I N I C I A R ");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shuffleButtons();
			}
		});
		panel_1.add(btnReiniciar);
	}
	
	private void shuffleButtons() {
		
	    Collections.shuffle(values);
	    int i = 0;
	    for (Component c : panel.getComponents()) {
	        if (c instanceof JButton) {
	            ((JButton) c).setText(values.get(i));
	            i++;
	        }
	    }
	}
	
	private void swapButtons() {
		
	    for (Component component : panel.getComponents()) {
	        if (component instanceof JButton) {
	            JButton button = (JButton) component;
	            button.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    int buttonIndex = values.indexOf(button.getText());
	                    int emptyIndex = values.indexOf(" ");
	                    
	                    if (buttonIndex == emptyIndex - 1 || buttonIndex == emptyIndex + 1 ||
	                        buttonIndex == emptyIndex - 4 || buttonIndex == emptyIndex + 4) {
	                        String temp = button.getText();
	                        button.setText(" ");
	                        values.set(buttonIndex, " ");
	                        values.set(emptyIndex, temp);
	                        
	                        ((JButton) panel.getComponent(emptyIndex)).setText(temp);
	                        checkForWin();
	                    }
	                }
	            });
	        }
	    }
	}
	
	private void checkForWin() {

	    boolean isWin = true;
	    for (int i = 0; i < values.size() - 1; i++) {
	        if (!values.get(i).equals(String.valueOf(i + 1))) {
	            isWin = false;
	            break;
	        }
	    }

	    if (isWin) {
	        JOptionPane.showMessageDialog(this, "¡Haz completado el juego!");
	    }
	}
}
