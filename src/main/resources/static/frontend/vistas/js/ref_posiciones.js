const API_URL = "http://localhost:8080/api/posiciones";

async function cargarRefPosiciones() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar las posiciones");
        const posiciones = await response.json();
        mostrarRefPosiciones(posiciones);
    } catch (error) {
        console.error("Error al cargar las posiciones:", error);
    }
}

function mostrarRefPosiciones(posiciones) {
    const tableBody = document.querySelector("#refPosicionesTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    posiciones.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.codigo_posicion}</td>
            <td>${item.descripcion_de_la_posicion}</td>
            <td>
                <button onclick="editarPosicion(${item.codigo_posicion})">Editar</button>
                <button onclick="eliminarPosicion(${item.codigo_posicion})">Eliminar</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarPosicion(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        descripcion_de_la_posicion: formData.get('descripcionPosicion')
    };

    const codigoPosicion = formData.get('codigoPosicion');

    try {
        if (codigoPosicion) {
            // Editar posición
            await fetch(`${API_URL}/${codigoPosicion}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        } else {
            // Agregar posición
            await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        }
        cargarRefPosiciones(); // Recargar la tabla
    } catch (error) {
        console.error("Error al guardar la posición:", error);
    }
}

async function editarPosicion(codigo) {
    const response = await fetch(`${API_URL}/${codigo}`);
    const posicion = await response.json();
    document.getElementById('codigoPosicion').value = posicion.codigo_posicion;
    document.getElementById('descripcionPosicion').value = posicion.descripcion_de_la_posicion;
}

async function eliminarPosicion(codigo) {
    if (confirm("¿Estás seguro de que deseas eliminar esta posición?")) {
        try {
            await fetch(`${API_URL}/${codigo}`, { method: 'DELETE' });
            cargarRefPosiciones(); // Recargar la tabla
        } catch (error) {
            console.error("Error al eliminar la posición:", error);
        }
    }
}

// Cargar las posiciones al iniciar la página
document.addEventListener("DOMContentLoaded", cargarRefPosiciones);

// Manejar el envío del formulario
document.getElementById("posicionForm").addEventListener("submit", guardarPosicion);