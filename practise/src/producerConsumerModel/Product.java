package producerConsumerModel;

/**
 * @Author: ruan
 * Date: 2021/9/8 14:40
 * @Description: 生产者消费者产品类
 */
public class Product {
    /**
     * 厂商
     */
    private String brand;
    /**
     * 商品名
     */
    private String name;
    /**
     * 是否有商品
     */
    private boolean flag = false;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
