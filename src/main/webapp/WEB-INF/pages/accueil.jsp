<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<form  method="post">
<button class="rotating" name="choix" value="pierre" ><img src="<%= request.getContextPath() %>/image/chi.png" height ="80" width="100" /></button>
<button class="rotating" name="choix" value="fueille"><img src="<%= request.getContextPath() %>/image/fou.png" height ="80" width="100" /></button>
<button class="rotating" name="choix" value="ciseaux"><img src="<%= request.getContextPath() %>/image/mi.png" height ="80" width="100" /></button>
</form>
</body>
</html>