package fr.eni.ProjetJee.ihm;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ProjetJee.bll.ArticleVenduMger;
import fr.eni.ProjetJee.bll.BLLException;
import fr.eni.ProjetJee.bll.CategorieMger;
import fr.eni.ProjetJee.bo.ArticleVendu;
import fr.eni.ProjetJee.bo.Categorie;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("")
public class AccueilServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieMger categorieMger = CategorieMger.getInstance();
		ArticleVenduMger articleVenduMger = ArticleVenduMger.getInstance();
		 try {
			ArrayList<ArticleVendu> articles=articleVenduMger.allArticleVendu();
			List<Categorie> categories = categorieMger.getCategories();
			request.setAttribute("categories", categories);
			request.setAttribute("articles", articles);
			Object seesion = request.getSession().getAttribute("utilisateur");
			if(seesion!=null) {
				request.getRequestDispatcher("WEB-INF/pages/accueil.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("WEB-INF/pages/accueilNonCo.jsp").forward(request, response);
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieMger categorieMger = CategorieMger.getInstance();
		ArticleVenduMger articleVenduMger = ArticleVenduMger.getInstance();
		Object session = request.getSession().getAttribute("utilisateur");
		ArrayList<ArticleVendu> articles=null;
		if(session!=null) {
			
		}
		else {
			String nom= request.getParameter("recherche");
			String categorie= request.getParameter("categorie");
			System.out.println(nom);
			System.out.println(categorie);
			try {
				articles=articleVenduMger.allArticleVendu();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 try {
			
			List<Categorie> categories = categorieMger.getCategories();
			request.setAttribute("categories", categories);
			request.setAttribute("articles", articles);
			
			if(session!=null) {
				request.getRequestDispatcher("WEB-INF/pages/accueil.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("WEB-INF/pages/accueilNonCo.jsp").forward(request, response);
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
