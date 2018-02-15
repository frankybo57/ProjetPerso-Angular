/**
* Service utilitaires
*/

(function(){
	angular.module('UtilitaireService',[])
	.factory('UtilitaireFactory', serviceUtilitaireFactory);

	function serviceUtilitaireFactory(){
		return{
			creerCollection : function(entier){
				var collection=[];
				for(var i=1;i<=entier;i++){
					collection.push(i);}
				return collection;
			},

		};
	}

})();
