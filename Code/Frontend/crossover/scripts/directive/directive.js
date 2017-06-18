define(['scripts/appModule'], function(app){
    app.directive("modalShow", function ($parse) {
        return {
               function() {
                  var openDialog = {
                     link :   function(scope, element, attrs) {
                        function openDialog() {
                          var element = angular.element('#myModal');
                          var ctrl = element.controller();
                          ctrl.setModel(scope.blub);
                          element.modal('show');
                        }
                        element.bind('click', openDialog);
                   }
               }
               return openDialog;
            }

        }
    });

    app.directive("PieCharts",function(){
          $scope.data = [[
                ['Heavy Industry', 12],['Retail', 9], ['Light Industry', 14], 
                ['Out of home', 16],['Commuting', 7], ['Orientation', 9]
              ]];

            $scope.chartOptions = { 
              seriesDefaults: {
                // Make this a pie chart.
                renderer: jQuery.jqplot.PieRenderer, 
                rendererOptions: {
                  // Put data labels on the pie slices.
                  // By default, labels show the percentage of the slice.
                  showDataLabels: true
                }
              }, 
              legend: { show:true, location: 'e' }
            };

            });
});

