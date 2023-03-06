package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private JPanel contentPane;

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
		
		JButton GestorInsertar = new JButton("Gestor Insertar");
		GestorInsertar.setBounds(187, 98, 151, 23);
		GestorInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(GestorInsertar);
		
		JButton GestorModificar = new JButton("Gestor Modificar");
		GestorModificar.setBounds(187, 190, 151, 23);
		GestorModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(GestorModificar);
		
		JButton GestorEliminar = new JButton("Gestor eliminar");
		GestorEliminar.setBounds(187, 142, 151, 23);
		GestorEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(GestorEliminar);
		
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
