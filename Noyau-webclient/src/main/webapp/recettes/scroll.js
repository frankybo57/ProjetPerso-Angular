(function(){
	
	var scr = angular.module('recettesScroll', []);
	
//	scr.run(['$anchorScroll', function($anchorScroll) {
//	  $anchorScroll.yOffset = 50;   // always scroll by 50 extra pixels
//	}]);
	
	scr.controller('recetteScrollController', ['$anchorScroll', '$location', '$scope',
	  function($anchorScroll, $location, $scope) {
	    $scope.gotoAnchor = function(x) {
	      var newHash = 'anchor' + x;
	      if ($location.hash() !== newHash) {
	        // set the $location.hash to `newHash` and
	        // $anchorScroll will automatically scroll to it
	        $location.hash('anchor' + x);
	      } else {
	        // call $anchorScroll() explicitly,
	        // since $location.hash hasn't changed
	        $anchorScroll();
	      }
	    };
	  }
	]);
	
	
})();



