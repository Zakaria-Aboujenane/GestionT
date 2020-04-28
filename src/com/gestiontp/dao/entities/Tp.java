package com.gestiontp.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import utils.HibernateUtil;

@Entity
@Table(name="tp")
public class Tp implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTp;
	private String titre;
	private String contenu;
	private Date dateAjout;
	private String CIN;
	private int idFil;
	private String matiere;
	
	@OneToOne
	@JoinColumn(name="CIN",
				referencedColumnName = "CIN",
				insertable = false,updatable = false)
	private Professeur professeur;
	
	@OneToOne
	@JoinColumn(name="idFil",
				referencedColumnName = "idFil",
				insertable = false,updatable = false)
	private Filiere filiere;
	
	@ManyToMany
	@JoinTable(
			name="voirtp",
			joinColumns = {@JoinColumn(name="idTp")},
			inverseJoinColumns = {@JoinColumn(name="CNE")}
			)
	private List<Etudiant> etudiants = new ArrayList<Etudiant>();

	//getters-setters:
	public int getIdTp() {
		
		return idTp;
	}

	public void setIdTp(int idTp) {
		this.idTp = idTp;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public int getIdFil() {
		return idFil;
	}

	public void setIdFil(int idFil) {
		this.idFil = idFil;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	
	
	

}
