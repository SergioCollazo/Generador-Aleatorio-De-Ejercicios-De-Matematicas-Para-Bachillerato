/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sergiocollazo.tfg.Servlet;

import com.mycompany.sergiocollazo.tfg.Operaciones.Derivada;
import com.mycompany.sergiocollazo.tfg.Operaciones.EcuacionGrado2;
import com.mycompany.sergiocollazo.tfg.Operaciones.Integral;
import com.mycompany.sergiocollazo.tfg.Operaciones.Limite;
import com.mycompany.sergiocollazo.tfg.Operaciones.Logaritmo;
import com.mycompany.sergiocollazo.tfg.Operaciones.Matriz;
import com.mycompany.sergiocollazo.tfg.Operaciones.Polinomio;
import com.mycompany.sergiocollazo.tfg.controlers.ControlConfiguracion;
import com.mycompany.sergiocollazo.tfg.controlers.ControlFicheros;
import com.mycompany.sergiocollazo.tfg.controlers.ControlLatex2PDF;
import com.mycompany.sergiocollazo.tfg.controlers.StreamGobbler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet(name = "MaximaResult", urlPatterns = {"/MaximaResult"})
public class MaximaResult extends HttpServlet {
    //Creacion de clases de control
    ControlConfiguracion controlconf= new ControlConfiguracion();
    ControlFicheros CF = new ControlFicheros();
    
    //Asignacion de directorios segun clase de configuracion
    String diretorioMaxima=controlconf.getDirMaxima();
    String direcorioArchivosBatch=controlconf.getDirArchivoBatch();
    
    //Listas Operaciones
    List<EcuacionGrado2> listaEc2Grado;
    List<Polinomio> listaPolinomios;
    List<Logaritmo> listaLogaritmos;
    List<Limite> listaLimites;
    List<Derivada> listaDerivadas;
    List<Integral> listaIntegrales;
    List<Matriz> listaMatrices;
    //Fin Listas Operaciones
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            controlconf.generarID();
            //Creacion lista de todas las Operaciones
            List<String> listaOperaciones = new ArrayList<String>();

            //Procesamiento Listas Operaciones individuales
            listaEc2Grado = ProcesarFormularioEcuacion2Grado(request);
            listaPolinomios = ProcesarFormularioPolinomios(request);
            listaLogaritmos = ProcesarFormularioLogaritmos(request);
            listaLimites = ProcesarFormularioLimites(request);
            listaDerivadas = ProcesarFormularioDerivadas(request);
            listaIntegrales = ProcesarFormularioIntegrales(request);
            listaMatrices = ProcesarFormularioMatrices(request);
            //Añadir Operaciones individuales a listaOperaciones
            Iterator<EcuacionGrado2> iteratorEc2Grado = listaEc2Grado.iterator();
            while (iteratorEc2Grado.hasNext()) {
                listaOperaciones.add(iteratorEc2Grado.next().crearSentenciaMaxima());
            }
            Iterator<Polinomio> iteratorPolinomios = listaPolinomios.iterator();
            while (iteratorPolinomios.hasNext()) {
                listaOperaciones.add(iteratorPolinomios.next().crearSentenciaMaxima());
            }
            Iterator<Logaritmo> iteratorLogaritmos = listaLogaritmos.iterator();
            while (iteratorLogaritmos.hasNext()) {
                listaOperaciones.add(iteratorLogaritmos.next().crearSentenciaMaxima());
            }
            Iterator<Limite> iteratorLimites = listaLimites.iterator();
            while (iteratorLimites.hasNext()) {
                listaOperaciones.add(iteratorLimites.next().crearSentenciaMaxima());
            }
             Iterator<Derivada> iteratorDerivadas = listaDerivadas.iterator();
            while (iteratorDerivadas.hasNext()) {
                listaOperaciones.add(iteratorDerivadas.next().crearSentenciaMaxima());
            }
             Iterator<Matriz> iteratorMatrices = listaMatrices.iterator();
            while (iteratorMatrices.hasNext()) {
                listaOperaciones.add(iteratorMatrices.next().crearSentenciaMaxima());
            }
                Iterator<Integral> iteratorIntegrales = listaIntegrales.iterator();
            while (iteratorIntegrales.hasNext()) {
                listaOperaciones.add(iteratorIntegrales.next().crearSentenciaMaxima());
            }
            //Instruccion de finalizacion
            listaOperaciones.add("s_2 : \"Fin de instrucciones.\";");
            //Crear archivo batch con instrucciones Maxima
            CF.crearFichero(direcorioArchivosBatch, controlconf.getNombreArchivoBatch(), listaOperaciones);
            ejecutarComandoConsola();
            //GENERAR PDF
            generarPDF(1);//Si 1 entonces Generar PDF completo, si 2 entonces solo se generan preguntas
            generarPDF(2);//Si 1 entonces Generar PDF completo, si 2 entonces solo se generan preguntas
            
            
            //HTML Cabecera
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css' integrity='sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh' crossorigin='anonymous'>");
            out.println(" <script src='scriptsMaxima.js'></script><title>TFG</title>"+
                    "<script src='https://polyfill.io/v3/polyfill.min.js?features=es6'></script>"+
                    "<script id='MathJax-script' async src='https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js'></script>"+
                   "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>\n" +
                    "<script src=\"https://unpkg.com/d3@3/d3.min.js\"></script>\n" +
                    "   <script src=\"scripts/function-plot.js\"></script>\n" +
                    "   <script src=\"scripts/scriptsFormularios.js\"></script>"
                    + ""
                    + ""
                    );
            out.println("</head>");
            out.println("<body class='text-center'>");
            out.println("<div class='cover-container d-flex w-100 h-100 p-3 mx-auto flex-column'> ");
            out.println("<header class='masthead mb-auto'><div class='inner'>");
            out.println("<h3 class='masthead-brand'>Resultados</h3>");
            out.println("</div>");
            out.println("</header>");
            out.println("<main role='main' class='inner cover'>");
           
            out.println("<div class='row border' >");
            //Boton descargaPDF, llama al servlet PdfDownload
            out.println("<div class='col' >");
            out.println("<form method='post' action='PdfDownload' name='formularioPDF' >");
            out.println("<input type='text' name='idpdf' value="+controlconf.getDirPDFlatex()+"\\"+controlconf.getNombreArchivoPDF()+"  id='idpdf' style='display: none'>");
            out.println("<input type='text' name='id' value="+controlconf.getId()+"  id='id' style='display: none'>");
            out.println("<input type='text' name='diraux' value="+controlconf.getDirAuxPDFlatex()+"  id='diraux' style='display: none'>");
            out.println("<input type='text' name='diroutput' value="+controlconf.getDirOurputPDFlatex()+"  id='diroutput' style='display: none'>");
            out.println("<button type='submit' class='btn btn-primary' id='formularioPDFsubmit'>Descargar PDF Completo</button>");
            out.println("</form>");
            out.println("</div>");
            //Boton descargaPDFPreguntas, llama al servlet PdfDownloadPreguntas
            out.println("<div class='col' >");
            out.println("<form method='post' action='PdfSoloPreguntas' name='PdfSoloPreguntas' >");
            out.println("<input type='text' name='idpdfpreguntas' value="+controlconf.getDirPDFlatex()+"\\"+controlconf.getNombreArchivoPDFSoloPreguntas()+"  id='idpdfpreguntas' style='display: none'>");
            out.println("<input type='text' name='id' value="+controlconf.getId()+"  id='id' style='display: none'>");
            out.println("<input type='text' name='diraux' value="+controlconf.getDirAuxPDFlatex()+"  id='diraux' style='display: none'>");
            out.println("<input type='text' name='diroutput' value="+controlconf.getDirOurputPDFlatex()+"  id='diroutput' style='display: none'>");
            out.println("<button type='submit' class='btn btn-primary' id='formularioPDFsubmit'>Descargar PDF Preguntas</button>");
            out.println("</form>");
            out.println("</div>");
            //Boton descargaTex, llama al servlet TexDownload
            out.println("<div class='col' >");
            out.println("<form method='post' action='TexDownload' name='TexDownload' >");
            out.println("<input type='text' name='idtex' value="+controlconf.getDirAuxPDFlatex()+"\\"+controlconf.getNombreArchivoTex()+"  id='idtex' style='display: none'>");
            out.println("<input type='text' name='id' value="+controlconf.getId()+"  id='id' style='display: none'>");
            out.println("<input type='text' name='diraux' value="+controlconf.getDirAuxPDFlatex()+"  id='diraux' style='display: none'>");
            out.println("<input type='text' name='diroutput' value="+controlconf.getDirOurputPDFlatex()+"  id='diroutput' style='display: none'>");
            out.println("<button type='submit' class='btn btn-primary' id='formularioTexsubmit'>Descargar Tex</button>");
            out.println("</form>");
            out.println("</div>");
            
