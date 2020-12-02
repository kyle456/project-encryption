package encryption;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import utils.MD5;

public class FileAndHash {
    private static final String PATH_OF_SEARCHING_FOLDER = "utilFiles";

    private InputView inputView;

    FileAndHash(InputView inputView) {
        this.inputView = inputView;
    }

    public String selectMenu() {
        String menuSelect;
        try {
            menuSelect = inputView.printFileMenu();
            MenuSelectValidator.validateMenuSelectIsOneOrTwo(menuSelect);
            return menuSelect;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectMenu();
        }
    }

    public void printHashValue() throws NoSuchAlgorithmException, IOException {
        try {
            String fileName = inputView.printFileNameInput();
            FileAndHashValidator.validateFile(fileName);
            getHashValueOfFile(fileName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            printHashValue();
        }
    }

    public void printModulationYesOrNo() throws NoSuchAlgorithmException, IOException {
        try {
            String fileName = inputView.printFileNameInput();
            String hashValue = inputView.printHashValueInput();
            FileAndHashValidator.validateFile(fileName);
            FileAndHashValidator.checkSpace(hashValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            printHashValue();
        }
    }

    public void getHashValueOfFile(String fileName) throws NoSuchAlgorithmException, IOException {
        File file = new File(PATH_OF_SEARCHING_FOLDER);
        String[] fileNameList = file.list();
        for (String eachFileName : fileNameList) {
            if (fileName.equals(eachFileName)) {
                String filePath = PATH_OF_SEARCHING_FOLDER + "/" + fileName;
                System.out.println(fileName + "의 해시 값(md5)은 " + MD5.getHash(filePath));
                return;
            }
        }
        System.out.println("해당 파일이 존재하지 않습니다.");
    }
}
