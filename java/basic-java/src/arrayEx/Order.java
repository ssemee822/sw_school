package arrayEx;

//| **요구사항** | **설명** |
//| --- | --- |
//| 멤버 변수 | ArrayList<Product> products, BigDecimal total |
//| 생성자 | 기본 생성자에서 리스트와 총액 초기화 |
//| 주요 메서드 |
//- addItem(Product)
//- getItem(String name) → 같은 이름이 있으면 첫 번째 항목 반환
//- removeItem(String name) → 있으면 제거하고 true, 없으면 false
//- calculateFinalPrice(BigDecimal taxRate) → 소수점 둘째 자리 반올림 |
//| 제약 | 문자열 비교는 equals(), float/double X |

import java.math.BigDecimal;
import java.util.ArrayList;
import java.math.RoundingMode;

public class Order {
    ArrayList<Product> products;
    BigDecimal total;

    public Order() {
        products = new ArrayList<>();
        total = new BigDecimal(0);
    }

    public void addItem(Product product) {
        products.add(product);
        total = total.add(product.getPrice());
    }

    public Product getItem(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public boolean removeItem(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                total = total.subtract(product.getPrice());
                return true;
            }
        }
        return false;
    }

    public BigDecimal calculateFinalPrice(BigDecimal taxRate){
        BigDecimal taxAmount = total.multiply(taxRate);
        BigDecimal finalPrice = total.add(taxAmount);
        return finalPrice.setScale(2, RoundingMode.HALF_UP);
    }

    public Product[] getProducts() {
        return products.toArray(new Product[products.size()]);
    }
}