            //Boton vuelta atrás
            out.println("<div class='col' >");
            out.println("<button class='btn btn-secondary' type='submit' onclick=\"location.href='http://localhost:8080/SergioCollazo-TFG/';\">Volver</button>");
            out.println("</div>");
            
            out.println("</div>");
        
          
                //Generar HTML para la operacion: Ecuacion Grado 2
                iteratorEc2Grado=listaEc2Grado.iterator();
                while(iteratorEc2Grado.hasNext()){
                EcuacionGrado2 ec = iteratorEc2Grado.next();
                     out.println("<div class='jumbotron'><div class='container'>"
                             + "<div  class=\"canvas_div_pdf\">"+
                                    "Ecuacion: \\("+ec.toString()+"\\)"+"<p> Solucion: "+ ec.crearSolucionMathJax()+" "+ec.getSolucion()+" </p>"+
                               "</div>" +
                               "<div  id=\""+ec.getCodigo()+"\"></div> "
                               + "<div ><script> functionPlot({\n" +
                                         "  target: '#"+ec.getCodigo()+"',\n" +
                                         "  data: [{\n" +
                                         "    fn: '"+ec.getGrafica()+"'\n" +
                                         "  }]\n" +
                                         "    });\n" +
                                         "</script></div>"+        
                                "</div></div>");
                }
                //Generar HTML para la operacion: Polinomios
                iteratorPolinomios=listaPolinomios.iterator();
                while(iteratorPolinomios.hasNext()){
                Polinomio pol = iteratorPolinomios.next();
                     out.println("<div class='jumbotron'><div class='container'>"
                             + "<div  class=\"canvas_div_pdf\">"+
                                    "Ecuacion: \\("+pol.toString()+"\\)"+"<p> Solucion:  "+pol.getSolucion()+" </p>"+
                               "</div>" +
                               "<div  id=\""+pol.getCodigo()+"\"></div> "
                               + "<div ><script> functionPlot({\n" +
                                         "  target: '#"+pol.getCodigo()+"',\n" +
                                         "  data: [{\n" +
                                         "    fn: '"+pol.toString()+"'\n" +
                                         "  }]\n" +
                                         "    });\n" +
                                         "</script></div>"+        
                                "</div></div>");
                }
                //Generar HTML para la operacion: Logaritmo
                iteratorLogaritmos=listaLogaritmos.iterator();
                while(iteratorLogaritmos.hasNext()){
                Logaritmo log = iteratorLogaritmos.next();
                     out.println("<div class='jumbotron'><div class='container' id='pdf'>"+
                        "Logaritmo: \\("+log.toString()+"\\)"+"<p> Solucion: \\["+ log.crearSolucionMathJax()+"\\] \\("+log.getSolucion()+"\\) </p>"+
                        "</div>" +
                        "</div>");
                }
           
                //Generar HTML para la operacion: Limite
                iteratorLimites=listaLimites.iterator();
                while(iteratorLimites.hasNext()){
                Limite lim = iteratorLimites.next();
                
                if(lim.getGrafica().contains("^x")||lim.getGrafica().contains("^-x")){//Para visualizarse bien en exponenciales
                     out.println("<div class='jumbotron'><div class='container' id='pdf'>"+
                        "Limite: \\("+lim.toString()+"\\)"+"<p> Solucion: \\["+ lim.crearSolucionMathJax()+"\\] "+lim.getSolucion()+" </p>"+
                        "</div>" +
                               "<div  id=\""+lim.getCodigo()+"\"></div> "
                               + "<div ><script> functionPlot({\n" +
                                         "  target: '#"+lim.getCodigo()+"',\n" +
                                         "  data: [{\n" +
                                         "    fn: '"+lim.getGrafica()+"',graphType: 'polyline'\n" +
                                         "  }]\n" +
                                         "    });\n" +
                                         "</script></div>"+        
                                "</div>");
                }else{
                     out.println("<div class='jumbotron'><div class='container' id='pdf'>"+
                        "Limite: \\("+lim.toString()+"\\)"+"<p> Solucion: \\["+ lim.crearSolucionMathJax()+"\\] "+lim.getSolucion()+" </p>"+
                        "</div>" +
                               "<div  id=\""+lim.getCodigo()+"\"></div> "
                               + "<div ><script> functionPlot({\n" +
                                         "  target: '#"+lim.getCodigo()+"',\n" +
                                         "  data: [{\n" +
                                         "    fn: '"+lim.getGrafica()+"'\n" +
                                         "  }]\n" +
                                         "    });\n" +
                                         "</script></div>"+        
                                "</div>");
                }
                
                    
                }
                
