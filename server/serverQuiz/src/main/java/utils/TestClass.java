package utils;

public class TestClass {
    public static void main(String [] args){
        String token = JWToken.create("test","asdf");
        JWToken.decode(token);

    }
}
