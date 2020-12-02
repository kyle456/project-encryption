package encryption;

public class File {
    private InputView inputView;

    File(InputView inputView) {
        this.inputView = inputView;
    }

    // 중복으로 인한 리팩토링 예정
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

    public void printHashValue() {
        try {
            String fileName = inputView.printFileNameInput();
            FileValidator.validateFile(fileName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            printHashValue();
        }
    }

    public void printModulationYesOrNo() {
        try {
            String fileName = inputView.printFileNameInput();
            String hashValue = inputView.printHashValueInput();
            FileValidator.validateFile(fileName);
            FileValidator.checkSpace(hashValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            printHashValue();
        }
    }
}
