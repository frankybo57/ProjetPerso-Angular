/**
 * 
 */



var initVue = function(){
	// Fonction d'initialisation de la vue principale du module de gestion des recettes
	container = $("div.container");
	
	var div = $("<div>").addClass("col-sm-2");
	container.append(div);
	
	// Création de la barre de navigation interne à gauche
	var ul = $("<ul>").addClass("nav nav-pills nav-stacked");
	div.append(ul);
	
	for(var typePlat of typePlats){
		var li = $("<li>").addClass("nav-link");
		li.attr("id",typePlat.ancre);
		li.html("<a href=#ancre"+typePlat.ancre+">"+typePlat.label+"</a>");
		ul.append(li);
	}
	
	// Création de la partie centrale de la page
	div = $("<div>").addClass("panel panel-default");
	div.addClass("col-sm-10");
	container.append(div);
	
	var div2 = $("<div>").addClass("panel-heading");
	div2.text("Liste des recettes");
	
	div.append(div2);
	
	// Création du tableau qui contiendra la liste des rcettes
	var table = $("<table>").addClass("table table-striped");
	table.attr("id","listeRecettes");
	
	var thead = $("<thead>");
	table.append(thead);
	
	var tr = $("<tr>");
	thead.append(tr);
	
	for(var champRecette of champsRecette){
		if(champRecette.id > 7){
			var td = $("<td>").html("<label>"+champRecette.nom+"</label>");
			tr.append(td);
		}
	}
	
	var tbody = $("<tbody>");
	table.append(tbody);
	
	div.append(table);
};

var refreshTable = function(){
	var tbody = $("tbody").empty();
	
	for(var typePlat of typePlats){
		var tr = $("<tr>");
		var td = $("<td>").html("<label>"+typePlat.label+"</label>");
		td.attr("colspan",(champsRecette.length-1));
		tr.append(td);
		tr.attr("id","ancre"+typePlat.ancre)
		tbody.append(tr);
		
		for(var recette of recettes){
			if(recette.typePlat == typePlat.id){
				var tr = $("<tr>");
				for(var champRecette of champsRecette){
					if(champRecette.id > 7){
						var td = $("<td>");
						if(champRecette.nom == "Coût"){
							for(var i=0; i<recette[champRecette.nom];i++){
								var span = $("<span>").addClass("glyphicon glyphicon-euro");
								td.append(span);
							}
						}
						else if(champRecette.nom == "Difficulté"){
							for(var i=0; i<recette[champRecette.nom];i++){
								var span = $("<span>").addClass("glyphicon glyphicon-apple");
								td.append(span);
							}
						}
						else if(champRecette.nom == "Temps de préparation"){
							var label = $("<label>").css("font-weight","normal");
							label.text(parseInt(recette[champRecette.nom])+parseInt(recette["Temps de cuisson"]));
							td.append(label);
						}
						else{
							var label = $("<label>").css({"padding-left":"20px","font-weight":"normal"});
							label.text(recette[champRecette.nom]);
							td.append(label);
						}
						tr.append(td);
						tbody.append(tr);
					}
				}
				
				// Création des boutons d'impression, d'édition et de suppression
				var td = $("<td>");
				td.html("<div class='btn-group'><button type='button' class='btn btn-info btn-sm' onclick='editRecette("+recette.id+")'><span class='glyphicon glyphicon-print'><button type='button' class='btn btn-info btn-sm' onclick='editRecette("+recette.id+")'><span class='glyphicon glyphicon-pencil'></span></button><button type='button' class='btn btn-danger btn-sm' onclick='removeRecetteById("
				+ recette.id
				+ ")'><span class='glyphicon glyphicon-trash'></span></button></div>");
				tr.append(td);
			}
		}
	}
};





















initVue();
refreshTable();