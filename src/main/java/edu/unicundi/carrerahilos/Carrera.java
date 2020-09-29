package edu.unicundi.carrerahilos;

/**
 * Esta clase se encarga de crear e iniciar los hilos (Corredores)
 *
 * @author Andres Forero
 * @version: 2.0.2
 * @since 03/09/2020
 */
public class Carrera {

    /**
     * Metodo donde se inicializan cada uno de los hilos
     */
    public void empezarCarrera() {
        UbicandoCorredor parametros = new UbicandoCorredor((short) 101, (short) 0, (short) 33, (short) 66);

        Equipo equipoRojo = new Equipo("Rojo", (short) 1, parametros);
        Equipo equipoAzul = new Equipo("Azul", (short) 2, parametros);
        Equipo equipoVerde = new Equipo("Verde", (short) 3, parametros);

        //1er Tramo de la carrera-----------------------------------------------
        Corredor corredor1 = new Corredor((short) 1, "//", equipoRojo);
        Corredor corredor2 = new Corredor((short) 1, "//", equipoAzul);
        Corredor corredor3 = new Corredor((short) 1, "//", equipoVerde);

        //2do Tramo de la carrera-----------------------------------------------
        Corredor corredor4 = new Corredor((short) 2, "()", equipoRojo);
        Corredor corredor5 = new Corredor((short) 2, "()", equipoAzul);
        Corredor corredor6 = new Corredor((short) 2, "()", equipoVerde);

        //3er Tramo de la carrera-----------------------------------------------
        Corredor corredor7 = new Corredor((short) 3, "[]", equipoRojo);
        Corredor corredor8 = new Corredor((short) 3, "[]", equipoAzul);
        Corredor corredor9 = new Corredor((short) 3, "[]", equipoVerde);

        SeguimientoCarrera carrera = new SeguimientoCarrera(equipoRojo,
                equipoAzul, equipoVerde);

        //1------------------------------------------
        corredor1.start();
        corredor2.start();
        corredor3.start();

        //2------------------------------------------
        corredor4.start();
        corredor5.start();
        corredor6.start();

        //3------------------------------------------
        corredor7.start();
        corredor8.start();
        corredor9.start();

        //Imprimir carrera---------------------------
        carrera.start();

    }
}
