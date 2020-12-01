package encryption;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import utils.Seed256;

public class Application {
    private static final String USER_INFO_TXT_PATH = "C:\\Users\\YOUNGJOO\\Desktop\\project_encryption\\src\\main\\resources\\userInfo.txt";

    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        while (true) {
            String selection = selectMenu(inputView);
            if (selection.equals("1")) {
                signUp(inputView);
            }
            if (selection.equals("2")) {
                logIn(inputView);
            }
        }
    }

    public static String selectMenu(InputView inputView) {
        String menuSelect;
        try {
            menuSelect = inputView.printMenuSelectView();
            MenuSelectValidator.validateMenuSelectIsOneOrTwo(menuSelect);
            return menuSelect;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectMenu(inputView);
        }
    }

    public static void signUp(InputView inputView) throws IOException {
        String id;
        String password;
        try {
            id = inputView.printIdInput();
            password = inputView.printPasswordInput();
            IdPasswordValidator.validateSignUp(id, password);
            saveUserIDPassword(id, password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            signUp(inputView);
        }
    }

    public static void saveUserIDPassword(String id, String password) throws IOException {
        FileWriter fileWriter = new FileWriter(USER_INFO_TXT_PATH, true); // true argument는 이어서 쓰기를 가능하게 함
        PrintWriter printWriter = new PrintWriter(fileWriter);

        id = Seed256.Encrypt(id); // ID 암호화
        password = Seed256.Encrypt(password); // Password 암호화
        printWriter.println(id + "," + password);
        System.out.println("계정이 생성되었습니다.");

        printWriter.close();
        fileWriter.close();
    }

    public static void logIn(InputView inputView) throws IOException {
        String id;
        String password;
        try {
            id = inputView.printIdInput();
            password = inputView.printPasswordInput();
            IdPasswordValidator.validateLogIn(id, password);
            System.out.println("올바른 계정입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            logIn(inputView);
        }
    }
}
