/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import data.CD;
import data.DVD;
import Exception.LibroException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import data.Autor;
import data.Libro;
import data.Soporte;

/**
 * @author fabian.giraldo
 * Luego va ser mejorada
 */
public class Dao {
         
    public Autor cargarAutor(Scanner sc) {
	Autor autor = null;
	String nombre = sc.next().trim();
        String apellido = sc.next().trim();
        autor = new Autor(nombre, apellido);
        return autor;
    }
        
    public Libro cargarLibro(Scanner sc) throws LibroException{
	Libro libro = null;
	String titulo = sc.next().trim();
        
        if(titulo.length()< 5){
           throw new LibroException("Titulo incorrecto" + titulo);
        }
        Autor autor = cargarAutor(sc);
	String isbn = sc.next().trim();	
        libro = new Libro(isbn, titulo);
        libro.setAutor(autor);
         
        return libro;
    }
    
    public DVD cargarDVD(Scanner sc){
        DVD dvd=null; 
        String titulo=sc.next().trim();
        Autor autor=cargarAutor(sc);
        Autor actor1= cargarAutor(sc);
        Autor actor2= cargarAutor(sc);
        String duracion= sc.next().trim();
        dvd=new DVD(titulo, duracion);
        dvd.setActor1(actor1);
        dvd.setActor2(actor2);
        dvd.setAutor(autor);
        return dvd; 
    }
    public CD cargarCD(Scanner sc){
        CD cd=null; 
        String titulo=sc.next().trim();
        Autor autor=cargarAutor(sc);
        String genero= sc.next().trim();
        String duracion= sc.next().trim();
        cd=new CD(genero, duracion,titulo);
        cd.setAutor(autor);
        return cd; 
    }
    
    public Soporte leerSoporte(Scanner sc) throws LibroException {
	String type = sc.next().trim();
	if (type.equals("Libro")) return cargarLibro(sc);
        if (type.equals("DVD")) return cargarDVD(sc);
          if (type.equals("CD")) return cargarCD(sc);
            return null; //Se debe completar
    }
	
    public ArrayList<Soporte> cargarSoportes(String archivo) throws FileNotFoundException, LibroException{
  	ArrayList<Soporte> soportes = new ArrayList<Soporte>();
	Scanner sc;
	sc = new Scanner(new File(archivo));
	sc.useDelimiter(",");
	while (sc.hasNext()) {
		soportes.add(leerSoporte(sc));
	}
	
	return soportes;
   }
    
}
