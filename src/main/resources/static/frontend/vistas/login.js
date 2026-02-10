document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const loginMessage = document.getElementById('loginMessage');

    try {
        const response = await fetch('/api/usuarios/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        });
        if (response.ok) {
            loginMessage.textContent = '¡Login exitoso!';
            loginMessage.style.color = 'green';
            setTimeout(() => {
                window.location.href = '/frontend/index.html';
            }, 1000);
        } else {
            const text = await response.text();
            loginMessage.textContent = text || 'Credenciales incorrectas';
            loginMessage.style.color = 'red';
        }
    } catch (error) {
        loginMessage.textContent = 'Error de conexión con el servidor';
        loginMessage.style.color = 'red';
    }
});
