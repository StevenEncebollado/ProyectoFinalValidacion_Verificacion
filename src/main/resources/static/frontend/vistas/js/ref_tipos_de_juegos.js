const API_URL = "http://localhost:8080/api/tipos-de-juegos";

async function cargarRefTiposDeJuegos() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar los tipos de juegos");
        const tiposDeJuegos = await response.json();
        mostrarRefTiposDeJuegos(tiposDeJuegos);
    } catch (error) {
        console.error("Error al cargar los tipos de juegos:", error);
    }
}

function mostrarRefTiposDeJuegos(tiposDeJuegos) {
    const tableBody = document.querySelector("#refTiposDeJuegosTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    tiposDeJuegos.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.codigo_de_tipo_de_juego}</td>
            <td>${item.descripcion_del_tipo_de_juego}</td>
            <td>
                <button onclick="editarTipoJuego(${item.codigo_de_tipo_de_juego})">Editar</button>
                <button onclick="eliminarTipoJuego(${item.codigo_de_tipo_de_juego})">Eliminar</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarTipoJuego(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        descripcion_del_tipo_de_juego: formData.get('descripcionTipoJuego')
    };

    const codigoTipoJuego = formData.get('codigoTipoJuego');

    try {
        if (codigoTipoJuego) {
            // Editar tipo de juego
            await fetch(`${API_URL}/${codigoTipoJuego}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        } else {
            // Agregar tipo de juego
            await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        }
        cargarRefTiposDeJuegos(); // Recargar la tabla
    } catch (error) {
        console.error("Error al guardar el tipo de juego:", error);
    }
}

async function editarTipoJuego(codigo) {
    const response = await fetch(`${API_URL}/${codigo}`);
    const tipoJuego = await response.json();
    document.getElementById('codigoTipoJuego').value = tipoJuego.codigo_de_tipo_de_juego;
    document.getElementById('descripcionTipoJuego').value = tipoJuego.descripcion_del_tipo_de_juego;
}

async function eliminarTipoJuego(codigo) {
    if (confirm("¿Estás seguro de que deseas eliminar este tipo de juego?")) {
        try {
            await fetch(`${API_URL}/${codigo}`, { method: 'DELETE' });
            cargarRefTiposDeJuegos(); // Recargar la tabla
        } catch (error) {
            console.error("Error al eliminar el tipo de juego:", error);
        }
    }
}

// Cargar los tipos de juegos al iniciar la página
document.addEventListener("DOMContentLoaded", cargarRefTiposDeJuegos);

// Manejar el envío del formulario
document.getElementById("tipoJuegoForm").addEventListener("submit", guardarTipoJuego);