package Ventanas_GUI;

import DAO.Pacientes_CRUD;
import Entidades.Pacientes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alta_Pac extends JFrame{
    private JTextField txtNombre;
    private JTextField txtID;
    private JTextField txtApePat;
    private JTextField txtApeMat;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtAlergias;
    private JComboBox cbDia;
    private JComboBox cbMes;
    private JComboBox cbAnio;
    private JComboBox cbGenero;
    private JButton btnBuscarD;
    private JButton btnRegistrar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JPanel miPanel;
    private void seleccionarMesEnComboBox(String mes) {
        cbMes.setSelectedItem(mes);
    }
    private void seleccionarDiaEnComboBox(String dia) {
        cbDia.setSelectedItem(dia);
    }
    private void seleccionarAnioEnComboBox(String anio) {
        cbAnio.setSelectedItem(anio);
    }
    private void seleccionarGenero(String Sexo) {cbGenero.setSelectedItem(Sexo);

    }
    public Alta_Pac() {
        btnBuscarD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar paciente
                Pacientes_CRUD crud = new Pacientes_CRUD();
                String numID = txtID.getText();
                Pacientes a = crud.buscarPacientePorID(numID);
                if(a == null){
                    //JOptionPane.showMessageDialog(miPanel,"No se encuentra el paciente con el identificador: " + numID,"Pacientes",JOptionPane.ERROR_MESSAGE);
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra el Paciente con el ID: " +
                                    numID + "\n¿Desea dar de alta?" ,
                            "Doctor",JOptionPane.YES_NO_OPTION);
                    if(respuesta == 0){
                        //sí quiere dar de alta el Doctor inexistente

                        btnEliminar.setEnabled(false);
                        btnEditar.setEnabled(false);
                        btnRegistrar.setEnabled(true);
                        txtNombre.requestFocus();

                    }else if(respuesta == 1){
                        //limpiar formulario
                        //invocar método para limpiar
                        limpiarFormularioPaciente();
                        btnEliminar.setEnabled(false);
                        btnEditar.setEnabled(false);
                        btnRegistrar.setEnabled(true);
                        txtNombre.requestFocus();

                    }
                }
                else{

                    txtNombre.setText(a.getNombre_p());
                    txtApePat.setText(a.getApePat_p());
                    txtApeMat.setText(a.getApeMat_p());
                    txtAlergias.setText(a.getAlergias());
                    txtEmail.setText(a.getCorreo_p());
                    txtTelefono.setText(a.getTelefono_p());
                    txtID.setText(a.getID_p());

                    String Sexo = a.getSexo_p();
                    seleccionarGenero(Sexo);
                    String Mes = a.getMes();
                    seleccionarMesEnComboBox(Mes);
                    String Dia = a.getDia();
                    seleccionarDiaEnComboBox(Dia);
                    String AnioFNP = a.getAnio();
                    seleccionarAnioEnComboBox(AnioFNP);


                    btnEliminar.setEnabled(true);
                    btnEditar.setEnabled(true);
                    btnRegistrar.setEnabled(false);
                }


            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validarCampos()) {
                    return; // Detener el proceso si la validación falla
                }
                Pacientes a = new Pacientes();
                a.setID_p(txtID.getText());
                a.setNombre_p(txtNombre.getText());
                a.setApePat_p(txtApePat.getText());
                a.setApeMat_p(txtApeMat.getText());
                a.setAlergias(txtAlergias.getText());
                a.setTelefono_p(txtTelefono.getText());
                a.setCorreo_p(txtEmail.getText());
                String Sexo = (String) cbGenero.getSelectedItem();
                a.setSexo_p(Sexo);
                String Mes = (String) cbMes.getSelectedItem();
                a.setMes(Mes);
                String Dia = (String) cbDia.getSelectedItem();
                a.setDia(Dia);
                String Anio = (String) cbAnio.getSelectedItem();
                a.setAnio(Anio);
                Pacientes_CRUD crud = new Pacientes_CRUD();
                crud.insertarPaciente(a);
                limpiarFormularioPaciente();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //EliminarDoctor
                String ID = txtID.getText();
                int respuesta= JOptionPane.showConfirmDialog(miPanel,"¿Quieres eliminar al Paciente?","Eliminar Paciente", JOptionPane.YES_NO_OPTION);
                if (respuesta ==0){
                    if (!ID.isEmpty()) {
                        //Crear el doctor a eliminar
                        Pacientes PacienteBorrar= new Pacientes();
                        PacienteBorrar.setID_p(ID);
                        //Eliminar el doctor con el metodo crud
                        Pacientes_CRUD crud = new Pacientes_CRUD();
                        crud.eliminarPaciente(PacienteBorrar);
                        JOptionPane.showMessageDialog(miPanel,"Se elimino el Paciente exitosamente","Paciente Eliminado", JOptionPane.INFORMATION_MESSAGE);
                        limpiarFormularioPaciente();
                    } else if (ID.isEmpty()){
                        Pacientes PacienteBorrar= new Pacientes();
                        PacienteBorrar.setID_p(ID);
                        JOptionPane.showMessageDialog(miPanel, "No especificaste el paciente a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }else if (respuesta==1){
                    JOptionPane.showMessageDialog(miPanel, "No se elimino el Paciente", "Paciente no Eliminado", JOptionPane.ERROR_MESSAGE);
                } else if (respuesta ==-1)
                    JOptionPane.showMessageDialog(miPanel, "No se elimino el Paciente", "Paciente no Eliminado", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormularioPaciente();
            }
        });
    }
    //Metodo de limpiar Formularios
    private void limpiarFormularioPaciente(){
        txtNombre.setText("");
        txtID.setText("");
        txtApePat.setText("");
        txtApeMat.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        cbGenero.setSelectedIndex(0);
        cbDia.setSelectedIndex(0);
        cbMes.setSelectedIndex(0);
        cbAnio.setSelectedIndex(0);
        txtAlergias.setText("");
    }
    public boolean validarCampos() {
        if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty()|| txtApePat.getText().isEmpty() || txtApeMat.getText().isEmpty() || cbGenero.getSelectedIndex()==0||txtTelefono.getText().isEmpty()
                || txtEmail.getText().isEmpty() || txtAlergias.getText().isEmpty() || cbDia.getSelectedIndex()==0 || cbMes.getSelectedIndex()==0 || cbAnio.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(miPanel, "Verifique que todos los datos esten completos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }
    public static void main(String[] args) {
        Alta_Pac v = new Alta_Pac();
        v.setContentPane(v.miPanel);
        v.setSize(1000,300);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }

}
