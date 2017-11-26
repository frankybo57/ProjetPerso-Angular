/**
 * 
 */


var getModuleById = function(Id){
	for(var module of modulesActifs){
		if(module.id == Id) return module;
	}
	return null;
}

var getModuleByNom = function(nom){
	for(var module of modulesActifs){
		if(module.nom == nom) return module;
	}
	return null;
}

var getModulesByEtat = function(etat){
	var modulesSet;
	for(var module of modulesActifs){
		if(module.etat == etat) modulesSet.push(module);
	}
	return modulesSet;
}

var getEtatById = function(Id){
	for(var module of modulesActifs){
		if(module.id == Id) return module.etat;
	}
	return null;
}

var getEtatByNom = function(nom){
	for(var module of modulesActifs){
		if(module.nom == nom) return module.etat;
	}
	return null;
}