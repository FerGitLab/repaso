Global.controller("InicioController", function($scope, $http) {
    $scope.personas = [];
    $scope.persona = {};
    $scope.p = {};
    $scope.cargos = [];
    $scope.cargo = [];

    listar();
    listarCargo();

    $scope.editar = p => {
        console.log(p);
        sessionStorage.setItem("id", p.id);
    }

    $scope.delete = p => {
        $http({
            url: api + `/persona/${p.id}`,
            method: "DELETE"
        }).then(sc => sc.data).then(sc => {
            console.log(sc);
            listar();
        })
    }

    $scope.modalEdit = p => {
        console.log(p);
        $scope.p = p;
        $("#edit").modal("show");
    }

    $scope.editar = () => {
        console.log($scope.p);
        $http({
            url: api + "/persona",
            method: 'PUT',
            data: $scope.p
        }).then(sc => sc.data).then(sc => {
            console.log(sc);
            $scope.p = {};
            listar();
            $("#edit").modal("hide");
        })
    }

    $scope.crear = () => {
        console.log($scope.persona);
        $http({
            url: api + "/persona",
            method: 'POST',
            data: $scope.persona
        }).then(sc => sc.data).then(sc => {
            console.log(sc);
            $scope.persona = {};
            listar();
            $("#add").modal("hide");
        })
    }

    $scope.crearCargo = () => {
        console.log($scope.cargo);
        $http({
            url: api + "/cargo",
            method: 'POST',
            data: {
                cargo: $scope.cargo
            }
        }).then(sc => sc.data).then(sc => {
            console.log(sc);
            $scope.cargo = {};
            listarCargo();
            $("#c").modal("hide");
        })
    }

    function listar() {
        $http({
            url: api + "/persona",
            mehtod: 'GET',
        }).then(sc => sc.data).then(sc => {
            $scope.personas = sc;
        })
    }

    function listarCargo() {
        $http({
            url: api + `/cargo`,
            method: "GET"
        }).then(sc => sc.data).then(sc => {
            $scope.cargos = sc;
        })
    }
});