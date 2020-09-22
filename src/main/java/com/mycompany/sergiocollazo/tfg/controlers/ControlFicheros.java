package com.mycompany.sergiocollazo.tfg.controlers;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ControlFicheros {

	   public ControlFicheros() {

    }

    public void crearFichero(String directorio, String nombre, List<String> contenido) throws IOException {
        //crear el fichero
        File fichero = new File(directorio, nombre);
        //escribir en el fichero
        FileWriter fw = new FileWriter(fichero);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<String> it = contenido.iterator();
        while (it.hasNext()) {
            bw.write(it.next());
        }
        bw.close();

        fichero.createNewFile();

    }

    public void borrarFichero(String directorio, String nombre) {
        File fichero = new File(directorio, nombre);
        fichero.delete();

    }

    public File creaFichero(String directorio, String nombre) {
        return new File(directorio, nombre);
    }

    public void crearFichero(File fichero, List<String> contenido) throws IOException {

        //escribir en el fichero
        FileWriter fw = new FileWriter(fichero);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<String> it = contenido.iterator();
        while (it.hasNext()) {
            bw.write(it.next());
            bw.newLine();
        }
        bw.close();
        fichero.createNewFile();

    }
	

	
}
