/**
 * 
 */

var initNavigation = function(){
	var div = $("#container");
	
	var ul = $("<ul>").addClass("nav nav-tabs");
	div.append(ul);
	
	// Onglet acceuil
	if(getEtatByNom("Noyau")=="Actif"){
		var li = $("<li>").addClass("nav-item");
		ul.append(li);
		
		li.attr("id","noyauTab");

		var a = $("<a>").addClass("nav-link active");
		li.append(a);
		
		a.attr("href","../../NoyauView/WebContent/noyauView.html");
		a.text("Acceuil");
	}
	
	// Onglet admin
	if(getEtatByNom("Admin")=="Actif"){
		var li = $("<li>").addClass("nav-item");
		ul.append(li);
		
		li.attr("id","adminTab");

		var a = $("<a>").addClass("nav-link active");
		li.append(a);
		
		a.attr("href","../../ModuleAdminView/WebContent/adminView.html");
		a.text("Admin");
	}
	
	// Onglet stock
	if(getEtatByNom("ModuleStock")=="Actif"){
		var li = $("<li>").addClass("nav-item");
		li.attr("id","stockTab");
		
		var a = $("<a>").addClass("nav-link");
		a.attr("href","../../ModuleStockView/WebContent/stockView.html");
		a.text("Gestion du stock");
		
		li.append(a);
		ul.append(li);
	}
	
	// Onglet recettes
	if(getEtatByNom("ModuleRecette")=="Actif"){
		var li = $("<li>").addClass("nav-item");
		li.attr("id","recetteTab");
		
		var a = $("<a>").addClass("nav-link");
		a.attr("href","../../ModuleRecetteView/WebContent/recetteView.html");
		a.text("Gestion des recettes");
		
		li.append(a);
		ul.append(li);
	}
	
	// Onglet courses
	if(getEtatByNom("ModuleCourse")=="Actif"){
		var li = $("<li>").addClass("nav-item");
		li.attr("id","courseTab");
		
		var a = $("<a>").addClass("nav-link");
		a.attr("href","../../ModuleCourseView/WebContent/courseView.html");
		a.text("Gestion des courses");
		
		li.append(a);
		ul.append(li);
	}
	
	// Onglet menu
	if(getEtatByNom("ModuleMenu")=="Actif"){
		var li = $("<li>").addClass("nav-item");
		li.attr("id","menuTab");
		
		var a = $("<a>").addClass("nav-link");
		a.attr("href","../../ModuleMenuView/WebContent/menuView.html");
		a.text("Gestion des menus");
		
		li.append(a);
		ul.append(li);
	}
	
	// Onglet menu
	if(getEtatByNom("ModuleCalculatrice")=="Actif"){
		var li = $("<li>").addClass("nav-item");
		li.attr("id","calculatriceTab");
		
		var a = $("<a>").addClass("nav-link");
		a.attr("onclick","ouvrirCalculatrice()");
		a.text("Calculatrice");
		
		li.append(a);
		ul.append(li);
	}
	
	
};

var ouvrirCalculatrice = function(){
	var position = screen.width - 200;
	window.open("../../ModuleCalculatriceView/WebContent/calculatriceView.html","newwindow","width=500,height=620,left="+position);
};

initNavigation();