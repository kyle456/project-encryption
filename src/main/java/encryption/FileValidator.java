package encryption;

public class FileValidator {
    private static final String SPACE = " ";
    private static final String ENTER = "\\n";

    private static final char DOT = '.';
    private static final int FIRST_CHARACTER = 0;

    public static void validateFile(String fileName) {
        checkFilecontainsName(fileName);
        checkFilecontainsExtensions(fileName);
        checkFileExists(fileName);
    }

    public static void checkFilecontainsName(String fileName) {
        if (fileName.charAt(FIRST_CHARACTER) == DOT) {
            throw new IllegalArgumentException("파일의 이름이 입력되지 않았습니다. 다시 입력해주세요.");
        }
    }

    public static void checkFilecontainsExtensions(String fileName) {
        if (!fileName.contains(Character.toString(DOT))) {
            throw new IllegalArgumentException("파일의 확장자가 입력되지 않았습니다. 다시 입력해주세요.");
        }
        // 공백.txt를 인식하는데 문제 해결해야 함
        // 이름을 입력하지 않으면 바로 예외가 뜨는데, 확장자만 입력하지 않으면 바로 뜨지 않고 해시값을 받는 화면으로 넘어감
    }

    public static void checkFileExists(String fileName) {
        // 파일이 존재하는가? : md5 알고리즘 적용 후 구현 예정
    }

    public static void checkHashValueContainsSpace(String hashValue) {
        if (hashValue.contains(SPACE) || hashValue.contains(ENTER)) {
            throw new IllegalArgumentException("해시 값에 공백이 입력되었습니다. 다시 입력해주세요.");
        }
    }
}
