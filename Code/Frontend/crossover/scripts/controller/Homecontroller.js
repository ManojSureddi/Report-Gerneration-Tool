define(['scripts/appModule'], function(app){
	app.lazy.controller('HomeController',  ["$scope","$rootScope","$location","$timeout","GetData","$cookies","Auth",function($scope,$rootScope,$location,$timeout,GetData,$cookies,Auth){
		    $scope.sess=$cookies.jsession;
            $scope.$parent.sess=$cookies.jsession;
            $rootScope.sess=$cookies.jsession;
            console.log($rootScope.sess);
            if($scope.sess==null){
                $location.path("/login");
            }
		var plot5=null;

		$scope.process={
			"getUserDetails":function(){
				var sess={
					"sessionId":$scope.sess
				};
				Auth.getuserdetails(sess).query(function(data){
					$scope.$parent.uname=data.username
				});
			},
			"logOut":function(){
				console.log("logged out");
				delete $cookies["jsession"];
				$location.path("/login");
			},
			"pichart":function(data){
				console.log("asd");
				var sess={
					"sessionId":$scope.sess
				};
				var p;
				GetData.getSalesmanData(sess).query(function(data){
			       console.log("asdasd");

						  var line1 = data.data;
						  if(plot5!=null){
						  	plot5.destroy();
						  }
					 plot5 = $.jqplot('plotarea', [line1], {
				        gridPadding: {top:0, bottom:38, left:0, right:0},
				        seriesDefaults:{
				            renderer:$.jqplot.PieRenderer, 
				            trendline:{ show:false }, 
				            rendererOptions: { padding: 8, showDataLabels: true }
				        },
				            title: {
						        text: $scope.graphTitle,   // title for the plot,
						        show: true,
						    },
				        legend:{
				            show:true,  
				            placement: 'outside',
				            location:'e',
				            marginTop: '15px'
				        }       
				    });					 
	
				})



			},
			"barchart":function(){
								console.log("asd");
				var sess={
					"sessionId":$scope.sess
				};
				var p;
				GetData.getMonthwiseData(sess).query(function(data){
			       console.log("asdasd");

						  var line1 = data.data;
					plot5 = $.jqplot('plotarea', [line1], {
					   title: 'Concern vs. Occurrance',
					    series:[{renderer:$.jqplot.BarRenderer}],
					    axesDefaults: {
					        tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
					        tickOptions: {
					          angle: -30,
					          fontSize: '10pt'
					        }
					    },
				            title: {
						        text: $scope.graphTitle,   // title for the plot,
						        show: true,
						    },
					    axes: {
					      xaxis: {
					        renderer: $.jqplot.CategoryAxisRenderer
					      }
					    }      
				    });						 
	
				})

			},
			"Horizontalbarchart":function(data){
				console.log("asd");
				var sess={
					"sessionId":$scope.sess
				};
				var p;
				GetData.getTopSales(sess).query(function(data){
			       console.log("asdasd");

						  var line1 = data.data;
					plot5 = $.jqplot('plotarea', [line1], {
					   title: 'Concern vs. Occurrance',
					    series:[{renderer:$.jqplot.BarRenderer}],
					    axesDefaults: {
					        tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
					        tickOptions: {
					          angle: -30,
					          fontSize: '10pt'
					        }
					    },
				            title: {
						        text: $scope.graphTitle,   // title for the plot,
						        show: true,
						    },
					    axes: {
					      xaxis: {
					        renderer: $.jqplot.CategoryAxisRenderer
					      }
					    }      
				    });						 
				})
			},
			"HorizontalSaleschart":function(data){
				console.log("asd");
				var sess={
					"sessionId":$scope.sess
				};
				var p;
				GetData.getTopSalesMan(sess).query(function(data){
			       console.log("asdasd");

						  var line1 = data.data;
					plot5 = $.jqplot('plotarea', [line1], {
					   title: 'Concern vs. Occurrance',
					    series:[{renderer:$.jqplot.BarRenderer}],
					    axesDefaults: {
					        tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
					        tickOptions: {
					          angle: -30,
					          fontSize: '10pt'
					        }
					    },
				            title: {
						        text: $scope.graphTitle,   // title for the plot,
						        show: true,
						    },
					    axes: {
					      xaxis: {
					        renderer: $.jqplot.CategoryAxisRenderer
					      }
					    }      
				    });					 
	
				})
			},
			"plotChart":function(opt){
				
					if(opt==1){
						$timeout(function(){
							
							$scope.process.pichart("sda");
							$scope.modalTitle="Total sales values for each salesman ";
							$scope.graphTitle="Amount vs Salesman Name"
						})
					}
					else if(opt==2){
						$timeout(function(){
							
							$scope.process.barchart("sda");
							$scope.modalTitle="Total sales per month";
							$scope.graphTitle="Amount vs Month"
						})
					}
					else if(opt==3){
						$timeout(function(){
							$scope.process.Horizontalbarchart("sda");
							$scope.modalTitle="Top 5 sales orders in amount";
							$scope.graphTitle="Amount vs Rank"
						})
					}
					else{
						$timeout(function(){

							$scope.process.HorizontalSaleschart("sda");
							$scope.modalTitle="Top 5 sales men in last 3 months";
							$scope.graphTitle="Amount vs Salesman name"
						})
					}					
				$timeout(function(){
					plot5.replot();
				},300);

			}
		}
				$scope.process.getUserDetails();
		
	}]);
});