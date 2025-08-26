 // Função para navegar para as páginas
        function navigateTo(page) {
            window.location.href = page;
        }
        
        // Animações de contagem para as estatísticas
        function animateCounter(elementId, finalValue, duration) {
            let startTime = null;
            const element = document.getElementById(elementId);
            const initialValue = 0;
            
            function updateCounter(timestamp) {
                if (!startTime) startTime = timestamp;
                const progress = Math.min((timestamp - startTime) / duration, 1);
                const currentValue = Math.floor(progress * finalValue);
                element.textContent = currentValue;
                
                if (progress < 1) {
                    requestAnimationFrame(updateCounter);
                } else {
                    element.textContent = finalValue;
                }
            }
            
            requestAnimationFrame(updateCounter);
        }
        
        // Iniciar animações quando a página carregar
        document.addEventListener('DOMContentLoaded', function() {
            // Valores simulados - você pode substituir por valores real do seu banco
            animateCounter('players-count', 42, 2000);
            animateCounter('games-count', 15, 2000);
            animateCounter('scores-count', 128, 2000);
            animateCounter('active-count', 28, 2000);
            
            // Adicionar efeitos de hover nos cards
            const cards = document.querySelectorAll('.card');
            cards.forEach(card => {
                card.addEventListener('mouseenter', function() {
                    this.style.transform = 'translateY(-10px)';
                    this.style.boxShadow = '0 12px 20px rgba(0, 0, 0, 0.3)';
                    this.style.background = 'rgba(255, 255, 255, 0.15)';
                });
                
                card.addEventListener('mouseleave', function() {
                    this.style.transform = 'translateY(0)';
                    this.style.boxShadow = 'none';
                    this.style.background = 'rgba(255, 255, 255, 0.1)';
                });
            });
        });