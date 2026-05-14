package web.service;

/**
 * Business logic to handle registration functions.
 */
public class RegistrationService {

    public static boolean register(
            String fName, String lName, String username,
            String password, String email, String phone,
            String gender, String dob) {

        // Validate first name
        if (fName == null || fName.trim().isEmpty()) {
            System.out.println("Registration failed: First name is empty.");
            return false;
        }

        // Validate last name
        if (lName == null || lName.trim().isEmpty()) {
            System.out.println("Registration failed: Last name is empty.");
            return false;
        }

        // Validate username
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Registration failed: Username is empty.");
            return false;
        }

        // Validate password
        if (password == null || password.trim().isEmpty()) {
            System.out.println("Registration failed: Password is empty.");
            return false;
        }

        // Validate email format
        if (email == null || !email.contains("@") || !email.contains(".")) {
            System.out.println("Registration failed: Invalid email.");
            return false;
        }

        // Validate phone
        if (phone == null || phone.trim().isEmpty()) {
            System.out.println("Registration failed: Phone is empty.");
            return false;
        }

        // Validate gender
        if (gender == null || gender.trim().isEmpty()) {
            System.out.println("Registration failed: Gender is empty.");
            return false;
        }

        // Validate DOB
        if (dob == null || dob.trim().isEmpty()) {
            System.out.println("Registration failed: DOB is empty.");
            return false;
        }

        System.out.println("Registration successful for: " + username);
        return true;
    }
}