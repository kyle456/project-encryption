package encryption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IdPasswordValidator {
    private static final int ID = 0;
    
    public static void validateSignUp(String id, String password) throws IOException {
        checkIdPasswordContainsSpace(id, password);
        checkIdDuplication(id);
    }

    public static void validateLogIn(String id, String password) {
        checkIdPasswordContainsSpace(id, password);
        // 존재하지 않는 id, password 일 경우 로그인 예외처리 추가
    }

    public static void checkIdPasswordContainsSpace(String id, String password) {
        if (id.contains(" ") || id.contains("\\n")) {
            throw new IllegalArgumentException("ID 또는 Password에 공백이 입력되었습니다. 다시 입력해주세요.");
        }
    }

    public static void checkIdDuplication(String id) throws IOException {
        FileReader userInfo = new FileReader(
                "C:\\Users\\YOUNGJOO\\Desktop\\project_encryption\\src\\main\\resources\\userInfo.txt");
        BufferedReader bufferedReader = new BufferedReader(userInfo);
        String line;
        String existedId;
        while (true) {
            line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            existedId = line.split(",")[ID];
            if (id.equals(existedId)) {
                throw new IllegalArgumentException("이미 생성된 계정입니다.");
            }
        }
        bufferedReader.close();
    }
}
