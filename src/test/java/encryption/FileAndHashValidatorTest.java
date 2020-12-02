package encryption;

import org.junit.Test;

import validator.FileAndHashValidator;

public class FileAndHashValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void 파일_이름에_공백_예외발생() {
        FileAndHashValidator.checkSpace(" .txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 해시값에_공백_예외발생() {
        FileAndHashValidator.checkSpace("532fa3634 8ec32f32c70e0353212a31");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 파일_이름_없이_입력시_예외발생() {
        FileAndHashValidator.checkFileContainsName(".txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 파일_확장자_없이_입력시_예외발생() {
        FileAndHashValidator.checkFileContainsExtensions("data");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 파일_존재하지_않을시_예외발생() {
        FileAndHashValidator.checkFileExists("data.txt");
    }
}
