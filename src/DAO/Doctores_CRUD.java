package DAO;

import Entidades.Doctores;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;


public class Doctores_CRUD {

    public static void escribirArchivo(ArrayList<Doctores> lista) {
        try {
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\listaDoctor.txt");
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
    public static Doctores buscarDoctorPorID(String ID) {
        ArrayList<Doctores> lista = leerArchivo();
        for (Doctores doctor : lista) {
            if (doctor.getID().equals(ID)) {
                System.out.println("Doctor encontrado y dado de alta: " + doctor);
                return doctor;
            }
        }
        System.out.println("Doctor no encontrado con este ID: " + ID);
        return null;
    }
    public static ArrayList<Doctores> leerArchivo() {
        ArrayList<Doctores> otraLista = new ArrayList<>();
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaDoctor.txt");
            ObjectInputStream miStream2 =
                    new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<Doctores>) o;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error de E/S o lectura");
            System.out.println(e);
        }
        return otraLista;
    }
    public static void eliminarDoctor(Doctores doctor) {
        ArrayList<Doctores> lista = leerArchivo();
        lista.removeIf(d -> d.getID().equals(doctor.getID()));
        escribirArchivo(lista);
    }
    public void insertarDoctor(Doctores nuevoDoc){
        ArrayList<Doctores> lista = leerArchivo();
        lista.add(nuevoDoc);
        escribirArchivo(lista);

    }
    public static void asignarIDDoctorCB(JComboBox<String> cmbIDDoctorC) {
        ArrayList<Doctores> lista = leerArchivo();
        for (Doctores a : lista) {
            cmbIDDoctorC.addItem(a.getID());
        }
    }
}
