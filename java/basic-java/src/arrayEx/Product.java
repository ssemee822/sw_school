package arrayEx;

//| **요구사항** | **설명** |
//| --- | --- |
//| 멤버 변수 | name: String, price: BigDecimal |
//| 생성자 | Product(String name, String price) (문자열 입력 받아 BigDecimal로 변환) |
//| 메서드 | getName(), getPrice() |
//| 제약 | 추가 멤버 변수 X, float/double X |

import java.math.BigDecimal;

public class Product {
    String name;
    BigDecimal price;

    public Product(String name, String price) {
        this.name = name;
        this.price = new BigDecimal(price);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
