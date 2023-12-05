package Ventanas_GUI;

import DAO.Doctores_CRUD;
import Entidades.Doctores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alta_Doc extends JFrame{
    private JTextField txtNombre;
    private JTextField txtApePat;
    private JTextField txtApeMat;
    private JComboBox comboBox1;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JButton btnBuscarD;
    private JButton btnRegistrar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JTextField txtEspecialidad;
    private JTextField txtID;
    private JPanel miPanel;
    private void seleccionarGenero(String Sexo) {comboBox1.setSelectedItem(Sexo);
    }
    public Alta_Doc() {
        btnBuscarD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar paciente
                Doctores_CRUD crud = new Doctores_CRUD();
                String numID = txtID.getText();
                Doctores a = crud.buscarDoctorPorID(numID);
                if(a == null){
                    //JOptionPane.showMessageDialog(miPanel,"No se encuentra el paciente con el identificador: " + numID,"Pacientes",JOptionPane.ERROR_MESSAGE);
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra el Doctor con el ID: " +
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
                        limpiarFormularioDoctor();
                        btnEliminar.setEnabled(false);
                        btnEditar.setEnabled(false);
                        btnRegistrar.setEnabled(true);
                        txtNombre.requestFocus();

                    }
                }
                else{

                    txtNombre.setText(a.getNombres());
                    txtApePat.setText(a.getApePat());
                    txtApeMat.setText(a.getApeMat());
                    txtEspecialidad.setText(a.getEspecialidad());
                    txtEmail.setText(a.getEmail());
                    txtTelefono.setText(a.getTelefono());
                    txtID.setText(a.getID());

                    String Sexo = a.getSexo();
                    seleccionarGenero(Sexo);
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
            Doctores a = new Doctores();
            a.setID(txtID.getText());
            a.setNombres(txtNombre.getText());
            a.setApePat(txtApePat.getText());
            a.setApeMat(txtApeMat.getText());
            a.setEspecialidad(txtEspecialidad.getText());
            a.setTelefono(txtTelefono.getText());
            a.setEmail(txtEmail.getText());
            String Sexo = (String) comboBox1.getSelectedItem();
            a.setSexo(Sexo);
            Doctores_CRUD crud = new Doctores_CRUD();
            crud.insertarDoctor(a);
            limpiarFormularioDoctor();
        }
    });
    btnEliminar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //EliminarDoctor
            String ID = txtID.getText();
            int respuesta= JOptionPane.showConfirmDialog(miPanel,"¿Quieres eliminar al doctor?","Eliminar Doctor", JOptionPane.YES_NO_OPTION);
            if (respuesta ==0){
                if (!ID.isEmpty()) {
                    //Crear el doctor a eliminar
                    Doctores doctorBorrar= new Doctores();
                    doctorBorrar.setID(ID);
                    //Eliminar el doctor con el metodo crud
                    Doctores_CRUD crud = new Doctores_CRUD();
                    crud.eliminarDoctor(doctorBorrar);
                    JOptionPane.showMessageDialog(miPanel,"Se elimino el doctor exitosamente","Doctor Eliminado", JOptionPane.INFORMATION_MESSAGE);
                    limpiarFormularioDoctor();
                } else if (ID.isEmpty()){
                    Doctores doctorBorrar= new Doctores();
                    doctorBorrar.setID(ID);
                    JOptionPane.showMessageDialog(miPanel, "No especificaste el doctor a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }else if (respuesta==1){
                JOptionPane.showMessageDialog(miPanel, "No se elimino el Doctor", "Doctor no Eliminado", JOptionPane.ERROR_MESSAGE);
            } else if (respuesta ==-1)
                JOptionPane.showMessageDialog(miPanel, "No se elimino el Doctor", "Doctor no Eliminado", JOptionPane.ERROR_MESSAGE);
        }
    });
    btnEditar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            limpiarFormularioDoctor();
        }
    });
}
    //Metodo de limpiar Formularios
    private void limpiarFormularioDoctor(){
        txtNombre.setText("");
        txtApePat.setText("");
        txtApeMat.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtEspecialidad.setText("");
        txtID.setText("");
        comboBox1.setSelectedIndex(0);

    }
    public boolean validarCampos() {
        if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty()|| txtApePat.getText().isEmpty() || txtApeMat.getText().isEmpty() || comboBox1.getSelectedIndex()==0||txtTelefono.getText().isEmpty()
                || txtEmail.getText().isEmpty() || txtEspecialidad.getText().isEmpty()){
            JOptionPane.showMessageDialog(miPanel, "Verifique que todos los datos esten completos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }
    public static void main(String[] args) {
        Alta_Doc v = new Alta_Doc();
        v.setContentPane(v.miPanel);
        v.setSize(700,300);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
