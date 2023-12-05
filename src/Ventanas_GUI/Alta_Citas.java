package Ventanas_GUI;

import DAO.Citas_CRUD;
import DAO.Doctores_CRUD;
import DAO.Pacientes_CRUD;
import Entidades.Citas;
import Entidades.Doctores;
import Entidades.Pacientes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alta_Citas extends JFrame{
    private JTextField txtID_Cita;
    private JTextField txtEspecialidad;
    private JTextField txtID_Doc;
    private JTextArea txtObs;
    private JComboBox cbDia;
    private JComboBox cbMes;
    private JComboBox cbAnio;
    private JButton btnBuscarD;
    private JButton btnRegistrar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JTextField txtID_Paciente;
    private JPanel miPanel;
    private JTextField txtNom_doc;
    private JTextField txtNom_pac;
    private JComboBox cbDoctorID;
    private JComboBox cbPacienteID;
    private JTextField txtFechaC;
    private void seleccionarIDDoctor(String IDD) { cbDoctorID.setSelectedItem(IDD);}
    private void seleccionarIDPaciente (String IDP) { cbDoctorID.setSelectedItem(IDP);
    }
    private void seleccionarDiaCita(String DiaC) { cbDia.setSelectedItem(DiaC);}
    private void seleccionarMesCita (String MesC) { cbMes.setSelectedItem(MesC);
    }
    private void seleccionarAnioCita (String AnioC) { cbAnio.setSelectedItem(AnioC);
    }

    public Alta_Citas() {
        Doctores_CRUD crud= new Doctores_CRUD();
        crud.asignarIDDoctorCB(cbDoctorID);
        Pacientes_CRUD crud1 = new Pacientes_CRUD();
        crud1.asignarIDPacienteCB(cbPacienteID);
        cbPacienteID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPacienteS = (String) cbPacienteID.getSelectedItem();
                Pacientes pacienteSeleccionado = Pacientes_CRUD.buscarPacientePorID(idPacienteS);
                if (pacienteSeleccionado != null) {
                    txtNom_pac.setText(pacienteSeleccionado.getNombre_p() + " "+ pacienteSeleccionado.getApePat_p() +" " + pacienteSeleccionado.getApeMat_p());
                } else {
                    txtNom_pac.setText("");
                }
            }
        });

        cbDoctorID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idDoctorS = (String) cbDoctorID.getSelectedItem();
                Doctores doctorSeleccionado = Doctores_CRUD.buscarDoctorPorID(idDoctorS);
                if (doctorSeleccionado != null) {
                    txtNom_doc.setText(doctorSeleccionado.getNombres() + " "+ doctorSeleccionado.getApePat() + " " + doctorSeleccionado.getApeMat());
                } else {
                    txtNom_doc.setText("");
                }
            }
        });
    btnBuscarD.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //buscar paciente
            Citas_CRUD crud = new Citas_CRUD();
            String numID = txtID_Cita.getText();
            Citas a = crud.buscarCita(numID);
            if(a == null){
                //JOptionPane.showMessageDialog(miPanel,"No se encuentra el paciente con el identificador: " + numID,"Pacientes",JOptionPane.ERROR_MESSAGE);
                int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra la Cita con el ID: " +
                                numID + "\n¿Desea Registar la Cita?" ,
                        "Cita",JOptionPane.YES_NO_OPTION);
                if(respuesta == 0){
                    //sí quiere dar de alta el Doctor inexistente

                    btnEliminar.setEnabled(false);
                    btnEditar.setEnabled(false);
                    btnRegistrar.setEnabled(true);
                    txtID_Cita.requestFocus();

                }else if(respuesta == 1){
                    //limpiar formulario
                    //invocar método para limpiar
                    limpiarFormularioCitas();
                    btnEliminar.setEnabled(false);
                    btnEditar.setEnabled(false);
                    btnRegistrar.setEnabled(true);
                    txtID_Cita.requestFocus();

                }
            }
            else{

                txtID_Cita.setText(a.getID());
                txtObs.setText(a.getDatos());
                btnEliminar.setEnabled(true);
                btnEditar.setEnabled(true);
                btnRegistrar.setEnabled(false);


            }


        }
    });
    btnRegistrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fecha = cbDia.getSelectedItem().toString() + "/" + cbMes.getSelectedItem().toString() + "/" + cbAnio.getSelectedItem().toString();
            boolean resultado = validarFecha(fecha);
            if(resultado){
                JOptionPane.showMessageDialog(miPanel,"La fecha esta bien");
                if (validarCamposCita()){
                    Citas c = new Citas();
                    c.setID(txtID_Cita.getText());
                    String idDoctor= (String) cbDoctorID.getSelectedItem();
                    c.setIDDoctor(idDoctor);
                    String idPaciente= (String) cbPacienteID.getSelectedItem();
                    c.setIDPaciente(idPaciente);
                    c.setNombreDoctor(txtNom_doc.getText());
                    c.setEspecialidad(txtEspecialidad.getText());
                    c.setNombrePaciente(txtNom_pac.getText());
                    c.setDatos(txtObs.getText());
                    c.setFecha(fecha);
                    String diaC= (String) cbDia.getSelectedItem();
                    c.setDia(diaC);
                    String mesC= (String) cbMes.getSelectedItem();
                    c.setMes(mesC);
                    String anioC= (String) cbAnio.getSelectedItem();
                    c.setAnio(anioC);
                    limpiarFormularioCitas();
                } else{
                    JOptionPane.showMessageDialog(miPanel, "Error en los campos de la cita");
                }
            }else {
                JOptionPane.showMessageDialog(miPanel, "Error en la fecha");
                txtFechaC.requestFocus();
            }
        }
    });
    btnEditar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {limpiarFormularioCitas();}
    });
    btnEliminar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //EliminarDoctor
            String ID = txtID_Cita.getText();
            int respuesta= JOptionPane.showConfirmDialog(miPanel,"¿Quieres eliminar esta Cita?","Eliminar Cita", JOptionPane.YES_NO_OPTION);
            if (respuesta ==0){
                if (!ID.isEmpty()) {
                    //Crear el doctor a eliminar
                    Citas citasborrar= new Citas();
                    citasborrar.setID(ID);
                    //Eliminar el doctor con el metodo crud
                    Citas_CRUD crud = new Citas_CRUD();
                    crud.eliminarCita(citasborrar);
                    JOptionPane.showMessageDialog(miPanel,"Se elimino la Cita","Cita Eliminada", JOptionPane.INFORMATION_MESSAGE);
                    limpiarFormularioCitas();
                } else if (ID.isEmpty()){
                    Citas doctorBorrar= new Citas();
                    doctorBorrar.setID(ID);
                    JOptionPane.showMessageDialog(miPanel, "No especificaste la Cita", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }else if (respuesta==1){
                JOptionPane.showMessageDialog(miPanel, "No se elimino la cita", "Cita no Eliminado", JOptionPane.ERROR_MESSAGE);
            } else if (respuesta ==-1)
                JOptionPane.showMessageDialog(miPanel, "No se elimino la cita", "Cita no Eliminado", JOptionPane.ERROR_MESSAGE);
        }
    });
}
    private void limpiarFormularioCitas(){
        txtID_Cita.setText("");
        txtID_Paciente.setText("");
        txtID_Doc.setText("");
        txtObs.setText("");
        txtEspecialidad.setText("");
        txtNom_doc.setText("");
        txtNom_pac.setText("");
        cbDia.setSelectedIndex(0);
        cbMes.setSelectedIndex(0);
        cbAnio.setSelectedIndex(0);

    }
    public boolean validarCamposCita() {
        if (txtID_Cita.getText().isEmpty()||cbDoctorID.getSelectedIndex()==0 || cbPacienteID.getSelectedIndex()==0 || txtNom_doc.getText().isEmpty() || txtNom_pac.getText().isEmpty()
                || txtObs.getText().isEmpty() ||cbDia.getSelectedIndex()==0||cbMes.getSelectedIndex()==0||cbAnio.getSelectedIndex()==0 ) {
            JOptionPane.showMessageDialog(miPanel, "Hay una casilla vacia o con un valor invalido, verifique de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }
    public boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha =
                    new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            Date miFecha = formatoFecha.parse(fecha);
            System.out.println(miFecha);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Alta_Citas v = new Alta_Citas();
        v.setContentPane(v.miPanel);
        v.setSize(1000,300);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
