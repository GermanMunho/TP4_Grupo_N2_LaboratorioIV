package ejercicio2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import ejercicio1.Ejercicio1;
import principal.Principal;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class Ejercicio2 extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textFieldNota1;
    private JTextField textFieldNota2;
    private JTextField textFieldNota3;
    private JTextField textFieldPromedio;
    private JTextField textFieldCondicion;
    private JComboBox<String> comboBoxTPS;

	
	public Ejercicio2() {
		setTitle("Promedio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label lblNotas = new Label("Notas del estudiante");
		lblNotas.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNotas.setBounds(36, 38, 208, 22);
		contentPane.add(lblNotas);
		
		Label lblNotas2 = new Label("Notas del estudiante");
		lblNotas2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNotas2.setBounds(36, 220, 208, 22);
		contentPane.add(lblNotas2);
		
		Label lblNota1 = new Label("Nota 1");
		lblNota1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNota1.setBounds(36, 81, 54, 22);
		contentPane.add(lblNota1);
		
		Label lblNota2 = new Label("Nota 2");
		lblNota2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNota2.setBounds(36, 109, 54, 22);
		contentPane.add(lblNota2);
		
		Label lblNota3 = new Label("Nota 3");
		lblNota3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNota3.setBounds(36, 141, 54, 22);
		contentPane.add(lblNota3);
		
		Label lblTPS = new Label("TPS");
		lblTPS.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTPS.setBounds(36, 169, 37, 22);
		contentPane.add(lblTPS);
		
		textFieldNota1 = new JTextField();
		textFieldNota1.setBounds(96, 83, 101, 20);
		contentPane.add(textFieldNota1);
		textFieldNota1.setColumns(10);
		
		
		textFieldNota2 = new JTextField();
		textFieldNota2.setColumns(10);
		textFieldNota2.setBounds(96, 111, 101, 20);
		contentPane.add(textFieldNota2);
		
		textFieldNota3 = new JTextField();
		textFieldNota3.setColumns(10);
		textFieldNota3.setBounds(96, 141, 101, 20);
		contentPane.add(textFieldNota3);
		
		Label lblPromedio = new Label("Promedio:");
		lblPromedio.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPromedio.setBounds(36, 261, 61, 22);
		contentPane.add(lblPromedio);
		
		Label lblCondicion = new Label("Condicion:");
		lblCondicion.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCondicion.setBounds(36, 292, 61, 22);
		contentPane.add(lblCondicion);
		
		textFieldPromedio = new JTextField();
		textFieldPromedio.setEditable(false);
		textFieldPromedio.setColumns(10);
		textFieldPromedio.setBounds(105, 261, 92, 20);
		contentPane.add(textFieldPromedio);
		
		textFieldCondicion = new JTextField();
		textFieldCondicion.setEditable(false);
		textFieldCondicion.setColumns(10);
		textFieldCondicion.setBounds(105, 294, 92, 20);
		contentPane.add(textFieldCondicion);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularPromedio();
			}
		});
		btnCalcular.setBounds(296, 81, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNuevo.setBounds(296, 109, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dispose();
				  Principal principal = new Principal();
				  principal.setVisible(true);
			}
		});
		btnSalir.setBounds(296, 140, 89, 23);
		contentPane.add(btnSalir);
		
		  comboBoxTPS = new JComboBox<>();
	        comboBoxTPS.setModel(new DefaultComboBoxModel<>(new String[] {"Aprobado", "Desaprobado"}));
	        comboBoxTPS.setBounds(96, 166, 150, 25);
	        contentPane.add(comboBoxTPS);
	}
	
	private void calcularPromedio() {
		  try {
			  double nota1 = Double.parseDouble(textFieldNota1.getText());
	            double nota2 = Double.parseDouble(textFieldNota2.getText());
	            double nota3 = Double.parseDouble(textFieldNota3.getText());
	            if (nota1 < 1 || nota1 > 10 || nota2 < 1 || nota2 > 10 || nota3 < 1 || nota3 > 10) {
	                JOptionPane.showMessageDialog(null, "Las notas deben estar entre 1 y 10.");
	                return;
	            }

	            double promedio = (nota1 + nota2 + nota3) / 3;
	            textFieldPromedio.setText(String.format("%.2f", promedio));

	            String tpStatus = (String) comboBoxTPS.getSelectedItem();
	            if (tpStatus.equals("Desaprobado") || nota1 < 6 || nota2 < 6 || nota3 < 6) {
	                textFieldCondicion.setText("Libre");
	            } else if (nota1 >= 8 && nota2 >= 8 && nota3 >= 8 && tpStatus.equals("Aprobado")) {
	                textFieldCondicion.setText("Promocionado");
	            } else if (promedio >= 6 && promedio < 8 && tpStatus.equals("Aprobado")) {
	                textFieldCondicion.setText("Regular");
	            } else {
	                textFieldCondicion.setText("Libre");
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Ingrese notas válidas.");
	        }
		
	}
	private void limpiarCampos() {
		textFieldNota1.setText("");
		textFieldNota2.setText("");
		textFieldNota3.setText("");
		textFieldPromedio.setText("");
		textFieldCondicion.setText("");
	}
}
