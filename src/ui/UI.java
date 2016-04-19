/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Exception.LibroException;
import data.Soporte;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.ServicioSoporte;

/**
 *
 * @author fabian.giraldo
 */
public class UI {
    private Scanner sc ;
    private ServicioSoporte servicio;
    
    
    public UI(){
      this.sc = new Scanner(System.in);
      this.servicio = new ServicioSoporte();
    }
         
    public void imprimirSoportes(ArrayList<Soporte> soportes){
        if(soportes != null){
          for(Soporte soporte: soportes){
              System.out.println(soporte);
          }
        }else{
            System.out.println("No existen soportes actualmente");
        }
   }
    
    public void menu(){
        int opcion = 0;     
        System.out.println("Bienvenido a la mediateca");
        System.out.println("Opciones."+"\n1. Cargar datos"+ "\n2. Imprimir"+"\n3. Buscar por titulo"+"\n4. Pedir prestado un recurso.");
        opcion = this.sc.nextInt();
        
        if(opcion == 1){
           System.out.println("Nombre del archivo: ");
           String rutaArchivo =   sc.next();
            try {
                this.servicio.cargarSoportes(rutaArchivo);
            } catch (FileNotFoundException ex) {
                System.out.println("El archivo especificado no existe");
            } catch (LibroException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else if(opcion == 2){
           ArrayList<Soporte> soportes = this.servicio.getSoportes();
           this.imprimirSoportes(soportes);
        }
        else if(opcion == 3){
            System.out.println("Ingrese el titulo del soporte (DVD, Libro o CD)");
            String titulo = sc.next();
            try{
                if(this.servicio.buscarSoporte(titulo)!=null){
                    System.out.println(this.servicio.buscarSoporte(titulo));
                }else{
                    System.out.println("Soporte inexistente");
                }
                
            }catch(NullPointerException exc){
                System.out.println("No existen soportes actualmente");
            }
        }
        else if (opcion == 4) {
            System.out.println("Ingrese el titulo del soporte (DVD, Libro o CD)");
            String titulo = sc.next();
            try {
                if (this.servicio.prestarSoporte(titulo)!=null) {
                    System.out.println(this.servicio.prestarSoporte(titulo));
                }else 
                    System.out.println("El soporte no existe.");
            } catch (NullPointerException e) {
                System.out.println("No se encontro el soporte.");
            }
            
        }
        else{
            System.out.println("Opcion invalida");
        }
    
    }
   
}
