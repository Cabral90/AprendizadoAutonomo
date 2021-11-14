// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();
  $('#usuarios').DataTable();
});


async function cargarUsuarios(){

      const request = await fetch('users', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const usuarios = await request.json();
      let listadoHtml = '';

      for (let user of usuarios){

        let = usuarioHTML = "<tr><td>"+user.id+"</td><td>"+user.nombre+ " "
        +user.apellido+"</td><td>"+user.email+"</td><td>"
        +user.telefono+"</td><td><a href='#' class='btn btn-danger btn-circle'><i class='fas fa-trash'></i></a></td></tr>";

         listadoHtml += usuarioHTML;
      }

      console.log(usuarios);
      // codigo para manipular el DOM HTML y injectar datos
       // let = usuarioHTML = "<tr><td>1234</td><td>Jose Cabral PROBA</td><td>cabralzay@gmail.com</td><td><a href='#' class='btn btn-danger btn-circle'><i class='fas fa-trash'></i></a></td></tr>";

      // let = usuario = "<tr><td>1234</td><td>Jose Cabral</td><td>cabralzay@gmail.com</td><td><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>";
    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}