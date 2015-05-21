/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_8;

import java.util.Objects;
import java.util.Random;

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
        //return "fBruta{" + "ini=" + ini + ", fin=" + fin + ", direccion=" + direccion + '}';
        return "direccion: "+direccion;
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
    private coordenadas BuscarCoordenada(){
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
    
    public void BuscarDireccion(){
        Random  rnd = new Random();
        coordenadas xy = new coordenadas(BuscarCoordenada());
        fin= new puzzle(ini); //INICIAMOS EL PUZZLE FINAL CON EL INICIAL PARA PODER MANEJARLO
        if(xy.getI()%2 == 0 && xy.getJ()%2 == 0){ // EN EL CASO QUE ESTE EN LAS ESQUINAS
            //EN CADA UNA DE LAS SIGUINTES IF SE PUEDEN TOMAR DOS CAMINOS
            if(xy.getI() == 0 && xy.getJ() == 0){ // ESQUINA SUPERIOR IZQUIERDA
                // BUSCAMOS EL G(N) POR LA ESQUINA SUPERIOR IZQUIERDA
                if((int)(rnd.nextDouble() * 2 + 1) == 1){ // ABAJO
                    fin.setPos(fin.getPos(1, 0), 0, 0);
                    fin.setPos(0, 1, 0);               // mover la posicion vacía del puzle del lugar 0,0 al lugar 1,0
                    direccion = "abajo";
                }
                else{ // DERECHA
                    fin.setPos(fin.getPos(0, 1), 0, 0);
                    fin.setPos(0, 0, 1);
                    direccion = "derecha";
                }
            }
            else {
                if(xy.getI() == 2 && xy.getJ() == 0){ // ESQUINA INFERIOR IZQUIERDA
                    // BUSCAMOS EL G(N) POR LA ESQUINA INFERIOR IZQUIERDA
                    if((int)(rnd.nextDouble() * 2 + 1) == 1){ // ARRIBA
                        fin.setPos(fin.getPos(1,0), 2, 0);
                        fin.setPos(0, 2, 0);
                        direccion = "arriba";
                    }
                    else{ // DERECHA
                        fin.setPos(fin.getPos(2,1), 2, 0);
                        fin.setPos(0, 2, 1);
                        direccion = "derecha";
 
                    }
                }
                else {
                    if(xy.getI() == 0 && xy.getJ() == 2){ // ESQUINA SUPERIOR DERECHA
                        // BUSCAMOS EL G(N) POR LA ESQUINA SUPERIOR DERECHA
                        if((int)(rnd.nextDouble() * 2 + 1) == 1){ // ABAJO
                            fin.setPos(fin.getPos(1,2), 0, 2);
                            fin.setPos(0, 1, 2);
                            direccion = "abajo";
                        }
                        else{ // IZQUIERDA
                            fin.setPos(fin.getPos(0,1), 0, 2);
                            fin.setPos(0, 0, 1);
                            direccion = "izquierda";
                        }
                    }
                    else{
                        if(xy.getI() == 2 && xy.getJ() == 2){ // ESQUINA INFERIOR DERECHA
                            // BUSCAMOS EL G(N) POR LA ESQUINA INFERIOR DERECHA
                            if((int)(rnd.nextDouble() * 2 + 1) == 1){ // ARRIBA
                                fin.setPos(fin.getPos(1,2), 2, 2);
                                fin.setPos(0, 1, 2);
                                direccion = "arriba";
                            }
                            else{ // IZQUIERDA
                                fin.setPos(fin.getPos(2,1), 2, 2);
                                fin.setPos(0, 2, 1);
                                direccion = "izquierda";
                            }
                        }
                    }
                }
            }
        }
        else{
            if((xy.getI()+xy.getJ())%2 != 0){ // EN EL CASO QUE ESTE A LOS COSTADOS DEL CENTRO
                //EN CADA UNA DE LAS SIGUINTES IF SE PUEDEN TOMAR TRES CAMINOS
                if(xy.getI() == 0 && xy.getJ() == 1){ //ARRIBA
                    // BUSCAMOS EL G(N) POR ARRIBA
                    if((int)(rnd.nextDouble() * 3 + 1) == 1){ //IZQUIERDA
                        fin.setPos(fin.getPos(0,0), 0, 1);
                        fin.setPos(0, 0, 0); 
                        direccion = "izquierda";
                    }
                    else{
                        if((int)(rnd.nextDouble() * 3 + 1) == 2){ // DERECHA
                            fin.setPos(fin.getPos(0,2), 0, 1);
                            fin.setPos(0, 0, 2); 
                            direccion = "derecha";
                        }
                        else{ //ABAJO
                            fin.setPos(fin.getPos(1,1), 0, 1);
                            fin.setPos(0, 1, 1);
                            direccion = "abajo";
                        }
                    }
                }
                else{
                    if(xy.getI() == 2 && xy.getJ() == 1){ // ABAJO
                    // BUSCAMOS EL G(N) POR ABAJO
                        if((int)(rnd.nextDouble() * 3 + 1) == 1){ //IZQUIERDA
                            fin.setPos(fin.getPos(2,0), 2, 1);
                            fin.setPos(0, 2, 0);
                            direccion = "izquierda";
                        }
                        else{
                            if((int)(rnd.nextDouble() * 3 + 1) == 2){ // DERECHA
                                fin.setPos(fin.getPos(2,2), 2, 1);
                                fin.setPos(0, 2, 2);
                                direccion = "derecha";
                            }
                            else{ //ARRIBA
                                fin.setPos(fin.getPos(1,1), 2, 1);
                                fin.setPos(0, 1, 1);
                                direccion = "arriba";
                            }
                        }
                    }
                    else{
                        if(xy.getI() == 1 && xy.getJ() == 0){ //IZQUIERDA
                            // BUSCAMOS EL G(N) POR IZQUIERDA
                            if((int)(rnd.nextDouble() * 3 + 1) == 1){ //ARRIBA
                                fin.setPos(fin.getPos(0,0), 1, 0);
                                fin.setPos(0, 0, 0);
                                direccion = "arriba";
                            }
                            else{
                                if((int)(rnd.nextDouble() * 3 + 1) == 2){ // ABAJO
                                    fin.setPos(fin.getPos(2,0), 1, 0);
                                    fin.setPos(0, 2, 0);
                                    direccion = "abajo";
                                }
                                else{ // DERECHA
                                    fin.setPos(fin.getPos(1,1), 1, 0);
                                    fin.setPos(0, 1, 1); 
                                    direccion = "derecha";
                                }
                            }   
                        }
                        else{
                            if(xy.getI() == 1 && xy.getJ() == 2){ // DERECHA
                                // BUSCAMOS EL G(N) POR DERECHA
                                if((int)(rnd.nextDouble() * 3 + 1) == 1){ //ARRIBA
                                    fin.setPos(fin.getPos(0,2), 1, 2);
                                    fin.setPos(0, 0, 2);
                                    direccion = "arriba";
                                }
                                else{
                                    if((int)(rnd.nextDouble() * 3 + 1) == 2){ // ABAJO
                                        fin.setPos(fin.getPos(2,2), 1, 2);
                                        fin.setPos(0, 2, 2);
                                        direccion = "abajo";
                                    }
                                    else{ // IZQUIERDA
                                        fin.setPos(fin.getPos(1,1), 1, 2);
                                        fin.setPos(0, 1, 1);
                                        direccion = "izquierda";
                                    }
                                }  
                            }
                        }
                    }
                }
            }
            else{ // EN EL CASO QUE ESTE EN EL CENTRO
                //EN ESTE CASO EXISTEN CUATRO CAMINOS DIFERENTES
                if((int)(rnd.nextDouble() * 4 + 1) == 1){ // ARRIBA
                    fin.setPos(fin.getPos(0,1), 1, 1);
                    fin.setPos(0, 0, 1);
                    direccion = "arriba";
                }
                else{
                    if((int)(rnd.nextDouble() * 4 + 1) == 2){ // ABAJO
                        fin.setPos(fin.getPos(2,1), 1, 1);
                        fin.setPos(0,2,1);
                        direccion = "abajo";
                    }
                    else{
                        if((int)(rnd.nextDouble() * 4 + 1) == 3){ // IZQUIERDA
                            fin.setPos(fin.getPos(1,0), 1, 1);
                            fin.setPos(0,1,0);
                            direccion = "izquierda";
                        }
                        else{ // DERECHA
                            fin.setPos(fin.getPos(1,2), 1, 1);
                            fin.setPos(0,1,2);
                            direccion = "derecha";
                        }
                    }
                }
                
            }
        }
    }
    
}
