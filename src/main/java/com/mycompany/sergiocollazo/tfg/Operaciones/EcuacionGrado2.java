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
public class EcuacionGrado2 implements Operacion{
    private String a;
    private String b;
    private String c;
    private String codigo;
    private String solucion;
    private String grafica;
 
    public EcuacionGrado2(String a, String b, String c, String codigo){
    this.a=a;
    this.b=b;
    this.c=c;
    int numero = (int)(Math.random()*1000+1);
    this.codigo=codigo+numero;
    this.solucion="";
    this.grafica="";
    }

    public String getGrafica() {
        return  a+"*x^2+"+b+"*x+"+c;
    }

    public void setGrafica(String grafica) {
        this.grafica = grafica;
    }

    
    
    public String getA() {
        String toret = a.replaceAll("%e", "e");
        return toret;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
         String toret = b.replaceAll("%e", "e");
        return toret;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
         String toret = b.replaceAll("%e", "e");
        return toret;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
    public void setSolucion(String s){
        this.solucion=s;
    }
    
    public String getSolucion(){
        String toret = solucion.replaceAll("%e", "e");
        toret = toret.replaceAll("\\\\right", "");
        toret = toret.replaceAll("\\\\left", "");
       return toret;
    }
    
    @Override
    public String crearSentenciaMaxima(){
             return "s_1 : \"ecuacion grado 2.\"; tex(solve("+a+"*x^2 + "+b+"*x + "+c+" = 0),false);";

      
        
    }
    @Override
    public String toString(){
    return getA()+"*x^2 + "+getB()+"*x + "+getC()+" = 0";
    }
    @Override
    public String crearSolucionMathJax(){
    return "\\[x = {-"+getB()+" \\pm \\sqrt{"+getB()+"^2-4*"+getA()+"*"+getC()+"} \\over 2*"+getA()+"}\\]";
    }
    public String crearSolucionMathJaxPaso2(){
        float a2 = Float.parseFloat(a);
        float b2 = Float.parseFloat(b);
        float c2 = Float.parseFloat(c);
       float x= b2*b2 -4*a2*c2;float y= 2*a2;
    return "\\[x = {-"+b+" \\pm \\sqrt{"+x+"} \\over "+y+"}\\]";
    }

    @Override
    public String crearSeccionLatex() {
      return "\\section{$"+getA()+"x^2 + "+getB()+"x + "+getC()+" = 0$"+"}\n" +
                    "Resultados: \n" +
                    "$x = \\frac {-"+getB()+" \\pm \\sqrt {"+getB()+"^2 - 4*"+getA()+"*"+getC()+"}}{2*"+getA()+"}$ \n" +
                    "\n$"+getSolucion()+"$\n";
    }
    @Override
    public String crearSeccionLatexSoloPreguntas() {
       return "\\section{$"+getA()+"x^2 + "+getB()+"x + "+getC()+" = 0$"+"}\n";
    }
}
