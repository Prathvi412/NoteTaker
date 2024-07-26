package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.entities.Note;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveNoteServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);
            note.setAddedDate(new Date());

            // Hibernate save
            Session session = FactoryProvider.getFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(note);
            tx.commit();
            session.close();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Note is added successfully</h1>");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error saving note", e);
        }
    }
}
