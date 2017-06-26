/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.presentation;

import com.mycompany.provaesame.Messaggi;
import com.mycompany.provaesame.Utenti;
import com.mycompany.service.FiltroUtente;
import com.mycompany.service.MessaggioService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */
@WebServlet(urlPatterns = "/add")

public class CreaMessaggioServlet extends HttpServlet {

    @Inject
    MessaggioService messaggioservice;

    @Inject
    FiltroUtente filtroutente;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Messaggi mex = new Messaggi();

        String str2 = req.getParameter("contenuto");

        mex.setContenuto(str2); //in questo modo ho messo il contenuto dentro mex

        filtroutente.getUt();

        mex.setIdUtente(filtroutente.getUt());

        messaggioservice.save(mex);

        resp.sendRedirect("ListaMessaggi.jsp");

        System.out.println(mex);

    }

}
