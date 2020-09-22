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
public class Polinomio implements Operacion{
    private String exp;
    private String solucion;
    private String codigo;
    public Polinomio(String exp,String cod){
        this.exp=exp;
        this.solucion="";
        this.codigo=cod;
    }

    public String getCodigo() {
        return codigo;
    }
    
    @Override
    public String crearSentenciaMaxima() {
         return "s_1 : \"polinomio.\"; tex(solve("+exp+",x),false);";
    }
    @Override
    public String toString() {
        String toret = exp.replaceAll("%e", "e");
       return toret;
    }
    @Override
    public String crearSolucionMathJax() {
       return "";
    }

    @Override
    public void setSolucion(String s){
        this.solucion=s;
    }
    @Override
    public String getSolucion(){
        String toret = solucion.replaceAll("%e", "e");
        toret = toret.replaceAll("\\\\right", "");
        toret = toret.replaceAll("\\\\left", "");
       return toret;
    }

    @Override
    public String crearSeccionLatex() {
       return "\\section{$Polinomio: "+toString()+"$}\n" +
                    "Resultados: \n" +
                    "\n$"+getSolucion()+"$\n";
    }
    @Override
    public String crearSeccionLatexSoloPreguntas() {
      return "\\section{$Polinomio: "+toString()+"$}\n";
    }
    
}
