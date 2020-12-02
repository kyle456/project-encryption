package encryption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import utils.Seed256;

public class IdPasswordValidator {
    private static final String SPACE = " ";
    private static final String SPLIT_REGEX_ID_PASSWORD = ",";
    private static final String FILE_PATH = "utilFiles/userInfo.txt";

    private static final int ID = 0;
    private static final int PASSWORD = 1;

    public static void validateSignUp(String id, String password) throws IOException {
        checkIdPasswordContainsSpace(id, password);
        checkIdDuplication(id);
    }

    public static void validateLogIn(String id, String password) throws IOException {
        checkIdPasswordContainsSpace(id, password);
        checkIdPasswordIsCorrect(id, password);
    }

    public static void checkIdPasswordContainsSpace(String id, String password) {
        if (id.contains(SPACE) || password.contains(SPACE)) {
            throw new IllegalArgumentException("ID 또는 Password에 공백이 입력되었습니다. 다시 입력해주세요.\n");
        }
    }

    public static void checkIdDuplication(String id) throws IOException {
        FileReader userInfo = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(userInfo);
        String line;
        String existedId;
        while (true) {
            line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            existedId = Seed256.Decrypt(line.split(SPLIT_REGEX_ID_PASSWORD)[ID]); // ID 복호화
            if (id.equals(existedId)) {
                bufferedReader.close();
                throw new IllegalArgumentException("이미 생성된 계정입니다.\n");
            }
        }
        bufferedReader.close();
    }

    public static void checkIdPasswordIsCorrect(String id, String password) throws IOException {
        FileReader userInfo = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(userInfo);
        String line;
        String[] splitedLine;
        String checkId;
        String checkPassword;
        while (true) {
            line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            splitedLine = line.split(SPLIT_REGEX_ID_PASSWORD);
            checkId = Seed256.Decrypt(splitedLine[ID]); // ID 복호화
            checkPassword = Seed256.Decrypt(splitedLine[PASSWORD]); // Password 복호화
            if (id.equals(checkId) && password.equals(checkPassword)) {
                bufferedReader.close();
                return;
            }
        }
        bufferedReader.close();
        throw new IllegalArgumentException("잘못된 계정입니다.\n");
    }
}
