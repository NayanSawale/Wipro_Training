document.addEventListener('DOMContentLoaded', () => {
    const registrationForm = document.getElementById('registrationForm');
    const loginForm = document.getElementById('loginForm');

    // Validate Registration Form
    registrationForm.addEventListener('submit', (event) => {
        let isValid = true;

        const username = document.getElementById('reg-username');
        const email = document.getElementById('reg-email');
        const password = document.getElementById('reg-password');
        const confirmPassword = document.getElementById('reg-confirm-password');

        // Clear previous error messages
        clearErrors(registrationForm);

        if (username.value.trim() === '') {
            showError(username, 'Username is required.');
            isValid = false;
        }

        if (email.value.trim() === '') {
            showError(email, 'Email is required.');
            isValid = false;
        } else if (!validateEmail(email.value.trim())) {
            showError(email, 'Email is not valid.');
            isValid = false;
        }

        if (password.value.trim() === '') {
            showError(password, 'Password is required.');
            isValid = false;
        }

        if (confirmPassword.value.trim() === '') {
            showError(confirmPassword, 'Confirm Password is required.');
            isValid = false;
        } else if (password.value.trim() !== confirmPassword.value.trim()) {
            showError(confirmPassword, 'Passwords do not match.');
            isValid = false;
        }

        if (!isValid) {
            event.preventDefault();
        }
    });

    // Validate Login Form
    loginForm.addEventListener('submit', (event) => {
        let isValid = true;

        const username = document.getElementById('login-username');
        const password = document.getElementById('login-password');

        // Clear previous error messages
        clearErrors(loginForm);

        if (username.value.trim() === '') {
            showError(username, 'Username is required.');
            isValid = false;
        }

        if (password.value.trim() === '') {
            showError(password, 'Password is required.');
            isValid = false;
        }

        if (!isValid) {
            event.preventDefault();
        }
    });

    // Show error message
    function showError(input, message) {
        const errorElement = input.nextElementSibling;
        errorElement.textContent = message;
    }

    // Clear all error messages
    function clearErrors(form) {
        const errorElements = form.querySelectorAll('.error');
        errorElements.forEach(element => {
            element.textContent = '';
        });
    }

    // Validate email format
    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    }
});