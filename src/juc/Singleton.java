package juc;

// 双重检测锁
public class Singleton {
    // 可见性 指令重排序
    private volatile static Singleton singleton = null;

    // 私有构造
    private Singleton() {
    }

    public static Singleton getInstance() {
        // 第一重检查锁定
        if (singleton == null) {
            // 同步锁 代码块
            synchronized (Singleton.class) {
                // 第二重检查锁定
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
