/**
 * 
 */
var container = $("#container");

var initMotDePasse = function(){
	container.empty();
	
	var div = $("<div>").addClass("panel panel-default");
	container.append(div);
	
	var div2 = $("<div>").addClass("panel panel-heading");
	div2.html("<h1>Connexion au mode admin</h1>");
	div.append(div2);
	
	div2 = $("<div>").addClass("panel panel-body");
	div.append(div2);
	
	var form = $("<form>").attr("name","mdp");
	div2.append(form);
	
	div = $("<div>").addClass("form-group");
	form.append(div);
	
	// Champ de saisie login
	var label = $("<label>").attr("for","login");
	label.text("Login");
	div.append(label);
	
	var input = $("<input>").addClass("form-control");
	input.attr("type","text");
	input.attr("id","login");
	input.css("width","400px");
	div.append(input);
	
	div = $("<div>").addClass("form-group");
	form.append(div);
	
	// Champ de saisie mot de passe
	label = $("<label>").attr("for","password");
	label.text("Mot de passe");
	div.append(label);
	
	input = $("<input>").addClass("form-control");
	input.attr("type","password");
	input.attr("id","password");
	input.css("width","400px");
	div.append(input);
	
	// Bouton confirmer
	var button = $("<button>").addClass("btn btn-success");
	button.attr("onclick","testLogin()");
	button.attr("type","button");
	button.html("<span class=\"glyphicon glyphicon-ok\"></span>")
	form.append(button);
	
	// Bouton effacer
	button = $("<button>").addClass("btn btn-danger");
	button.attr("onclick","effacer()");
	button.attr("type","button");
	button.html("<span class=\"glyphicon glyphicon-remove\"></span>")
	form.append(button);
	
	// Bouton retour
	var a = $("<a>").addClass("btn btn-warning");
	a.attr("href","../../NoyauView/WebContent/noyauView.html");
	a.html("<span class=\"glyphicon glyphicon-arrow-left\"></span>")
	form.append(a);
};

var effacer = function(){
	// Effacement des champs "login" et "password" de l'écran de connexion au mode admin.
	$("#login").value = "";
	$("#password").value = "";
	
	initMotDePasse();
};

var testLogin = function(){
	var login = encodeURIComponent($("#login").val());
	var password = encodeURIComponent($("#password").val());
	
	if(isUser(login)){
		if(getUserByLogin(login).password == password)initAdmin();
		else{initMotDePasse();}
	}
	else{initMotDePasse();}
};

var initAdmin = function(){
	container.empty();
	
	var div = $("<div>").addClass("panel panel-default");
	container.append(div);
	
	var div2 = $("<div>").addClass("panel panel-heading");
	div2.html("<h1>Mode Admin</h1>");
	div.append(div2);
	
	div2 = $("<div>").addClass("panel panel-body");
	div.append(div2);
	
	// Cadrant de gestion des différents utilisateurs
	var div3 = $("<div>").addClass("col-sm-6");
	div2.append(div3);
	
	var div4 =  $("<div>").addClass("panel panel-heading");
	div4.html("<h2>Gestion des utilisateurs</h2>");
	div3.append(div4);
	
	div4 = $("<div>").addClass("panel panel-body");
	div3.append(div4);
	
	var table = $("<table>").addClass("table table-striped");
	table.attr("id","tableUtilisateurs");
	div4.append(table);
	
	initTableUtilisateurs();
	
	// Cadrant de gestion des modules
	div3 = $("<div>").addClass("col-sm-6");
	div2.append(div3);
	
	var div4 =  $("<div>").addClass("panel panel-heading");
	div4.html("<h2>Gestion des modules</h2>");
	div3.append(div4);
	
	div4 = $("<div>").addClass("panel panel-body");
	div3.append(div4);
	
	var table = $("<table>").addClass("table table-striped");
	table.attr("id","tableModules");
	div4.append(table);
	
	initTableModules();
};

var initTableUtilisateurs = function(){
	var table = $("#tableUtilisateurs");
	
	var thead = $("<thead>");
	table.append(thead);
	
	var tr = $("<tr>");
	thead.append(tr);
	
	var td = $("<td>");
	tr.append(td);
	td.html("<label>Login</label>");
	
	td = $("<td>");
	tr.append(td);
	td.html("<label>Password</label>");
	
	td = $("<td>");
	tr.append(td);
	td.html("<label>Droits</label>");
	
	td = $("<td>");
	tr.append(td);
	td.html("<label>Opérations</label>");
	
	var tbody = $("<tbody>").attr("id","tableUtilisateurs");
	table.append(tbody);
	
	refreshTableUtilisateurs();
};

var initTableModules = function(){
	var table = $("#tableModules");
	
	var thead = $("<thead>");
	table.append(thead);
	
	var tr = $("<tr>");
	thead.append(tr);
	
	var td = $("<td>");
	tr.append(td);
	td.html("<label>Module</label>");
	
	td = $("<td>");
	tr.append(td);
	td.html("<label>Etat</label>");
	
	td = $("<td>");
	tr.append(td);
	td.html("<label>Opérations</label>");
	
	var tbody = $("<tbody>").attr("id","tableModules");
	table.append(tbody);
	
	refreshTableModules();
};

var refreshTableUtilisateurs = function(){
	tbody = $("tbody#tableUtilisateurs");
	tbody.empty();
	
	for(var utilisateur of utilisateurs){
		var tr = $("<tr>");
		
		var td = $("<td>");
		tr.append(td);
		td.text(utilisateur.login);
		
		td = $("<td>");
		tr.append(td);
		td.text("******");
		//td.text(utilisateur.password);
		
		td = $("<td>");
		tr.append(td);
		td.text(utilisateur.droits);
		
		tbody.append(tr);
	}
};

var refreshTableModules = function(){
	tbody = $("tbody#tableModules");
	tbody.empty();
	
	for(var module of modules){
		var tr = $("<tr>");
		
		var td = $("<td>");
		tr.append(td);
		td.text(module.nom);
		
		td = $("<td>");
		tr.append(td);
		td.text(module.etat);
		//td.text(utilisateur.password);
		
		tbody.append(tr);
	}
};








initMotDePasse();