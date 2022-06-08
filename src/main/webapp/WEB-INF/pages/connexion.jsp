<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
<%@ include file="header/header.html"%>
<form action="/tpConnexion/" method="post">
<span>Identifiant</span>
<input name="login" type="text">
<span>Mots de passe</span>
<input name="mdp"type="text">
<input name="souvenir" type="checkbox">
<a>Mots de passe oublié</a>
<button>Connexion</button>
</form>
<a>Crée un compte</a>
</body>
</html>