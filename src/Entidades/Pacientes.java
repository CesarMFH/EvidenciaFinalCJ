package Entidades;

import java.io.Serializable;

public class Pacientes implements Serializable {

    String ID_p,Nombre_p,ApePat_p,ApeMat_p, Dia, Mes, Anio, Sexo_p, Telefono_p, Correo_p,Alergias;
    public String getID_p() {return ID_p;}

    public void setID_p(String ID_p) {this.ID_p = ID_p;}

    public String getNombre_p() {return Nombre_p;}

    public void setNombre_p(String nombre_p) {this.Nombre_p = nombre_p;}

    public String getApePat_p() {return ApePat_p;}

    public void setApePat_p(String apePat_p) {this.ApePat_p = apePat_p;}

    public String getApeMat_p() {return ApeMat_p;}

    public void setApeMat_p(String apeMat_p) {this.ApeMat_p = apeMat_p;}

    public String getDia() {return Dia;}

    public void setDia(String dia) {this.Dia = dia;}

    public String getMes() {return Mes;}

    public void setMes(String mes) {this.Mes = mes;}

    public String getAnio() {return Anio;}

    public void setAnio(String anio) {this.Anio = anio;}

    public String getSexo_p() {return Sexo_p;}

    public void setSexo_p(String sexo_p) {this.Sexo_p = sexo_p;}

    public String getTelefono_p() {return Telefono_p;}

    public void setTelefono_p(String telefono_p) {this.Telefono_p = telefono_p;}

    public String getCorreo_p() {return Correo_p;}

    public void setCorreo_p(String correo_p) {this.Correo_p = correo_p;}

    public String getAlergias() {return Alergias;}

    public void setAlergias(String alergias) {this.Alergias = alergias;}


}
