// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();
    $('#usuarios').DataTable();
    actualizarEmailUser();
});

function actualizarEmailUser(){
     document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}


async function cargarUsuarios() {

    const request = await fetch('api/users', {
        method: 'GET',
        headers: getHeaders()
    });
    const usuarios = await request.json();

    let listadoHtml = '';

    for (let user of usuarios) {
        let botonEliminar = "<a href='#' onclick='eliminarUsuario(" + user.id + ")' class='btn btn-danger btn-circle'><i class='fas fa-trash'></i></a>";

        let telefonoTxt = user.telefono == null ? '-' : user.telefono; // un if en una sola linea

        let usuarioHTML = "<tr><td>" + user.id + "</td><td>" + user.nombre + " " +
            user.apellido + "</td><td>" + user.email + "</td><td>" +
            telefonoTxt + "</td><td>" + botonEliminar + "</td></tr>";

        listadoHtml += usuarioHTML;
    }

    //console.log(usuarios);
    // codigo para manipular el DOM HTML y injectar datos
    // let = usuarioHTML = "<tr><td>1234</td><td>Jose Cabral PROBA</td><td>cabralzay@gmail.com</td><td><a href='#' class='btn btn-danger btn-circle'><i class='fas fa-trash'></i></a></td></tr>";


    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

   function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}

async function eliminarUsuario(id) {

    if (!confirm('¿Desea eliminar este Usuario?')) {
        return;
    }
    const request = await fetch('api/users/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });

    location.reload();

}