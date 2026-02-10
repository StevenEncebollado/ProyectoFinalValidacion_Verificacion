const API_URL = "http://localhost:8080/api/direcciones";

// Cargar direcciones al iniciar la página
async function cargarDirecciones() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar las direcciones");
        const direcciones = await response.json();
        mostrarDirecciones(direcciones);
    } catch (error) {
        console.error("Error al cargar las direcciones:", error);
    }
}

// Mostrar direcciones en la tabla
function mostrarDirecciones(direcciones) {
    const tableBody = document.querySelector("#direccionesTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    direcciones.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.id_direccion}</td>
            <td>${item.linea_1_numero_de_edificio}</td>
            <td>${item.linea_2_numero_de_calle}</td>
            <td>${item.linea_3_area_de_localidad}</td>
            <td>${item.ciudad}</td>
            <td>${item.codigo_postal}</td>
            <td>${item.estado_provincia_o_condado}</td>
            <td>${item.pais}</td>
            <td>${item.otros_detalles_de_la_direccion}</td>
            <td>
                <button onclick="editarDireccion(${item.id_direccion})">Editar</button>
                <button onclick="eliminarDireccion(${item.id_direccion})">Eliminar</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

// Guardar una nueva dirección
async function guardarDireccion(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        linea_1_numero_de_edificio: formData.get('linea1'),
        linea_2_numero_de_calle: formData.get('linea2'),
        linea_3_area_de_localidad: formData.get('areaLocalidad'),
        ciudad: formData.get('ciudad'),
        codigo_postal: formData.get('codigoPostal'),
        estado_provincia_o_condado: formData.get('estado'),
        pais: formData.get('pais'),
        otros_detalles_de_la_direccion: formData.get('otrosDetalles')
    };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) throw new Error("Error al guardar la dirección");
        cargarDirecciones(); // Recargar la tabla
    } catch (error) {
        console.error("Error al guardar la dirección:", error);
    }
}

// Editar una dirección
async function editarDireccion(id) {
    alert(`Editar dirección con ID: ${id}`);
    // Implementar la lógica para editar
}

// Eliminar una dirección
async function eliminarDireccion(id) {
    if (confirm("¿Estás seguro de que deseas eliminar esta dirección?")) {
        try {
            const response = await fetch(`${API_URL}/${id}`, {
                method: 'DELETE'
            });

            if (!response.ok) throw new Error("Error al eliminar la dirección");
            cargarDirecciones(); // Recargar la tabla
        } catch (error) {
            console.error("Error al eliminar la dirección:", error);
        }
    }
}

// Cargar las direcciones al iniciar la página
document.addEventListener("DOMContentLoaded", cargarDirecciones);

// Manejar el envío del formulario
document.getElementById("direccionesForm").addEventListener("submit", guardarDireccion);