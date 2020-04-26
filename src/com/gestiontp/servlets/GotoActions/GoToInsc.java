package com.gestiontp.servlets.GotoActions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.metier.FiliereMetier;

/**
 * Servlet implementation class GoToInsc
 */
@WebServlet("/gotoinsc")
public class GoToInsc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToInsc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FiliereMetier filiereMetier = new FiliereMetier();
		List<Filiere> fs = filiereMetier.listerTous();
		request.setAttribute("filieres", fs);
		request.getRequestDispatcher("./inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
