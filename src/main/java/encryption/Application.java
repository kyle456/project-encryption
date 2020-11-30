package encryption;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputview = new InputView(scanner);

        String menuSelect;

        try {
            menuSelect = inputview.printMenuSelectView();
            MenuSelectValidator.validateMenuSelectIsOneOrTwo(menuSelect);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // 반복 추가
        }
    }
}
