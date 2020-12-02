package encryption;

import org.junit.Test;

import validator.IdPasswordValidator;

public class IdPasswordValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void 패스워드_공백_예외발생() {
        IdPasswordValidator.checkIdPasswordContainsSpace("id", "pass word");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 아이디_공백_예외발생() {
        IdPasswordValidator.checkIdPasswordContainsSpace("i d", "password");
    }
}
