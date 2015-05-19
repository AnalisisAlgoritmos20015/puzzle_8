/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle_8;

//import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Oscar Muñoz Bernales
 */
public class Puzzle_8 {

    /**
     * @param args the command line arguments
     */
    public static boolean verificarMatriz(ArrayList rnd,int e){
        if(!rnd.isEmpty()){
            if(rnd.contains(new Integer(e)))
                return true;
        }
        return false;
    }
    public static void GenerarMatriz(int [][] M,int n){
        int init = 1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(j == 2 && i == 2){
                    M[i][j] = 0;
                }
                else{
                    M[i][j] = init;
                }
                init++;
            }
        }
    }
    public static void GenerarMatrizAleatoria(int [][] M,int n){
        int aux;
        ArrayList<Integer> rnd = new ArrayList<Integer>();
        for(int h=0;h<9;h++){
            aux = (int) Math.floor(Math.random() * 9 + 0 ); // Generar numeros aleatorios 
            while(verificarMatriz(rnd,aux)){
                aux = (int) Math.floor(Math.random() * 9 + 0 );
            }
            rnd.add(new Integer(aux));
        }
        /*
        Iterator<Integer> Iterar = rnd.iterator();
	while(Iterar.hasNext()){  // comprobamos que no se repiten los elementos
            Integer elemento = Iterar.next();
            System.out.print(elemento+" ");
	}*/
        int fin = rnd.size()-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                M[i][j] =  rnd.get(fin).intValue();
                fin--;
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] M1 = new int[3][3];
        int [][] M2 = new int[3][3];
        
        
        //System.out.print();
        
        /*GENERAMOS LOS PUZZLES INICIAL Y FINAL*/
        GenerarMatriz(M1,3);
        GenerarMatrizAleatoria(M2,3);
        
        /*DECLARAMOS LAS CLASES PUZZLE PARA CADA UNO*/
        puzzle tabla_final = new puzzle(M1,3);
        puzzle tabla_inicial = new puzzle(M2,3);
        //System.out.print(tabla_inicial.toString());
        
    }
    
}
