package com.gestiontp.servlets.CRUDActions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestiontp.dao.EtudiantDAO;
import com.gestiontp.dao.EtudiantIDAO;
import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.EtudiantIMetier;
import com.gestiontp.metier.EtudiantMetier;
import com.gestiontp.metier.TpIMetier;
import com.gestiontp.metier.TpMetier;

/**
 * Servlet implementation class FaireTp
 */
@WebServlet("/fairetp")
public class FaireTp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaireTp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TpIMetier tpMet = new TpMetier();
		EtudiantIMetier etudMetier = new EtudiantMetier();
		
		Etudiant e = etudMetier.getEtudiantByCNE(request.getSession().getAttribute("CNE")+"");
		System.out.println("etud"+e.getNom());
		
		int id;
		try {
		   id = Integer.parseInt(request.getParameter("idTp"));
		}
		catch (NumberFormatException e1)
		{
		   id = 0;
		}
		Tp t = tpMet.getTpByidTp(id);
		System.out.println("tp"+t.getTitre());
		tpMet.toogleFaireTp(t, e);
		response.getWriter().print(id);
	}

}
