package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { } // private로 외부에서 new 불가능

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
