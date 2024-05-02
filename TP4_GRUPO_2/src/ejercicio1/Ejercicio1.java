package ejercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;*/
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Ejercicio1 extends JFrame {

	
	private static final long serialVersionUID = 1L;
	Font fuente = new Font("Tahoma", Font.BOLD, 16);
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textFecha;
	

	public Ejercicio1() {
		setTitle("Contactos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 572, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(57, 58, 73, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(57, 83, 73, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(57, 108, 73, 26);
		contentPane.add(lblTelefono);
		
		JLabel lblFecha = new JLabel("Fecha Nacimiento:");
		lblFecha.setBounds(57, 145, 107, 14);
		contentPane.add(lblFecha);
		
		textNombre = new JTextField();
		textNombre.setBounds(174, 55, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(174, 81, 86, 19);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(174, 111, 86, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(174, 142, 86, 20);
		contentPane.add(textFecha);
		textFecha.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(127, 186, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel labelMostrar = new JLabel("");
		labelMostrar.setBounds(20, 220, 500, 20);
		contentPane.add(labelMostrar);
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 String nombre = textNombre.getText();
	             String apellido = textApellido.getText();
	             String telefono = textTelefono.getText();
	             String fechaNacimiento = textFecha.getText();
	             String datos= null;
	                textNombre.setBackground(nombre.trim().isEmpty()? Color.RED:UIManager.getColor("TextField.background") );
	                textApellido.setBackground(apellido.trim().isEmpty()? Color.RED: UIManager.getColor("TextField.background"));
	                textTelefono.setBackground(telefono.trim().isEmpty()? Color.RED: UIManager.getColor("TextField.background"));
	                textFecha.setBackground(fechaNacimiento.trim().isEmpty()? Color.RED: UIManager.getColor("TextField.background"));
	            
	                if((nombre.trim().isEmpty() || apellido.trim().isEmpty() || telefono.trim().isEmpty() || fechaNacimiento.trim().isEmpty())) {
	                    datos = "No se ingresaron datos ";
	                }
	                else {
	                    datos = "Los datos ingresados fueron: " + nombre + " " + apellido + ", " + telefono + ", " + fechaNacimiento;
	                } 
	                
	                labelMostrar.setText(datos);
	                
	                textNombre.setText("");
	                textApellido.setText("");
	                textTelefono.setText("");
	                textFecha.setText("");
			}
		});
	}
}
