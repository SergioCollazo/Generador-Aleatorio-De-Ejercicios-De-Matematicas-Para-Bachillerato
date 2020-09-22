/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sergiocollazo.tfg.Operaciones;

/**
 *
 * @author sergi
 */
public interface Operacion {

    public String crearSentenciaMaxima();
    public String toString();
    public String crearSolucionMathJax();
    public void setSolucion(String s);
    public String getSolucion();
    public String crearSeccionLatex();
    public String crearSeccionLatexSoloPreguntas();
}
