package com.sk.test;

/**
 * Created by sk on 2015/11/20.
 */
public class Singleton {
	//单例使用volatile修饰
	private static volatile Singleton instance = null;
	
	//必须防止外部可以调用构造函数进行实例化，因此构造函数必须私有化。
	private Singleton(){
	}
	
	//必须定义一个静态函数获得该单例
	public static Singleton getInstance() {
		if (instance == null) {
			//使用synchronized 进行同步处理，并且双重判断是否为null，
			// 我们看到synchronized (Singleton.class)里面又进行了是否为null的判断，这是因为一个线程进入了该代码，
			// 如果另一个线程在等待，这时候前一个线程创建了一个实例出来完毕后，另一个线程获得锁进入该同步代码，实例已经存在，没必要再次创建，
			// 因此这个判断是否是null还是必须的。
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}


/**
//至于单例的并发测试，可以使用CountDownLatch，使用await()等待锁释放，使用countDown()释放锁从而达到并发的效果。可以见下面的代码
public static void main(String[] args) {
    final CountDownLatch latch = new CountDownLatch(1);
    int threadCount = 1000;
    for (int i = 0; i < threadCount; i++) {
        new Thread() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Singleton.getInstance().hashCode());
            }
        }.start();
    }
    latch.countDown();
}
*/