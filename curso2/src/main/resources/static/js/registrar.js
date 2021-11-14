// Call the dataTables jQuery plugin
$(document).ready(function() {
    // onread


});


async function registrarUsuarios() {
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;
    let pass2 = document.getElementById('txtPassword2').value;

    if (pass2 != datos.password) {
        alert('Las dos contraseñas son distintas.');
        return;
    }

    const request = await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert('La cuenta fue creada con exito. ');
      window.location.href = 'login.html'

}