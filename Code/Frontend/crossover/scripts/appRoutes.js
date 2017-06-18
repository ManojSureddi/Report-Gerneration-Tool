/*
 * INSTRUCTIONS
 * Add all your routes here. Please follow the SAME STRUCTURE with PROPER INDENTATION.
 * Before adding a route please check whether it's app name is already added.
 */
define([],function() {
	return {
		defaultRoutePaths : '/workspaces/user',
		routes : {
			// Login
			'/login' : {								// loginRemoveSM
				templateUrl : 'views/login.html', 		// loginRemoveSM
				controller : 'indexController', 				// loginRemoveSM
				dependencies : [   						// loginRemoveSM
					'scripts/controller/controller.js',
					'scripts/directive/directive.js',
					{} 			// loginRemoveSM
				]										// loginRemoveSM
			},
			'/home' : {								// loginRemoveSM
				templateUrl : 'views/home.html', 		// loginRemoveSM
				controller : 'HomeController', 				// loginRemoveSM
				dependencies : [   						// loginRemoveSM
					'scripts/jquery.jqplot.min.js',
					'scripts/jqplot.barRenderer.min.js',
					'scripts/jqplot.pieRenderer.min.js',
					'scripts/jqplot.pointLabels.min.js',
					'scripts/jqplot.dragable.min.js',
					'scripts/jqplot.categoryAxisRenderer.min.js',
					'scripts/controller/HomeController.js',

					{} 			// loginRemoveSM
				]										// loginRemoveSM
			}
		}// routes end
	}; // return statement end
});
