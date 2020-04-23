package com.gestiontp.dao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="filiere")
public class Filiere implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFil;
	private String nomF;
	private String desc;
	private String dateC;
	private String createur;
	
	@ManyToMany(mappedBy = "filieres",fetch = FetchType.EAGER)
	private List<Professeur> professeurs = new ArrayList<Professeur>();
	
	public int getIdFil() {
		return idFil;
	}
	public void setIdFil(int idFil) {
		this.idFil = idFil;
	}
	public String getNomF() {
		return nomF;
	}
	public void setNomF(String nomF) {
		this.nomF = nomF;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDateC() {
		return dateC;
	}
	public void setDateC(String dateC) {
		this.dateC = dateC;
	}
	public String getCreateur() {
		return createur;
	}
	public void setCreateur(String createur) {
		this.createur = createur;
	}
	public List<Professeur> getProfesseurs() {
		return professeurs;
	}
	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}
	
}
