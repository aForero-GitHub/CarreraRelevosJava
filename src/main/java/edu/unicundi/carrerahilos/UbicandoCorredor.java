package edu.unicundi.carrerahilos;

/**
 *
 * @author Andres Forero
 * @version: 2.0.2
 * @since 03/09/2020
 */
public class UbicandoCorredor {

    /**
     * distancia recorrida
     */
    private short distancia;

    /**
     * posicion de los corredores
     */
    private short posicion1, posicion2, posicion3;

    /**
     *
     * @param distancia
     * @param posicion1
     * @param posicion2
     * @param posicion3
     */
    public UbicandoCorredor(short distancia, short posicion1, short posicion2, short posicion3) {
        this.distancia = distancia;
        this.posicion1 = posicion1;
        this.posicion2 = posicion2;
        this.posicion3 = posicion3;
    }

    public short getDistancia() {
        return distancia;
    }

    public void setDistancia(short distancia) {
        this.distancia = distancia;
    }

    public short getPosicion1() {
        return posicion1;
    }

    public void setPosicion1(short posicion1) {
        this.posicion1 = posicion1;
    }

    public short getPosicion2() {
        return posicion2;
    }

    public void setPosicion2(short posicion2) {
        this.posicion2 = posicion2;
    }

    public short getPosicion3() {
        return posicion3;
    }

    public void setPosicion3(short posicion3) {
        this.posicion3 = posicion3;
    }

}
