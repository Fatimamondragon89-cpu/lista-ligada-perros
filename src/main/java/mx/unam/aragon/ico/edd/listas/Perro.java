package mx.unam.aragon.ico.edd.listas;

import java.util.Objects;

public class Perro {
    private String raza;
    private int edad;
    private boolean vacunado;

    public Perro(String raza) {
        this.raza = raza;
    }

    public Perro() {
    }

    public Perro(String raza, int edad, boolean vacunado) {
        this.raza = raza;
        this.edad = edad;
        this.vacunado = vacunado;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "raza='" + raza + '\'' +
                ", edad=" + edad +
                ", vacunado=" + vacunado +
                '}';
    }
    // Dos perros son iguales cuando coinciden sus tres atributos.
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Perro)) return false;
        Perro otro = (Perro) objeto;
        return edad == otro.edad && vacunado == otro.vacunado
                && Objects.equals(raza, otro.raza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raza, edad, vacunado);
    }
}
