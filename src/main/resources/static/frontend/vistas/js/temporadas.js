const API_URL = "http://localhost:8080/api/temporadas";

async function cargarTemporadas() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar las temporadas");
        const temporadas = await response.json();
        mostrarTemporadas(temporadas);
    } catch (error) {
        console.error("Error al cargar las temporadas:", error);
    }
}

function mostrarTemporadas(temporadas) {
    const tableBody = document.querySelector("#temporadasTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    temporadas.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.nombre_de_temporada}</td>
            <td>${item.id_escuela}</td>
            <td>${new Date(item.fecha_de_inicio).toLocaleDateString()}</td>
            <td>${new Date(item.fecha_de_finalizacion).toLocaleDateString()}</td>
            <td>${item.clasificacion_al_final_de_temporada}</td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarTemporada(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        nombre_de_temporada: formData.get('nombreTemporadaInput'), // Se usa el input oculto
        id_escuela: formData.get('idEscuela'),
        fecha_de_inicio: formData.get('fechaInicio'),
        fecha_de_finalizacion: formData.get('fechaFinalizacion'),
        clasificacion_al_final_de_temporada: formData.get('clasificacionFinal')
    };

    const nombreTemporada = formData.get('nombreTemporadaInput'); // Identificador para edición

    try {
        if (nombreTemporada) {
            // Editar temporada
            await fetch(`${API_URL}/${nombreTemporada}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        } else {
            // Agregar nueva temporada
            await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        }
        cargarTemporadas(); // Recargar la tabla
        event.target.reset(); // Limpiar el formulario
    } catch (error) {
        console.error("Error al guardar la temporada:", error);
    }
}

async function editarTemporada(nombre) {
    try {
        const response = await fetch(`${API_URL}/${nombre}`);
        if (!response.ok) throw new Error("Error al obtener datos de la temporada");
        const temporada = await response.json();

        document.getElementById('nombreTemporadaInput').value = temporada.nombre_de_temporada; // Campo oculto para edición
        document.getElementById('idEscuela').value = temporada.id_escuela;
        document.getElementById('fechaInicio').value = new Date(temporada.fecha_de_inicio).toISOString().slice(0, 10);
        document.getElementById('fechaFinalizacion').value = new Date(temporada.fecha_de_finalizacion).toISOString().slice(0, 10);
        document.getElementById('clasificacionFinal').value = temporada.clasificacion_al_final_de_temporada;
    } catch (error) {
        console.error("Error al editar la temporada:", error);
    }
}

async function eliminarTemporada(nombre) {
    if (confirm("¿Estás seguro de que deseas eliminar esta temporada?")) {
        try {
            await fetch(`${API_URL}/${nombre}`, { method: 'DELETE' });
            cargarTemporadas(); // Recargar la tabla
        } catch (error) {
            console.error("Error al eliminar la temporada:", error);
        }
    }
}

// Cargar temporadas al inicio
document.addEventListener("DOMContentLoaded", () => {
    cargarTemporadas();
    document.getElementById("temporadaForm").addEventListener("submit", guardarTemporada);
});
