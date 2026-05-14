package web.service;

import org.junit.Assert;
import org.junit.Test;

public class RegistrationServiceTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "225138433";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Kavish Choudhary";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // Successful registration

    @Test
    public void testRegisterSuccess() {
        Assert.assertTrue(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", "2000-01-01"));
    }

    // First name validation

    @Test
    public void testRegisterEmptyFirstName() {
        Assert.assertFalse(RegistrationService.register(
                "", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", "2000-01-01"));
    }

    @Test
    public void testRegisterNullFirstName() {
        Assert.assertFalse(RegistrationService.register(
                null, "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", "2000-01-01"));
    }

    // Last name validation

    @Test
    public void testRegisterEmptyLastName() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", "2000-01-01"));
    }

    @Test
    public void testRegisterNullLastName() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", null, "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", "2000-01-01"));
    }

    // Username validation

    @Test
    public void testRegisterEmptyUsername() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "",
                "pass123", "kavish@email.com", "0412345678",
                "male", "2000-01-01"));
    }

    @Test
    public void testRegisterNullUsername() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", null,
                "pass123", "kavish@email.com", "0412345678",
                "male", "2000-01-01"));
    }

    // Password validation

    @Test
    public void testRegisterEmptyPassword() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "", "kavish@email.com", "0412345678",
                "male", "2000-01-01"));
    }

    @Test
    public void testRegisterNullPassword() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                null, "kavish@email.com", "0412345678",
                "male", "2000-01-01"));
    }

    // Email validation

    @Test
    public void testRegisterInvalidEmailNoAt() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", "kavishnoatsign.com", "0412345678",
                "male", "2000-01-01"));
    }

    @Test
    public void testRegisterInvalidEmailNoDot() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@emailcom", "0412345678",
                "male", "2000-01-01"));
    }

    @Test
    public void testRegisterNullEmail() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", null, "0412345678",
                "male", "2000-01-01"));
    }

    // Phone validation

    @Test
    public void testRegisterEmptyPhone() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "",
                "male", "2000-01-01"));
    }

    @Test
    public void testRegisterNullPhone() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", null,
                "male", "2000-01-01"));
    }

    // Gender validation

    @Test
    public void testRegisterEmptyGender() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "", "2000-01-01"));
    }

    @Test
    public void testRegisterNullGender() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                null, "2000-01-01"));
    }

    // DOB validation

    @Test
    public void testRegisterEmptyDob() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", ""));
    }

    @Test
    public void testRegisterNullDob() {
        Assert.assertFalse(RegistrationService.register(
                "Kavish", "Choudhary", "kavishc",
                "pass123", "kavish@email.com", "0412345678",
                "male", null));
    }
}