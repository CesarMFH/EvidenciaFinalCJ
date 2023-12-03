package DAO;

import Entidades.Doctores;
import java.util.ArrayList;
import java.io.*;

public class Doctores_CRUD {
    public Doctores buscarDoctorPorID(String ID){
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaDoctores.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Doctores> otraLista = (ArrayList<Doctores>)o;
            for(Doctores a: otraLista){
                if(ID.equals(a.getID())){
                    return a;
                }
            }
            //saliendo del for
            miStream2.close();
            return null;
            // Paciente pruebaPaciente = otraLista.get(0);
            // System.out.println(pruebaPaciente.getNombre());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertarDoctor(Doctores a){
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaDoctores.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Doctores> otraLista = (ArrayList<Doctores>)o;
            otraLista.add(a);

            //escribir de vuelta al archivo
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\listaDoctores.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(otraLista);
            miStream.close();
            miStream2.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
