package commons;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message); //super() 생성하지 않으면 기본 생성자만 만들어짐
    }
}
