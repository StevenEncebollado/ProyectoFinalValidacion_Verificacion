const API_URL = "http://localhost:8080/api/escuelas";

async function cargarEscuelas() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar las escuelas");
        const escuelas = await response.json();
        mostrarEscuelas(escuelas);
    } catch (error) {
        console.error("Error al cargar las escuelas:", error);
    }
}

function mostrarEscuelas(escuelas) {
    const tableBody = document.querySelector("#escuelasTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    escuelas.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.id_escuela}</td>
            <td>${item.id_del_entrenador_actual}</td>
            <td>${item.codigo_de_distrito}</td>
            <td>${item.id_direccion_escuela}</td>
            <td>${item.nombre_de_escuela}</td>
            <td>${item.mascota_de_escuela}</td>
            <td>${item.numero_de_telefono}</td>
            <td>${item.estadio_local}</td>
            <td>${item.otros_detalles}</td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarEscuela(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        id_del_entrenador_actual: formData.get('idEntrenador'),
        codigo_de_distrito: formData.get('codigoDistrito'),
        id_direccion_escuela: formData.get('idDireccion'),
        nombre_de_escuela: formData.get('nombreEscuela'),
        mascota_de_escuela: formData.get('mascota'),
        numero_de_telefono: formData.get('numeroTelefono'),
        estadio_local: formData.get('estadioLocal'),
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

        if (!response.ok) throw new Error("Error al guardar la escuela");
        cargarEscuelas(); // Recargar la tabla
    } catch (error) {
        console.error("Error al guardar la escuela:", error);
    }
}

async function editarEscuela(id) {
    alert(`Editar escuela con ID: ${id}`);
    // Implementar la lógica para editar
}

async function eliminarEscuela(id) {
    if (confirm("¿Estás seguro de que deseas eliminar esta escuela?")) {
        try {
            const response = await fetch(`${API_URL}/${id}`, {
                method: 'DELETE'
            });

            if (!response.ok) throw new Error("Error al eliminar la escuela");
            cargarEscuelas(); // Recargar la tabla
        } catch (error) {
            console.error("Error al eliminar la escuela:", error);
        }
    }
}

// Cargar las escuelas al iniciar la página
document.addEventListener("DOMContentLoaded", cargarEscuelas);

// Manejar el envío del formulario
document.getElementById("escuelasForm").addEventListener("submit", guardarEscuela);