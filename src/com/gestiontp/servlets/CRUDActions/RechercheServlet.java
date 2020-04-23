package com.gestiontp.servlets.CRUDActions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.EtudiantIMetier;
import com.gestiontp.metier.EtudiantMetier;
import com.gestiontp.metier.TpIMetier;
import com.gestiontp.metier.TpMetier;

/**
 * Servlet implementation class RechercheServlet
 */
@WebServlet("/search")
public class RechercheServlet extends HttpServlet {
	private TpIMetier tpMetier;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheServlet() {
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
		String CNE = request.getSession().getAttribute("CNE") + "";
		System.out.println("cne " + CNE);
		EtudiantIMetier etudMetier = new EtudiantMetier();
		Etudiant e = etudMetier.getEtudiantByCNE(CNE);
		String searchString = request.getParameter("searchString");
		tpMetier = new TpMetier();
		System.out.println(searchString+" "+e.getFiliere().getIdFil());
		List<Tp> tps = tpMetier.rechercheGenerale(e.getFiliere().getIdFil(), searchString);
		System.out.println("cfil id " + e.getFiliere().getIdFil());
		String content = "";
		for (Tp tp : tps) {

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
					+ "					<h5>Matiere : " + tp.getMatiere() + "</h5>\r\n";
			if (tpMetier.getFaireTp(tp, e)) {
				System.out.println("good");
				content += "<input type=\"checkbox\" checked onchange=\"changeStatusTp(" + tp.getIdTp()
						+ ")\" name=\"Fairetp\" id=\" " + tp.getIdTp()
						+ "\"> <span class=\"spanC\">si le tp est fait cocher ici si non <br/> ne cochez pas </span>";
			} else if (!tpMetier.getFaireTp(tp, e)) {
				System.out.println("nope");
				content += "<input type=\"checkbox\" onchange=\"changeStatusTp(" + tp.getIdTp()
						+ ")\" name=\"Fairetp\" id=\" " + tp.getIdTp()
						+ " \"> <spanclass=\"spanC\" >si le tp est fait cocher ici si non <br/> ne cochez pas</span>";
			}
			content += "                <h5>voir Le tp:  <a href=\"#\">Cliquer ici</a> </p>\r\n"
					+ "           		</div>\r\n" + "           \r\n" + "        </div>";
		}

		response.getWriter().print(content);
	}

}
