package encryption;

import org.junit.Test;

public class MenuSelectValidatorTest {   
    @Test(expected = IllegalArgumentException.class)
    public void 다른숫자_입력시_예외발생() {
        MenuSelectValidator.validateMenuSelectIsOneOrTwo("9");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void 문자_입력시_예외발생() {
        MenuSelectValidator.validateMenuSelectIsOneOrTwo("+");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void 공백_입력시_예외발생() {
        MenuSelectValidator.validateMenuSelectIsOneOrTwo(" ");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void 줄바꿈_입력시_예외발생() {
        MenuSelectValidator.validateMenuSelectIsOneOrTwo("\\n");
    }
}
