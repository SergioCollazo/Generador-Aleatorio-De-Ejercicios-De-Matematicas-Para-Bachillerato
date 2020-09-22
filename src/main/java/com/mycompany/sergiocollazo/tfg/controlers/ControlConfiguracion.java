/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sergiocollazo.tfg.controlers;

import java.security.SecureRandom;
import java.util.UUID;

/**
 *
 * @author sergi
 */
public class ControlConfiguracion {
    //directorios utilizados por la Aplicacion
    private String dirMaxima;
    private String dirArchivoBatch;
    private String dirPDFlatex;
    private String dirAuxPDFlatex;
    private String dirOurputPDFlatex;
    //nombres a generar
    private String nombreArchivoBatch;
    private String nombreArchivoTex;
    private String nombreArchivoTexSoloPreguntas;
    private String nombreArchivoPDF;
    private String nombreArchivoPDFSoloPreguntas;
    private String nombreSalidaMaxima;
    private String nombreAuxPDFlatex;
    private String nombreAuxPDFlatexSoloPreguntas;
    private String id;
    
    public ControlConfiguracion(){
    //Se cambian manualmente
    this.dirMaxima="C:\\maxima-5.43.2\\bin\\maxima";
    this.dirArchivoBatch="C:\\maxima-5.43.2\\share\\maxima\\5.43.2\\tmp";
    this.dirPDFlatex="C:\\Users\\sergi\\Desktop\\aaa";
    this.dirAuxPDFlatex="C:\\Users\\sergi\\Desktop\\aaa";
    this.dirOurputPDFlatex="C:\\Users\\sergi\\Desktop\\aaa";
  
    //Se generan automaticamente
    this.nombreArchivoBatch="test.mac";
    this.nombreArchivoTex="test.tex";
    this.nombreArchivoTexSoloPreguntas="testp.tex";
    this.nombreArchivoPDF="test.pdf";
    this.nombreArchivoPDFSoloPreguntas="testp.pdf";
    this.nombreSalidaMaxima="test.txt";
    this.nombreAuxPDFlatex="test.aux";
    this.nombreAuxPDFlatexSoloPreguntas="testp.aux";
    this.id="";
    }

    public String getNombreArchivoTexSoloPreguntas() {
        return nombreArchivoTexSoloPreguntas;
    }

    public String getNombreAuxPDFlatexSoloPreguntas() {
        return nombreAuxPDFlatexSoloPreguntas;
    }

    
    public String getNombreArchivoPDFSoloPreguntas() {
        return nombreArchivoPDFSoloPreguntas;
    }

    public String getNombreAuxPDFlatex() {
        return nombreAuxPDFlatex;
    }

    public String getId() {
        return id;
    }
    
    public String getDirMaxima() {
        return dirMaxima;
    }

    public String getDirArchivoBatch() {
        return dirArchivoBatch;
    }

    public String getDirPDFlatex() {
        return dirPDFlatex;
    }

    public String getDirAuxPDFlatex() {
        return dirAuxPDFlatex;
    }

    public String getDirOurputPDFlatex() {
        return dirOurputPDFlatex;
    }

    public String getNombreArchivoBatch() {
        return nombreArchivoBatch;
    }

    public String getNombreArchivoTex() {
        return nombreArchivoTex;
    }

    public String getNombreArchivoPDF() {
        return nombreArchivoPDF;
    }

    public String getNombreSalidaMaxima() {
        return nombreSalidaMaxima;
    }
   
    
   public void generarID(){
        UUID id = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        UUID id4 = UUID.randomUUID();

        String time = id.toString().replace("-", "");
        String time2 = id2.toString().replace("-", "");
        String time3 = id3.toString().replace("-", "");
        String time4 = id4.toString().replace("-", "");

        StringBuffer data = new StringBuffer();
        data.append(time);
        data.append(time2);
        data.append(time3);
        data.append(time4);

        SecureRandom random = new SecureRandom();
        int beginIndex = random.nextInt(100);       
        int endIndex = beginIndex + 10;            //benginIndex + n, n no puede ser > 27

        String ID = data.substring(beginIndex, endIndex);
   
        this.nombreArchivoBatch=ID+".mac";
        this.nombreArchivoTex=  ID+".tex";
        this.nombreArchivoTexSoloPreguntas=  ID+"p.tex";
        this.nombreArchivoPDF=  ID+".pdf";
        this.nombreArchivoPDFSoloPreguntas=ID+"p.pdf";
        this.nombreSalidaMaxima=ID+".txt";
        this.nombreAuxPDFlatex=ID+".aux";
        this.nombreAuxPDFlatexSoloPreguntas=ID+"p.aux";
        this.id=ID;
    }
    
}
