package Singleton;

public class StaticInnerClass {

    private StaticInnerClass() {

    }

    private static class SingletonHolder {
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 下面是为了解决序列化反序列化破解单例模式
     * 在Singleton类中添加 readResolve() 方法，在反序列化时被反射调用，如果定义了这个方法，
     * 就返回这个方法的值，如果没有定义，则返回新new出来的对象。
     */
    private Object readResolve() {
        return SingletonHolder.instance;
    }

}

/*
 * 第一次加载Singleton类时不会去初始化INSTANCE，只有第一次调用getInstance，虚拟机加
 * 载SingletonHolder并初始化INSTANCE，这样不仅能确保线程安全，也能保证 Singleton 类的唯一性。
 *
 * 静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。在没有加任
 * 何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。
 */