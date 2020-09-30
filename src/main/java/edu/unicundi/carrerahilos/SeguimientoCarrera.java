package edu.unicundi.carrerahilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Logica de la carrera, comparacion de equipos para evaluar ganador 
 * 
 * @author Andres Forero
 * @version: 2.0.2
 * @since 26/09/2020
 */
public class SeguimientoCarrera extends Thread {
    /**
     * 
     */
    private Equipo equipo1, equipo2, equipo3;
    
    /**
     * costructor el cual llama a el valor del nombre de cada uno de los equipos
     * @param equipo1 valor del equipo 1
     * @param equipo2 valor del equipo 2
     * @param equipo3 valor del equipo 3 
     */
    public SeguimientoCarrera(Equipo equipo1, Equipo equipo2, Equipo equipo3) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.equipo3 = equipo3;

    }
    /**
     * Metodo que levanta cada uno de los hilos
     */
    @Override
    public void run() {
        boolean resultado = false;
        System.out.println("                             EQUIPOS");
        System.out.println("______________________________________________________________________________");
        System.out.println(equipo1.getColorEquipo() + equipo1.getNombreEquipo()
                + "\u001B[0m" + "      " + equipo2.getColorEquipo() + equipo2.getNombreEquipo() + "\u001B[0m"
                + "      " + equipo3.getColorEquipo() + equipo3.getNombreEquipo() + "\u001B[0m");
        System.out.println(" ");
        do {
            imprimirRecorrido(equipo1);
            imprimirRecorrido(equipo2);
            imprimirRecorrido(equipo3);
            System.out.println("\n");
            resultado = ganador();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(SeguimientoCarrera.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (resultado == false);
    }
    
    /**
     * Metodo que imprime la carrera 
     * @param equipo valor del recorrido de cada uno de los equipos
     */
    private void imprimirRecorrido(Equipo equipo) {
        for (Object elementos : equipo.getPista()) {
            System.out.print(equipo.getColorEquipo() + elementos + "\u001B[0m");
        }
        System.out.println();
    }
    
    /**
     * Comparar equipos y verificar el ganador
     * @return  ganador  (el valor del equipo ganador)
     */
    private boolean ganador() {
        
        boolean ganador = false;
        
        String valor1 = equipo1.getPista().get(equipo1.getParametros().getDistancia());
        String valor2 = equipo2.getPista().get(equipo1.getParametros().getDistancia());
        String valor3 = equipo3.getPista().get(equipo1.getParametros().getDistancia());
        
        //Si los 3 hilos llegan al tiempo---------------------------------------
        
        if (valor1 != "°°°" && valor2 != "°°°" && valor3 != "°°°") {
            System.out.println("Empate entre los equipos: " + equipo1.getColorEquipo() 
                    + equipo1.getNombreEquipo() + "\u001B[0m" + " y " + equipo2.getColorEquipo() 
                    + equipo2.getNombreEquipo() + "\u001B[0m" + " y " + equipo3.getColorEquipo() 
                    + equipo3.getNombreEquipo() + "\u001B[0m");
            ganador = true;
            
        //Si el equipo 1 y 2  llegan al tiempo----------------------------------
            
        } else if (valor1 != "°°°" && valor2 != "°°°") {
            System.out.println("Empate entre los equipos: " + equipo1.getColorEquipo()
                    + equipo1.getNombreEquipo() + "\u001B[0m" + " y " + equipo2.getColorEquipo() 
                    + equipo2.getNombreEquipo() + "\u001B[0m");
            ganador = true;
        
        //Si el equipo 1 y 3  llegan al tiempo----------------------------------
         
        } else if (valor1 != "°°°" && valor3 != "°°°") {
            
            System.out.println("Empate entre los equipos: " + equipo1.getColorEquipo() 
                    + equipo1.getNombreEquipo() + "\u001B[0m" + " y " + equipo3.getColorEquipo() 
                    + equipo3.getNombreEquipo() + "\u001B[0m");
            ganador = true;
            
        //Si el equipo 2 y 3  llegan al tiempo----------------------------------
            
        } else if (valor2 != "°°°" && valor3 != "°°°") {
            System.out.println("Empate entre los equipos: " + equipo2.getColorEquipo() + 
                    equipo2.getNombreEquipo() + "\u001B[0m" + " y " + equipo3.getColorEquipo() + 
                    equipo3.getNombreEquipo() + "\u001B[0m");
            ganador = true;
        
        //Si el equipo 1   llegan primero---------------------------------------     
            
        } else if (valor1 != "°°°") {
            System.out.println("Gano el Equipo " + equipo1.getColorEquipo() + "°°° "
                    + equipo1.getNombreEquipo() + " °°°");
            ganador = true;
            
        //Si el equipo 2 llegan primero-----------------------------------------   
            
        } else if (valor2 != "°°°") {
            System.out.println("Gano el Equipo " + equipo2.getColorEquipo() + "°°° "
                   + equipo2.getNombreEquipo()+ " °°°");
            ganador = true;
            
        //Si el equipo 3 llegan primero-----------------------------------------
            
        } else if (valor3 != "°°°") {
            System.out.println("Gano el Equipo " + equipo3.getColorEquipo() + "°°° " 
                    + equipo3.getNombreEquipo() + " °°°");
            ganador = true;
        }

        return ganador;
    }
}
