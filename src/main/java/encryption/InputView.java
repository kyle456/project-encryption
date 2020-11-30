package encryption;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String printMenuSelectView() {
        System.out.println("1. 회원 가입");
        System.out.println("2. 로그인");
        System.out.print("메뉴를 선택하세요 : ");
        return scanner.nextLine();
    }
}
