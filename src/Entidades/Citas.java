package Entidades;

import java.io.Serializable;

public class Citas implements Serializable {
    String IDDoctor;

    String Especialidad;
    String dia;
    String mes;
    String anio;
    String IDPaciente;
    String nombreDoctor;
    String nombrePaciente;
    String ID;
    String Fecha;
    String Hora;
    String Datos;
    String Receta;
    public String getDia() {return dia;}
    public void setDia(String dia) {this.dia = dia;}

    public String getMes() {return mes;}

    public void setMes(String mes) {this.mes = mes;}

    public String getAnio() {return anio;}

    public void setAnio(String anio) {this.anio = anio;}


    public String getNombreDoctor() {return nombreDoctor;}

    public void setNombreDoctor(String nombreDoctor) {this.nombreDoctor = nombreDoctor;}

    public String getNombrePaciente() {return nombrePaciente;}

    public void setNombrePaciente(String nombrePaciente) {this.nombrePaciente = nombrePaciente;}


    public String getIDDoctor() {return IDDoctor;}

    public void setIDDoctor(String IDDoctor) {this.IDDoctor = IDDoctor;}

    public String getIDPaciente() {return IDPaciente;}

    public void setIDPaciente(String IDPaciente) {this.IDPaciente = IDPaciente;}

    public String getID() {return ID;}

    public void setID(String ID) {this.ID = ID;}

    public String getFecha() {return Fecha;}

    public void setFecha(String fecha) {Fecha = fecha;}

    public String getHora() {return Hora;}

    public void setHora(String hora) {Hora = hora;}

    public String getDatos() {return Datos;}

    public void setDatos(String datos) {Datos = datos;}

    public String getReceta() {return Receta;}

    public void setReceta(String receta) {Receta = receta;}
    public String getEspecialidad() {return Especialidad;}

    public void setEspecialidad(String especialidad) {Especialidad = especialidad;}

}
