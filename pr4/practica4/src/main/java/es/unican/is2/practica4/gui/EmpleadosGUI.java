package es.unican.is2.practica4.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.unican.is2.practica4.model.Categoria;
import es.unican.is2.practica4.model.DatoIncorrectoException;
import es.unican.is2.practica4.model.Empleado;
import es.unican.is2.practica4.model.FechaIncorrectaException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings({ "serial", "unused" })
public class EmpleadosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaContratacion;
	private JTextField txtSueldo;
	private JRadioButton btnBaja;
	@SuppressWarnings("rawtypes")
	private JComboBox comboCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpleadosGUI frame = new EmpleadosGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EmpleadosGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtFechaContratacion = new JTextField();
		txtFechaContratacion.setText("dd/mm/yyyy");
		txtFechaContratacion.setName("txtFechaContratacion");
		txtFechaContratacion.setBounds(124, 8, 86, 20);
		contentPane.add(txtFechaContratacion);
		txtFechaContratacion.setColumns(10);

		JLabel lblSueldo = new JLabel("SUELDO");
		lblSueldo.setName("lblSueldo");
		lblSueldo.setBounds(10, 140, 126, 17);
		contentPane.add(lblSueldo);

		txtSueldo = new JTextField();
		txtSueldo.setName("txtSueldo");
		txtSueldo.setBounds(100, 140, 208, 18);
		contentPane.add(txtSueldo);
		txtSueldo.setColumns(10);

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setName("btnCalcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				LocalDate fechaUltimaVisita = null;
				try {
					fechaUltimaVisita = LocalDate.parse(txtFechaContratacion.getText(), formatter);
				}catch(DateTimeParseException e){
					System.out.println("Introduce fecha con formato dd/mm/aaaa");
				}
				
			    boolean baja = btnBaja.isSelected();
			    Categoria categoria = Categoria.valueOf(comboCategoria.getSelectedItem().toString());
			    
			    double sueldo = 0;
				try {
				    Empleado emp = new Empleado("Pepe", fechaUltimaVisita, categoria);
				    if (baja) emp.darBaja();
					sueldo = emp.sueldoBruto();
					txtSueldo.setText(Double.toString(sueldo));
				} catch (NullPointerException e1) {
				} catch (DatoIncorrectoException e1) {
				} catch (FechaIncorrectaException e1) {
				}

			}
		});
		btnCalcular.setBounds(134, 88, 126, 29);
		contentPane.add(btnCalcular);

		btnBaja = new JRadioButton("Baja");
		btnBaja.setBounds(249, 26, 109, 23);
		btnBaja.setName("btnBaja");
		contentPane.add(btnBaja);

		comboCategoria = new JComboBox();
		comboCategoria.setName("comboCategoria");
		comboCategoria.setModel(new DefaultComboBoxModel(new String[] {"DIRECTIVO", "GESTOR", "OBRERO"}));
		comboCategoria.setBounds(124, 47, 86, 20);
		contentPane.add(comboCategoria);

		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setName("lblCategoria");
		lblCategoria.setBounds(10, 50, 114, 14);
		contentPane.add(lblCategoria);

	}
}