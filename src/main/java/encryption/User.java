package encryption;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import utils.Seed256;

public class User {
    private static final String FILE_PATH = "utilFiles/userInfo.txt";
    private InputView inputView;

    User(InputView inputView) {
        this.inputView = inputView;
    }

    public String selectMenu() {
        String menuSelect;
        try {
            menuSelect = inputView.printUserMenu();
            MenuSelectValidator.validateMenuSelectIsOneOrTwo(menuSelect);
            return menuSelect;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectMenu();
        }
    }

    public void signUp() throws IOException {
        try {
            String id = inputView.printIdInput();
            String password = inputView.printPasswordInput();
            IdPasswordValidator.validateSignUp(id, password);
            saveUserIDPassword(id, password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            signUp();
        }
    }

    public void saveUserIDPassword(String id, String password) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH, true); // 'true' argument는 이어서 쓰기를 가능하게 함
        PrintWriter printWriter = new PrintWriter(fileWriter);

        id = Seed256.Encrypt(id); // ID 암호화
        password = Seed256.Encrypt(password); // Password 암호화
        printWriter.println(id + "," + password);
        System.out.println("계정이 생성되었습니다.");

        printWriter.close();
        fileWriter.close();
    }

    public void logIn() throws IOException {
        try {
            String id = inputView.printIdInput();
            String password = inputView.printPasswordInput();
            IdPasswordValidator.validateLogIn(id, password);
            System.out.println("올바른 계정입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            logIn();
        }
    }
}
