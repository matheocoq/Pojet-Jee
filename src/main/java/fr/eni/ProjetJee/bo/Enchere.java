package fr.eni.ProjetJee.bo;

import java.time.LocalDateTime;

public class Enchere {
	private int noEnch�re;
	private LocalDateTime dateEnch�re;
	private int montantEnch�re;
	private int noUtilisateur;
	private int noArticle;
	
	public Enchere(int noEnch�re, LocalDateTime dateEnch�re, int montantEnch�re, int noUtilisateur, int noArticle) {
		this.noEnch�re = noEnch�re;
		this.dateEnch�re = dateEnch�re;
		this.montantEnch�re = montantEnch�re;
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
	}

	public int getNoEnch�re() {
		return noEnch�re;
	}

	public void setNoEnch�re(int noEnch�re) {
		this.noEnch�re = noEnch�re;
	}

	public LocalDateTime getDateEnch�re() {
		return dateEnch�re;
	}

	public void setDateEnch�re(LocalDateTime dateEnch�re) {
		this.dateEnch�re = dateEnch�re;
	}

	public int getMontantEnch�re() {
		return montantEnch�re;
	}

	public void setMontantEnch�re(int montantEnch�re) {
		this.montantEnch�re = montantEnch�re;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	
	

}
