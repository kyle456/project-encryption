package encryption;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import validator.MenuSelectValidator;

public class Application {
    private static final String MENU_ONE = "1";
    private static final String MENU_TWO = "2";
    private static final String QUIT = "3";
    private static final String LOG_IN_SYSTEM = "login system";
    private static final String FILE_SYSTEM = "file system";

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        final User user = new User(inputView);
        final FileAndHash fileAndHash = new FileAndHash(inputView);

        while (true) {
            operateLogInSystem(inputView, user);
            operateFileSystem(inputView, fileAndHash);
        }
    }

    public static String selectMenu(InputView inputView, String option) {
        String menuSelect;
        if (option.equals(LOG_IN_SYSTEM)) {
            menuSelect = inputView.printUserMenu();
        } else {
            menuSelect = inputView.printFileMenu();
        }
        try {
            MenuSelectValidator.validateMenuSelectIsOneOrTwo(menuSelect);
            return menuSelect;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectMenu(inputView, option);
        }
    }

    public static void operateLogInSystem(InputView inputView, User user) throws IOException {
        boolean successLogIn = false;
        while (!successLogIn) {
            switch (selectMenu(inputView, LOG_IN_SYSTEM)) {
            case MENU_ONE:
                user.signUp();
                break;
            case MENU_TWO:
                successLogIn = user.isLogIn(); // 로그인 성공 시 "파일 변조 확인 시스템"으로 이동
                break;
            case QUIT:
                System.out.println("프로그램을 종료 합니다. 이용해주셔서 감사합니다.");
                System.exit(0);
            }
        }
    }

    public static void operateFileSystem(InputView inputView, FileAndHash fileAndHash)
            throws NoSuchAlgorithmException, IOException {
        while (true) {
            switch (selectMenu(inputView, FILE_SYSTEM)) {
            case MENU_ONE:
                fileAndHash.searchFileHashValue();
                break;
            case MENU_TWO:
                fileAndHash.searchModulationYesOrNo();
                break;
            case QUIT:
                System.out.println("로그아웃 합니다.\n");
                return;
            }
        }
    }
}
