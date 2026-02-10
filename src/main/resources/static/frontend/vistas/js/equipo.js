const API_URL = "http://localhost:8080/api/equipo";

async function cargarEquipo() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar el equipo");
        const equipo = await response.json();
        mostrarEquipo(equipo);
    } catch (error) {
        console.error("Error al cargar el equipo:", error);
    }
}

function mostrarEquipo(equipo) {
    const tableBody = document.querySelector("#equipoTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    equipo.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.id_equipo}</td>
            <td>${item.id_juego}</td>
            <td>${item.id_estudiante}</td>
            <td>${item.codigo_posicion}</td>
            <td>${item.titular ? "Sí" : "No"}</td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarEquipo(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        id_juego: formData.get('idJuego'),
        id_estudiante: formData.get('idEstudiante'),
        codigo_posicion: formData.get('codigoPosicion'),
        titular: formData.get('titular') === 'on'
    };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) throw new Error("Error al guardar el equipo");
        cargarEquipo(); // Recargar la tabla
    } catch (error) {
        console.error("Error al guardar el equipo:", error);
    }
}

// Cargar el equipo al iniciar la página
document.addEventListener("DOMContentLoaded", cargarEquipo);

// Manejar el envío del formulario
document.getElementById("equipoForm").addEventListener("submit", guardarEquipo);