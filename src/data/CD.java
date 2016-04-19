/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Estudiante
 */
public class CD extends Soporte{
    private String genero;
    private String duracion; 
   

    public CD(String genero, String duracion, String titulo) {
        super(titulo);
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "CD{"+super.toString() + "genero=" + genero + ", duracion=" + duracion + '}';
    }
   
}
