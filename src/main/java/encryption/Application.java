package encryption;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Application {
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
            saveToUserInfoTxt(id, password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            signUp(inputView);
        }
    }

    public static void saveToUserInfoTxt(String id, String password) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(
                "C:\\Users\\YOUNGJOO\\Desktop\\project_encryption\\src\\main\\resources\\userInfo.txt", true)); // true 시 추가 쓰기
        String userInfo = id + "," + password;
        printWriter.println(userInfo);
        printWriter.close();
    }

    public static void logIn(InputView inputView) {
        String id;
        String password;
        try {
            id = inputView.printIdInput();
            password = inputView.printPasswordInput();
            IdPasswordValidator.validateLogIn(id, password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            logIn(inputView);
        }
    }
}
