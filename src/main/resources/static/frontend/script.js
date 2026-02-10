// script.js
function cargarTopBar() {
    fetch('topbar.html') // Asegúrate de que la ruta sea correcta
        .then(response => {
            if (!response.ok) {
                throw new Error('No se pudo cargar la topbar');
            }
            return response.text();
        })
        .then(data => {
            document.getElementById('topbar').innerHTML = data;
            resaltarVistaActual();
        })
        .catch(error => {
            console.error('Error al cargar la topbar:', error);
        });
}

function resaltarVistaActual() {
    const rutaActual = window.location.pathname.split('/').pop(); // Obtiene el nombre del archivo actual
    const enlaces = document.querySelectorAll('#topbar a');

    enlaces.forEach(enlace => {
        const href = enlace.getAttribute('href').split('/').pop(); // Obtiene el nombre del archivo del enlace
        if (href === rutaActual) {
            enlace.style.fontWeight = 'bold';
            enlace.style.color = '#ffcc00';
        }
    });
}

// Cargar la topbar al iniciar la página
document.addEventListener('DOMContentLoaded', cargarTopBar);


