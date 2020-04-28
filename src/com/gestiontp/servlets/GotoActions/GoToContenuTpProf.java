package com.gestiontp.servlets.GotoActions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.EtudiantMetier;
import com.gestiontp.metier.TpIMetier;
import com.gestiontp.metier.TpMetier;

/**
 * Servlet implementation class GoToContenuTpProf
 */
@WebServlet("/GoToContenuTpProf")
public class GoToContenuTpProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToContenuTpProf() {
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
		System.out.println("hello "+idTp);
		Tp t = tpmet.getTpByidTp(Integer.parseInt(idTp));
		List<Etudiant> eFTp = new ArrayList<Etudiant>() ;//liste des etudiants qui ont fait le tp
		List<Etudiant> eNFtp = new ArrayList<Etudiant>() ;//liste des etudiants qui n ont pas fait le tp
		if(t.getIdFil() != 0) {
			List<Etudiant> es = new EtudiantMetier().listerTous();
			for (Etudiant e : es) {
				if(tpmet.getFaireTp(t, e)) {
					eFTp.add(e);
				}else if(!tpmet.getFaireTp(t, e)){
					eNFtp.add(e);
				}	
			}
		}
		request.setAttribute("tp", t);
		request.setAttribute("etFTp", eFTp);
		request.setAttribute("etNFTp", eNFtp);
		if(t != null)
			request.getRequestDispatcher("ContenuTpProf.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
