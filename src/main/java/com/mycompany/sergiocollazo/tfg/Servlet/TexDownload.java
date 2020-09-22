/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sergiocollazo.tfg.Servlet;

import com.mycompany.sergiocollazo.tfg.controlers.ControlFicheros;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet(name = "TexDownload", urlPatterns = {"/TexDownload"})
public class TexDownload extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

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
    //    processRequest(request, response);
   
        
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
       // processRequest(request, response);
        ControlFicheros CF = new ControlFicheros();
        
       
        String a=request.getParameter("idtex");
        String filePath=a;
        
        File downloadFile= new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        
        ServletContext context = getServletContext();
        
        String mimeType = context.getMimeType(filePath);
        if(mimeType==null){
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: "+mimeType);
        
        
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        
        String headerKey = "Content-Disposition";
        String headerValue= String.format("attachement; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
        
        OutputStream outStream = response.getOutputStream();
        
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        
        while((bytesRead= inStream.read(buffer))!=-1){
            outStream.write(buffer, 0, bytesRead);
        }
        
        inStream.close();
        outStream.close();
       /*
        //Borrar archivos generados para el funcionamiento de la aplicacion
        CF.borrarFichero(request.getParameter("diroutput"), request.getParameter("id")+".pdf");
        CF.borrarFichero(request.getParameter("diraux"), request.getParameter("id")+".log");
        CF.borrarFichero(request.getParameter("diraux"), request.getParameter("id")+".tex");
        CF.borrarFichero(request.getParameter("diraux"), request.getParameter("id")+".aux");
        */
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
