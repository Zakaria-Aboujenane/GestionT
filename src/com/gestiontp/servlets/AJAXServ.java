package com.gestiontp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestiontp.dao.EtudiantDAO;
import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.EtudiantIMetier;
import com.gestiontp.metier.EtudiantMetier;
import com.gestiontp.metier.TpIMetier;
import com.gestiontp.metier.TpMetier;

/**
 * Servlet implementation class AJAXServ
 */
@WebServlet("/AJAXServ")
public class AJAXServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AJAXServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EtudiantIMetier etudiantMetier;
		TpIMetier tpMet = new TpMetier();
		tpMet.listerTous();
		String CNE = request.getParameter("cne");
		System.out.println("cne : " + CNE);
		etudiantMetier = new EtudiantMetier();
		Etudiant etudiant = etudiantMetier.getEtudiantByCNE(CNE);
		System.out.println("cne : " + etudiant.getNom());
		List<Tp> tps = etudiantMetier.getEtudiantTp(etudiant);
		request.setAttribute("tps", tps);
		
		String content = "";
		for (Tp tp : tps) {
			System.out.println("tp fait :");
			System.out.println("tp fait :"+tpMet.getFaireTp(tp, etudiant));
			content += "  <div class=\"card\">\r\n" + "            <div class=\"thumbnail\">\r\n"
					+ "                <img src=\"./photo/png.png\" class=\"left\">\r\n" + "            </div>\r\n"
					+ "            <div class=\"right\">\r\n" + "                <h1>" + tp.getTitre() + "</h1>\r\n"
					+ "           <div class=\"author\">\r\n"
					+ "               <img src=\"./photo/profile.png\" alt=\"\">\r\n" + "               <h2>"
					+ tp.getProfesseur().getNom() + " " + tp.getProfesseur().getPrenom() + "</h2>\r\n"
					+ "           </div>\r\n" + "          \r\n" + "           <div class=\"seperator\"></div>\r\n"
					+ "                <h5>Ajoute le: " + tp.getDateAjout() + "</h5>\r\n"
					+ "                <h5>Dernier Delai: " + tp.getDateAjout() + "</h5>\r\n"
					+ "                <h5>Email du prof: " + tp.getProfesseur().getEmail() + "</h5>\r\n"
					+ "					<h5>Matiere : " + tp.getMatiere() + "</h5>\r\n"
					+ "                <h5>voir Le tp:  <a href=\"#\">Cliquer ici</a> </p>\r\n"
					+ "           </div>\r\n" + "           \r\n" + "        </div>";
		}
		etudiant = null;
		response.getWriter().print(content);
	}

}
