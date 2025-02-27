<jsp:include page="header/headerNonConnecter.jsp" />
<%@ page import="fr.eni.ProjetJee.bo.Categorie" %>
<%@ page import="fr.eni.ProjetJee.bo.ArticleVendu" %>
<%@page import="java.util.ArrayList"%>
<span>Liste des Ench�res</span>
<span>Filtre :</span>
<form action="/Projet_ENI-Encheres/" method="get">
<input name="nom" type="text">
<label for="categorie-select">Categorie:</label>
<select name="categorie" id="categorie-select">
    <option value="Toute">Toute</option>
    <%
		ArrayList<Categorie> categories= (ArrayList<Categorie>)request.getAttribute("categories");
		for (Categorie catgorie : categories) {
	%>
    	<option value="<%=catgorie.getNoCategorie() %>"><%=catgorie.getLibelle() %></option>
    <%
		}
    %>
</select>
<button value=true name="rechercher">Rechercher</button>
</form>
<div class="fiche-produits">
	<%
		ArrayList<ArticleVendu> articles= (ArrayList<ArticleVendu>)request.getAttribute("articles");
		for (ArticleVendu article : articles) {
	%>
		<div class="article">
		<img alt="" src="<%= article.getPhoto() %>">
		<span><%= article.getNomArticle() %></span>
		<span>Prix : <%= article.getPrixDeVente() %></span>
		<span>Fin de l'ench�re: <%= article.getDateFinEncheres() %></span>
		<span>Vendeur : <%= article.getUtilisateur().getPseudo() %></span>
		</div>
    <%
		}
    %>
</div>
<jsp:include page="footer/footer.jsp" />