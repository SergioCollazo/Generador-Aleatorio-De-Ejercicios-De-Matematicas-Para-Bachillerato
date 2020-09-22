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
public class Matriz implements Operacion{
    private String exp1;
    private String exp2;
    private String solucion;
    private String tipo;
    
    public Matriz(String exp1, String exp2, String tipo){
        this.exp1=exp1;
        this.exp2=exp2;
        this.solucion="";
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
    
     @Override
    public String toString(){
        
         switch(tipo){
                case "+":
                    return ""+exp1+" + "+exp2+"";
                  //  break;
                case "-":
                     return ""+exp1+" - "+exp2+"";
                  //  break;
                case "*":
                     return ""+exp1+" * "+exp2+"";
                  //  break;
                case "/":
                    return ""+exp1+" / "+exp2+"";
                   // break;
                case "invert":
                    return ""+exp1+"";
                   // break;
                 case ".":
                    return ""+exp1+" . "+exp2+"";
                   // break;    
            }
        
        
         
        
        
        return "";
   
    }
    
    
    @Override
    public String crearSentenciaMaxima() {
         switch(tipo){
                case "+":
                    return "s_1 : \"matriz.\";tex(x:matrix("+exp1+"),false);tex(y:matrix("+exp2+"),false);tex(x+y,false);";
                  //  break;
                case "-":
                     return "s_1 : \"matriz.\";tex(x:matrix("+exp1+"),false);tex(y:matrix("+exp2+"),false);tex(x-y,false);";
                  //  break;
                case "*":
                     return "s_1 : \"matriz.\";tex(x:matrix("+exp1+"),false);tex(y:matrix("+exp2+"),false);tex(x*y,false);";
                  //  break;
                case "/":
                    return "s_1 : \"matriz.\";tex(x:matrix("+exp1+"),false);tex(y:matrix("+exp2+"),false);tex(x/y,false);";
                   // break;
                case "invert":
                    return "s_1 : \"matrizI.\";tex(x:matrix("+exp1+"),false);tex(invert(x),false);";
                   // break; 
                case ".":
                    return "s_1 : \"matriz.\";tex(x:matrix("+exp1+"),false);tex(y:matrix("+exp2+"),false);tex(x.y,false);";
                   // break;    
            }
        
        return "";
    }

    @Override
    public String crearSolucionMathJax() {
        String toret=this.solucion;
       toret = toret.replaceAll("\\\\ifx\\\\endpmatrix\\\\undefined\\\\pmatrix\\{\\\\else", ""); 
       toret = toret.replaceAll("\\\\ifx\\\\endpmatrix\\\\undefined\\}\\\\else", "");
       toret = toret.replaceAll("\\\\fi", "");//System.err.println(toret);
        return toret;
    }

    @Override
    public void setSolucion(String s){
        this.solucion=s;
    }
    @Override
    public String getSolucion(){
                String toret=this.solucion;
       toret = toret.replaceAll("\\\\ifx\\\\endpmatrix\\\\undefined\\\\pmatrix\\{\\\\else", ""); 
       toret = toret.replaceAll("\\\\ifx\\\\endpmatrix\\\\undefined\\}\\\\else", "");
       toret = toret.replaceAll("\\\\fi", "");//System.err.println(toret);
       return toret;
    }

    @Override
    public String crearSeccionLatex() {
        String toret="";
         switch(tipo){
                case "+":
                    toret= "A + B";
                    break;
                case "-":
                     toret= "A - B";
                    break;
                case "*":
                     toret= "A * B";
                    break;
                case "/":
                    toret= "A / B";
                    break;
                case "invert":
                    toret= "A^{-1}";
                    break;
                 case ".":
                    toret= "A . B";
                    break;    
            }
        
         
         
         return "\\section{$"+toret+"$}\n" +
                    "Resultados: \n" +
                    "\n"+getSolucion()+"\n";
    }
     @Override
    public String crearSeccionLatexSoloPreguntas() {
        String[] toret = getSolucion().split("=");
         return "\\section{$"+toret+"$}\n" +
                    "" +
                 "\n"+toret[0]+" $$\n";
    }
}
