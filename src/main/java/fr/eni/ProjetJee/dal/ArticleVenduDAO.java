package fr.eni.ProjetJee.dal;

import java.util.ArrayList;

import fr.eni.ProjetJee.bo.ArticleVendu;
import fr.eni.ProjetJee.bo.Categorie;
import fr.eni.ProjetJee.bo.Utilisateur;

public interface ArticleVenduDAO {
	void insert(ArticleVendu article) throws DALException; 
	ArticleVendu select(int id) throws DALException;
	ArrayList<ArticleVendu> select() throws DALException;
	ArrayList<ArticleVendu> selectByUtilisateur(Utilisateur utilisateur) throws DALException;
	ArrayList<ArticleVendu> selectByCategorie(Categorie categorie) throws DALException;
	ArrayList<ArticleVendu> selectByCategorieName(Categorie categorie , String name) throws DALException;
	ArrayList<ArticleVendu> selectByName(String name) throws DALException;
	void delete(int id) throws DALException; 
	void update(ArticleVendu article) throws DALException; 
}
