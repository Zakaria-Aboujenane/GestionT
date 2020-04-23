package com.gestiontp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.EtudiantIMetier;
import com.gestiontp.metier.EtudiantMetier;
import com.gestiontp.metier.ProfesseurIMetier;
import com.gestiontp.metier.ProfesseurMetier;
import com.gestiontp.metier.TpMetier;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private EtudiantIMetier metierEtudiant;
	private ProfesseurIMetier metierProfesseur;
	private static final long serialVersionUID = 1L;
	private String MESSAGE = "";
	private String MESSAGE_ERROR = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		metierEtudiant = new EtudiantMetier();
		metierProfesseur = new ProfesseurMetier();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hello"+request.getParameter("choix"));
		if (request.getParameter("choix").equals("etudiant")) {
			System.out.println("helloka");
			String CNE = request.getParameter("CNE");
			String Password = request.getParameter("MotDePasse");
			System.out.println("hello1"+CNE+Password);
			if (metierEtudiant.authentifier(CNE, Password)) {
				HttpSession session = request.getSession();
				Etudiant e = metierEtudiant.getEtudiantByCNE(CNE);
				String Filiere = e.getFiliere().getNomF();
				String email = e.getEmail();
				String nom = e.getNom();
				String prenom = e.getPrenom();
				int age = e.getAge();
				List<Professeur> profs = e.getFiliere().getProfesseurs();
				request.setAttribute("profs",profs);
				System.out.println("hello4"+Filiere+email);
				session.setAttribute("CNE", CNE);
				session.setAttribute("MotDePasse", Password);
				session.setAttribute("Filiere", Filiere);
				session.setAttribute("age", age);
				session.setAttribute("email", email);
				session.setAttribute("nom", nom);
				session.setAttribute("prenom", prenom);
				session.setAttribute("role", e.getRole());
				response.getWriter().write("/GestionTp/start");
			} else {
				response.getWriter().println("etud0");
			}
		} else if (request.getParameter("choix").equals("professeur")) {

			String CIN = request.getParameter("CIN");
			String Password = request.getParameter("MotDePasse");
			if (metierProfesseur.authentifier(CIN, Password)) {
						Professeur p = metierProfesseur.getProfesseurByCIN(CIN);
						String email = p.getEmail();
						int age = p.getAge();
						String role = p.getRole();
						HttpSession session = request.getSession();
						session.setAttribute("CIN", CIN);
						session.setAttribute("MotDePasse", Password);
						session.setAttribute("age", age);
						session.setAttribute("email", email);
						session.setAttribute("role", role);
						response.getWriter().write("/GestionTp/start");
			} else {
			
				response.getWriter().write("prof0");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// traitement if de la bd
		doGet(request, response);
	}

}
