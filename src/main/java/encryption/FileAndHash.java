package encryption;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import utils.MD5;

public class FileAndHash {
    private static final String PATH_OF_SEARCHING_FOLDER = "utilFiles";

    private InputView inputView;

    FileAndHash(InputView inputView) {
        this.inputView = inputView;
    }

    public void searchFileHashValue() throws NoSuchAlgorithmException, IOException {
        try {
            String fileName = inputView.printFileNameInput();
            FileAndHashValidator.validateFile(fileName);
            printHashValue(fileName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchModulationYesOrNo() throws NoSuchAlgorithmException, IOException {
        try {
            String fileName = inputView.printFileNameInput();
            String hashValue = inputView.printHashValueInput();
            FileAndHashValidator.validateFile(fileName);
            FileAndHashValidator.checkSpace(hashValue);
            printModulation(fileName, hashValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printHashValue(String fileName) throws NoSuchAlgorithmException, IOException {
        String filePath = PATH_OF_SEARCHING_FOLDER + "/" + fileName;
        System.out.println(fileName + "의 해시 값(md5)은 " + MD5.getHash(filePath) + "\n");
    }

    public void printModulation(String fileName, String hashValue) throws NoSuchAlgorithmException, IOException {
        String filePath = PATH_OF_SEARCHING_FOLDER + "/" + fileName;
        if (hashValue.equals(MD5.getHash(filePath))) {
            System.out.println("올바른 파일입니다.\n");
            return;
        }
        System.out.println("해시 값이 다릅니다. 파일의 변조 가능성이 있습니다.\n");
    }
}
