/**
 * @Author: ruan
 * Date: 2021/9/25 15:55
 * @Description:
 */
public class Test {
    private MyUnReentrantLock lock = new MyUnReentrantLock();
    public static void main(String[] args) {

        Test test = new Test();
        test.methodA();

    }
    public void methodA(){
        lock.lock();
        System.out.println("methodA被调用");
        methodB();
        lock.unLock();
    }

    private void methodB() {
        lock.lock();
        System.out.println("methodB被调用");
        methodA();
        lock.unLock();
    }
}
