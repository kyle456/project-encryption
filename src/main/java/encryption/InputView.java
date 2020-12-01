package encryption;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String printUserMenu() {
        System.out.println("1. 회원 가입");
        System.out.println("2. 로그인");
        System.out.print("메뉴를 선택하세요 : ");
        return scanner.nextLine();
    }

    public String printFileMenu() {
        System.out.println("1. 파일 해시값 표시");
        System.out.println("2. 변조 여부 확인");
        System.out.print("메뉴를 선택하세요 : ");
        return scanner.nextLine();
    }

    public String printIdInput() {
        System.out.print("ID : ");
        return scanner.nextLine();
    }

    public String printPasswordInput() {
        System.out.print("PW : ");
        return scanner.nextLine();
    }

    public String printFileNameInput() {
        System.out.print("파일 이름을 넣으세요 : ");
        return scanner.nextLine();
    }

    public String printHashValueInput() {
        System.out.print("파일의 해시 값(md5)을 넣으세요 : ");
        return scanner.nextLine();
    }
}
