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
public class Derivada implements Operacion{
    String expr;
    String x;
    String n;
    String solucion;
    String codigo;
    private String grafica;
    public Derivada(String expr, String x, String n,String codigo){
    this.expr=expr;
    this.x=x;
    this.n=n;
    this.solucion="";
     int numero = (int)(Math.random()*1000+1);
        this.codigo=codigo+numero;
        this.grafica="";
    }

    public String getExpr() {
        String toret=expr.replaceAll("%e", "e"); //System.err.println(toret);
        return toret;
    }
    
     public String getCodigo() {
        return codigo;
    }
    
    public String getGrafica() {
        String toret=expr;
        if("sec(x)".equals(toret)){return "1/cos(x)";}
        if("cot(x)".equals(toret)){return "1/tan(x)";}
        if("csc(x)".equals(toret)){return "1/sin(x)";}
        toret=toret.replaceAll("sec\\(x\\)", "1/cos(x)");
        toret=toret.replaceAll("cot\\(x\\)", "1/tan(x)");
        toret=toret.replaceAll("csc\\(x\\)", "1/sin(x)");
        //System.err.println(toret);
        return  toret;
    }

     public String getGraficaD() {
         String toret=solucion; toret=toret.replaceAll("\\$", "");
         toret=toret.replaceAll("\\{", "(");
         toret=toret.replaceAll("\\}", ")");
        toret=toret.replaceAll("\\\\over", "/");
        toret=toret.replaceAll("\\\\right", "");toret=toret.replaceAll("\\\\left", "");
        toret=toret.replaceAll("\\\\,", "*");
        toret=toret.replaceAll("\\\\cos x", "cos(x)");
        toret=toret.replaceAll("\\\\sec x", "1/cos(x)");
        toret=toret.replaceAll("\\\\tan x", "tan(x)");
        toret=toret.replaceAll("\\\\csc x", "1/sin(x)");
        toret=toret.replaceAll("\\\\sin x", "sin(x)");
        toret=toret.replaceAll("\\\\cot x", "1/tan(x)");
        toret=toret.replaceAll("\\\\arcos x", "acos(x)");
        toret=toret.replaceAll("\\\\tan ^2x", "(tan(x))^2");
        toret=toret.replaceAll("\\\\arcsin ^2x", "(asin(x))^2");
        toret=toret.replaceAll("\\\\arcsin x", "asin(x)");
        toret=toret.replaceAll("\\\\arctan x", "atan(x)");
        toret=toret.replaceAll("\\\\arccos x", "acos(x)");
        toret=toret.replaceAll("\\| x\\|", "abs(x)");
        if(toret.contains("\\log ")){toret=toret.replaceAll("\\\\log ", "log(");toret+=")";}
        
        toret=toret.trim();
        
        return  toret;
    }
    
    public void setGrafica(String grafica) {
        this.grafica = grafica;
    }
    
       @Override
    public void setSolucion(String s){
        this.solucion=s;
    }
    @Override
    public String getSolucion(){
       return this.solucion;
    }
    
    @Override
    public String crearSentenciaMaxima() {
         return "s_1 : \"derivada.\"; tex(diff("+expr+","+x+","+n+"),false);";
    }

    @Override
    public String crearSolucionMathJax() {
        return "";
    }

   public String toString(){
         
         return "f(x)="+getExpr();
    
    }

    @Override
    public String crearSeccionLatex() {
          return "\\section{$f(x)="+getExpr()+"$"+"}\n" +
                    "Resultados: \n" +
                    "\n$f'(x)="+solucion+"$\n";
    }
      @Override
    public String crearSeccionLatexSoloPreguntas() {
          return "\\section{$f(x)="+getExpr()+"$"+"}\n";
    }
    
}