                 //Generar HTML para la operacion: Derivada
                iteratorDerivadas=listaDerivadas.iterator();
                while(iteratorDerivadas.hasNext()){
                    Derivada der = iteratorDerivadas.next();
                    System.err.println("Graf:  "+der.getGrafica());
                    System.err.println("GrafD:  "+der.getGrafica());
                     if(der.getGrafica().contains("^x")||der.getGrafica().contains("^(x")||der.getGrafica().contains("^-x")){
                      out.println("<div class='jumbotron'><div class='container' id='pdf'><div class='row'> <div class='col-10'>"+
                        "Derivada: \\("+der.toString()+"\\)"+"<p> Solucion: \\["+ der.crearSolucionMathJax()+"\\] "+der.getSolucion()+" </p>"+
                        "</div>" +
                        "<div class='col-2'>"+
                        "<small id='help' class='form-text text-muted'>Algunas funciones trigonometricas o con el formato 'n^x' no pueden mostrarse graficamente.</small>  "+
                        "</div>"
                        + "</div>" +
                         "<div  id=\""+der.getCodigo()+"\"></div><div  id=\""+der.getCodigo()+"segundaD\"></div> "
                               + "<div ><script> functionPlot({\n" +
                                         "  target: '#"+der.getCodigo()+"',\n" +
                                         "  data: [{\n" +
                                         "    fn: '"+der.getGrafica()+"'\n" +
                                         "  , title: 'f(x)',graphType: 'polyline',    derivative: {\n" +
                                        "      fn: '"+der.getGraficaD()+"',graphType: 'polyline',\n" +
                                        "      updateOnMouseMove: true}\n" +
                                        "    },]\n" +
                                         "    });\n" +
                                         "</script></div>"+ 
                                                "<div ><script> functionPlot({\n" +
                                         "  target: '#"+der.getCodigo()+"segundaD',\n" +
                                         "  data: [\n" +
                                        "    { fn: '"+der.getGraficaD()+"',  graphType: 'polyline', color: 'red', title: 'derivada de f(x)' }, ]\n" +
                                         "    });\n" +
                                         "</script></div>"+
                                "</div></div>");}
                     else{
                      out.println("<div class='jumbotron'><div class='container' id='pdf'><div class='row'> <div class='col-10'>"+
                        "Derivada: \\("+der.toString()+"\\)"+"<p> Solucion: \\["+ der.crearSolucionMathJax()+"\\] "+der.getSolucion()+" </p>"+
                        "</div>" +
                        "<div class='col-2'>"+
                        "<small id='help' class='form-text text-muted'> Algunas funciones trigonometricas o con el formato 'n^x' no pueden mostrarse graficamente.</small>  "+
                        "</div>"
                        + "</div>" +
                         "<div  id=\""+der.getCodigo()+"\"></div><div  id=\""+der.getCodigo()+"segundaD\"></div> "
                               + "<div ><script> functionPlot({\n" +
                                         "  target: '#"+der.getCodigo()+"',\n" +
                                         "  data: [{\n" +
                                         "    fn: '"+der.getGrafica()+"'\n" +
                                         "  , title: 'f(x)',    derivative: {\n" +
                                        "      fn: '"+der.getGraficaD()+"',\n" +
                                        "      updateOnMouseMove: true}\n" +
                                        "    },]\n" +
                                         "    });\n" +
                                         "</script></div>"+ 
                                                "<div ><script> functionPlot({\n" +
                                         "  target: '#"+der.getCodigo()+"segundaD',\n" +
                                         "  data: [\n" +
                                        "    { fn: '"+der.getGraficaD()+"',color: 'red', title: 'derivada de f(x)' }, ]\n" +
                                         "    });\n" +
                                         "</script></div>"+
                                "</div></div>");}
                    
                    
                }
                  //Generar HTML para la operacion: Integral
                iteratorIntegrales=listaIntegrales.iterator();
                while(iteratorIntegrales.hasNext()){
                    Integral inte = iteratorIntegrales.next();
                    String solucionIntegralDefError="";
                    if(inte.getSolucion()==""){solucionIntegralDefError="Solucion no disponible. Error en cascada  [una derivada es divergente.]";}
                     out.println("<div class='jumbotron'><div class='container' id='pdf'><div class='row'> <div class='col-10'>"+
                        "Integral: \\("+inte.toString()+"\\)"+"<p> Solucion: \\["+ inte.crearSolucionMathJax()+"\\] "+inte.getSolucion()+solucionIntegralDefError+" </p>"+
                        "</div>" +
                        "<div class='col-2'>"+
                        "<small id='help' class='form-text text-muted'> Algunas funciones trigonometricas o con el formato 'n^x' no pueden mostrarse graficamente.</small>  "+
                        "</div>"
                        + "</div>" +
                         "<div  id=\""+inte.getCodigo()+"\"></div> "
                               + "<div ><script> functionPlot({\n" +
                                         "  target: '#"+inte.getCodigo()+"',\n" +
                                         "  data: [{\n" +
                                         "    fn: '"+inte.getGrafica()+"',range: ["+inte.getN1()+","+inte.getN2()+"],\n" +
                                         "    closed: true\n" +
                                         "  },{ fn: '"+inte.getGrafica()+"' }]\n" +
                                         "    });\n" +
                                         "</script></div>"+        
                                "</div></div>");
                }          
                 //Generar HTML para la operacion: Matriz
                iteratorMatrices=listaMatrices.iterator();
                while(iteratorMatrices.hasNext()){
                    Matriz matr = iteratorMatrices.next();
                    String tipoMatrizShow="";
                    switch(matr.getTipo()){
                            case "+":
                                tipoMatrizShow= "A + B";
                                break;
                            case "-":
                                 tipoMatrizShow= "A - B";
                                break;
                            case "*":
                                 tipoMatrizShow= "A * B";
                                break;
                            case "/":
                                tipoMatrizShow= "A / B";
                                break;
                            case "invert":
                                tipoMatrizShow= "A^{-1}";
                                break;
                             case ".":
                                tipoMatrizShow= "A . B";
                                break;    
                        }
                     out.println("<div class='jumbotron'><div class='container' id='pdf'><div class='row'> <div class='col-10'>"+
                        "<p>\\("+tipoMatrizShow+"\\) Solucion: "+ matr.crearSolucionMathJax()+" </p>"+
                        "</div></div>" +
                        "</div></div>");
                }          
                
                
            //HTML Footer
            out.println("</main>");
            out.println("");
            out.println("<footer class='mastfoot mt-auto'><div class='inner'><p>Sergio Collazo Sorribas | Sergio6010@gmail.com</p></div></footer>");
            out.println("</div></body></html>");
           
