package com.mycompany.sergiocollazo.tfg.controlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamGobbler implements Runnable {

    private InputStream inputStream;
    private File salida;
    private ControlFicheros CF;

    public StreamGobbler(InputStream inputStream) {
        this.inputStream = inputStream;
        this.salida = null;
        this.CF = null;
    }

    public StreamGobbler(InputStream inputStream, File salida) {
        this.inputStream = inputStream;
        this.salida = salida;
        this.CF = new ControlFicheros();
    }

    @Override
    public void run() {
        try {

            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            List<String> lineas = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                if (salida == null) {
                    //System.out.println("> " + line);
                } else {
                    lineas.add(line);
                }
            }
            if (salida != null) {
                CF.crearFichero(salida, lineas);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
