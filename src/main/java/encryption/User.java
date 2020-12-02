package encryption;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import utils.Seed256;
import validator.IdPasswordValidator;

public class User {
    private static final String FILE_PATH = "utilFiles/userInfo.txt";
    private InputView inputView;

    User(InputView inputView) {
        this.inputView = inputView;
    }

    public void signUp() throws IOException {
        try {
            String id = inputView.printIdInput();
            String password = inputView.printPasswordInput();
            IdPasswordValidator.validateSignUp(id, password);
            saveUserIDPassword(id, password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUserIDPassword(String id, String password) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH, true); // 'true' argument는 이어서 쓰기를 가능하게 함
        PrintWriter printWriter = new PrintWriter(fileWriter);

        id = Seed256.Encrypt(id); // ID 암호화
        password = Seed256.Encrypt(password); // Password 암호화
        printWriter.println(id + "," + password);
        System.out.println("계정이 생성되었습니다.\n");

        printWriter.close();
        fileWriter.close();
    }

    public boolean isLogIn() throws IOException {
        try {
            String id = inputView.printIdInput();
            String password = inputView.printPasswordInput();
            IdPasswordValidator.validateLogIn(id, password);
            System.out.println("올바른 계정입니다. 파일 변조 확인 시스템으로 이동합니다.\n");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
