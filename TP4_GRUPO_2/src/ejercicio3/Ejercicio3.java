package ejercicio3;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Ejercicio3 extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private ButtonGroup bg;
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
		panel1 = new JPanel();
		Border bordeLinea = new LineBorder(Color.BLACK,2,true);
		
		panel1.setBounds(10, 11, 409, 62);
		panel1.setBorder(bordeLinea);
		
		lblSistema = new JLabel("Elija un sistema operativo");
	    lblSistema.setBounds(10, 24, 142, 16);
	    
	    lblSistema.setFont(new Font("Dialog", Font.PLAIN, 12));
	    
	    btnLinux = new JRadioButton("Linux",false);
	    btnLinux.setBounds(327, 22, 51, 23);
	    
	    btnMac = new JRadioButton("Mac",false); 
	    btnMac.setBounds(264, 22, 45, 23);
	    contentPane.setLayout(null);

	    bg = new ButtonGroup();
	    bg.add(btnLinux);
	    bg.add(btnMac);
	    panel1.setLayout(null);

	    panel1.add(lblSistema);
	    btnWindows = new JRadioButton("Windows",true);
	    btnWindows.setBounds(183, 22, 69, 23);
	    bg.add(btnWindows);
	    panel1.add(btnWindows);
	    panel1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblSistema, btnWindows, btnLinux, btnMac}));
	    panel1.add(btnMac);
	    panel1.add(btnLinux);
	    contentPane.add(panel1);
	    
	    panel2 =new JPanel();
	    panel2.setBounds(10, 81, 409, 103);
		panel2.setBorder(bordeLinea);
		panel2.setLayout(null);
	    
		lblEspecialidad = new JLabel("Elija una especialidad");
		lblEspecialidad.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEspecialidad.setBounds(10, 40, 178, 14);
		
		chckbxProgramcion = new JCheckBox("Programaci\u00F3n");
		chckbxProgramcion.setBounds(215, 11, 129, 23);	
		
		chckbxAdministracion = new JCheckBox("Administraci\u00F3n");
		chckbxAdministracion.setBounds(215, 61, 129, 23);	
		
		chckbxDiseño = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		chckbxDiseño.setBounds(215, 37, 129, 23);
		
		
		lblHoras = new JLabel("Cantidad de horas en el computador:",0);
		lblHoras.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblHoras.setBounds(10, 195, 235, 22);
		
		panel2.add(lblEspecialidad);
		panel2.add(chckbxProgramcion);
		panel2.add(chckbxDiseño);
		panel2.add(chckbxAdministracion);
		contentPane.add(panel2);

		
		txtHoras = new JTextField();
		txtHoras.setText("0");
		txtHoras.setBounds(264, 195, 86, 20);
		txtHoras.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		setVisible(true);
		btnAceptar.setBounds(156, 245, 89, 23);
		
		contentPane.add(lblHoras);
		contentPane.add(txtHoras);
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
