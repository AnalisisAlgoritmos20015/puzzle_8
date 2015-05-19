/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_8;

import java.util.Objects;

/**
 *
 * @author Oscar Muñoz Bernales
 */
public class fBruta {
    private puzzle ini; // Matriz INICIAL
    private puzzle fin; // Matriz FINAL
    private String direccion; // Direccion de la rama

    public fBruta(puzzle ini) {
        this.ini = ini;
    }

    public puzzle getIni() {
        return ini;
    }

    public void setIni(puzzle ini) {
        this.ini = ini;
    }

    public puzzle getFin() {
        return fin;
    }

    public void setFin(puzzle fin) {
        this.fin = fin;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "fBruta{" + "ini=" + ini + ", fin=" + fin + ", direccion=" + direccion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final fBruta other = (fBruta) obj;
        if (!Objects.equals(this.ini, other.ini)) {
            return false;
        }
        if (!Objects.equals(this.fin, other.fin)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return true;
    }
    
    //VEMOS LA DIRECCION
    /*private int BuscarCoordenadai(){
        int cordi = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(ini.getPos(i, j) == 0){
                    cordi = i;
                }
            }
        }
        return cordi;
    }
    private int BuscarCoordenadaj(){
        int cordj = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(ini.getPos(i, j) == 0){
                    cordj = j;
                }
            }
        }
        return cordj;
    }*/
    
    private coordenadas BuscarCoordenadai(){
        coordenadas  coord = new coordenadas(-1,-1);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(ini.getPos(i, j) == 0){
                    coord.setI(i);
                    coord.setJ(j);
                }
            }
        }
        return coord;
    }
    
}
