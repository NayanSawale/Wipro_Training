document.getElementById('emailForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting

    const emailInput = document.getElementById('email').value;
    const messageElement = document.getElementById('message');

    // Regular expression for validating an email address
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    // Check if the email matches the regular expression
    if (emailRegex.test(emailInput)) {
        messageElement.textContent = 'Email is valid!';
        messageElement.className = 'success';
    } else {
        messageElement.textContent = 'Invalid email format. Please enter a correct email.';
        messageElement.className = 'error';
    }
});