package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceUnitTest {

    // Valid credentials
    @Test
    public void testLogin_AllCorrect_ReturnsTrue() {
        assertTrue(LoginService.login("kavish", "kavish193", "2005-03-19"));
    }

    // Wrong username
    @Test
    public void testLogin_WrongUsername_ReturnsFalse() {
        assertFalse(LoginService.login("wronguser", "kavish193", "2005-03-19"));
    }

    // Wrong password
    @Test
    public void testLogin_WrongPassword_ReturnsFalse() {
        assertFalse(LoginService.login("kavish", "wrongpass", "2005-03-19"));
    }

    // Wrong DoB
    @Test
    public void testLogin_WrongDob_ReturnsFalse() {
        assertFalse(LoginService.login("kavish", "kavish193", "2000-12-31"));
    }

    // All wrong
    @Test
    public void testLogin_AllWrong_ReturnsFalse() {
        assertFalse(LoginService.login("nobody", "badpass", "1999-09-09"));
    }

    // Null username
    @Test
    public void testLogin_NullUsername_ReturnsFalse() {
        assertFalse(LoginService.login(null, "kavish193", "2005-03-19"));
    }

    // Null password
    @Test
    public void testLogin_NullPassword_ReturnsFalse() {
        assertFalse(LoginService.login("kavish", null, "2005-03-19"));
    }

    // Null DoB
    @Test
    public void testLogin_NullDob_ReturnsFalse() {
        assertFalse(LoginService.login("kavish", "kavish193", null));
    }

    // Empty username
    @Test
    public void testLogin_EmptyUsername_ReturnsFalse() {
        assertFalse(LoginService.login("", "kavish193", "2005-03-19"));
    }

    // Empty password
    @Test
    public void testLogin_EmptyPassword_ReturnsFalse() {
        assertFalse(LoginService.login("kavish", "", "2005-03-19"));
    }

    // Empty DoB
    @Test
    public void testLogin_EmptyDob_ReturnsFalse() {
        assertFalse(LoginService.login("kavish", "kavish193", ""));
    }

    // Only username correct
    @Test
    public void testLogin_OnlyUsernameCorrect_ReturnsFalse() {
        assertFalse(LoginService.login("kavish", "badpass", "2001-01-01"));
    }

    // Only password correct
    @Test
    public void testLogin_OnlyPasswordCorrect_ReturnsFalse() {
        assertFalse(LoginService.login("baduser", "kavish193", "2001-01-01"));
    }

    // Only DoB correct
    @Test
    public void testLogin_OnlyDobCorrect_ReturnsFalse() {
        assertFalse(LoginService.login("baduser", "badpass", "2005-03-19"));
    }

    // Username + password correct, DoB wrong
    @Test
    public void testLogin_UsernamePasswordCorrect_DobWrong_ReturnsFalse() {
        assertFalse(LoginService.login("kavish", "kavish193", "1991-05-20"));
    }

    // Valid date format
    @Test
    public void testIsValidDateFormat_Valid_ReturnsTrue() {
        assertTrue(LoginService.isValidDateFormat("2005-03-19"));
    }

    // Wrong separator
    @Test
    public void testIsValidDateFormat_SlashSeparator_ReturnsFalse() {
        assertFalse(LoginService.isValidDateFormat("2005/03/19"));
    }

    // Wrong order
    @Test
    public void testIsValidDateFormat_WrongOrder_ReturnsFalse() {
        assertFalse(LoginService.isValidDateFormat("19-03-2005"));
    }

    // Impossible date
    @Test
    public void testIsValidDateFormat_ImpossibleDate_ReturnsFalse() {
        assertFalse(LoginService.isValidDateFormat("2000-02-30"));
    }

    // Null
    @Test
    public void testIsValidDateFormat_Null_ReturnsFalse() {
        assertFalse(LoginService.isValidDateFormat(null));
    }

    // Leap day valid
    @Test
    public void testIsValidDateFormat_LeapDay_Valid_ReturnsTrue() {
        assertTrue(LoginService.isValidDateFormat("2000-02-29"));
    }

    // Leap day invalid year
    @Test
    public void testIsValidDateFormat_LeapDay_Invalid_ReturnsFalse() {
        assertFalse(LoginService.isValidDateFormat("1900-02-29"));
    }
}