import DAO.Doctores_CRUD;
import Entidades.Doctores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alta_Doc {
    private JTextField txtNombre;
    private JTextField txtApePat;
    private JTextField txtApeMat;
    private JComboBox comboBox1;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JButton btnBuscar;
    private JButton btnRegistrar;
    private JButton btnLimpiar;
    private JButton btnEliminar;
    private JTextField txtEspecialidad;
    private JTextField txtID;
    private JPanel miPanel;

    public Alta_Doc() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar paciente
                Doctores_CRUD crud = new Doctores_CRUD();
                String numID = txtID.getText();
                Doctores a = crud.buscarDoctorPorID(numID);
                if(a == null){
                    //JOptionPane.showMessageDialog(miPanel,"No se encuentra el paciente con el identificador: " + numID,"Pacientes",JOptionPane.ERROR_MESSAGE);
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra el Doctor con el identificador: " + numID + "\n¿Desea dar de alta?" ,"Doctor",JOptionPane.YES_NO_OPTION);
                    if(respuesta == 0){
                        //sí quiere dar de alta el paciente inexistente
                        btnRegistrar.setEnabled(true);
                        txtNombre.requestFocus();

                    }else if(respuesta == 1){
                        //no quiere dar de alta
                        //limpiar formulario
                        //invocar método para limpiar


                    }
                }
                else{
                    txtNombre.setText(a.getNombres());
                    txtApePat.setText(a.getApePat());
                    txtApeMat.setText(a.getApeMat());
                }


            }
    });
    btnRegistrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    btnLimpiar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    btnEliminar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}
