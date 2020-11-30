package encryption;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputview = new InputView(scanner);

        String menuSelect;
        String id;
        String password;
        
        // 메뉴선택
        try {
            menuSelect = inputview.printMenuSelectView();
            MenuSelectValidator.validateMenuSelectIsOneOrTwo(menuSelect);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // 반복 추가
        }
        
        // 회원가입
        try {
            id = inputview.printIdInput();
            password = inputview.printPasswordInput();
            IdPasswordValidator.validateSignUp(id, password);;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // 반복 추가
        }
        
        // 로그인
        try {
            id = inputview.printIdInput();
            password = inputview.printPasswordInput();
            IdPasswordValidator.validateLogIn(id, password);;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // 반복 추가
        }
    }
}
