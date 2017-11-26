/**
 * 
 */
var utilisateurs = [
	{
		"id" : 1,
		"login" : "Admin",
		"password" : "Passwort",
		"droits" : "admin"
	}
];

var isUser = function(login){
	for(var utilisateur of utilisateurs){
		if(utilisateur.login === login)return true;
	}
	return false;
};

var getUserByLogin = function(login){
	for(var utilisateur of utilisateurs){
		if(utilisateur.login === login)return utilisateur;
	}
	return null;
};