package sit707_week4;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginFormTest {

    private static final String VALID_USER = "ahsan";
    private static final String VALID_PASS = "ahsan_pass";
    private static final String VALID_CODE = "123456";
    private static final String WRONG_USER = "wronguser";
    private static final String WRONG_PASS = "wrongpass";
    private static final String WRONG_CODE = "abcd";
    
    private static final String STUDENT_NAME = "Kavish";
    private static final String STUDENT_ID = "225138433";
    
    @Test
    public void testStudentName() {
        String name = "Kavish";
        assertEquals(STUDENT_NAME, name);
    }

    @Test
    public void testStudentId() {
        String id = "225138433";
        assertEquals(STUDENT_ID, id);
    }

    // Col 1: empty username, empty password: fail "Empty Username"
    @Test
    public void testEmptyUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login(null, null);
        assertFalse(status.isLoginSuccess());
        assertEquals("Empty Username", status.getErrorMsg());
    }

    // Col 2: empty username, wrong password: fail "Empty Username"
    @Test
    public void testEmptyUsernameWrongPassword() {
        LoginStatus status = LoginForm.login(null, WRONG_PASS);
        assertFalse(status.isLoginSuccess());
        assertEquals("Empty Username", status.getErrorMsg());
    }

    // Col 3: empty username, correct password: fail "Empty Username"
    @Test
    public void testEmptyUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login(null, VALID_PASS);
        assertFalse(status.isLoginSuccess());
        assertEquals("Empty Username", status.getErrorMsg());
    }

    // Col 4: wrong username, empty password: fail "Empty Password"
    @Test
    public void testWrongUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login(WRONG_USER, null);
        assertFalse(status.isLoginSuccess());
        assertEquals("Empty Password", status.getErrorMsg());
    }

    // Col 5: wrong username, wrong password: fail "Credential mismatch"
    @Test
    public void testWrongUsernameWrongPassword() {
        LoginStatus status = LoginForm.login(WRONG_USER, WRONG_PASS);
        assertFalse(status.isLoginSuccess());
        assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // Col 6: wrong username, correct password: fail "Credential mismatch"
    @Test
    public void testWrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login(WRONG_USER, VALID_PASS);
        assertFalse(status.isLoginSuccess());
        assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // Col 7: correct username, empty password: fail "Empty Password"
    @Test
    public void testCorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login(VALID_USER, null);
        assertFalse(status.isLoginSuccess());
        assertEquals("Empty Password", status.getErrorMsg());
    }

    // Col 8: correct username, wrong password: fail "Credential mismatch"
    @Test
    public void testCorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login(VALID_USER, WRONG_PASS);
        assertFalse(status.isLoginSuccess());
        assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // Col 9: correct username, correct password, empty code: login success, validateCode false
    @Test
    public void testLoginSuccessEmptyValidationCode() {
        LoginStatus status = LoginForm.login(VALID_USER, VALID_PASS);
        assertTrue(status.isLoginSuccess());
        assertFalse(LoginForm.validateCode(null));
    }

    // Col 10: correct username, correct password, wrong code: login success, validateCode false
    @Test
    public void testLoginSuccessWrongValidationCode() {
        LoginStatus status = LoginForm.login(VALID_USER, VALID_PASS);
        assertTrue(status.isLoginSuccess());
        assertFalse(LoginForm.validateCode(WRONG_CODE));
    }

    // Col 11: correct username, correct password, correct code: login success, validateCode true
    @Test
    public void testLoginSuccessCorrectValidationCode() {
        LoginStatus status = LoginForm.login(VALID_USER, VALID_PASS);
        assertTrue(status.isLoginSuccess());
        assertTrue(LoginForm.validateCode(VALID_CODE));
    }
}