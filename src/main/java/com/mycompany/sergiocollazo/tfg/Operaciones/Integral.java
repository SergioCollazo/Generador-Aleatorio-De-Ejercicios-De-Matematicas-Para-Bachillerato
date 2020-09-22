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
public class Integral implements Operacion{
    String expr;
    String x;
    String n1;
    String n2;
    String solucion;
    String codigo;
    private String grafica;
    public Integral(String expr, String x, String n1,String n2,String codigo){
    this.expr=expr;
    this.x=x;
    this.n1=n1;
     this.n2=n2;
    this.solucion="";
     int numero = (int)(Math.random()*1000+1);
        this.codigo=codigo+numero;
        this.grafica="";
    }
    
    public Integral(String expr, String x,String codigo){
    this.expr=expr;
    this.x=x;
    this.solucion="";
     this.n1="";
     this.n2="";
     int numero = (int)(Math.random()*1000+1);
        this.codigo=codigo+numero;
        this.grafica="";
    }

    public String getN1() {
        return n1;
    }

    public String getN2() {
        return n2;
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
         if(n1=="" && n2==""){
          return "s_1 : \"integral.\"; tex(integrate("+expr+","+x+"),false);";
         }else{
         return "s_1 : \"integral.\"; tex(integrate("+expr+","+x+","+n1+","+n2+"),false);";
         }
    }

    @Override
    public String crearSolucionMathJax() {
        return "";
    }

   public String toString(){
        String toret = expr.replaceAll("%e", "e");
           if(n1=="" && n2==""){return "\\int "+toret+", dx";}
           else{return "\\int_{"+n1+"}^{"+n2+"} "+toret+", dx";}
       
         
    
    }

    @Override
    public String crearSeccionLatex() {
         String toret = expr.replaceAll("%e", "e");String toret2 = solucion.replaceAll("%e", "e");if(toret2==""){toret2="Error";}
        if(n1=="" && n2==""){
            return "\\section{$\\int "+toret+", dx$}\n" +
                    "Resultados: \n" +
                    "\n$"+toret2+"$\n";}
           else{
            return "\\section{$\\int_{"+n1+"}^{"+n2+"} "+toret+", dx$}\n" +
                    "Resultados: \n" +
                    "\n$"+toret2+"$\n";}
          
    }
    @Override
    public String crearSeccionLatexSoloPreguntas() {
        String toret = expr.replaceAll("%e", "e");
        if(n1=="" && n2==""){
            return "\\section{$\\int "+toret+", dx$}\n";}
           else{
            return "\\section{$\\int_{"+n1+"}^{"+n2+"} "+toret+", dx$}\n";}
          
    }
    
}
