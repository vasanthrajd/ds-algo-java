package designpatterns.creational;

/**
 * Real time example of Singleton is Logger.getInstance() used in Sl4j and configuration manager
 */
public class SingleTon {

    public static void main(String[] args) {
        SingleClass singleClass = SingleClass.getInstance();
        System.out.println(singleClass);
        SingleClass singleClass1 = SingleClass.getInstance();
        System.out.println(singleClass1);

        ThreadSafeSingleTon threadSafeSingleTon = ThreadSafeSingleTon.getInstance();
        System.out.println(threadSafeSingleTon);
        ThreadSafeSingleTon threadSafeSingleTon1 = ThreadSafeSingleTon.getInstance();
        System.out.println(threadSafeSingleTon1);
    }
}

class SingleClass {

    private static SingleClass singleClass;

    private SingleClass() {
    }

    public static SingleClass getInstance() {
        if (singleClass == null) {
            singleClass = new SingleClass();
        }
        return singleClass;
    }
}

class ThreadSafeSingleTon {
    private static ThreadSafeSingleTon threadSafeSingleTon;
    private ThreadSafeSingleTon() {

    }

    public static ThreadSafeSingleTon getInstance() {
        if (threadSafeSingleTon == null) {
            synchronized (ThreadSafeSingleTon.class) {
                threadSafeSingleTon = new ThreadSafeSingleTon();
            }
            return threadSafeSingleTon;
        }
        return threadSafeSingleTon;
    }
}

