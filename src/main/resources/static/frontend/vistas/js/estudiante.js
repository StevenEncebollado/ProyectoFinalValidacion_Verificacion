const API_URL = "http://localhost:8080/api/estudiantes";

async function cargarEstudiantes() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Error al cargar los estudiantes");
        const estudiantes = await response.json();
        mostrarEstudiantes(estudiantes);
    } catch (error) {
        console.error("Error al cargar los estudiantes:", error);
    }
}

function mostrarEstudiantes(estudiantes) {
    const tableBody = document.querySelector("#estudiantesTable tbody");
    tableBody.innerHTML = ""; // Limpiar la tabla

    estudiantes.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.id_estudiante}</td>
            <td>${item.id_escuela}</td>
            <td>${item.id_direccion_del_estudiante}</td>
            <td>${item.nombre}</td>
            <td>${item.segundo_nombre}</td>
            <td>${item.apellido}</td>
            <td>${item.numero_celular}</td>
            <td>${item.correo_electronico}</td>
            <td>${new Date(item.fecha_primer_alquiler).toLocaleDateString()}</td>
            <td>${item.fecha_de_salida_de_universidad ? new Date(item.fecha_de_salida_de_universidad).toLocaleDateString() : ''}</td>
            <td>${item.saldo_actual_derivado}</td>
            <td>${item.otros_detalles_del_estudiante}</td>
        `;
        tableBody.appendChild(row);
    });
}

async function guardarEstudiante(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
        id_escuela: formData.get('idEscuela'),
        id_direccion_del_estudiante: formData.get('idDireccion'),
        nombre: formData.get('nombre'),
        segundo_nombre: formData.get('segundoNombre'),
        apellido: formData.get('apellido'),
        numero_celular: formData.get('numeroCelular'),
        correo_electronico: formData.get('correoElectronico'),
        fecha_primer_alquiler: formData.get('fechaPrimerAlquiler'),
        fecha_de_salida_de_universidad: formData.get('fechaSalidaUniversidad'),
        saldo_actual_derivado: parseFloat(formData.get('saldoActual')),
        otros_detalles_del_estudiante: formData.get('otrosDetalles')
    };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) throw new Error("Error al guardar el estudiante");
        cargarEstudiantes(); // Recargar la tabla
    } catch (error) {
        console.error("Error al guardar el estudiante:", error);
    }
}


// Cargar los estudiantes al iniciar la página
document.addEventListener("DOMContentLoaded", cargarEstudiantes);

// Manejar el envío del formulario
document.getElementById("estudiantesForm").addEventListener("submit", guardarEstudiante);