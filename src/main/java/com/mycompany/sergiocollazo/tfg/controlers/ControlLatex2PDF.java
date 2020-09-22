/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sergiocollazo.tfg.controlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;

/**
 *
 * @author sergi
 */
public class ControlLatex2PDF {
    private String nombreArchivoTex;
    private String rutaPdflatex;
    private String dirAux;
    private String dirOutput;
    private String cabecera;
    private String footer;
    private List<String> contenidoDocumentoLatex = new ArrayList<String>();

    public ControlLatex2PDF(String rutaPdflatex,String nombreArchivoTex,String dirAux, String dirOutput) {

        this.nombreArchivoTex = nombreArchivoTex;
        this.rutaPdflatex = rutaPdflatex;
        this.dirAux = dirAux;
        this.dirOutput = dirOutput;

        this.cabecera = "\\documentclass[a4paper,11pt]{article}\n"
                + "\n"
                + "\\usepackage[latin1]{inputenc}\n"
                + "\\usepackage{color}\n"
                + "\\usepackage{array}\n"
                + "\\usepackage{amsmath,amssymb}\n"
                + "\n"
                + "\\addtolength{\\textwidth}{2cm}\n"
                + "\\addtolength{\\hoffset}{-1cm}\n"
                + "\n"
                + "\\title{Ejercicios}\n"
                + "\n"
                + "\\begin{document}\n"
                + "\n"
                + "\\maketitle\n"
                + "\n"
                + "";
        this.footer = "\n"
                + "\n"
                + "\n"
                + "\\end{document}";
    }

    public List<String> construirTemplateLatex(List<String> contenido) {
        contenidoDocumentoLatex.add(this.cabecera);
        Iterator it = contenido.iterator();
        while (it.hasNext()) {
            String c = (String) it.next();
            contenidoDocumentoLatex.add(c);
        }
        contenidoDocumentoLatex.add(this.footer);
        return contenidoDocumentoLatex;
    }

    public void ejecutarComandoConsola() throws IOException, InterruptedException {
       
        String comando = "pdflatex -output-directory="+dirOutput+" " + rutaPdflatex+"\\" + nombreArchivoTex;
        Process process;
        process = Runtime.getRuntime().exec(String.format("cmd.exe /c %s", comando));
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream());
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;

    }

}
