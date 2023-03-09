package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField ModificarId;
	private JTextField ModificarNombreApellido;
	private JTextField ModificarDni;
	private JTextField ModificarCodigo;
	private JTextField EliminarId;
	private JTextField ModificarNombre;
	private JTextField ModificarDnii;
	private JTextField ModificarCode;

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
		tabbedPane.addTab("Insertar", null, panel, null);
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
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Cierra la pestaña	
				dispose();
			
			}
		});
		btnNewButton.setBounds(354, 199, 65, 23);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Modificar", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("MODIFICAR USUARIOS");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(0, 11, 429, 31);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel Id_1 = new JLabel("ID");
		Id_1.setBounds(10, 60, 65, 20);
		panel_1.add(Id_1);
		
		JLabel NombreApellido_1 = new JLabel("Nombre_Apellido");
		NombreApellido_1.setBounds(10, 96, 85, 14);
		panel_1.add(NombreApellido_1);
		
		JLabel Dni_1 = new JLabel("Dni\r\n");
		Dni_1.setBounds(10, 132, 46, 14);
		panel_1.add(Dni_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Codigo");
		lblNewLabel_2_2_1.setBounds(10, 170, 46, 14);
		panel_1.add(lblNewLabel_2_2_1);
		
		ModificarId = new JTextField();
		ModificarId.setBounds(125, 60, 187, 20);
		panel_1.add(ModificarId);
		ModificarId.setColumns(10);
		
		ModificarNombreApellido = new JTextField();
		ModificarNombreApellido.setColumns(10);
		ModificarNombreApellido.setBounds(125, 93, 187, 20);
		panel_1.add(ModificarNombreApellido);
		
		ModificarDni = new JTextField();
		ModificarDni.setColumns(10);
		ModificarDni.setBounds(125, 129, 187, 20);
		panel_1.add(ModificarDni);
		
		ModificarCodigo = new JTextField();
		ModificarCodigo.setColumns(10);
		ModificarCodigo.setBounds(125, 167, 187, 20);
		panel_1.add(ModificarCodigo);
		
		JButton GuardarModificaciones = new JButton("Modificar");
		GuardarModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				
				
				usuario.setId(Integer.parseInt(ModificarId.getText()));
				usuario.setNombre_apellido(ModificarNombreApellido.getText());
				usuario.setDni(ModificarDni.getText());
				usuario.setCodigo(ModificarCodigo.getText());
				
				int idAInt = Integer.parseInt(ModificarId.getText());
				
				try {
					AccesoBBDD.modificarClienteJframe(idAInt, usuario);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Error al modificar ");
				
					e1.printStackTrace();
				}
				
				
				ModificarId.setText(null);
				ModificarNombreApellido.setText(null);
				ModificarDni.setText(null);
				ModificarCodigo.setText(null);
				
				JOptionPane.showMessageDialog(null, "Usuario modificado ");
			}
		});
		GuardarModificaciones.setBounds(180, 201, 89, 23);
		panel_1.add(GuardarModificaciones);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(354, 201, 65, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cargar datos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(322, 59, 97, 23);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Eliminar", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ELIMINAR USUARIO");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(0, 11, 429, 31);
		panel_2.add(lblNewLabel_1_1_1);
		
		EliminarId = new JTextField();
		EliminarId.setColumns(10);
		EliminarId.setBounds(119, 53, 187, 20);
		panel_2.add(EliminarId);
		
		JLabel Id_1_1 = new JLabel("ID");
		Id_1_1.setBounds(10, 53, 65, 20);
		panel_2.add(Id_1_1);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(354, 199, 65, 23);
		panel_2.add(btnNewButton_3);
		
		JButton EliminarId1 = new JButton("Eliminar");
		EliminarId1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ELIMINAR
				
				Usuario usuario = new Usuario();
				
				usuario.setId(Integer.parseInt(EliminarId.getText()));
				usuario.setNombre_apellido(ModificarNombre.getText());
				usuario.setDni(ModificarDnii.getText());
				usuario.setCodigo(ModificarCode.getText());
				
				//Arreglar esta parte
				AccesoBBDD eliminar = new AccesoBBDD();
				int id = Integer.parseInt(ModificarId.getText());
				try {
					eliminar.bajaUsuario(id);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				EliminarId.setText(null);
				ModificarNombre.setText(null);
				ModificarDnii.setText(null);
				ModificarCode.setText(null);
				
				JOptionPane.showInputDialog(null, "Usuario Eliminado");
			
				
			}
		});
		EliminarId1.setBounds(170, 199, 89, 23);
		panel_2.add(EliminarId1);
		
		ModificarNombre = new JTextField();
		ModificarNombre.setColumns(10);
		ModificarNombre.setBounds(119, 95, 187, 20);
		panel_2.add(ModificarNombre);
		
		ModificarDnii = new JTextField();
		ModificarDnii.setColumns(10);
		ModificarDnii.setBounds(119, 130, 187, 20);
		panel_2.add(ModificarDnii);
		
		ModificarCode = new JTextField();
		ModificarCode.setColumns(10);
		ModificarCode.setBounds(119, 168, 187, 20);
		panel_2.add(ModificarCode);
		
		JLabel NombreApellido_1_1 = new JLabel("Nombre_Apellido");
		NombreApellido_1_1.setBounds(10, 98, 85, 14);
		panel_2.add(NombreApellido_1_1);
		
		JLabel Dni_1_1 = new JLabel("Dni\r\n");
		Dni_1_1.setBounds(10, 133, 46, 14);
		panel_2.add(Dni_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Codigo");
		lblNewLabel_2_2_1_1.setBounds(10, 171, 46, 14);
		panel_2.add(lblNewLabel_2_2_1_1);
	}
}

