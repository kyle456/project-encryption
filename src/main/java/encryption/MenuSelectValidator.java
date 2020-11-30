package encryption;

public class MenuSelectValidator {
    private static final String SIGN_UP = "1";
    private static final String LOG_IN = "2";

    public static void validateMenuSelectIsOneOrTwo(String menuSelect) {
        if (menuSelect.equals(SIGN_UP) || menuSelect.equals(LOG_IN)) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.(1.회원가입 / 2.로그인)");
        }
    }
}
