package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejercicio1.Ejercicio1;
import ejercicio2.Ejercicio2;
import ejercicio3.Ejercicio3;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupo = new JLabel("Grupo Nro: 2");
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGrupo.setBounds(78, 23, 83, 43);
		contentPane.add(lblGrupo);
		
		JButton btnEjercicio1 = new JButton("Ejercicio 1");
        btnEjercicio1.setBounds(167, 74, 134, 23);
        contentPane.add(btnEjercicio1);
        btnEjercicio1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ejercicio1 ejercicio1 = new Ejercicio1();
                ejercicio1.setVisible(true);
                setVisible(false);
                ejercicio1.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        setVisible(true);
                    }
                });
            }
        });
			
		JButton btnEjercicio2 = new JButton("Ejercicio 2");
		btnEjercicio2.setBounds(167, 108, 134, 23);
		contentPane.add(btnEjercicio2);
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejercicio2 ejercicio2 = new Ejercicio2();
				ejercicio2.setVisible(true);
                setVisible(false);
                ejercicio2.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        setVisible(true);
                    }
                });
			}
		});
		
		
		JButton btnEjercicio3 = new JButton("Ejercicio 3");
		btnEjercicio3.setBounds(167, 142, 134, 23);
		contentPane.add(btnEjercicio3);
		btnEjercicio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejercicio3 ejercicio3 = new Ejercicio3();
				ejercicio3.setVisible(true);
                setVisible(false);
                ejercicio3.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        setVisible(true);
                    }
                });
			}
		});
		
	}
}
