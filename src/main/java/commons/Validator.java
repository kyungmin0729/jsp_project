package commons;

public interface Validator<T> {
    //검증하는 인터페이스(지네릭스)
    void check(T t);
}
