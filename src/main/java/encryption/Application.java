package encryption;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        final User user = new User(inputView);
        final File file = new File(inputView);

        while (true) {
//            String userSystem = user.selectMenu();
//            if (userSystem.equals("1")) {
//                user.signUp();
//            }
//            if (userSystem.equals("2")) {
//                user.logIn();
//            }

            String fileSystem = file.selectMenu();
            if (fileSystem.equals("1")) {
                file.printHashValue();
            }
            if (fileSystem.equals("2")) {
                file.printModulationYesOrNo();
            }
        }
    }
}
