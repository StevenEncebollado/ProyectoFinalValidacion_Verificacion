document.getElementById('registerForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const registerMessage = document.getElementById('registerMessage');

    try {
        const response = await fetch('/api/usuarios', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, email, password })
        });
        if (response.ok || response.status === 201) {
            registerMessage.textContent = '¡Usuario registrado exitosamente!';
            registerMessage.style.color = 'green';
            setTimeout(() => {
                window.location.href = 'login.html';
            }, 1200);
        } else {
            const text = await response.text();
            registerMessage.textContent = text || 'Error al registrar usuario';
            registerMessage.style.color = 'red';
        }
    } catch (error) {
        registerMessage.textContent = 'Error de conexión con el servidor';
        registerMessage.style.color = 'red';
    }
});
