package com.gestiontp.servlets.CRUDActions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.TpIMetier;
import com.gestiontp.metier.TpMetier;

/**
 * Servlet implementation class SupprTp
 */
@WebServlet("/SupprTp")
public class SupprTp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprTp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TpIMetier tpmet = new TpMetier();
		String idTp = request.getParameter("idTp");
		Tp t = tpmet.getTpByidTp(Integer.parseInt(idTp));
		tpmet.supprimeTp(t);
		response.getWriter().append("pageTpProf.jsp").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
