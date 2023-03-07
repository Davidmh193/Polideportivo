package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	public JButton getGestorInsertar() {
		return GestorUsuarios;
	}

	public void setGestorInsertar(JButton gestorInsertar) {
		GestorUsuarios = gestorInsertar;
	}

	public JButton getGestorEliminar() {
		return GestorActividades;
	}

	public void setGestorEliminar(JButton gestorEliminar) {
		GestorActividades = gestorEliminar;
	}

	private JPanel contentPane;
	private JButton GestorUsuarios;
	private JButton GestorActividades;
	private JButton GestorModificar;

	public JButton getGestorModificar() {
		return GestorModificar;
	}

	public void setGestorModificar(JButton gestorModificar) {
		GestorModificar = gestorModificar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Gray", "INSERT YOUR LICENSE KEY HERE", "my company");
                    
                    // select the Look and Feel
                    UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		GestorUsuarios = new JButton("Gestor Usuarios");
		GestorUsuarios.setBounds(187, 98, 151, 23);
		GestorUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LLeva a usuarios_JDialog
				GestorUsuarios frame = new GestorUsuarios();
				frame.setVisible(true);
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(GestorUsuarios);
		
		 GestorModificar = new JButton("Gestor Inscripciones");
		GestorModificar.setBounds(187, 190, 151, 23);
		GestorModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		contentPane.add(GestorModificar);
		
		GestorActividades = new JButton("Gestor Actividades");
		GestorActividades.setBounds(187, 142, 151, 23);
		GestorActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(GestorActividades);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 94, 261);
		panel.setBackground(Color.BLUE);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setToolTipText("\r\n");
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(94, 31, 340, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel MENU = new JLabel("MENU");
		MENU.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		MENU.setHorizontalAlignment(SwingConstants.CENTER);
		MENU.setBounds(0, 0, 340, 49);
		panel_1.add(MENU);
	}
}
