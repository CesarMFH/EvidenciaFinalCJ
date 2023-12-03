package Entidades;

import java.io.Serializable;
import java.util.Date;

public class Doctores implements Serializable {
    String ID;
    String ApePat;
    String ApeMat;
    String Nombres;
    Date FechaNacimiento;
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
