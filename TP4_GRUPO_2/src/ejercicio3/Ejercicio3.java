package ejercicio3;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;

import javax.swing.JCheckBox;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup bg = new ButtonGroup();
	private JTextField txtHoras;
	private JButton btnAceptar;
	private JRadioButton btnWindows;
	private JRadioButton btnMac;
	private JRadioButton btnLinux;
	private JCheckBox chckbxProgramcion;
	private JCheckBox chckbxAdministracion;
	private JCheckBox chckbxDiseño;
	private JLabel lblEspecialidad;
	private JLabel lblSistema;
	private JLabel lblHoras;
	private JFrame infoFrame;
	private JLabel infoLabel;
	
	public Ejercicio3() {
		initlayaout();
		initComponents();
		initListeners();
		
	}
	
	private void initlayaout() {
		setTitle("Ejercicio 3");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 445, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
	
	private void initComponents() {
		lblSistema = new JLabel("Elija un sistema operativo");

	    btnWindows = new JRadioButton("Windows",true);
	    btnWindows.setBounds(160, 10, 87, 23);
	    btnLinux = new JRadioButton("Linux",false);
	    btnLinux.setBounds(338, 10, 87, 23);
	    btnMac = new JRadioButton("Mac",false); 
	    btnMac.setBounds(249, 10, 87, 23);
	    contentPane.setLayout(null);

	    bg.add(btnLinux);
	    bg.add(btnWindows);
	    bg.add(btnMac);


	    lblSistema.setBounds(12, 12, 142, 16);
	    lblSistema.setFont(new Font("Dialog", Font.PLAIN, 12));
	    contentPane.add(lblSistema);
	    contentPane.add(btnMac);
	    contentPane.add(btnWindows);
	    contentPane.add(btnLinux);
		
		lblEspecialidad = new JLabel("Elija una especialidad");
		lblEspecialidad.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEspecialidad.setBounds(12, 116, 178, 14);
		contentPane.add(lblEspecialidad);
		
		chckbxProgramcion = new JCheckBox("Programaci\u00F3n");
		chckbxProgramcion.setBounds(174, 83, 129, 23);
		contentPane.add(chckbxProgramcion);
		
		chckbxAdministracion = new JCheckBox("Administraci\u00F3n");
		chckbxAdministracion.setBounds(174, 113, 129, 23);
		contentPane.add(chckbxAdministracion);
		
		chckbxDiseño = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		chckbxDiseño.setBounds(174, 139, 129, 23);
		contentPane.add(chckbxDiseño);
		
		lblHoras = new JLabel("Cantidad de horas en el computador:",0);
		lblHoras.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblHoras.setBounds(12, 237, 235, 22);
		contentPane.add(lblHoras);
		
		txtHoras = new JTextField();
		txtHoras.setText("0");
		txtHoras.setBounds(250, 239, 86, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
		btnAceptar = new JButton("Aceptar");
		setVisible(true);
		btnAceptar.setBounds(160, 275, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	private void initListeners() {
		txtHoras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				Validaciones.JtextFieldEsNumero(evt);
				Validaciones.JtextFieldEsPositivo(evt);				
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				String sistemaOperativo =SistemaOperativoSeleccionado();
                String especialidades = EspecialidadSeleccionada();
                if(especialidades=="") {
					JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR AL MENOS 1 ESPECIALIDAD.", "INGRESO DE NOTA INCORRECTO", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				else {
					JOptionPane.showMessageDialog(null, sistemaOperativo + especialidades + " - "+txtHoras.getText() +"Hs");
				}
			}
		});
		
	}
	
public String SistemaOperativoSeleccionado() {
		
		String sistema=null;
		if(btnWindows.isSelected()) {
			sistema=btnWindows.getText();
		}
		else if(btnMac.isSelected()) {
			sistema=btnMac.getText();
		}
		else if(btnLinux.isSelected()) {
			sistema=btnLinux.getText();
		}
		return sistema;
	}
	
	public String EspecialidadSeleccionada() {
		String seleccion="";
		if(chckbxProgramcion.isSelected()) {
			seleccion+=" - "+chckbxProgramcion.getText();
		}
		if(chckbxDiseño.isSelected()) {
			seleccion+=" - "+chckbxDiseño.getText();
		}
		if(chckbxAdministracion.isSelected()) {
			seleccion+=" - "+chckbxAdministracion.getText();
		}
		return seleccion;
	}
	
	
}
