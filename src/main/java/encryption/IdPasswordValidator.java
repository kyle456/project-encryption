package encryption;

public class IdPasswordValidator {   
    public static void validateSignUp(String id, String password) {
        checkIdPasswordContainsSpace(id, password);
        // 이미 존재하는 id, password 일 경우 회원가입 예외처리 추가
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
}
