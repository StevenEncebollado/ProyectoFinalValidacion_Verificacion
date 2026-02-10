const API_URL = "http://localhost:8080/api/clasificaciones";

async function cargarClasificacion() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) {
            throw new Error("Error al cargar la clasificación");
        }
        const clasificacion = await response.json();
        mostrarClasificacion(clasificacion);
    } catch (error) {
        console.error("Error al cargar la clasificación:", error);
    }
}

function mostrarClasificacion(clasificacion) {
    const tableBody = document.querySelector("#clasificacionTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    clasificacion.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.fecha_de_clasificacion}</td>
            <td>${item.id_escuela}</td>
            <td>${item.clasificacion_del_distrito}</td>
            <td>${item.clasificacion_general}</td>
            <td>${item.otros_detalles}</td>
            <td>
                <button onclick="editarClasificacion('${item.fecha_de_clasificacion}')">Editar</button>
                <button onclick="eliminarClasificacion('${item.fecha_de_clasificacion}')">Eliminar</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarClasificacion(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        id_escuela: formData.get('idEscuela'),
        clasificacion_del_distrito: formData.get('clasificacionDistrito'),
        clasificacion_general: formData.get('clasificacionGeneral'),
        otros_detalles: formData.get('otrosDetalles')
    };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error("Error al guardar la clasificación");
        }

        cargarClasificacion(); // Recargar la tabla después de guardar
        event.target.reset(); // Limpiar el formulario
    } catch (error) {
        console.error("Error al guardar la clasificación:", error);
    }
}

async function eliminarClasificacion(fecha) {
    if (confirm("¿Estás seguro de que deseas eliminar este registro?")) {
        try {
            const response = await fetch(`${API_URL}/${fecha}`, {
                method: 'DELETE'
            });

            if (!response.ok) {
                throw new Error("Error al eliminar la clasificación");
            }

            cargarClasificacion(); // Recargar la tabla después de eliminar
        } catch (error) {
            console.error("Error al eliminar la clasificación:", error);
        }
    }
}

// Cargar la clasificación al iniciar la página
document.addEventListener("DOMContentLoaded", cargarClasificacion);

// Manejar el envío del formulario
document.getElementById("clasificacionForm").addEventListener("submit", guardarClasificacion);
