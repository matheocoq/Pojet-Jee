package fr.eni.ProjetJee.bo;

import java.time.LocalDateTime;

public class Enchere {
	private int noEnchère;
	private LocalDateTime dateEnchère;
	private int montantEnchère;
	private int noUtilisateur;
	private int noArticle;
	
	public Enchere(int noEnchère, LocalDateTime dateEnchère, int montantEnchère, int noUtilisateur, int noArticle) {
		this.noEnchère = noEnchère;
		this.dateEnchère = dateEnchère;
		this.montantEnchère = montantEnchère;
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
	}

	public int getNoEnchère() {
		return noEnchère;
	}

	public void setNoEnchère(int noEnchère) {
		this.noEnchère = noEnchère;
	}

	public LocalDateTime getDateEnchère() {
		return dateEnchère;
	}

	public void setDateEnchère(LocalDateTime dateEnchère) {
		this.dateEnchère = dateEnchère;
	}

	public int getMontantEnchère() {
		return montantEnchère;
	}

	public void setMontantEnchère(int montantEnchère) {
		this.montantEnchère = montantEnchère;
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
