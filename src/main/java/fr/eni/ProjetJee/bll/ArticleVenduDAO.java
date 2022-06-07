package fr.eni.ProjetJee.bll;

import java.util.ArrayList;

import fr.eni.ProjetJee.bo.ArticleVendu;
import fr.eni.ProjetJee.bo.Utilisateur;

public interface ArticleVenduDAO {
	void insert(ArticleVendu article) throws DALException; 
	ArticleVendu select(int id) throws DALException;
	ArrayList<ArticleVendu> select() throws DALException;
	ArrayList<ArticleVendu> selectByUtilisateur(Utilisateur utilisateur) throws DALException;
	void delete(int id) throws DALException; 
	void update(ArticleVendu article) throws DALException; 
}
