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

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.metier.EtudiantIMetier;
import com.gestiontp.metier.EtudiantMetier;
import com.gestiontp.metier.FiliereIMetier;
import com.gestiontp.metier.FiliereMetier;
import com.gestiontp.metier.ProfesseurIMetier;
import com.gestiontp.metier.ProfesseurMetier;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private EtudiantIMetier metierEtudiant;
	private ProfesseurIMetier metierProfesseur;
	private FiliereIMetier metierFiliere;
	private String MESSAGE = "";
	private String MESSAGE_ERROR = "";
	private static final long serialVersionUID = 1L;
	private String CNE, Password, email, nom, prenom;
	private String age;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();
		metierEtudiant = new EtudiantMetier();
		metierProfesseur = new ProfesseurMetier();
		metierFiliere = new FiliereMetier();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		email = request.getParameter("email");
		Password = request.getParameter("MotDePasse");	
		if (request.getParameter("choix").equals("etudiant")) {
			// seul l etudiant a :
			String f = request.getParameter("selectM1");
			int idF = Integer.parseInt(f);
			Filiere filiere = metierFiliere.getFiliereById(idF);
			CNE = request.getParameter("CNE");
			if (metierEtudiant.getEtudiantByCNE(CNE) == null) {
				// creation de l eutudiant:
				Etudiant e = new Etudiant();
				e.setAge(18);
				e.setCNE(CNE);
				e.setEmail(email);
				e.setFiliere(filiere);
				e.setMotDePasse(Password);
				e.setNom(nom);
				e.setPrenom(prenom);
				e.setRole("Etudiant");
				// ajout:
				metierEtudiant.ajouterEtud(e);
				MESSAGE = "vous avez ete inscrit tant q'etudiant" + " , veuillez entrer vos infos pour vous inscrire:";
				request.setAttribute("message", MESSAGE);
				AllerVerLoginPage(request, response);
			}else {
				MESSAGE_ERROR = "L etudiant avec CNE: "+CNE+" est deja inscrit!";
				request.setAttribute("MESSAGE_ERROR", MESSAGE_ERROR);
				retour(request, response);
			}
		}
		else if (request.getParameter("choix").equals("professeur")) {

			String CIN = request.getParameter("CIN");

			if(!metierProfesseur.verifierExis(CIN)) {
				System.out.println("hello4");
				Professeur p = new Professeur();
				p.setAge(30);
				p.setCIN(CIN);
				p.setEmail(email);
				p.setFilieres(listerFils(request.getParameterValues("FilieresProf")));
				p.setMotDePasse(Password);
				p.setNom(nom);
				p.setPrenom(prenom);
				p.setRole("Professeur");
				// ajout du prof:
				metierProfesseur.ajouterProfesseur(p);
				MESSAGE = "vous avez ete inscrit tant que prof" + " , veuillez entrer vos infos pour vous inscrire:";
				request.setAttribute("message", MESSAGE);
				AllerVerLoginPage(request, response);
			}else {
				MESSAGE_ERROR = "Le prof avec CIN: "+CIN+" est deja inscrit!";
				request.setAttribute("MESSAGE_ERROR", MESSAGE_ERROR);
				retour(request, response);
			}
			
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

	// fonction pour recuperer une liste d filieres selon les ids
	List<Filiere> listerFils(String[] ids) {
		List<Filiere> fs = new ArrayList<Filiere>();
		for (String id : ids) {
			int idF = Integer.parseInt(id);
			Filiere f = metierFiliere.getFiliereById(idF);
			fs.add(f);
		}
		return fs;

	}

	public void AllerVerLoginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("MESSAGE", MESSAGE);
		request.getRequestDispatcher("./login.jsp").forward(request, response);
	}
	public void retour(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("MESSAGE", MESSAGE);
		request.getRequestDispatcher("./inscription.jsp").forward(request, response);
	}

}
