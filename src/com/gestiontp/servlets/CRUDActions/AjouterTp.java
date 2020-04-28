package com.gestiontp.servlets.CRUDActions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.FiliereMetier;
import com.gestiontp.metier.TpMetier;

/**
 * Servlet implementation class AjouterTp
 */
@WebServlet({ "/AjouterTp", "/addTp" })
public class AjouterTp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterTp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomtp = request.getParameter("titreTp");
		
		String CIN = (String) request.getSession().getAttribute("CIN");
		System.out.print("hello"+nomtp+" "+CIN);
		String matiere = request.getParameter("matiere");
		String filiere = request.getParameter("FilieresProf");
		String contenu = request.getParameter("textArea");
		Filiere f = new FiliereMetier().getFiliereById(Integer.parseInt(filiere));
		Tp t = new Tp();
		t.setTitre(nomtp);
		t.setMatiere(matiere);
		t.setIdFil(Integer.parseInt(filiere));
		t.setFiliere(f);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("");  
		  LocalDateTime now = LocalDateTime.now();  
		  String d  = "";
		  d = now.format(dtf);
		  DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
		  Date date;
		try {
			date = format.parse(d);
			t.setDateAjout(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.setContenu(contenu);
		t.setCIN(CIN);
		String idTp = new TpMetier().ajouterTp(t);
		if(idTp != "") {
			request.getRequestDispatcher("pageTpProf.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
