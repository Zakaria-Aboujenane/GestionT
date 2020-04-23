package com.gestiontp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.EtudiantIMetier;
import com.gestiontp.metier.EtudiantMetier;
import com.gestiontp.metier.FiliereIMetier;
import com.gestiontp.metier.FiliereMetier;
import com.gestiontp.metier.ProfesseurIMetier;
import com.gestiontp.metier.ProfesseurMetier;
import com.gestiontp.metier.TpMetier;

/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FiliereIMetier filiereMetier;
	private EtudiantIMetier etudiantMetier;
	private ProfesseurIMetier professeurMetier;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Start() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
		
		if (sess.getAttribute("role") != null) {
			System.out.println("hello"+sess.getAttribute("role"));
			if (sess.getAttribute("role").equals("Etudiant")) {
				etudiantMetier = new EtudiantMetier();
				String CNE  =sess.getAttribute("CNE")+"";
				System.out.println("hello"+CNE);
				Etudiant e = etudiantMetier.getEtudiantByCNE(CNE);
				List<Professeur> profs = e.getFiliere().getProfesseurs();
				request.setAttribute("profs", profs);
				request.getRequestDispatcher("/pageTpEtudiant.jsp")
				.forward(request, response);
			} else if (sess.getAttribute("role").equals("Professeur")) {
				String CIN = (String) sess.getAttribute("CIN");
				Professeur p = new ProfesseurMetier().getProfesseurByCIN(CIN);
				List<Tp> tps = new TpMetier().ListerTpParProf(p);
				List<Filiere> fs =new FiliereMetier().getTpsByProf(p);
				request.setAttribute("Filieres", fs);
				request.setAttribute("tps", tps);
				professeurMetier = new ProfesseurMetier();
				request.getRequestDispatcher("/pageTpProf.jsp").forward(request, response);
			} else if (sess.getAttribute("role") == "Admin") {
				professeurMetier = new ProfesseurMetier();
				etudiantMetier = new EtudiantMetier();
				List<Etudiant> etds = etudiantMetier.listerTous();
				List<Professeur> profs = professeurMetier.listerTous();
				request.setAttribute("profs", profs);
				request.setAttribute("etudiants", etds);
				request.getRequestDispatcher("/AdminPage.jsp").forward(request, response);
			}
		} else {
			filiereMetier = new FiliereMetier();
			List<Filiere> fs = filiereMetier.listerTous();
			
			request.setAttribute("filieres", fs);
			
			request.getRequestDispatcher("/acceuil.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
