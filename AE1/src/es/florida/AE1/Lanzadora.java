package es.florida.AE1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Clase que contiene la interfaz de usuario.
 * 
 * @author sergi
 */
public class Lanzadora extends JFrame {

	private JPanel spnJamon;
	private JLabel lblCroquetas = new JLabel("CROQUETAS");
	private JLabel lblmnimoPor;
	private JLabel lbljamon;
	private JLabel lblPollo;
	private JLabel lblBacalao;
	private JLabel lblQueso;
	private JButton btnPedido;
	private JSpinner spJamon;
	private JSpinner spPollo;
	private JSpinner spBacalao;
	private JSpinner spQueso;

	/**
	 * Método principal. Ejecuta la interfaz para que se visible por el usuario.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadora frame = new Lanzadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * En el bntPedido se recoge los valores obtenidos en la interfaz y se
	 * inicializa la llamada ProcessBuilder a la clase Procesadora.
	 * 
	 * Create the frame.
	 */
	public Lanzadora() {
		setTitle("PSP AE1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		spnJamon = new JPanel();
		spnJamon.setBackground(new Color(255, 222, 173));
		spnJamon.setForeground(new Color(0, 0, 0));
		spnJamon.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(spnJamon);
		spnJamon.setLayout(null);
		lblCroquetas.setBounds(153, 11, 113, 36);
		lblCroquetas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnJamon.add(lblCroquetas);

		JLabel lblInfo = new JLabel("Selección de croquetas ");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInfo.setBounds(132, 48, 159, 24);
		spnJamon.add(lblInfo);

		lblmnimoPor = new JLabel("(Mínimo 6 por caja del mismo tipo elegido)");
		lblmnimoPor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblmnimoPor.setBounds(76, 71, 287, 24);
		spnJamon.add(lblmnimoPor);

		lbljamon = new JLabel("JAMON");
		lbljamon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbljamon.setBounds(56, 124, 49, 14);
		spnJamon.add(lbljamon);

		lblPollo = new JLabel("POLLO");
		lblPollo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPollo.setBounds(141, 124, 49, 14);
		spnJamon.add(lblPollo);

		lblBacalao = new JLabel("BACALAO");
		lblBacalao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBacalao.setBounds(215, 124, 65, 14);
		spnJamon.add(lblBacalao);

		lblQueso = new JLabel("QUESO");
		lblQueso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQueso.setBounds(321, 126, 49, 14);
		spnJamon.add(lblQueso);

		spJamon = new JSpinner();
		spJamon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spJamon.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(6)));
		spJamon.setBounds(56, 149, 49, 42);
		spnJamon.add(spJamon);
		spJamon.setEditor(new JSpinner.DefaultEditor(spJamon));

		spPollo = new JSpinner();
		spPollo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spPollo.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(6)));
		spPollo.setBounds(141, 149, 49, 42);
		spnJamon.add(spPollo);
		spPollo.setEditor(new JSpinner.DefaultEditor(spPollo));

		spBacalao = new JSpinner();
		spBacalao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spBacalao.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(6)));
		spBacalao.setBounds(225, 149, 49, 42);
		spnJamon.add(spBacalao);
		spBacalao.setEditor(new JSpinner.DefaultEditor(spBacalao));

		spQueso = new JSpinner();
		spQueso.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spQueso.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(6)));
		spQueso.setBounds(321, 149, 49, 42);
		spnJamon.add(spQueso);
		spQueso.setEditor(new JSpinner.DefaultEditor(spQueso));

		btnPedido = new JButton("INICIAR PEDIDO");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String clase = "es.florida.AE1.Procesadora";
				String javaHome = System.getProperty("java.home");
				String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
				String classpath = System.getProperty("java.class.path");
				String className = clase;
				ArrayList<String> command = new ArrayList<>();
				command.add(javaBin);
				command.add("-cp");
				command.add(classpath);
				command.add(className);
				command.add(String.valueOf(spJamon.getValue()));
				command.add(String.valueOf(spPollo.getValue()));
				command.add(String.valueOf(spBacalao.getValue()));
				command.add(String.valueOf(spQueso.getValue()));

				ProcessBuilder builder = new ProcessBuilder(command);
				try {
					builder.inheritIO().start();

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPedido.setBounds(123, 210, 168, 42);
		spnJamon.add(btnPedido);

	}
}
