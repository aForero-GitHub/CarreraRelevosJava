/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.carrerahilos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres Forero
 * @version: 2.0.2
 * @since 26/09/2020
 */
public class Corredor extends Thread {

    /**
     * identifica el corredor en su posicion (1, 2 , 3)
     */
    private short identificador;
    /**
     * la variable nombre almacena el nombre de cada uno de los hilos
     */
    private String nombre;
    /**
     * la variable equipo almacena los hilos que pertenencen a ese equipo
     */
    private Equipo equipo;

    /**
     *
     * @param identificador
     * @param nombre
     * @param equipo
     */
    public Corredor(short identificador, String nombre, Equipo equipo) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.equipo = equipo;
        ubicarCorredor();
    }

    /**
     * Metodo que levanta cada uno de los hilos
     */
    @Override
    public void run() {
        relevo();
    }

    /**
     * Metodo que ubica a cada uno de los Corredores segun el hilo
     */
    private void ubicarCorredor() {
        ArrayList<String> pistaUbicacion = new ArrayList<>();
        pistaUbicacion = equipo.getPista();
        if (identificador == 1) {
            pistaUbicacion.set(equipo.getParametros().getPosicion1(), nombre);
            equipo.setPista(pistaUbicacion);
        } else if (identificador == 2) {
            pistaUbicacion.set(equipo.getParametros().getPosicion2(), nombre);
            equipo.setPista(pistaUbicacion);
        } else if (identificador == 3) {
            pistaUbicacion.set(equipo.getParametros().getPosicion3(), nombre);
            equipo.setPista(pistaUbicacion);
        }
    }

    /**
     * le notifica a los otros hilos(corredores) si ya pueden iniciar
     */
    private void relevo() {
        if (identificador == 1) {
            empezarACorrer(equipo.getParametros().getPosicion2());
            synchronized (equipo.getPista().get(equipo.getParametros().getPosicion3())) {
                equipo.getPista().get(equipo.getParametros().getPosicion3()).notifyAll();
            }
        } else if (identificador == 2) {

            synchronized (equipo.getPista().get(equipo.getParametros().getPosicion3())) {
                try {
                    equipo.getPista().get(equipo.getParametros().getPosicion3()).wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            empezarACorrer(equipo.getParametros().getPosicion3());

            synchronized (equipo.getNombreEquipo()) {
                equipo.getNombreEquipo().notifyAll();
            }
        } else if (identificador == 3) {

            synchronized (equipo.getNombreEquipo()) {
                try {
                    equipo.getNombreEquipo().wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            empezarACorrer(equipo.getParametros().getDistancia());
        }
    }

    /**
     * Metodo que muestra el movimiento de cada uno de los hilos
     */
    private void empezarACorrer(short posicion) {
        ArrayList<String> pistaUbicacion = new ArrayList<>();
        int random, posicionActual, restaPosicion, posicionFinal;
        short posicionRelevo;
        if (posicion == equipo.getParametros().getDistancia()) {
            posicionRelevo = posicion;
        } else {
            posicionRelevo = (short) (posicion - 1);
        }
        while (equipo.getPista().get(posicionRelevo) != nombre) {

            pistaUbicacion = equipo.getPista();
            random = (int) (Math.random() * 3) + 1;
            posicionActual = pistaUbicacion.indexOf(nombre);
            restaPosicion = posicionRelevo - posicionActual;
            if (restaPosicion > 3) {
                random = random;
            } else if (restaPosicion == 1) {
                if (random > 1) {
                    random = 1;
                }
            } else if (restaPosicion == 2) {
                if (random > 2) {
                    random = 1;
                }
            }

            posicionFinal = posicionActual + random;

            if (posicionFinal >= (equipo.getParametros().getDistancia() + 1)) {
                posicionFinal = equipo.getParametros().getDistancia();
            } else if (posicionFinal == (equipo.getParametros().getDistancia() - 1)) {
                posicionFinal = equipo.getParametros().getDistancia();
            } else {
                posicionFinal = posicionFinal;
            }

            pistaUbicacion.set(posicionActual, "_");
            pistaUbicacion.set(posicionFinal, nombre);
            equipo.setPista(pistaUbicacion);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
