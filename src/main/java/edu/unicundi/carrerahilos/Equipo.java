package edu.unicundi.carrerahilos;

import java.util.ArrayList;

/**
 *
 * @author Andres Forero
 * @version: 2.0.2
 * @since 26/09/2020
 */
public class Equipo {
    /**
     * Este Array captura la posicion de los corredores en la pista
     */
    ArrayList<String> pista = new ArrayList<>();

    /**
     * Variable que almacena el nombre del equipo
     * para mostrar al final si es el ganador 
     */
    private String nombreEquipo;
    /**
     * variable que almacena el color para pintar en consola
     */
    private String colorEquipo;

    /**
     * variable que almacena un id para identificar a que equipo 
     * le coresponde un color 
     */
    private short identificador;
    
    /**
     * Variable que almacena un objeto parametros 
     * para la construcion de la pista
     */
    
    private UbicandoCorredor parametros;
    
    /**
     * 
     * @param nombreEquipo
     * @param identificador
     * @param parametros 
     */
    public Equipo(String nombreEquipo, short identificador, UbicandoCorredor parametros){
        this.nombreEquipo = nombreEquipo;
        this.identificador = identificador;
        this.parametros = parametros;
        PintarCarril();
        colorCorrespondiente();
    } 
    
    /**
     * vector de 101 posiciones Para dibujar la pista
     */
    private void PintarCarril(){
        for (int i = 0; i < parametros.getDistancia(); i++) {
           pista.add(i, "_");
        }
        pista.add(pista.size(), "°°°");
    }
    
    /**
     * Segun el numero del equipo selecciona el color
     * del equipo 
     */
    private void colorCorrespondiente(){
        switch (this.identificador){
            case 1:
                this.colorEquipo = "\u001B[31m";
                break;
            case 2:
                this.colorEquipo = "\u001B[36m";
                break;
            case 3:
                this.colorEquipo = "\u001B[32m";
                break;
            default:
                break;
        }
    }

    /**
     * Metodo para mostrar cual a sido el nombre del equipo
     * @return nombreEquipo retorna el valor del equipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }
    /**
     * Metodo para modificar el nombre  del equipo
     * @param nombreEquipo modificar el nombre  del equipo
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    /**
     * Metodo para mostrar cual a sido el color del equipo
     * @return  colorEquipo retorna el color de equipo
     */
    public String getColorEquipo() {
        return colorEquipo;
    }
    /**
     * Metodo para modificar el color  del equipo
     * @param colorEquipo  modificar el  color del equipo
     */
    public void setColorEquipo(String colorEquipo) {
        this.colorEquipo = colorEquipo;
    }
    /**
     * Metodo para mostrar cual a sido el identificadro del corredor
     * @return identificador retorna el identificador del corredor 
     */
    public short getIdentificador() {
        return identificador;
    }
    /**
     * Metodo para modificar el identificador del equipo
     * @param identificador modificar el valor del identificador
     */
    public void setIdentificador(short identificador) {
        this.identificador = identificador;
    }
    /**
     * Metodo para mostrar la pista  
     * @return pista retorna array
     */
    
    public ArrayList<String> getPista() {
        return pista;
    }
    /**
     * Metodo para modificar la pista de los corredores 
     * @param pista modificar la pista
     */
    public void setPista(ArrayList<String> pista) {
        this.pista = pista;
    }
    
    
    /**
     * Metodo para mostrar un objeto de la clase ParametrosCarrera
     * @return parametros
     */
    public UbicandoCorredor getParametros() {
        return parametros;
    }
    
    /**
     *  Metodo para modificar un objeto de la clase ParametrosCarrera
     * @param parametros 
     */

    public void setParametros(UbicandoCorredor parametros) {
        this.parametros = parametros;
    }
  
}
