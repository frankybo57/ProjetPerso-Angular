/**
 * 
 */

var getRecetteById = function(id){
	for(var recette of recettes){
		if(recette.id == id) return recette;
	}
	return null;
}

var removeRecetteById = function(id){
	for(var i = 0; i < recettes.length; i++){
		var recette = recettes[i];
		if(recette.id == id){
			recettes.splice(i,1);
			refreshTable();
			return true;
		}
	}
	return false;
}