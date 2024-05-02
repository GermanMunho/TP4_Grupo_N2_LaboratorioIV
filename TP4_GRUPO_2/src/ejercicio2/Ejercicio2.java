package ejercicio2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class Ejercicio2 extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textNota1;
    private JTextField textNota2;
    private JTextField textNota3;
    private JTextField textPromedio;
    private JTextField textCondicion;
    private JComboBox<String> comboBoxTPS;
    private JPanel recuadroNota;
	private JPanel RecuadroResultado; 

	
	public Ejercicio2() {
		setTitle("Promedio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 460, 430);
		
		Border bordeNota = BorderFactory.createTitledBorder("Notas del estudiante");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		recuadroNota = new JPanel();
		recuadroNota.setBounds(40, 47, 230, 202);
		recuadroNota.setLayout(null);
		recuadroNota.setBorder(bordeNota);
		getContentPane().add(recuadroNota);
		
		Label lblNotas2 = new Label("Notas del estudiante");
		lblNotas2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNotas2.setBounds(36, 220, 208, 22);
		recuadroNota.add(lblNotas2);
		
		Label lblNota1 = new Label("Nota 1");
		lblNota1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNota1.setBounds(10, 29, 54, 22);
		recuadroNota.add(lblNota1);
		
		Label lblNota2 = new Label("Nota 2");
		lblNota2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNota2.setBounds(10, 72, 54, 22);
		recuadroNota.add(lblNota2);
		
		Label lblNota3 = new Label("Nota 3");
		lblNota3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNota3.setBounds(10, 112, 54, 22);
		recuadroNota.add(lblNota3);
		
		Label lblTPS = new Label("TPS");
		lblTPS.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTPS.setBounds(10, 151, 37, 22);
		recuadroNota.add(lblTPS);
		
		textNota1 = new JTextField();
		textNota1.setBounds(96, 29, 101, 20);
		recuadroNota.add(textNota1);
		textNota1.setColumns(10);
		
		
		textNota2 = new JTextField();
		textNota2.setColumns(10);
		textNota2.setBounds(96, 72, 101, 20);
		recuadroNota.add(textNota2);
		
		textNota3 = new JTextField();
		textNota3.setColumns(10);
		textNota3.setBounds(96, 112, 101, 20);
		recuadroNota.add(textNota3);
		
		  comboBoxTPS = new JComboBox<>();
		  comboBoxTPS.setBounds(96, 150, 101, 25);
		  recuadroNota.add(comboBoxTPS);
		  comboBoxTPS.setModel(new DefaultComboBoxModel<>(new String[] {"Aprobado", "Desaprobado"}));
		
		
		
		Border bordeNota2 = BorderFactory.createTitledBorder("Resultado");
		RecuadroResultado = new JPanel();
		RecuadroResultado.setBounds(40, 260, 230, 103);
		getContentPane().add(RecuadroResultado);
		RecuadroResultado.setLayout(null);
		RecuadroResultado.setBorder(bordeNota2);
		
		Label lblPromedio = new Label("Promedio:");
		lblPromedio.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPromedio.setBounds(10, 26, 61, 22);
		RecuadroResultado.add(lblPromedio);
		
		Label lblCondicion = new Label("Condicion:");
		lblCondicion.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCondicion.setBounds(10, 64, 61, 22);
		RecuadroResultado.add(lblCondicion);
		
		textPromedio = new JTextField();
		textPromedio.setEditable(false);
		textPromedio.setColumns(10);
		textPromedio.setBounds(105, 28, 92, 20);
		RecuadroResultado.add(textPromedio);
		
		textCondicion = new JTextField();
		textCondicion.setEditable(false);
		textCondicion.setColumns(10);
		textCondicion.setBounds(105, 64, 92, 20);
		RecuadroResultado.add(textCondicion);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularPromedio();
			}
		});
		btnCalcular.setBounds(308, 150, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNuevo.setBounds(308, 178, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dispose();
				  Principal principal = new Principal();
				  principal.setVisible(true);
			}
		});
		btnSalir.setBounds(308, 209, 89, 23);
		contentPane.add(btnSalir);
	}
	
	private void calcularPromedio() {
		  try {
			  double nota1 = Double.parseDouble(textNota1.getText());
	            double nota2 = Double.parseDouble(textNota2.getText());
	            double nota3 = Double.parseDouble(textNota3.getText());
	            if (nota1 < 1 || nota1 > 10 || nota2 < 1 || nota2 > 10 || nota3 < 1 || nota3 > 10) {
	                JOptionPane.showMessageDialog(null, "Las notas deben estar entre 1 y 10.");
	                return;
	            }

	            double promedio = (nota1 + nota2 + nota3) / 3;
	            textPromedio.setText(String.format("%.2f", promedio));

	            String tpStatus = (String) comboBoxTPS.getSelectedItem();
	            if (tpStatus.equals("Desaprobado") || nota1 < 6 || nota2 < 6 || nota3 < 6) {
	                textCondicion.setText("Libre");
	            } else if (nota1 >= 8 && nota2 >= 8 && nota3 >= 8 && tpStatus.equals("Aprobado")) {
	                textCondicion.setText("Promocionado");
	            } else if (promedio >= 6 && promedio < 8 && tpStatus.equals("Aprobado")) {
	                textCondicion.setText("Regular");
	            } else {
	                textCondicion.setText("Libre");
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Ingrese notas válidas.");
	        }
		
	}
	private void limpiarCampos() {
		textNota1.setText("");
		textNota2.setText("");
		textNota3.setText("");
		textPromedio.setText("");
		textCondicion.setText("");
	}
}
