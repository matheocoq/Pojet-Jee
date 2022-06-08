package fr.eni.ProjetJee.bll;

import java.util.ArrayList;

import fr.eni.ProjetJee.bo.ArticleVendu;
import fr.eni.ProjetJee.bo.Categorie;
import fr.eni.ProjetJee.bo.Utilisateur;
import fr.eni.ProjetJee.dal.ArticleVenduDAO;
import fr.eni.ProjetJee.dal.DALException;
import fr.eni.ProjetJee.dal.DAOFactory;

public class ArticleVenduMger {
	
	ArticleVenduDAO articleVenduDAO;
	
	private static ArticleVenduMger instance;
	
	public static ArticleVenduMger getInstance() {
		if (instance == null) {
			instance = new ArticleVenduMger();
		}
		return instance;
	}
	
	private ArticleVenduMger () {
		articleVenduDAO = DAOFactory.getDAOArticleVendu();
	}
	
	public void ajouterArticleVendu(ArticleVendu articleVendu) throws BLLException {
		try {
			articleVenduDAO.insert(articleVendu);
		} catch (DALException e) {
			throw new BLLException("ajouterArticleVendu Error ", e);
		}
	}
	
	public ArticleVendu articleVenduById(int noArticle) throws BLLException {
		try {
			// DAL -> mettre un selectById pas juste select
			return articleVenduDAO.select(noArticle);
		} catch (DALException e) {
			throw new BLLException("articleVenduById Error ", e);
		}
	}
	
	public ArrayList<ArticleVendu> allArticleVendu() throws BLLException {
		try {
			// DAL -> mettre un selectAll pas juste select
			return articleVenduDAO.select();
		} catch (DALException e) {
			throw new BLLException("allArticleVendu Error ", e);
		}
	}
	
	public ArrayList<ArticleVendu> articleVenduByUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			// (DALE -> mettre id du user en parametre pas l'utilisateur en entier)
			return articleVenduDAO.selectByUtilisateur(utilisateur);
		} catch (DALException e) {
			throw new BLLException("articleVenduByUtilisateur Error ", e);
		}
	}
	
	public ArrayList<ArticleVendu> articleVenduByCategorie(Categorie categorie) throws BLLException {
		try {
			// (DALE -> mettre id de la categorie en parametre pas la categorie en entier)
			return articleVenduDAO.selectByCategorie(categorie);
		} catch (DALException e) {
			throw new BLLException("articleVenduByCategorie Error ", e);
		}
	}
	
	public void supprimerArticleVendu(int idArticleVendu) throws BLLException {
		try {
			articleVenduDAO.delete(idArticleVendu);
		} catch (DALException e) {
			throw new BLLException("supprimerArticleVendu Error ", e);
		}
	}
	
	public void majArticleVendu(ArticleVendu articleVendu) throws BLLException {
		try {
			articleVenduDAO.update(articleVendu);
		} catch (DALException e) {
			throw new BLLException("majArticleVendu Error ", e);
		}
	}

}
