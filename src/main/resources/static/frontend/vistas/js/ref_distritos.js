const API_URL = "http://localhost:8080/api/distritos";

async function cargarRefDistritos() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar los distritos");
        const distritos = await response.json();
        mostrarRefDistritos(distritos);
    } catch (error) {
        console.error("Error al cargar los distritos:", error);
    }
}

function mostrarRefDistritos(distritos) {
    const tableBody = document.querySelector("#refDistritosTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    distritos.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.codigo_de_distrito}</td>
            <td>${item.nombre_de_distrito}</td>
            <td>
                <button onclick="editarDistrito(${item.codigo_de_distrito})">Editar</button>
                <button onclick="eliminarDistrito(${item.codigo_de_distrito})">Eliminar</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarDistrito(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        nombre_de_distrito: formData.get('nombreDistrito')
    };

    const codigoDistrito = formData.get('codigoDistrito');

    try {
        if (codigoDistrito) {
            // Editar distrito
            await fetch(`${API_URL}/${codigoDistrito}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        } else {
            // Agregar distrito
            await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        }
        cargarRefDistritos(); // Recargar la tabla
    } catch (error) {
        console.error("Error al guardar el distrito:", error);
    }
}

async function editarDistrito(codigo) {
    const response = await fetch(`${API_URL}/${codigo}`);
    const distrito = await response.json();
    document.getElementById('codigoDistrito').value = distrito.codigo_de_distrito;
    document.getElementById('nombreDistrito').value = distrito.nombre_de_distrito;
}

async function eliminarDistrito(codigo) {
    if (confirm("¿Estás seguro de que deseas eliminar este distrito?")) {
        try {
            await fetch(`${API_URL}/${codigo}`, { method: 'DELETE' });
            cargarRefDistritos(); // Recargar la tabla
        } catch (error) {
            console.error("Error al eliminar el distrito:", error);
        }
    }
}

// Cargar los distritos al iniciar la página
document.addEventListener("DOMContentLoaded", cargarRefDistritos);

// Manejar el envío del formulario
document.getElementById("distritoForm").addEventListener("submit", guardarDistrito);