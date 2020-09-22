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
public class Limite implements Operacion{
    private String exp;
    private String x;
    private String val;
    private String solucion;
    private String codigo;
    private String grafica;
    public Limite(String exp, String x, String val,String codigo){
        this.exp=exp;
        this.x=x;
        this.val=val;
        this.solucion="";
        int numero = (int)(Math.random()*1000+1);int numero2 = (int)(Math.random()*100+1);
        this.codigo=codigo+numero+"e"+numero2;
        this.grafica="";
    }
    
        public String getCodigo() {
        return codigo;
    }
    
    public String getGrafica() {
        if("sec(x)".equals(exp)){return "1/cos(x)";}
        if("cot(x)".equals(exp)){return "1/tan(x)";}
        if("csc(x)".equals(exp)){return "1/sin(x)";}
        return  exp;
    }

    public void setGrafica(String grafica) {
        this.grafica = grafica;
    }

    public String getExp() {
        String toret = exp.replaceAll("%e", "e");
        return toret;
    }

    public String getVal() {
        String toret = val.replaceAll("%e", "e");
        return toret;
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
    
     public String toString(){
         
         return "\\lim_{"+x+" \\to "+getVal()+"}"+getExp();
    
    }
    
    @Override
    public String crearSentenciaMaxima() {
       //return "s_1 : \"limite.\"; limit("+exp+","+x+","+val+"),numer;";
       return "s_1 : \"limite.\"; tex(limit("+exp+","+x+","+val+"),false);";
    }

    
    @Override
    public String crearSolucionMathJax() {
         return "";
    }

  
    @Override
    public String crearSeccionLatex() {
          return "\\section{$lim_{"+x+" \\to "+getVal()+"}"+getExp()+"$"+"}\n" +
                    "Resultados: \n" +
                    "\n$"+getSolucion()+"$\n";
    }
    @Override
    public String crearSeccionLatexSoloPreguntas() {
          return "\\section{$lim_{"+x+" \\to "+getVal()+"}"+getExp()+"$"+"}\n";
    }
    
}
