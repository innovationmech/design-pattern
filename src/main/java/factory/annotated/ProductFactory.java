package factory.annotated;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {

    private static final Map<String, Class<? extends Product>> PRODUCT_REGISTRY = new HashMap<>();

    static {
        Reflections reflections = new Reflections("factory.annotated");
        for (Class<?> clazz : reflections.getTypesAnnotatedWith(ProductType.class)) {
            ProductType annotation = clazz.getAnnotation(ProductType.class);
            PRODUCT_REGISTRY.put(annotation.value(), clazz.asSubclass(Product.class));
        }
    }

    public static Product createProduct(String type) throws Exception {
        Class<? extends Product> clazz = PRODUCT_REGISTRY.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }
        return clazz.getDeclaredConstructor().newInstance();
    }
}
