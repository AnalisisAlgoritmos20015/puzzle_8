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
public class puzzle {
    private int[][] Matriz;
    private int numero;

    public puzzle(int[][] Matriz, int numero) {
        this.Matriz = Matriz;
        this.numero = numero;
    }
    
    public puzzle(puzzle M){
        this.Matriz = M.getMatriz();
        this.numero = M.getNumero();
    }
    puzzle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int[][] getMatriz() {
        return Matriz;
    }

    public void setMatriz(int[][] Matriz) {
        this.Matriz = Matriz;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setPos(int e, int i,int j){
        Matriz[i][j] = e;
    }
    
    public int getPos(int i,int j){
        return Matriz[i][j];
    }
    @Override
    public String toString() {
        String matriz = "";
        for(int i=0;i<numero;i++){
            for(int j=0;j<numero;j++){
                matriz = matriz+Matriz[i][j]+" ";
            }
            matriz = matriz+"\n";
        }
        return "Matriz \n" + matriz + " complejidad=" + numero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final puzzle other = (puzzle) obj;
        if (!Arrays.deepEquals(this.Matriz, other.Matriz)) {
            return false;
        }
        return true;
    }
    
    
}
