package ejercicio3;


import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup bg = new ButtonGroup();
	private JTextField textField;

	public Ejercicio3() {
		setTitle("Selecci\u00F3n m\u00FAltiple");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 445, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JRadioButton btnMac = new JRadioButton("Mac");
		btnMac.setBounds(249, 10, 87, 23);
		bg.add(btnMac);
		
		JRadioButton btnWindows = new JRadioButton("Windows");
		btnWindows.setBounds(160, 10, 87, 23);
		
		bg.add(btnWindows);
		
		JLabel lbl1 = new JLabel("Elija un sistema operativo");
		lbl1.setBounds(12, 12, 142, 16);
		lbl1.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		JRadioButton btnLinux = new JRadioButton("Linux");
		btnLinux.setBounds(338, 10, 87, 23);
		bg.add(btnLinux);
		contentPane.setLayout(null);
		contentPane.add(btnMac);
		contentPane.add(btnWindows);
		contentPane.add(lbl1);
		contentPane.add(btnLinux);
		
		JLabel lblNewLabel = new JLabel("Elija una especialidad");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBounds(12, 116, 178, 14);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Programaci\u00F3n");
		chckbxNewCheckBox.setBounds(174, 83, 129, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Administraci\u00F3n");
		chckbxNewCheckBox_1.setBounds(174, 113, 129, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		chckbxNewCheckBox_2.setBounds(174, 139, 129, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		Label label = new Label("Cantidad de horas en el computador:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(12, 237, 235, 22);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(250, 239, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sistemaOperativo = "";
                if (btnWindows.isSelected()) {
                    sistemaOperativo = "Windows";
                } else if (btnMac.isSelected()) {
                    sistemaOperativo = "Mac";
                } else if (btnLinux.isSelected()) {
                    sistemaOperativo = "Linux";
                }
                
                StringBuilder especialidades = new StringBuilder();
                if (chckbxNewCheckBox.isSelected()) {
                    especialidades.append("Programación, ");
                }
                if (chckbxNewCheckBox_1.isSelected()) {
                    especialidades.append("Administración, ");
                }
                if (chckbxNewCheckBox_2.isSelected()) {
                    especialidades.append("Diseño Gráfico, ");
                }
                
                String horas = textField.getText();
                
                
                JFrame infoFrame = new JFrame("Información Seleccionada");
                
                infoFrame.setBounds(100, 100, 500, 200);
                infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                if (especialidades.length() > 0) {
                    especialidades.delete(especialidades.length() - 2, especialidades.length());
                }
                JLabel infoLabel = new JLabel(sistemaOperativo + " - " + especialidades.toString() + " - " + horas + " Hs");

                infoLabel.setBounds(20, 20, 250, 250);
                infoFrame.add(infoLabel);
     
                infoFrame.setVisible(true);
                
				
			}
		});
		setVisible(true);
		btnAceptar.setBounds(160, 275, 89, 23);
		contentPane.add(btnAceptar);
		
	}
}
