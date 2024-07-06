package singleton;

public class DoubleCheck {

    private DoubleCheck() {
    }

    private static volatile DoubleCheck instance;

    public static DoubleCheck getInstance() {
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实际
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                //抢到锁之后再次判断是否为空
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
