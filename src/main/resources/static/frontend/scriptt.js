document.addEventListener('DOMContentLoaded', function() {

    // Animación de entrada del balón
    const ball = document.querySelector('.soccer-ball');
    const title = document.querySelector('.main-title');
    const subtitle = document.querySelector('.subtitle');
    const button = document.querySelector('.enter-btn');

    setTimeout(() => {
        ball.style.animation = 'ballBounce 3s ease-in-out infinite, fadeIn 1s ease-out';
    }, 500);


const letters = document.querySelectorAll('.letter');
letters.forEach((letter, index) => {
    letter.style.animationDelay = `${index * 0.1}s`;

    letter.addEventListener('mouseenter', function() {
        this.style.transform = 'translateY(-10px) scale(1.2)';
        this.style.transition = 'all 0.3s ease';
    });

    letter.addEventListener('mouseleave', function() {
        this.style.transform = 'translateY(0) scale(1)';
    });
});



    button.addEventListener('click', function() {

        this.style.transform = 'scale(0.95)';

        setTimeout(() => {
            this.style.transform = 'scale(1)';

            showWelcomeMessage();
        }, 150);
    });

    // Función para mostrar mensaje de bienvenida
    function showWelcomeMessage() {
        const message = document.createElement('div');
        message.innerHTML = `
            <div style="
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background: rgba(0, 0, 0, 0.9);
                color: white;
                padding: 30px;
                border-radius: 15px;
                text-align: center;
                z-index: 1000;
                box-shadow: 0 10px 30px rgba(0, 0, 0, 0.5);
                animation: messageAppear 0.5s ease-out;
            ">
                <h2 style="margin-bottom: 15px; color: #FFD700;">¡Bienvenido al Mundo del Fútbol!</h2>
                <p style="margin-bottom: 20px;">Prepárate para vivir la pasión del fútbol</p>
                <button onclick="this.parentElement.parentElement.remove()" style="
                    padding: 10px 20px;
                    background: linear-gradient(45deg, #FF6B35, #F7931E);
                    color: white;
                    border: none;
                    border-radius: 20px;
                    cursor: pointer;
                    font-weight: bold;
                ">Continuar</button>
            </div>
        `;

        document.body.appendChild(message);
    }


    ball.addEventListener('mouseenter', function() {
        const ballElement = this.querySelector('.ball');
        ballElement.style.animationDuration = '0.5s';
        ballElement.style.transform = 'scale(1.2)';
    });

    ball.addEventListener('mouseleave', function() {
        const ballElement = this.querySelector('.ball');
        ballElement.style.animationDuration = '2s';
        ballElement.style.transform = 'scale(1)';
    });


    function createDynamicParticles() {
        const particlesContainer = document.querySelector('.particles');

        for (let i = 0; i < 3; i++) {
            setTimeout(() => {
                const particle = document.createElement('div');
                particle.className = 'dynamic-particle';
                particle.style.cssText = `
                    position: absolute;
                    width: 6px;
                    height: 6px;
                    background: radial-gradient(circle, #FFD700, #FF6B35);
                    border-radius: 50%;
                    left: ${Math.random() * 100}%;
                    top: 100%;
                    animation: dynamicParticleFloat ${5 + Math.random() * 5}s linear infinite;
                    box-shadow: 0 0 10px rgba(255, 215, 0, 0.6);
                `;

                particlesContainer.appendChild(particle);

                // Remover partícula después de la animación
                setTimeout(() => {
                    if (particle.parentNode) {
                        particle.remove();
                    }
                }, 10000);
            }, i * 2000);
        }
    }


    const dynamicStyles = document.createElement('style');
    dynamicStyles.textContent = `
        @keyframes dynamicParticleFloat {
            0% {
                transform: translateY(0) rotate(0deg);
                opacity: 0;
            }
            10% {
                opacity: 1;
            }
            90% {
                opacity: 1;
            }
            100% {
                transform: translateY(-100vh) rotate(360deg);
                opacity: 0;
            }
        }

        @keyframes messageAppear {
            from {
                opacity: 0;
                transform: translate(-50%, -50%) scale(0.5);
            }
            to {
                opacity: 1;
                transform: translate(-50%, -50%) scale(1);
            }
        }

        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
    `;
    document.head.appendChild(dynamicStyles);

    createDynamicParticles();
    setInterval(createDynamicParticles, 10000);


document.addEventListener('mousemove', function(e) {
    const mouseX = e.clientX / window.innerWidth;
    const mouseY = e.clientY / window.innerHeight;

    // Mover el fondo ligeramente
    const fieldBackground = document.querySelector('.field-background');
    fieldBackground.style.transform = `translate(${mouseX * 10}px, ${mouseY * 10}px)`;

    // Mover las partículas
    const particles = document.querySelectorAll('.particle');
    particles.forEach((particle, index) => {
        const speed = (index + 1) * 0.5;
        particle.style.transform = `translate(${mouseX * speed}px, ${mouseY * speed}px)`;
    });
});



    console.log('🏈 Animación de fútbol cargada correctamente!');
});


window.addEventListener('resize', function() {
    const ball = document.querySelector('.ball');
    const title = document.querySelector('.main-title');

    if (window.innerWidth < 768) {
        ball.style.width = '60px';
        ball.style.height = '60px';
    } else {
        ball.style.width = '80px';
        ball.style.height = '80px';
    }
});


window.addEventListener('load', function() {

    document.body.classList.add('loaded');


    setTimeout(() => {
        const loadingComplete = document.createElement('div');
        loadingComplete.innerHTML = '⚽ ¡Listo para jugar!';
        loadingComplete.style.cssText = `
            position: fixed;
            bottom: 20px;
            right: 20px;
            background: rgba(255, 107, 53, 0.9);
            color: white;
            padding: 10px 20px;
            border-radius: 20px;
            font-weight: bold;
            z-index: 1000;
            animation: slideInRight 0.5s ease-out;
        `;

        document.body.appendChild(loadingComplete);

        setTimeout(() => {
            loadingComplete.style.animation = 'slideOutRight 0.5s ease-out';
            setTimeout(() => loadingComplete.remove(), 500);
        }, 3000);
    }, 1000);
});

const additionalStyles = document.createElement('style');
additionalStyles.textContent = `
    @keyframes slideInRight {
        from { transform: translateX(100%); opacity: 0; }
        to { transform: translateX(0); opacity: 1; }
    }

    @keyframes slideOutRight {
        from { transform: translateX(0); opacity: 1; }
        to { transform: translateX(100%); opacity: 0; }
    }

    .loaded .main-animation {
        animation: finalGlow 2s ease-in-out infinite alternate;
    }

    @keyframes finalGlow {
        from { filter: drop-shadow(0 0 5px rgba(255, 215, 0, 0.3)); }
        to { filter: drop-shadow(0 0 20px rgba(255, 215, 0, 0.6)); }
    }
`;
document.head.appendChild(additionalStyles);