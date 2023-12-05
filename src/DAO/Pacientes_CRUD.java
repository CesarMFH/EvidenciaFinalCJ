package DAO;
import Entidades.Doctores;
import Entidades.Pacientes;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
public class Pacientes_CRUD {
    public static void escribirArchivoPaciente(ArrayList<Pacientes> lista) {
        try {
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\listaPaciente.txt");
            ObjectOutputStream miStream =
                    new ObjectOutputStream(escribir);
            miStream.writeObject(lista);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            System.out.println(e);
        }
    }

    public static ArrayList<Pacientes> leerArchivoPaciente() {
        ArrayList<Pacientes> otraLista = new ArrayList<>();
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaPaciente.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<Pacientes>) o;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error de E/S o lectura");
            System.out.println(e);
        }
        return otraLista;
    }

    public static void insertarPaciente(Pacientes nuevoPaciente) {
        ArrayList<Pacientes> lista = leerArchivoPaciente();
        lista.add(nuevoPaciente);
        escribirArchivoPaciente(lista);
    }

    public static Pacientes buscarPacientePorID(String ID) {
        ArrayList<Pacientes> lista = leerArchivoPaciente();
        for (Pacientes paciente : lista) {
            if (paciente.getID_p().equals(ID)) {
                System.out.println("Paciente encontrado: " + paciente);
                return paciente;
            }
        }
        System.out.println("Paciente no encontrado para el ID: " + ID);
        return null;
    }

    public static void eliminarPaciente (Pacientes paciente){
        ArrayList<Pacientes> lista = leerArchivoPaciente();
        lista.removeIf(d -> d.getID_p().equals(paciente.getID_p()));
        escribirArchivoPaciente(lista);
    }

    public static void asignarIDPacienteCB(JComboBox<String> cmbIDPacienteC) {
        ArrayList<Pacientes> lista = leerArchivoPaciente();
        for (Pacientes a: lista) {
            cmbIDPacienteC.addItem(a.getID_p());
        }
    }
}
