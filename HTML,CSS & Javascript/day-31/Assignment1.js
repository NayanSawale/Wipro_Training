console.log 
 let user = {
    name: "Nayan Sawale",
    email: "sawalenayan.h@gmail.com",
    age: 22,
    // Function to update the name
    changeName: function(newName) {
        this.name = newName;
    },
    // Function to update the email
    updateEmail: function(newEmail) {
        this.email = newEmail;
    },
    // Function to calculate birth year based on current year
    calculateBirthYear: function() {
        let currentYear = new Date().getFullYear();
        return currentYear - this.age;
    }
};

// Testing initial values
console.log("Initial user:", user);

// Change the name
user.changeName("Gaurav sawale");
console.log("Updated name:", user.name);

// Update the email
user.updateEmail("sawalegaurav@gmail.com");
console.log("Updated email:", user.email);

// Calculate birth year
let birthYear = user.calculateBirthYear();
console.log("Birth year:", birthYear);