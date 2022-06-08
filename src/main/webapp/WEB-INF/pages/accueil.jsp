<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<%@ include file="header/headerConnecter.html"%>
<span>Liste des Enchères</span>
<span>Filtre :</span>
<form action="/recherche/" method="post">
<input name="recherche" type="text">
<label for="categorie-select">Choose a pet:</label>
<select name="categorie" id="categorie-select">
    <option value="Toute">Toute</option>
    <option value="dog">Dog</option>
</select>
<button>Rechercher</button>
</form>
<div class="fiche-produit">
</div>
</body>
</html>