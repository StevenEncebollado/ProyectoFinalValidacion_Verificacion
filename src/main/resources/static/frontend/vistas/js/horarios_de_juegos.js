const API_URL = "http://localhost:8080/api/horarios_de_juegos";

async function cargarHorarios() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar los horarios");
        const horarios = await response.json();
        mostrarHorarios(horarios);
    } catch (error) {
        console.error("Error al cargar los horarios:", error);
    }
}

function mostrarHorarios(horarios) {
    const tableBody = document.querySelector("#horariosTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    horarios.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.id_juego}</td>
            <td>${item.codigo_de_tipo_de_juego}</td>
            <td>${item.id_escuela}</td>
            <td>${item.nombre_de_la_escuela_oponente}</td>
            <td>${new Date(item.fecha_hora_del_juego).toLocaleString()}</td>
            <td>${item.resultado_del_juego}</td>
            <td>${item.otros_detalles_del_estudiante}</td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarHorario(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        codigo_de_tipo_de_juego: formData.get('tipoJuego'),
        id_escuela: formData.get('idEscuela'),
        nombre_de_la_escuela_oponente: formData.get('nombreOponente'),
        fecha_hora_del_juego: formData.get('fechaHora'),
        resultado_del_juego: formData.get('resultado'),
        otros_detalles_del_estudiante: formData.get('otrosDetalles')
    };

    const idJuego = formData.get('idJuego');

    try {
        if (idJuego) {
            // Editar horario
            await fetch(`${API_URL}/${idJuego}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        } else {
            // Agregar horario
            await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
        }
        cargarHorarios(); // Recargar la tabla
    } catch (error) {
        console.error("Error al guardar el horario:", error);
    }
}

async function editarHorario(id) {
    const response = await fetch(`${API_URL}/${id}`);
    const horario = await response.json();
    document.getElementById('idJuego').value = horario.id_juego;
    document.getElementById('tipoJuego').value = horario.codigo_de_tipo_de_juego;
    document.getElementById('idEscuela').value = horario.id_escuela;
    document.getElementById('nombreOponente').value = horario.nombre_de_la_escuela_oponente;
    document.getElementById('fechaHora').value = new Date(horario.fecha_hora_del_juego).toISOString().slice(0, 16);
    document.getElementById('resultado').value = horario.resultado_del_juego;
    document.getElementById('otrosDetalles').value = horario.otros_detalles_del_estudiante;
}

async function eliminarHorario(id) {
    if (confirm("¿Estás seguro de que deseas eliminar este horario?")) {
        try {
            await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
            cargarHorarios(); // Recargar la tabla
        } catch (error) {
            console.error("Error al eliminar el horario:", error);
        }
    }
}

// Cargar los horarios al iniciar la página
document.addEventListener("DOMContentLoaded", cargarHorarios);

// Manejar el envío del formulario
document.getElementById("horarioForm").addEventListener("submit", guardarHorario);