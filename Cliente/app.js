var app = angular.module("app", [
    "ngRoute",
    "Controllers"
]);

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: './views/inicio.html',
                controller: 'InicioController'
            })
            .when('/crear', {
                templateUrl: './views/crear.html',
                controller: 'CrearController'
            })
            .when('/cargo', {
                templateUrl: './views/cargos.html',
                controller: 'CargoController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }
]);

app.component("menuApp", {
    templateUrl: './views/components/menu.html',
    controller: 'MenuController'
});

app.directive('convertToNumber', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, ngModel) {
            ngModel.$parsers.push(function(val) {
                return val != null ? parseInt(val, 10) : null;
            });
            ngModel.$formatters.push(function(val) {
                return val != null ? '' + val : null;
            });
        }
    };
});