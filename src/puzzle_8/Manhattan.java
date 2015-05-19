/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_8;

import java.util.Arrays;

/**
 *
 * @author Oscar Muñoz Bernales
 */
public class Manhattan {
    private int[][] Inicio;
    private int[][] Fin;
    private int complejidad;
    private String direccion; // DERECHA, IZQUIERDA, ARRIBA O ABAJO
    
    //CONSTRUCCTOR
    public Manhattan(int[][] Inicio, int[][] Fin) {
        this.Inicio = Inicio;
        this.Fin = Fin;
    }

    // RESCATAR MATRIZ INICIO
    public int[][] getInicio() {
        return Inicio;
    }

    // SETIAR MATRIZ INICIO
    public void setInicio(int[][] Inicio) { // NO CREO QUE SE OCUPE MUCHO
        this.Inicio = Inicio;
    }

    // RESCATAR MATRIZ FIN
    public int[][] getFin() {
        return Fin;
    }

    // SETIAR MATRIZ FIN
    public void setFin(int[][] Fin) {
        this.Fin = Fin;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Manhattan other = (Manhattan) obj;
        if (!Arrays.deepEquals(this.Inicio, other.Inicio)) {
            return false;
        }
        if (!Arrays.deepEquals(this.Fin, other.Fin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Manhattan{" + "Inicio=" + Inicio + ", Fin=" + Fin + '}';
    }
    
    
}
