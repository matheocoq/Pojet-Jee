package fr.eni.ProjetJee.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

import fr.eni.ProjetJee.bll.BLLException;
import fr.eni.ProjetJee.bll.UtilisateurMger;
import fr.eni.ProjetJee.bo.Utilisateur;

import javax.servlet.RequestDispatcher;



/**
 * Servlet implementation class RegisterServer
 */
@WebServlet({"/register","/ajouter"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recuperation de tous les champs
		String speudo = req.getParameter("pseudo");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String rue = req.getParameter("rue");
		String codePostal = req.getParameter("codePostal");
		String ville = req.getParameter("ville");
		String mdp = req.getParameter("mdp");
		String confirmation = req.getParameter("confirmation");
		
		
		if(mdp.equals(confirmation)) {
			
			UtilisateurMger userMgr = UtilisateurMger.getInstance();
			Utilisateur user = new Utilisateur(0, speudo, nom, prenom, email, tel, rue, codePostal, ville, userMgr.generateHash(mdp), 0,false);
			try {
				userMgr.ajouterUtilisateur(user);
				req.getSession().setAttribute("utilisateur", user);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// on redirectionné vers la page d'acceuil du user connecté
			resp.sendRedirect("http://localhost:8080/Projet_ENI-Encheres/");
		}else {
			// veillez saisir un mot de passe identique
			System.out.println("mdp et confirmation sont pas identiques!");
			/*JFrame jFrame = new JFrame();
	        JOptionPane.showMessageDialog(jFrame, "Veillez saisir un mot de passe correct!");*/
	        
		}
		
		
	}

}
