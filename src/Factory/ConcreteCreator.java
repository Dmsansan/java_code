package Factory;

public class ConcreteCreator {


    public static <T extends Product> T createProduct(Class<T> clazz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) { //异常处理
            e.printStackTrace();
        }
        return (T) product;
    }
}