          //  borrarArchivosGenerados();
        }
    }
    
    //Borra los archivos generados en el proceso, para liberar espacio en el disco despues de usar la aplicacion
    private void borrarArchivosGenerados(){
       CF.borrarFichero(direcorioArchivosBatch, controlconf.getNombreArchivoBatch());
       CF.borrarFichero(direcorioArchivosBatch, controlconf.getNombreSalidaMaxima());
    }
    
    
    
    private void generarPDF(int opcion) throws IOException {
        ControlLatex2PDF clpdf;
        if(opcion==1){clpdf = new ControlLatex2PDF(controlconf.getDirPDFlatex(),controlconf.getNombreArchivoTex(),controlconf.getDirAuxPDFlatex(),controlconf.getDirOurputPDFlatex());}
        else{clpdf = new ControlLatex2PDF(controlconf.getDirPDFlatex(),controlconf.getNombreArchivoTexSoloPreguntas(),controlconf.getDirAuxPDFlatex(),controlconf.getDirOurputPDFlatex());}
        //ControlLatex2PDF clpdf = new ControlLatex2PDF(controlconf.getDirPDFlatex(),controlconf.getNombreArchivoTex(),controlconf.getDirAuxPDFlatex(),controlconf.getDirOurputPDFlatex());
        List<String> listaSeccionesPDF = new ArrayList<String>();

        Iterator it = listaEc2Grado.iterator();
        while (it.hasNext()) {
            EcuacionGrado2 e = (EcuacionGrado2) it.next();
            if(opcion==1){ listaSeccionesPDF.add(e.crearSeccionLatex());}else{ listaSeccionesPDF.add(e.crearSeccionLatexSoloPreguntas());}
        }
        it = listaPolinomios.iterator();
        while (it.hasNext()) {
            Polinomio e = (Polinomio) it.next();
            if(opcion==1){ listaSeccionesPDF.add(e.crearSeccionLatex());}else{ listaSeccionesPDF.add(e.crearSeccionLatexSoloPreguntas());}
        }
        it = listaLogaritmos.iterator();
        while (it.hasNext()) {
            Logaritmo l = (Logaritmo) it.next();
             if(opcion==1){ listaSeccionesPDF.add(l.crearSeccionLatex());}else{ listaSeccionesPDF.add(l.crearSeccionLatexSoloPreguntas());}
        }
        
        it = listaLimites.iterator();
        while (it.hasNext()) {
            Limite l = (Limite) it.next();
             if(opcion==1){ listaSeccionesPDF.add(l.crearSeccionLatex());}else{ listaSeccionesPDF.add(l.crearSeccionLatexSoloPreguntas());}
        }
        
         it = listaDerivadas.iterator();
        while (it.hasNext()) {
            Derivada l = (Derivada) it.next();
             if(opcion==1){ listaSeccionesPDF.add(l.crearSeccionLatex());}else{ listaSeccionesPDF.add(l.crearSeccionLatexSoloPreguntas());}
        }
        it = listaMatrices.iterator();
        while (it.hasNext()) {
            Matriz l = (Matriz) it.next();
             if(opcion==1){ listaSeccionesPDF.add(l.crearSeccionLatex());}else{ listaSeccionesPDF.add(l.crearSeccionLatexSoloPreguntas());}
        }
        it = listaIntegrales.iterator();
        while (it.hasNext()) {
            Integral l = (Integral) it.next();
             if(opcion==1){ listaSeccionesPDF.add(l.crearSeccionLatex());}else{ listaSeccionesPDF.add(l.crearSeccionLatexSoloPreguntas());}
        }
         if(opcion==1){ CF.crearFichero(controlconf.getDirPDFlatex(), controlconf.getNombreArchivoTex(), clpdf.construirTemplateLatex(listaSeccionesPDF));}
         else{CF.crearFichero(controlconf.getDirPDFlatex(), controlconf.getNombreArchivoTexSoloPreguntas(), clpdf.construirTemplateLatex(listaSeccionesPDF)); }
      //  CF.crearFichero(controlconf.getDirPDFlatex(), controlconf.getNombreArchivoTex(), clpdf.construirTemplateLatex(listaSeccionesPDF));
        try {
            clpdf.ejecutarComandoConsola();
        } catch (InterruptedException ex) {
            Logger.getLogger(MaximaResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private List<EcuacionGrado2> ProcesarFormularioEcuacion2Grado(HttpServletRequest request){
        List<EcuacionGrado2> listaEc=new ArrayList<EcuacionGrado2>();
        String numEc=request.getParameter("NumEcGrado2");
        String a,b,c;
        if(numEc!="0"){
         for(int i=0;i<=Integer.parseInt(numEc)-1;i++){
            a=request.getParameter("a"+i);
            b=request.getParameter("b"+i);
            c=request.getParameter("c"+i);
            if( !(a.equals("0") && b.equals("0") && c.equals("0"))){
            listaEc.add(new EcuacionGrado2(a,b,c,"cod"+i));
         }
         }
        }
      return listaEc;  
    }
    
        private List<Polinomio> ProcesarFormularioPolinomios(HttpServletRequest request){
        List<Polinomio> listaLim=new ArrayList<Polinomio>();
        String num=request.getParameter("NumPolinomios");
        String exp;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("Polinomioexpr"+i);
            
            if( !(exp.equals("0"))){
            listaLim.add(new Polinomio(exp,"Polinomiocod"+i));
         }
         }
        }
        return listaLim;   
    } 
    
    private List<Logaritmo> ProcesarFormularioLogaritmos(HttpServletRequest request){
        List<Logaritmo> listaLogs=new ArrayList<Logaritmo>();
	Iterator<Logaritmo> it = ProcesarFormularioLogaritmosProducto(request).iterator();
         while (it.hasNext()) {
             listaLogs.add(it.next());
         }
         it = ProcesarFormularioLogaritmosRaiz(request).iterator();
         while (it.hasNext()) {
             listaLogs.add(it.next());
         }
         it = ProcesarFormularioLogaritmosPotencia(request).iterator();
         while (it.hasNext()) {
             listaLogs.add(it.next());
         }
         it = ProcesarFormularioLogaritmosCociente(request).iterator();
         while (it.hasNext()) {
             listaLogs.add(it.next());
         }
         it = ProcesarFormularioLogaritmosLibre(request).iterator();
         while (it.hasNext()) {
             listaLogs.add(it.next());
         }
         it = ProcesarFormularioLogaritmosNeperiano(request).iterator();
         while (it.hasNext()) {
             listaLogs.add(it.next());
         }
        return listaLogs;   
    }

    private List<Logaritmo> ProcesarFormularioLogaritmosRaiz(HttpServletRequest request){
        List<Logaritmo> listaLogs=new ArrayList<Logaritmo>();
        
        String num=request.getParameter("NumLogRaiz");
        String x,y,b;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            x=request.getParameter("logRaizx"+i);
            y=request.getParameter("logRaizy"+i);
            b=request.getParameter("logRaizb"+i);
            if( !(x.equals("0") && b.equals("0") && y.equals("0"))){
                 listaLogs.add(new Logaritmo(x, y, b, "Raiz"));
            }
         }
        }
        
	 
        return listaLogs;   
    }
           
    private List<Logaritmo> ProcesarFormularioLogaritmosPotencia(HttpServletRequest request){
        List<Logaritmo> listaLogs=new ArrayList<Logaritmo>();
        String num=request.getParameter("NumLogPotencia");
        String x,y,b;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            x=request.getParameter("logPotenciax"+i);
            y=request.getParameter("logPotenciay"+i);
            b=request.getParameter("logPotenciab"+i);
            if( !(x.equals("0") && b.equals("0") && y.equals("0"))){
                 listaLogs.add(new Logaritmo(x, y, b, "Potencia"));
            }
         }
        }
        return listaLogs;   
    }
        
    private List<Logaritmo> ProcesarFormularioLogaritmosCociente(HttpServletRequest request){
        List<Logaritmo> listaLogs=new ArrayList<Logaritmo>();
        
        String num=request.getParameter("NumLogCociente");
        String x,y,b;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            x=request.getParameter("logCocientex"+i);
            y=request.getParameter("logCocientey"+i);
            b=request.getParameter("logCocienteb"+i);
            if( !(x.equals("0") && b.equals("0") && y.equals("0"))){
                 listaLogs.add(new Logaritmo(x, y, b, "Cociente"));
            }
         }
        }
          return listaLogs;   
    }
        
    private List<Logaritmo> ProcesarFormularioLogaritmosProducto(HttpServletRequest request){
        List<Logaritmo> listaLogs=new ArrayList<Logaritmo>();
        String num=request.getParameter("NumLogProducto");
        String x,y,b;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            x=request.getParameter("logProductox"+i);
            y=request.getParameter("logProductoy"+i);
            b=request.getParameter("logProductob"+i);
            if( !(x.equals("0") && b.equals("0") && y.equals("0"))){
                 listaLogs.add(new Logaritmo(x, y, b, "Producto"));
            }
         }
        }
        return listaLogs;   
    }
    private List<Logaritmo> ProcesarFormularioLogaritmosLibre(HttpServletRequest request){
        List<Logaritmo> listaLogs=new ArrayList<Logaritmo>();
        String num=request.getParameter("NumLogLibre");
        String x,y,b;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            x=request.getParameter("logLibrex"+i);
            //y=request.getParameter("logProductoy"+i);
            b=request.getParameter("logLibreb"+i);
            if( !(x.equals("0") && b.equals("0"))){
                 listaLogs.add(new Logaritmo(x, "", b, "Libre"));
            }
         }
        }
        return listaLogs;   
    }
     private List<Logaritmo> ProcesarFormularioLogaritmosNeperiano(HttpServletRequest request){
        List<Logaritmo> listaLogs=new ArrayList<Logaritmo>();
        String num=request.getParameter("NumLogNeperiano");
        String x;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            x=request.getParameter("logNeperianox"+i);
            //y=request.getParameter("logProductoy"+i);
           // b=request.getParameter("logLibreb"+i);
            if( !(x.equals("0"))){
                 listaLogs.add(new Logaritmo(x, "", "", "Neperiano"));
            }
         }
        }
        return listaLogs;   
    }   
    
        private List<Limite> ProcesarFormularioLimites(HttpServletRequest request){
        List<Limite> listaLim=new ArrayList<Limite>();
	Iterator<Limite> it = ProcesarFormularioLimitesPol(request).iterator();
         while (it.hasNext()) {
             listaLim.add(it.next());
         }
         it = ProcesarFormularioLimitesTri(request).iterator();
         while (it.hasNext()) {
             listaLim.add(it.next());
         }
         it = ProcesarFormularioLimitesCoc(request).iterator();
         while (it.hasNext()) {
             listaLim.add(it.next());
         }
          it = ProcesarFormularioLimitesDif(request).iterator();
         while (it.hasNext()) {
             listaLim.add(it.next());
         }
         it = ProcesarFormularioLimitesExpLog(request).iterator();
         while (it.hasNext()) {
             listaLim.add(it.next());
         }
         
        return listaLim;   
    }
    
      
    private List<Limite> ProcesarFormularioLimitesPol(HttpServletRequest request){
        List<Limite> listaLim=new ArrayList<Limite>();
        String num=request.getParameter("NumLimitePol");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("LimitePolexp"+i);
            val=request.getParameter("LimitePolval"+i);
            if( !(exp.equals("0") && val.equals("0") )){
            listaLim.add(new Limite(exp, "x", val,"cod"));
         }
         }
        }
        return listaLim;   
    }  
    
    private List<Limite> ProcesarFormularioLimitesTri(HttpServletRequest request){
        List<Limite> listaLim=new ArrayList<Limite>();
        String num=request.getParameter("NumLimiteTri");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("LimiteTriexp"+i);
            val=request.getParameter("LimiteTrival"+i);
            if( !(exp.equals("0") && val.equals("0") )){
            listaLim.add(new Limite(exp, "x", val,"cod"));
         }
         }
        }
        return listaLim;   
    }  
    
        private List<Limite> ProcesarFormularioLimitesCoc(HttpServletRequest request){
        List<Limite> listaLim=new ArrayList<Limite>();
        String num=request.getParameter("NumLimiteCoc");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("LimiteCocexp"+i);
            val=request.getParameter("LimiteCocval"+i);
            if( !(exp.equals("0") && val.equals("0") )){
            listaLim.add(new Limite(exp, "x", val,"cod"));
         }
         }
        }
        return listaLim;   
    }  
    
    private List<Limite> ProcesarFormularioLimitesDif(HttpServletRequest request){
        List<Limite> listaLim=new ArrayList<Limite>();
        String num=request.getParameter("NumLimiteDif");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("LimiteDifexp"+i);
            val=request.getParameter("LimiteDifval"+i);
            if( !(exp.equals("0") && val.equals("0") )){
            listaLim.add(new Limite(exp, "x", val,"cod"));
         }
         }
        }
        return listaLim;   
    }      
    private List<Limite> ProcesarFormularioLimitesExpLog(HttpServletRequest request){
        List<Limite> listaLim=new ArrayList<Limite>();
        String num=request.getParameter("NumLimiteExpLog");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("LimiteExpLogexp"+i);
            val=request.getParameter("LimiteExpLogval"+i);
            if( !(exp.equals("0") && val.equals("0") )){
            listaLim.add(new Limite(exp, "x", val,"cod"));
         }
         }
        }
        return listaLim;   
    }      
    
    
    
    private List<Derivada> ProcesarFormularioDerivadas(HttpServletRequest request){
        List<Derivada> listaDer=new ArrayList<Derivada>();
	Iterator<Derivada> it =  ProcesarFormularioDerivadasSim(request).iterator();
         while (it.hasNext()) {
             listaDer.add(it.next());
         }
         it =  ProcesarFormularioDerivadasTri(request).iterator();
         while (it.hasNext()) {
             listaDer.add(it.next());
         }
         it =  ProcesarFormularioDerivadasPot(request).iterator();
         while (it.hasNext()) {
             listaDer.add(it.next());
         }
          it =  ProcesarFormularioDerivadasRaiz(request).iterator();
         while (it.hasNext()) {
             listaDer.add(it.next());
         }
         it =  ProcesarFormularioDerivadasExpLog(request).iterator();
         while (it.hasNext()) {
             listaDer.add(it.next());
         }
         it =  ProcesarFormularioDerivadasComb(request).iterator();
         while (it.hasNext()) {
             listaDer.add(it.next());
         }
         
        return listaDer;   
    }
    
        
        private List<Derivada> ProcesarFormularioDerivadasSim(HttpServletRequest request){
        List<Derivada> listaDer=new ArrayList<Derivada>();
        String num=request.getParameter("NumDerivadaSim");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("DerivadaexprSim"+i);
            val=request.getParameter("DerivadanSim"+i);
            if( !(exp.equals("0") && val.equals("1") )){
            listaDer.add(new Derivada(exp, "x", val,"cod"));
         }
         }
        }
        return listaDer;   
    }  
        private List<Derivada> ProcesarFormularioDerivadasTri(HttpServletRequest request){
        List<Derivada> listaDer=new ArrayList<Derivada>();
        String num=request.getParameter("NumDerivadaTri");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("DerivadaexprTri"+i);
            val=request.getParameter("DerivadanTri"+i);
            if( !(exp.equals("0") && val.equals("1") )){
            listaDer.add(new Derivada(exp, "x", val,"cod"));
         }
         }
        }
        return listaDer;   
    }    
    
    private List<Derivada> ProcesarFormularioDerivadasPot(HttpServletRequest request){
        List<Derivada> listaDer=new ArrayList<Derivada>();
        String num=request.getParameter("NumDerivadaPot");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("DerivadaexprPot"+i);
            val=request.getParameter("DerivadanPot"+i);
            if( !(exp.equals("0") && val.equals("1") )){
            listaDer.add(new Derivada(exp, "x", val,"cod"));
         }
         }
        }
        return listaDer;   
    }        
        
    private List<Derivada> ProcesarFormularioDerivadasRaiz(HttpServletRequest request){
        List<Derivada> listaDer=new ArrayList<Derivada>();
        String num=request.getParameter("NumDerivadaRaiz");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("DerivadaexprRaiz"+i);
            val=request.getParameter("DerivadanRaiz"+i);
            if( !(exp.equals("0") && val.equals("1") )){
            listaDer.add(new Derivada(exp, "x", val,"cod"));
         }
         }
        }
        return listaDer;   
    }        
    private List<Derivada> ProcesarFormularioDerivadasExpLog(HttpServletRequest request){
        List<Derivada> listaDer=new ArrayList<Derivada>();
        String num=request.getParameter("NumDerivadaExpLog");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("DerivadaexprExpLog"+i);
            val=request.getParameter("DerivadanExpLog"+i);
            if( !(exp.equals("0") && val.equals("1") )){
            listaDer.add(new Derivada(exp, "x", val,"cod"));
         }
         }
        }
        return listaDer;   
    }      
    
     private List<Derivada> ProcesarFormularioDerivadasComb(HttpServletRequest request){
        List<Derivada> listaDer=new ArrayList<Derivada>();
        String num=request.getParameter("NumDerivadaComb");
        String exp,val;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("DerivadaexprComb"+i);
            val=request.getParameter("DerivadanComb"+i);
            if( !(exp.equals("0") && val.equals("1") )){
            listaDer.add(new Derivada(exp, "x", val,"cod"));
         }
         }
        }
        return listaDer;   
    }      
    
        private List<Integral> ProcesarFormularioIntegrales(HttpServletRequest request){
        List<Integral> listaIntegrales=new ArrayList<Integral>();
	Iterator<Integral> it = ProcesarFormularioIntegralIndef(request).iterator();
         while (it.hasNext()) {
             listaIntegrales.add(it.next());
         }
        it = ProcesarFormularioIntegralDef(request).iterator();
         while (it.hasNext()) {
             listaIntegrales.add(it.next());
         }
   
        return listaIntegrales;   
    }
        
         
         
       private List<Integral> ProcesarFormularioIntegralIndef(HttpServletRequest request){
         List<Integral> listaInte=new ArrayList<Integral>();
         String num=request.getParameter("NumIntegralIndef");
        String exp;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
           exp=request.getParameter("IntegralIndefexpr"+i);
            if( !(exp.equals("0"))){
            listaInte.add(new Integral(exp, "x","cod"));
         }
         }
        }
        return listaInte;   
    }  
       
      private List<Integral> ProcesarFormularioIntegralDef(HttpServletRequest request){
         List<Integral> listaInte=new ArrayList<Integral>();
         String num=request.getParameter("NumIntegralDef");
        String exp,n,m;
        if(num!="0"){
         for(int i=0;i<=Integer.parseInt(num)-1;i++){
            exp=request.getParameter("IntegralDefexpr"+i);
            n=request.getParameter("IntegralDefn"+i);
            m=request.getParameter("IntegralDefm"+i);
             if( !(exp.equals("0") && n.equals("0") && m.equals("0"))){
            listaInte.add(new Integral(exp, "x",n,m,"cod"));
         }
         }
        }
        return listaInte;   
    }     
       
      
        private List<Matriz> ProcesarFormularioMatrices(HttpServletRequest request){
        List<Matriz> listaMatrices=new ArrayList<Matriz>();
	Iterator<Matriz> it = ProcesarFormularioMatricesBasicas(request).iterator();
         while (it.hasNext()) {
             listaMatrices.add(it.next());
         }
        it = ProcesarFormularioMatricesInvert(request).iterator();
         while (it.hasNext()) {
             listaMatrices.add(it.next());
         }
        it = ProcesarFormularioMatricesMultM(request).iterator();
         while (it.hasNext()) {
             listaMatrices.add(it.next());
         } 
   
        return listaMatrices;   
    }
      
      
        private List<Matriz> ProcesarFormularioMatricesBasicas(HttpServletRequest request){
             List<Matriz> listaMatrices=new ArrayList<Matriz>();
         String num=request.getParameter("NumMatriz");
        String n1,n2,m1,m2,operac;
        String exp1="";String exp2="";
        //System.out.print("NumMatriz:"+num);
        if(num!="0"){
         //[3, 1], [2, 4]
          for(int x=0;x<Integer.parseInt(num);x++){
          n1 = request.getParameter("Matriz1n"+x);   //console.log("Matriz1n:"+x);
          m1 = request.getParameter("Matriz1m"+x);   //console.log("Matriz1m:"+x);
          for(int i=0;i<Integer.parseInt(n1);i++){
              exp1+="[";
            for(int j=0;j<Integer.parseInt(m1);j++){
              exp1+=""+request.getParameter("MatrizInput[1]"+x+"N"+i+"M"+j);
              exp1+=",";  
            }
            exp1=exp1.substring(0, exp1.length() - 1);
            exp1+="],";
          }
           exp1=exp1.substring(0, exp1.length() - 1);
      
          n2 = n1;//request.getParameter("Matriz2n"+x);   //console.log("Matriz1n:"+x);
          m2 = m1;//request.getParameter("Matriz2m"+x);   //console.log("Matriz1m:"+x);
          for(int i=0;i<Integer.parseInt(n2);i++){
              exp2+="[";
            for(int j=0;j<Integer.parseInt(m2);j++){
              exp2+=""+request.getParameter("MatrizInput[2]"+x+"N"+i+"M"+j);
              exp2+=",";  
            }
            exp2=exp2.substring(0, exp2.length() - 1);
            exp2+="],";
          }
           exp2=exp2.substring(0, exp2.length() - 1);
         //  System.out.print("exp2:"+exp2); System.out.print("exp1:"+exp1); 
           operac=request.getParameter("MatrizOp"+x);
          // System.out.print("operac:"+operac);
           listaMatrices.add(new Matriz(exp1,exp2,operac));
           exp2="";exp1="";
        }
        
        }
        return listaMatrices;  
    }
      
        
        private List<Matriz> ProcesarFormularioMatricesInvert(HttpServletRequest request){
            List<Matriz> listaMatrices=new ArrayList<Matriz>();
            String num=request.getParameter("NumMatrizInvert");
            String n1,m1;
            String exp1="";String exp2="";
            System.out.print("NumMatrizInvert:"+num);
            if(num!="0"){
             //[3, 1], [2, 4]
              for(int x=0;x<Integer.parseInt(num);x++){
              n1 = request.getParameter("MatrizInvert1n"+x);   //console.log("Matriz1n:"+x);
              m1 = request.getParameter("MatrizInvert1n"+x); 
              for(int i=0;i<Integer.parseInt(n1);i++){
                  exp1+="[";
                for(int j=0;j<Integer.parseInt(m1);j++){
                  exp1+=""+request.getParameter("MatrizInvertInput[1]"+x+"N"+i+"M"+j);
                  exp1+=",";  
                }
                exp1=exp1.substring(0, exp1.length() - 1);
                exp1+="],";
              }
               exp1=exp1.substring(0, exp1.length() - 1);

             //  System.out.print("exp:"+exp1); 

               listaMatrices.add(new Matriz(exp1,exp2,"invert"));
               exp1="";
            }
        
        }
        return listaMatrices;  
    }
        
      private List<Matriz> ProcesarFormularioMatricesMultM(HttpServletRequest request){
         List<Matriz> listaMatrices=new ArrayList<Matriz>();
        String num=request.getParameter("NumMatrizMultM");
        String n1,n2,m1,m2,operac;
        String exp1="";String exp2="";
        //System.out.print("NumMatriz:"+num);
        if(num!="0"){
         //[3, 1], [2, 4]
          for(int x=0;x<Integer.parseInt(num);x++){
          n1 = request.getParameter("MatrizMultM1n"+x);   //console.log("Matriz1n:"+x);
          m1 =  request.getParameter("MatrizMultM1n"+x);   //console.log("Matriz1n:"+x);
          for(int i=0;i<Integer.parseInt(n1);i++){
              exp1+="[";
            for(int j=0;j<Integer.parseInt(m1);j++){
              exp1+=""+request.getParameter("MatrizMultMInput[1]"+x+"N"+i+"M"+j);
              exp1+=",";  
            }
            exp1=exp1.substring(0, exp1.length() - 1);
            exp1+="],";
          }
           exp1=exp1.substring(0, exp1.length() - 1);
      
          n2 = n1;//request.getParameter("Matriz2n"+x);   //console.log("Matriz1n:"+x);
          m2 = m1;//request.getParameter("Matriz2m"+x);   //console.log("Matriz1m:"+x);
          for(int i=0;i<Integer.parseInt(n2);i++){
              exp2+="[";
            for(int j=0;j<Integer.parseInt(m2);j++){
              exp2+=""+request.getParameter("MatrizMultMInput[2]"+x+"N"+i+"M"+j);
              exp2+=",";  
            }
            exp2=exp2.substring(0, exp2.length() - 1);
            exp2+="],";
          }
           exp2=exp2.substring(0, exp2.length() - 1);
        //   System.out.print("exp2:"+exp2); System.out.print("exp1:"+exp1); 
        //   operac=request.getParameter("MatrizOp"+x);
         //  System.out.print("operac:"+operac);
           listaMatrices.add(new Matriz(exp1,exp2,"."));
           exp2="";exp1="";
        }
        
        }
        return listaMatrices;  
    }    
      
     
    private void ejecutarComandoConsola() throws IOException, InterruptedException {
        String comando = diretorioMaxima + " -b " + controlconf.getNombreArchivoBatch();
        Process process;
        process = Runtime.getRuntime().exec(String.format("cmd.exe /c %s", comando));
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), CF.creaFichero(direcorioArchivosBatch, controlconf.getNombreSalidaMaxima()));
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
        procesarSalidaMaxima(CF.creaFichero(direcorioArchivosBatch, controlconf.getNombreSalidaMaxima()));
    }
    
    public void procesarSalidaMaxima(File salida) throws IOException {
        String cadena;
        List<String> listaauxiliar = new ArrayList<String>();
        List<String> listaauxiliar2 = new ArrayList<String>();
        FileReader f = new FileReader(salida);
        BufferedReader b = new BufferedReader(f);
        boolean procesandoOperacion = false;
        int contadorlineas = 0;
        //Empieza el procesamiento de la salida de Maxima
        while ((cadena = b.readLine()) != null) {
            listaauxiliar.add(cadena);
        }
        b.close();
      
        String elem1 = "";
        String elem2 = "";
        int contadorecuacion = 0;
        int contadorpolinomios = 0;
        int contadorlogs = 0;
        int contadorlimites = 0;
        int contadorderivadas = 0;
        int contadorintegrales = 0;
        int contadormatrices = 0;
        int contadormatricesI = 0;
        int numOp = 0;
        int contadormatrizaux = 0;
        int contadormatrizIaux = 0;
        for (int i = 0; i < listaauxiliar.size() - 2; i++) {
            elem1 = listaauxiliar.get(i);
            elem2 = listaauxiliar.get(i + 1);
          
            if (numeroOperacion(elem1) != 0) {
                numOp = numeroOperacion(elem1);
                procesandoOperacion = true;
            }
            //Procesa las operaciones dependiendo de su tipo
            switch (numOp) {
                case 0:
                    break;
                case 1://Logaritmos
                    //System.out.println("-->"+elem1);
                    if (procesandoOperacion) {
                        if (contadorlineas >= 2) {
                            if (contadorlineas == 3) {
                                listaauxiliar2.add(elem1);
                            }//empieza el log
                            if (contadorlineas >= 4) {//empieza la sol
                                if (!esEntrada(elem2)) { //System.out.println(">"+elem1);
                                    listaauxiliar2.add(elem1);
                                } else {
                                    listaauxiliar2.add(elem1);
                                    procesarSalidaLogaritmo(listaauxiliar2, contadorlogs);
                                    listaauxiliar2.clear();
                                    procesandoOperacion = false;
                                    contadorlineas = 0;
                                    contadorlogs++;
                                }
                            }
                        }
                        if (procesandoOperacion) {
                            contadorlineas++;
                        }
                    }

                    break;
                case 2://EcuacionesGrado2

                    if (procesandoOperacion) {
                        if (contadorlineas >= 2) {
                            if (contadorlineas == 2) {
                                //numComando = numeroComando(elem1);
                                listaauxiliar2.add("codigo");
                                listaauxiliar2.add(elem1);
                            }//empieza la ecuacion
                            if (contadorlineas >= 3) {//empieza la sol
                                if (!esEntrada(elem2)) {
                                    listaauxiliar2.add(elem1);
                                } else {
                                    listaauxiliar2.add(elem1);
                                    procesarSalidaEcuacion2Grado(listaauxiliar2, contadorecuacion);
                                    listaauxiliar2.clear();
                                    procesandoOperacion = false;
                                    contadorlineas = 0;
                                    contadorecuacion++;
                                }
                            }
                        }
                        if (procesandoOperacion) {
                            contadorlineas++;
                        }
                    }

                    break;
                    
                case 3://Limites

                    if (procesandoOperacion) {
                        if (contadorlineas >= 2) {
                            if (contadorlineas == 3) {
                                listaauxiliar2.add(elem1);
                            }//empieza el lim
                            if (contadorlineas >= 3) {//empieza la sol
                                if (!esEntrada(elem2)) {
                                    listaauxiliar2.add(elem1);
                                } else {
                                    listaauxiliar2.add(elem1);
                                    procesarSalidaLimite(listaauxiliar2, contadorlimites);
                                    listaauxiliar2.clear();
                                    procesandoOperacion = false;
                                    contadorlineas = 0;
                                    contadorlimites++;
                                }
                            }
                        }
                        if (procesandoOperacion) {
                            contadorlineas++;
                        }
                    }

                    break;
                    
                    case 4://Derivadas
                        
                    if (procesandoOperacion) {
                        if (contadorlineas >= 2) {
                            if (contadorlineas == 3) {
                               // listaauxiliar2.add(elem1);
                            }//empieza la der
                            if (contadorlineas >= 3) {//empieza la sol
                                if (!esEntrada(elem2)) {
                                    listaauxiliar2.add(elem1);
                                } else {
                                    listaauxiliar2.add(elem1);
                                    procesarSalidaDerivada(listaauxiliar2, contadorderivadas);
                                    listaauxiliar2.clear();
                                    procesandoOperacion = false;
                                    contadorlineas = 0;
                                    contadorderivadas++;
                                }
                            }
                        }
                        if (procesandoOperacion) {
                            contadorlineas++;
                        }
                    }

                    break;  
                    
                    case 5://Integrales

                    if (procesandoOperacion) {
                        if (contadorlineas >= 2) {
                            if (contadorlineas == 3) {
                               // listaauxiliar2.add(elem1);
                            }//empieza la der
                            if (contadorlineas >= 3) {//empieza la sol
                                if (!esEntrada(elem2)) {
                                    listaauxiliar2.add(elem1);
                                } else {
                                    listaauxiliar2.add(elem1);
                                    procesarSalidaIntegral(listaauxiliar2, contadorintegrales);
                                    listaauxiliar2.clear();
                                    procesandoOperacion = false;
                                    contadorlineas = 0;
                                    contadorintegrales++;
                                }
                            }
                        }
                        if (procesandoOperacion) {
                            contadorlineas++;
                        }
                    }

                    break;  
                    case 6://Matrices
                        
                    if (procesandoOperacion) {
                        if (contadorlineas >= 2) {
                            if (contadorlineas == 3) {
                               // listaauxiliar2.add(elem1);
                            }//empieza la der
                            if (contadorlineas >= 3) {//empieza la sol
                                if (!esEntrada(elem2)) {
                                    listaauxiliar2.add(elem1); //System.err.println("W:"+elem1);
                                } else {
                                    if(contadormatrizaux==2){
                                    listaauxiliar2.add(elem1);//System.err.println("Q:"+elem1);
                                    procesarSalidaMatriz(listaauxiliar2, contadormatrices);
                                    listaauxiliar2.clear();
                                    procesandoOperacion = false;
                                    contadorlineas = 0;contadormatrizaux=0;
                                    contadormatrices++;}
                                    else{
                                    listaauxiliar2.add(elem1);contadormatrizaux++;
                                    }
                                    
                                   
                                }
                            }
                        }
                        if (procesandoOperacion) {
                            contadorlineas++;
                        }
                    }

                    break;  
                    case 7://Matrices Invert
                        
                    if (procesandoOperacion) {
                        if (contadorlineas >= 2) {
                            if (contadorlineas == 3) {
                               // listaauxiliar2.add(elem1);
                            }//empieza la der
                            if (contadorlineas >= 3) {//empieza la sol
                                if (!esEntrada(elem2)) {
                                    listaauxiliar2.add(elem1); //System.err.println("W:"+elem1);
                                } else {
                                    if(contadormatrizIaux==1){
                                    listaauxiliar2.add(elem1);//System.err.println("Q:"+elem1);
                                    procesarSalidaMatrizI(listaauxiliar2, contadormatrices);
                                    listaauxiliar2.clear();
                                    procesandoOperacion = false;
                                    contadorlineas = 0;contadormatrizIaux=0;
                                    contadormatrices++;}
                                    else{
                                    listaauxiliar2.add(elem1);contadormatrizIaux++;
                                    }
                                    
                                   
                                }
                            }
                        }
                        if (procesandoOperacion) {
                            contadorlineas++;
                        }
                    }

                    break; 
                    case 8://Polinomios
                        
                    if (procesandoOperacion) {
                        if (contadorlineas >= 2) {
                            if (contadorlineas == 3) {
                               // listaauxiliar2.add(elem1);
                            }//empieza la der
                            if (contadorlineas >= 3) {//empieza la sol
                                if (!esEntrada(elem2)) {
                                    listaauxiliar2.add(elem1);
                                } else {
                                    listaauxiliar2.add(elem1);
                                    procesarSalidaPolinomio(listaauxiliar2, contadorpolinomios);
                                    listaauxiliar2.clear();
                                    procesandoOperacion = false;
                                    contadorlineas = 0;
                                    contadorpolinomios++;
                                }
                            }
                        }
                        if (procesandoOperacion) {
                            contadorlineas++;
                        }
                    }

                    break;  
            }
/*
            if (numeroOperacion(elem1) == 2) {
                procesandoOperacion = true;
            }
*/
        }
   
	}
    
    
     public void procesarSalidaEcuacion2Grado(List<String> list, int n) {
        Iterator it = list.iterator();
        String toret = "";
        boolean flag = true;
        boolean flag2 = true;
        while (it.hasNext()) {
            String a = (String) it.next();
            if (flag && flag2) {
                flag = false;
            } else {
                if (flag2) {
                    //System.out.println("ESTO ES LA ECUACION:"+a);
                    flag2 = false;
                } else {
                    //System.out.println("ESTO ES LA SALIDA:"+a);
                    a = a.replaceAll("sqrt", "\\sqrt");
                    a = a.replaceAll("\\(%.[0-9]+\\)", " ");
                    a = a.replaceAll("\\(", "{");
                    a = a.replaceAll("\\)", "}");
                    a = a.replaceAll("%i", "i");
                    toret += a + "\n";
                }

            }

        }
        listaEc2Grado.get(n).setSolucion(toret);
    }

    public void procesarSalidaLogaritmo(List<String> list, int n) {
        Iterator it = list.iterator();
        String toret = "";
        boolean flag = true;
        while (it.hasNext()) {
            String a = (String) it.next();//System.out.println("AA"+a);
            if (flag) {
                flag = false;
                //System.out.println("ESTO ES LA ECUACION:"+a);
            } else {
                // System.out.println("ESTO ES LA SALIDA:"+a);
                a = a.replaceAll("\\(%.[0-9]+\\)", " ");
                a = a.replaceAll("\\(", "{");
                a = a.replaceAll("\\)", "}");
                a = a.replaceAll("%i", "i");
                toret += a + "\n";
               // System.out.println("ee"+toret);
            }

        }
        listaLogaritmos.get(n).setSolucion(toret);
    }

    
     public void procesarSalidaLimite(List<String> list, int n) {
        Iterator it = list.iterator();
        String toret = "";
        boolean flag = true;
        while (it.hasNext()) {
            String a = (String) it.next();
            if (flag) {
                flag = false;
              //  System.out.println("ESTO ES LIMITE:"+a);
            } else {
              //   System.out.println("ESTO ES LA SALIDA:"+a);
                a = a.replaceAll("\\(%.[0-9]+\\)", " ");
                a = a.replaceAll("\\(", "{");
                a = a.replaceAll("\\)", "}");
                a = a.replaceAll("%i", "i");
                toret += a + "\n";

            }

        }
        listaLimites.get(n).setSolucion(toret);
    }
    
    public void procesarSalidaPolinomio(List<String> list, int n) {
        Iterator it = list.iterator();
        String toret = "";
        while (it.hasNext()) {
            String a = (String) it.next();
                //System.out.println("ESTO ES LA SALIDA:"+a);
                a = a.replaceAll("\\(%.[0-9]+\\)", "     ");
                toret += ""+a+" ";
            }

       //  System.out.println("toret:"+toret);
        listaPolinomios.get(n).setSolucion(toret);
    }
     
    public void procesarSalidaDerivada(List<String> list, int n) {
        Iterator it = list.iterator();
        String toret = "";
        boolean flag = true;
        while (it.hasNext()) {
            String a = (String) it.next();
                //System.out.println("ESTO ES LA SALIDA:"+a);
                a = a.replaceAll("\\(%.[0-9]+\\)", "     ");
                toret += ""+a+" ";
            }

       //  System.out.println("toret:"+toret);
        listaDerivadas.get(n).setSolucion(toret);
    }
          
       public void procesarSalidaIntegral(List<String> list, int n) {
        Iterator it = list.iterator();
        String toret = "";
        boolean flag = true;
        while (it.hasNext()) {
            String a = (String) it.next();
                // System.out.println("ESTO ES LA SALIDA:"+a);
                a = a.replaceAll("\\(%.[0-9]+\\)", "     ");
                toret += ""+a+" ";
            }

       //  System.out.println("toret:"+toret);
        listaIntegrales.get(n).setSolucion(toret);
    }
       
    public void procesarSalidaMatrizI(List<String> list, int n) {
        Iterator it = list.iterator();
        String toret = "";
        int cont = 0;
        int cont2 = 0;
        while (it.hasNext()) {
            String a = (String) it.next();
                // System.out.println("SALIDA:"+a);
                 if(esEntrada(a)){
                 toret+=",  A^{-1} =";
                 }else{
                a = a.replaceAll("\\(%.[0-9]+\\)", "     ");a = a.replaceAll("\\$\\$", "");
                toret += ""+a+" ";
                 }
                
            }toret = "$$ A= "+toret+"$$";
           // System.out.println("result:"+toret);
       //  System.out.println("toret:"+toret);
        listaMatrices.get(n).setSolucion(toret);
    }
       
    public void procesarSalidaMatriz(List<String> list, int n) {
        Iterator it = list.iterator();
        String toret = "";
        int cont = 0;
        int cont2 = 0;
        while (it.hasNext()) {
            String a = (String) it.next();
                // System.out.println("SALIDA:"+a);
                 if(esEntrada(a)){
                 if(cont==1){cont++;cont2++;  toret+="=";}
                 if(cont==0){cont++;cont2++;toret+=listaMatrices.get(n).getTipo();}
                
                 }else{
              
                a = a.replaceAll("\\(%.[0-9]+\\)", "     ");a = a.replaceAll("\\$\\$", "");
                toret += ""+a+" ";
                 }
                
            }toret = "$$"+toret+"$$";
          //  System.out.println("result:"+toret);
       //  System.out.println("toret:"+toret);
        listaMatrices.get(n).setSolucion(toret);
    }
   
    public int numeroOperacion(String cadena){
        if(esLogaritmo(cadena)){ return 1;}
        if(esEcuacionGrado2(cadena)){ return 2;}
        if(esLimite(cadena)){ return 3;}
        if(esDerivada(cadena)){ return 4;}
        if(esIntegral(cadena)){ return 5;}
        if(esMatriz(cadena)){ return 6;}
        if(esMatrizI(cadena)){ return 7;}
        if(esPolinomio(cadena)){ return 8;}
        return 0;//no es ninguna operacion
    }
    
    public char numeroComando(String cadena) {
        return cadena.charAt(3);
    }
    public boolean esPolinomio(String cadena) {
        String patternin = "\\((%i[0-9]+)\\) (s_1:\")(polinomio).\"";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }
     public boolean esMatrizI(String cadena) {
        String patternin = "\\((%i[0-9]+)\\) (s_1:\")(matrizI).\"";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }
    public boolean esMatriz(String cadena) {
        String patternin = "\\((%i[0-9]+)\\) (s_1:\")(matriz).\"";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }
     public boolean esIntegral(String cadena) {
        String patternin = "\\((%i[0-9]+)\\) (s_1:\")(integral).\"";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }

     public boolean esDerivada(String cadena) {
        String patternin = "\\((%i[0-9]+)\\) (s_1:\")(derivada).\"";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }
    
     public boolean esLimite(String cadena) {
        String patternin = "\\((%i[0-9]+)\\) (s_1:\")(limite).\"";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }
    
    public boolean esLogaritmo(String cadena) {
        String patternin = "\\((%i[0-9]+)\\) (s_1:\")(logaritmo).\"";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }

    public boolean esEcuacionGrado2(String cadena) {
        String patternin = "\\((%i[0-9]+)\\) (s_1:\")(ecuacion) (grado) ([2].\")";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }

    public boolean esSalida(String cadena) {
        String patternout = "\\((%o[0-9]+)\\)(.*)";
        boolean matches = Pattern.matches(patternout, cadena);
        return matches;
    }

    public boolean esEntrada(String cadena) {
        String patternin = "\\((%i[0-9]+)\\)(.*)";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }
    /*
    public boolean esString(String cadena) {
        String patternin = "\\((%i[0-9]+)\\) (s_1:\")(matriz).\"";
        boolean matches = Pattern.matches(patternin, cadena);
        return matches;
    }*/
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(MaximaResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(MaximaResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
