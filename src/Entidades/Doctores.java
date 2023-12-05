package Entidades;

import java.io.Serializable;
import java.util.Date;

public class Doctores implements Serializable {
    String ID;
    String ApePat;
    String ApeMat;
    String Nombres;
    String Especialidad;
    String Sexo;
    String Telefono;
    String Email;
    Date FechaNacimiento;

    public String getEmail() {return Email;}

    public void setEmail(String email) {this.Email = email;}

    public String getEspecialidad() {return Especialidad;}

    public void setEspecialidad(String especialidad) {this.Especialidad = especialidad;}

    public String getSexo() {return Sexo;}

    public void setSexo(String sexo) {this.Sexo = sexo;}

    public String getTelefono() {return Telefono;}

    public void setTelefono(String telefono) {this.Telefono = telefono;}


    public Date getFechaNacimiento() {return FechaNacimiento;}

    public void setFechaNacimiento(Date FechaNacimiento) {this.FechaNacimiento = FechaNacimiento;}
    public String getID() {return ID;}

    public void setID(String ID) {this.ID = ID;}

    public String getApePat() {return ApePat;}

    public void setApePat(String apePat) {this.ApePat = apePat;}

    public String getApeMat() {return ApeMat;}

    public void setApeMat(String apeMat) {this.ApeMat = apeMat;}

    public String getNombres() {return Nombres;}

    public void setNombres(String nombres) {this.Nombres = nombres;}


}
