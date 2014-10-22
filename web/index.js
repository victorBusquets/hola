var app = angular.module("app", []);
   
function PruebaController($scope, $http) {

    $scope.getSucursal = function(id) {
        $http({
            method: "GET",
            url: contextPath+"/api/SucursalBancaria/" + id
        }).success(function(data, status, headers, config) {
                  $scope.entidadBancaria = data;
            }).error(function(data, status, headers, config) {
            alert("ERRRORRRRRRRRRRR!!(" + status + ")");
        });
    };

    $scope.deleteSucursal = function(id) {
        $http({
            method: "DELETE",
            url: contextPath+"/api/SucursalBancaria/" + id
        }).success(function(data, status, headers, config) {
            alert("Registro borrado");
            }).error(function(data, status, headers, config) {
            alert("ERRRORRRRRRRRRRR!!(" + status + ")");
        });
    };

    $scope.insertSucursal = function(sucursalBancaria) {
        $http({
            method: "POST",
            data: sucursalBancaria,
            url: contextPath+"/api/SucursalBancaria"
        }).success(function(data, status, headers, config) {
            alert("Registro insertado");
            }).error(function(data, status, headers, config) {
            alert("ERRRORRRRRRRRRRR!!(" + status + ")");
        });
    };

    $scope.updateSucursal = function(id, localizacion, codigoSucursal, entidadBancaria, nombreSucursal) {
        $http({
            method: "GET",
            url: contextPath+"/update.json.jsp?idSucursal=" + id + 
                                            "&&localizacion=" + localizacion + 
                                            "&&codigoSucursal=" + codigoSucursal+
                                            "&&entidadBancaria="+entidadBancaria+
                                            "&&nombreSucursal="+nombreSucursal
        }).success(function(data, status, headers, config) {
            alert("Registro actualizado");
            }).error(function(data, status, headers, config) {
            alert("ERRRORRRRRRRRRRR!!(" + status + ")");
        });
    };

    $scope.findAll = function() {
        $http({
            method: "GET",
            url: contextPath+"/api/SucursalBancaria"
        }).success(function(data, status, headers, config) {
            alert("Registros cargados");
            $scope.entidadesBancarias = data;
            }).error(function(data, status, headers, config) {
            alert("ERRRORRRRRRRRRRR!!(" + status + ")");
        });
    };
}