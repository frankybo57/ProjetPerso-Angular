/**
* Service recettes
*/
(function(){
	angular.module('RecetteService',[])
	.factory('RecetteFactory', serviceRecetteFactory);

	function serviceRecetteFactory(){
		var serv = this;

		serv.calculTempsTotal = calculTempsTotal;
		serv.formattage = formattage;
		serv.gestionTemps = gestionTemps;

		/**
		 * Calcule la somme des temps de préparation, repos et cuisson d'une recette et la renvoie sous forme d'une string formattée.
		 * @param recette
		 * @return String
		 */
		function calculTempsTotal(recette){
			var retour={
					'min': 0,
					'h' : 0,
					'j' : 0
			};
			if(recette.tempsPreparation){
				serv.gestionTemps(recette.tempsPreparation, retour);
			}
			if(recette.tempsCuisson){
				serv.gestionTemps(recette.tempsCuisson, retour);
			}
			if(recette.tempsRepos){
				serv.gestionTemps(recette.tempsRepos, retour);
			}
			return serv.formattage(retour);
		}

		function formattage(arg){
			var retour = "";
			var min = 0;
			var h = 0;
			var j = 0;
			if(arg.min > 60){
				h = h + Math.ceil(arg.min/60)*60;
				min = arg.min % 60;
			} else {min = arg.min;}
			if(min>0){
				retour = min + ' min ';
			}
			if((arg.h + h) > 60){
				j = j + Math.ceil(arg.h/60)*60;
				h = arg.h % 60;
			}else {h = arg.h;}
			if(h>0){
				retour = h + ' h ' + retour;
			}
			j = j + arg.j;
			if(j>0){
				retour = j + ' j ' + retour;
			}
			return retour;
		}

		function gestionTemps(arg, retour){
			var temp=arg.substring(arg.search("<unite>")+7,arg.search("</unite>"));
			if(temp==="min"){
				retour.min=retour.min+parseInt(arg.substring(arg.search("<nombre>")+8,arg.search("</nombre>")));}
			else if(temp==="h"){
				retour.h=retour.h+parseInt(arg.substring(arg.search("<nombre>")+8,arg.search("</nombre>")));}
			else if(temp==="j"){
				retour.j=retour.j+parseInt(arg.substring(arg.search("<nombre>")+8,arg.search("</nombre>")));}
		}

		return {
			calculTempsTotal : function(recette){
				return serv.calculTempsTotal(recette);
			}
		}
	}

})();
