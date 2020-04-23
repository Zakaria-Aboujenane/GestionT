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
		age = request.getParameter("age");
		System.out.println("hello1");
		
		if (request.getParameter("choix").equals("etudiant")) {

			// seul l etudiant a :

			String f = request.getParameter("selectM1");
			int idF = Integer.parseInt(f);
			Filiere filiere = metierFiliere.getFiliereById(idF);
			CNE = request.getParameter("CNE");

			if (metierEtudiant.getEtudiantByCNE(CNE) != null) {
				// creation de l eutudiant:
				Etudiant e = new Etudiant();
				e.setAge(Integer.parseInt(age));
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
				AllerVerLoginPage(request, response);
			}else {
				MESSAGE_ERROR = "L etudiant avec CNE: "+CNE+" est deja inscrit!";
				AllerVerLoginPage(request, response);
			}
		}
		else if (request.getParameter("choix").equals("professeur")) {
			System.out.println("hello2");
			String CIN = request.getParameter("cin");
			System.out.println("hello3");
			if(!metierProfesseur.verifierExis(CIN)) {
				System.out.println("hello4");
				Professeur p = new Professeur();
				p.setAge(Integer.parseInt(age));
				p.setCIN(CIN);
				p.setEmail(email);
				System.out.println("coucou1");
				p.setFilieres(listerFils(request.getParameterValues("FilieresProf")));
				System.out.println("coucou0.5");
				System.out.println("coucou2"+p.getFilieres().get(0));
				p.setMotDePasse(Password);
				p.setNom(nom);
				p.setPrenom(prenom);
				p.setRole("Professeur");
				System.out.println("coucou4");
				// ajout du prof:
				metierProfesseur.ajouterProfesseur(p);
				System.out.println("good !");
				MESSAGE = "vous avez ete inscrit tant que prof" + " , veuillez entrer vos infos pour vous inscrire:";
				AllerVerLoginPage(request, response);
			}else {
				MESSAGE_ERROR = "Le prof avec CIN: "+CIN+" est deja inscrit!";
				AllerVerLoginPage(request, response);
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
		request.getRequestDispatcher("/GestionTp/login").forward(request, response);
	}

}
