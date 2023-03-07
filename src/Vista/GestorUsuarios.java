package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.bean.Usuario;
import modelo.dao.AccesoBBDD;

public class GestorUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField IdInsertar;
	private JTextField NombreApellido_Insertar;
	private JTextField DniInsertar;
	private JTextField CodigoInsertar;

	public GestorUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);

		JLabel Id = new JLabel("ID");
		Id.setBounds(10, 47, 65, 20);
		panel.add(Id);

		JLabel lblNewLabel_1 = new JLabel("INSERTAR USUARIOS");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 429, 14);
		panel.add(lblNewLabel_1);

		IdInsertar = new JTextField();
		IdInsertar.setBounds(105, 47, 200, 20);
		panel.add(IdInsertar);
		IdInsertar.setColumns(10);

		NombreApellido_Insertar = new JTextField();
		NombreApellido_Insertar.setColumns(10);
		NombreApellido_Insertar.setBounds(105, 78, 200, 20);
		panel.add(NombreApellido_Insertar);

		DniInsertar = new JTextField();
		DniInsertar.setColumns(10);
		DniInsertar.setBounds(105, 112, 200, 20);
		panel.add(DniInsertar);

		CodigoInsertar = new JTextField();
		CodigoInsertar.setColumns(10);
		CodigoInsertar.setBounds(105, 145, 200, 20);
		panel.add(CodigoInsertar);

		JLabel NombreApellido = new JLabel("Nombre_Apellido");
		NombreApellido.setBounds(10, 78, 85, 14);
		panel.add(NombreApellido);

		JLabel Dni = new JLabel("Dni\r\n");
		Dni.setBounds(10, 115, 46, 14);
		panel.add(Dni);

		JLabel lblNewLabel_2_2 = new JLabel("Codigo");
		lblNewLabel_2_2.setBounds(10, 148, 46, 14);
		panel.add(lblNewLabel_2_2);

		JButton Insertar = new JButton("Insertar");
		Insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario usuario = new Usuario();

				usuario.setId(Integer.parseInt(IdInsertar.getText()));
				usuario.setNombre_apellido(NombreApellido_Insertar.getText());
				usuario.setDni(DniInsertar.getText());
				usuario.setCodigo(CodigoInsertar.getText());

				AccesoBBDD.registrarUsuarios(usuario);
				
				IdInsertar.setText("");
				NombreApellido_Insertar.setText("");
				DniInsertar.setText("");
				CodigoInsertar.setText("");

			}
		});
		Insertar.setBounds(162, 176, 89, 23);
		panel.add(Insertar);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
	}
}
