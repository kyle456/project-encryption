package encryption;

public class FileAndHashValidator {
    private static final String SPACE = " ";
    private static final String ENTER = "\\n";

    private static final char DOT = '.';
    private static final int FIRST_CHARACTER = 0;

    public static void validateFile(String fileName) {
        checkSpace(fileName);
        checkFileContainsName(fileName);
        checkFileContainsExtensions(fileName);
        checkFileExists(fileName);
    }

    public static void checkFileContainsName(String fileName) {
        if (fileName.charAt(FIRST_CHARACTER) == DOT) {
            throw new IllegalArgumentException("파일의 이름이 입력되지 않았습니다. 다시 입력해주세요.");
        }
    }

    public static void checkFileContainsExtensions(String fileName) {
        if (!fileName.contains(Character.toString(DOT))) {
            throw new IllegalArgumentException("파일의 확장자가 입력되지 않았습니다. 다시 입력해주세요.");
        }
    }

    public static void checkFileExists(String fileName) {
        // 파일이 존재하는가? : md5 알고리즘 적용 후 구현 예정
    }

    public static void checkSpace(String input) {
        if (input.contains(SPACE) || input.contains(ENTER)) {
            throw new IllegalArgumentException("파일 혹은 해시 값에 공백이 입력되었습니다. 다시 입력해주세요.");
        }
    }
}