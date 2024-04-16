package jpa20240411;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import jpa20240411.controladores.ControladorEstudianteJPA;
import jpa20240411.controladores.ControladorMateriaJPA;
import jpa20240411.controladores.ControladorProfesorJPA;
import jpa20240411.controladores.ControladorValoracionMateriaJPA;
import jpa20240411.controladores.SuperControladorJPA;
import jpa20240411.model.Estudiante;
import jpa20240411.model.Materia;
import jpa20240411.model.Profesor;
import jpa20240411.model.ValoracionMateria;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList jListSeleccionados;
	private DefaultListModel<Estudiante> listModelNoSeleccionados = null;
	private JList jListNoSeleccionados;
	private DefaultListModel<Estudiante> listModelSeleccionados = null;
	@SuppressWarnings("unchecked")
	private List<Estudiante> estudiantes = (List<Estudiante>) ControladorEstudianteJPA.getInstance().findAll();
	@SuppressWarnings("unchecked")
	private List<Profesor> profesores = (List<Profesor>) ControladorProfesorJPA.getInstance().findAll();
	@SuppressWarnings("unchecked")
	private List<Materia> materias = (List<Materia>) ControladorMateriaJPA.getInstance().findAll();
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Integer> jcbNota;
	private int indiceProximalistaEstudiantesSeleccionados = 0;
	private int indiceProximalistaEstudiantesNoSeleccionados = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(100, 100, 479, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Materia");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.gridwidth = 10;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.gridwidth = 10;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_2 = new JLabel("Nota:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNota = new JComboBox<Integer>();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.gridwidth = 10;
		gbc_jcbNota.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		JButton btnNewButton = new JButton("Boton actualizar alumnado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEstudiantes();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 10;
		gbc_btnNewButton.gridy = 3;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_1 = new JButton("Guardar notas alumnos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualiza();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 10;
		gbc_btnNewButton_1.gridy = 0;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{169, 87, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Alumno no seleccionado:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Alumno seleccionado:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jListNoSeleccionados = new JList(getDefaultListModelNoSeleccionados());
		this.jListNoSeleccionados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		GridBagConstraints gbc_jListNoSeleccionados = new GridBagConstraints();
		gbc_jListNoSeleccionados.insets = new Insets(0, 0, 0, 5);
		gbc_jListNoSeleccionados.fill = GridBagConstraints.BOTH;
		gbc_jListNoSeleccionados.gridx = 0;
		gbc_jListNoSeleccionados.gridy = 1;
		panel_2.add(jListNoSeleccionados, gbc_jListNoSeleccionados);
		
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnNewButton_2 = new JButton("<<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasaTodosANoSeleccionados();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridwidth = 2;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 0;
		panel_3.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasaANoSeleccionados();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridwidth = 2;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 1;
		panel_3.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton(">");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasaASeleccionados();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridwidth = 2;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 2;
		panel_3.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton(">>");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasaTodosASeleccionados();
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.gridwidth = 2;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 3;
		panel_3.add(btnNewButton_5, gbc_btnNewButton_5);
		
		jListSeleccionados = new JList(getDefaultListModelSeleccionados());
		this.jListSeleccionados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		GridBagConstraints gbc_jListSeleccionados = new GridBagConstraints();
		gbc_jListSeleccionados.fill = GridBagConstraints.BOTH;
		gbc_jListSeleccionados.gridx = 2;
		gbc_jListSeleccionados.gridy = 1;
		panel_2.add(jListSeleccionados, gbc_jListSeleccionados);
		
		
		cargaMaterias();
		cargaProfesores();
		cargaNotas();
	}
	
	private void cargaMaterias() {
		for(Materia m : materias) {
			this.jcbMateria.addItem(m);
		}
		
	}
	
	private void cargaProfesores() {
		for(Profesor p : profesores) {
			this.jcbProfesor.addItem(p);
		}
 	}
	
	private void cargaNotas() {
		for(int i = 1; i <= 10; i ++) {
			this.jcbNota.addItem(i);
		}
	}
	
	private void cargarEstudiantes() {
		
		this.indiceProximalistaEstudiantesSeleccionados = 0;
		this.indiceProximalistaEstudiantesNoSeleccionados = 0;
		listModelSeleccionados.removeAllElements();
		listModelNoSeleccionados.removeAllElements();
		for (Estudiante e : this.estudiantes) {
			ValoracionMateria v = ControladorValoracionMateriaJPA.getInstance().findByEstudianteAndProfesorAndMateria(
					(Profesor) this.jcbProfesor.getSelectedItem(),(Materia) this.jcbMateria.getSelectedItem(),e);
			if(v == null) {
				listModelNoSeleccionados.add(indiceProximalistaEstudiantesNoSeleccionados, e);
				indiceProximalistaEstudiantesNoSeleccionados++;
			}
			else {
				if(v.getValoracion() == Float.parseFloat(jcbNota.getSelectedItem().toString())) {
					this.listModelSeleccionados.add(indiceProximalistaEstudiantesSeleccionados, e);
					indiceProximalistaEstudiantesSeleccionados++;
				}
				else {
					listModelNoSeleccionados.add(indiceProximalistaEstudiantesNoSeleccionados, e);
					indiceProximalistaEstudiantesNoSeleccionados++;
				}
			}
			
			
			
		}
		
		
	}
	
	@SuppressWarnings("rawtypes")
	private DefaultListModel getDefaultListModelSeleccionados () {
		this.listModelSeleccionados = new DefaultListModel<Estudiante>();
		return this.listModelSeleccionados;
	}
	
	@SuppressWarnings("rawtypes")
	private DefaultListModel getDefaultListModelNoSeleccionados () {
		this.listModelNoSeleccionados = new DefaultListModel<Estudiante>();
		return this.listModelNoSeleccionados;
	}
	
	private void pasaASeleccionados() {
	    int[] indicesSeleccionados = this.jListNoSeleccionados.getSelectedIndices();
	    for (int i = indicesSeleccionados.length - 1; i >= 0; i--) {
	        Estudiante estudiante = (Estudiante) this.listModelNoSeleccionados.getElementAt(indicesSeleccionados[i]);
	        this.listModelNoSeleccionados.removeElementAt(indicesSeleccionados[i]);
	        this.listModelSeleccionados.addElement(estudiante);
	    }
	}

	
	private void pasaANoSeleccionados() {
	    int[] indicesSeleccionados = this.jListSeleccionados.getSelectedIndices();
	    for (int i = indicesSeleccionados.length - 1; i >= 0; i--) {
	        Estudiante estudiante = (Estudiante) this.listModelSeleccionados.getElementAt(indicesSeleccionados[i]);
	        this.listModelSeleccionados.removeElementAt(indicesSeleccionados[i]);
	        this.listModelNoSeleccionados.addElement(estudiante);
	    }
	}

	
	private void pasaTodosASeleccionados() {
		for(int i = this.listModelNoSeleccionados.getSize()-1; i>= 0; i--) {
			Estudiante e = this.listModelNoSeleccionados.getElementAt(i);
			this.listModelSeleccionados.addElement(e);
			this.listModelNoSeleccionados.removeElementAt(i);
		}
		
	}
	
	private void pasaTodosANoSeleccionados() {
		for(int i = this.listModelSeleccionados.getSize()-1; i>= 0; i--) {
			Estudiante e = this.listModelSeleccionados.getElementAt(i);
			this.listModelNoSeleccionados.addElement(e);
			this.listModelSeleccionados.removeElementAt(i);
		}
	}
	
	private void actualiza() {
	    for(int i = 0; i <= this.listModelSeleccionados.getSize() - 1; i++) {
	        Estudiante estudiante = this.listModelSeleccionados.getElementAt(i);
	        Profesor profesor = (Profesor) this.jcbProfesor.getSelectedItem();
	        Materia materia = (Materia) this.jcbMateria.getSelectedItem();
	        ValoracionMateria valoracionExistente = ControladorValoracionMateriaJPA.getInstance()
	                .findByEstudianteAndProfesorAndMateria(profesor, materia, estudiante);

	        ValoracionMateria nuevaValoracion = new ValoracionMateria();
	        nuevaValoracion.setIdEstudiante(estudiante.getId());
	        nuevaValoracion.setIdMateria(materia.getId());
	        nuevaValoracion.setIdProfesor(profesor.getId());
	        nuevaValoracion.setValoracion((Integer) this.jcbNota.getSelectedItem());

	        if (valoracionExistente != null) {
	            valoracionExistente.setValoracion(nuevaValoracion.getValoracion());
	            ControladorValoracionMateriaJPA.getInstance().update(valoracionExistente);
	        } else {
	            ControladorValoracionMateriaJPA.getInstance().insert(nuevaValoracion);
	        }
	    }
	}

	
	
	

}
