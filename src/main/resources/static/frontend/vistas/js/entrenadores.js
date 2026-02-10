const API_URL = "http://localhost:8080/api/entrenadores";

async function cargarEntrenadores() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar los entrenadores");
        const entrenadores = await response.json();
        mostrarEntrenadores(entrenadores);
    } catch (error) {
        console.error("Error al cargar los entrenadores:", error);
    }
}

function mostrarEntrenadores(entrenadores) {
    const tableBody = document.querySelector("#entrenadoresTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    entrenadores.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.id_entrenador}</td>
            <td>${item.id_direccion_del_entrenador}</td>
            <td>${item.nombre}</td>
            <td>${item.segundo_nombre}</td>
            <td>${item.apellido}</td>
            <td>${item.numero_de_celular}</td>
            <td>${item.correo_electronico}</td>
            <td>${new Date(item.fecha_de_inicio).toLocaleDateString()}</td>
            <td>${item.fecha_de_finalizacion ? new Date(item.fecha_de_finalizacion).toLocaleDateString() : ''}</td>
            <td>${item.otros_detalles}</td>
            <td>
                <button onclick="editarEntrenador(${item.id_entrenador})">Editar</button>
                <button onclick="eliminarEntrenador(${item.id_entrenador})">Eliminar</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarEntrenador(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        id_direccion_del_entrenador: formData.get('idDireccion'),
        nombre: formData.get('nombre'),
        segundo_nombre: formData.get('segundoNombre'),
        apellido: formData.get('apellido'),
        numero_de_celular: formData.get('numeroCelular'),
        correo_electronico: formData.get('correoElectronico'),
        fecha_de_inicio: formData.get('fechaInicio'),
        fecha_de_finalizacion: formData.get('fechaFinalizacion'),
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

        if (!response.ok) throw new Error("Error al guardar el entrenador");
        cargarEntrenadores(); // Recargar la tabla
    } catch (error) {
        console.error("Error al guardar el entrenador:", error);
    }
}

async function editarEntrenador(id) {
    alert(`Editar entrenador con ID: ${id}`);
    // Implementar la lógica para editar
}

async function eliminarEntrenador(id) {
    if (confirm("¿Estás seguro de que deseas eliminar este entrenador?")) {
        try {
            const response = await fetch(`${API_URL}/${id}`, {
                method: 'DELETE'
            });

            if (!response.ok) throw new Error("Error al eliminar el entrenador");
            cargarEntrenadores(); // Recargar la tabla
        } catch (error) {
            console.error("Error al eliminar el entrenador:", error);
        }
    }
}

// Cargar los entrenadores al iniciar la página
document.addEventListener("DOMContentLoaded", cargarEntrenadores);

// Manejar el envío del formulario
document.getElementById("entrenadoresForm").addEventListener("submit", guardarEntrenador);