package commons;

public interface RequiredValidator {
    //예외발생 관리
    default void requiredCheck(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }

    //약관동의 검증
    default void requiredTrue(boolean result, RuntimeException e) {
        if (!result) {
            throw e;
        }
    }
}
