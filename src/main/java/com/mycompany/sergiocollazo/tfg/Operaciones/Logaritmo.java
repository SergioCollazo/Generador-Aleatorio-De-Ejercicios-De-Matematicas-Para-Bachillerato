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
public class Logaritmo implements Operacion{

    private String x;
    private  String y;
    private String b;
    private  String solucion;
    private String tipo;
    
    public Logaritmo(String x, String y, String b,String tipo){
    this.x=x;
    this.y=y;
    this.b=b; 
    this.solucion="";
    this.tipo=tipo;
    }

    public String getX() {
        String toret = x.replaceAll("%e", "e");
        return toret;
    }
    public String getY() {
        String toret = y.replaceAll("%e", "e");
        return toret;
    }
    public String getB() {
        String toret = b.replaceAll("%e", "e");
        return toret;
    }    
    @Override
    public void setSolucion(String s){
        this.solucion=s;
    }
    @Override
    public String getSolucion(){
        String toret = solucion.replaceAll("\\\\right", ""); 
        toret = toret.replaceAll("\\\\left", "");toret = toret.replaceAll("\\$", "");toret = toret.replaceAll("%e", "e");
       return toret;
    }
     @Override
    public String toString(){
   switch(tipo){
                case "Producto":
                    return "log_{"+getB()+"}("+getX()+"*"+getY()+")";
                  //  break;
                case "Potencia":
                     return "log_{"+getB()+"}("+getX()+"^{"+getY()+"})";
                  //  break;
                case "Raiz":
                     return "log_{"+getB()+"}(\\sqrt["+getY()+"]"+getX()+")";
                  //  break;
                case "Cociente":
                    return "log_{"+getB()+"}(\\frac{"+getX()+"}{"+getY()+"})";
                   // break;
                case "Libre":
                    return "log_{"+getB()+"}("+getX()+")";
                   // break;
                case "Neperiano":
                    return "ln("+getX()+")";
                   // break;
            }
   return "";
    }
    
    @Override
    public String crearSentenciaMaxima() {
            //log2(x):=log(x)/log(b)$
            String tipolog="logB(x):=log(x)/log("+b+")$";
            switch(tipo){
                case "Producto":
                    return "s_1 : \"logaritmo.\";"+tipolog+"logB("+x+"*"+y+"),numer;";
                  //  break;
                case "Potencia":
                    return "s_1 : \"logaritmo.\";"+tipolog+"logB("+x+"^"+y+"),numer;";
                  //  break;
                case "Raiz":
                     return "s_1 : \"logaritmo.\";"+tipolog+"logB("+x+"^(1/"+y+")),numer;";
                  //  break;
                case "Cociente":
                    return "s_1 : \"logaritmo.\";"+tipolog+"logB("+x+"/"+y+"),numer;";
                   // break;
                case "Libre":
                    return "s_1 : \"logaritmo.\";"+tipolog+"tex(logB("+x+"),false);";
                   // break;
                case "Neperiano":
                    return "s_1 : \"logaritmo.\";"+"1+1$tex(log("+x+"),false),numer;";
                   // break;
            }
        return "";
            
    } 
    

    @Override
    public String crearSolucionMathJax() {
          switch(tipo){
                case "Producto":
                    return "log_{"+getB()+"}("+getX()+") + log_{"+getB()+"}("+ getY()+")";
                  //  break;
                case "Potencia":
                     return y+"*log_{"+getB()+"}("+getX()+")";
                  //  break;
                case "Cociente":
                     return "log_{"+getB()+"}("+getX()+") - log_{"+getB()+"}("+ getY()+")";
                  //  break;
                case "Raiz":
                    return "\\frac{log_{"+getB()+"}("+getX()+")}{"+ getY()+"}";
                   // break;
                case "Libre":
                    return "";
                case "Neperiano":
                    return "";
                   // break;    
                   // break;    
            }
        return "";
    }

    @Override
    public String crearSeccionLatex() {
         switch(tipo){
                case "Producto":
                    return "\\section{$log_{"+getB()+"}("+getX()+"*"+ getY()+")$}\n" +
                            "Resultados: \n"+
                            "$log_{"+getB()+"}("+getX()+") + log_{"+getB()+"}("+ getY()+") = "+getSolucion()+"$";
                  //  break;
                case "Potencia":
                     return "\\section{$log_{"+getB()+"}("+getX()+"^{"+ getY()+"})$}\n" +
                            "Resultados: \n"+
                            "$"+ getY()+"log_{"+getB()+"}("+getX()+")"+" = "+getSolucion()+"$";
                  //  break;
                case "Raiz":
                     return "\\section{$log_{"+getB()+"}(\\sqrt["+ getY()+"]{"+getX()+"})$}\n" +
                           "Resultados: \n"+
                            "$"+"\\frac{log_{"+getB()+"}("+getX()+")}{"+ getY()+"}"+" = "+getSolucion()+"$";
                  //  break;
                case "Cociente":
                    return "\\section{$log_{"+getB()+"}(\\frac{"+getX()+"}{"+ getY()+"})$}\n" +
                            "Resultados: \n"+
                            "$"+"log_{"+getB()+"}("+getX()+") - log_{"+getB()+"}("+ getY()+")"+" = "+getSolucion()+"$";
                   // break;
                case "Libre":
                     return"\\section{$log_{"+getB()+"}("+getX()+")$}\n" +
                            "Resultados: \n"+
                            "$"+""+getSolucion()+"$";
                   // break;    
                case "Neperiano":
                     return"\\section{$ln("+getX()+")$}\n" +
                            "Resultados: \n"+
                            "$"+""+getSolucion()+"$";
            }
        return "";
   
    }
        @Override
    public String crearSeccionLatexSoloPreguntas() {
         switch(tipo){
                case "Producto":
                    return "\\section{$log_{"+getB()+"}("+getX()+"*"+ getY()+")$}\n";
                  //  break;
                case "Potencia":
                     return "\\section{$log_{"+getB()+"}("+getX()+"^{"+ getY()+"})$}\n";
                  //  break;
                case "Raiz":
                     return "\\section{$log_{"+getB()+"}(\\sqrt["+ getY()+"]{"+getX()+"})$}\n";
                  //  break;
                case "Cociente":
                    return "\\section{$log_{"+getB()+"}(\\frac{"+getX()+"}{"+ getY()+"})$}\n";
                   // break;
                case "Libre":
                    return "\\section{$log_{"+getB()+"}("+getX()+")$}\n";
                   // break;    
                case "Neperiano":
                    return "\\section{$ln("+getX()+")$}\n";
                   // break;    
            }
        return "";
   
    }
}
