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
<span>Mots de passe</span>
<input name="mdp"type="text">
<input name="souvenir" type="checkbox">
<a>Mots de passe oublié</a>
<button>Connexion</button>
</form>
</body>
</html>