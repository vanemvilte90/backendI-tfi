$(document).ready(function(){

    $(document).on("click", "table button.ml-2", function(){
            let id_of_button = (event.srcElement.id);
            let turnoId = id_of_button.split("_")[2];

            $.ajax({
                url: '/turnos/' + turnoId,
                type: 'DELETE',
                success: function(response) {
                    alert("El turno ha sido eliminado con éxito.")
                       setTimeout(function(){
                               window.location.reload();
                             }, 500);
                },
                error: function(error){
                    console.log(error);
                    alert("Error -> " + error);
                }
            });
    });

});