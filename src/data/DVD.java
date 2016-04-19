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
public class DVD extends Soporte {
    private String duracion;
    private Autor actor1; 
    private Autor actor2; 
    public DVD(String titulo, String duracion) {
        super(titulo);
        this.duracion=duracion; 
    }

    public Autor getActor1() {
        return actor1;
    }

    public void setActor1(Autor actor1) {
        this.actor1 = actor1;
    }

    public Autor getActor2() {
        return actor2;
    }

    public void setActor2(Autor actor2) {
        this.actor2 = actor2;
    }

    @Override
    public String toString() {
        return "DVD{" +super.toString()+ ", actor 1 =" + actor1.getNombre() +" "+actor1.getApellido() + ", actor 2 =" + actor2.getNombre() +" "+actor2.getApellido()+ ", duracion ="+duracion+'}';
    }

    
    
    
}
