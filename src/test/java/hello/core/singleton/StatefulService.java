package hello.core.singleton;

public class StatefulService {
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 지역변수 사용이 아닌 price 자체를 return 하는 방식으로 변경해야함
    }

    public int getPrice() {
        return price;
    }
}
