package encryption;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        final User user = new User(inputView);
        final FileAndHash fileAndHash = new FileAndHash(inputView);

        while (true) {
//            String userSystem = user.selectMenu();
//            if (userSystem.equals("1")) {
//                user.signUp();
//            }
//            if (userSystem.equals("2")) {
//                user.logIn();
//            }

            String fileSystem = fileAndHash.selectMenu();
            if (fileSystem.equals("1")) {
                fileAndHash.searchFileHashValue();
            }
            if (fileSystem.equals("2")) {
                fileAndHash.searchModulationYesOrNo();
            }
        }
    }
}
