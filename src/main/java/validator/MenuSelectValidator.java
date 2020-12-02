package validator;

public class MenuSelectValidator {
    private static final String MENU_ONE = "1";
    private static final String MENU_TWO = "2";
    private static final String QUIT = "3";

    public static void validateMenuSelectIsOneOrTwo(String menuSelect) {
        if (!menuSelect.equals(MENU_ONE) && !menuSelect.equals(MENU_TWO) && !menuSelect.equals(QUIT)) {
            throw new IllegalArgumentException("1, 2, 3 중에서만 입력해야 합니다.\n");
        }
    }
}
