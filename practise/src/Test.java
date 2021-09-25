/**
 * @Author: ruan
 * Date: 2021/9/25 15:55
 * @Description:
 */
public class Test {
    //private MyUnReentrantLock lock = new MyUnReentrantLock();
    private MyReentrantLock lock = new MyReentrantLock();
    public static void main(String[] args) {

        Test test = new Test();
        test.methodA();

    }
    public void methodA(){
        try {
            lock.lock();
            System.out.println("methodA被调用");
            methodB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }

    private void methodB() {
        try {
            lock.lock();
            System.out.println("methodB被调用");
            //methodA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }

    }
}
