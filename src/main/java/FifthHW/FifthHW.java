package FifthHW;

public class FifthHW {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        methodOne(arr);
        methodTwo(arr);
    }

    private static void methodOne(float[] arr) {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.printf("Вычисления в одном потоке: %s \n", System.currentTimeMillis() - a);
    }

    private static void methodTwo(float[] arr) {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        MyThread thread1 = new MyThread(a1);
        MyThread thread2 = new MyThread(a2);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a1 = thread1.getArray();
        a2 = thread2.getArray();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, a1.length, a2.length);

        System.out.printf("Вычисления в двух потоках: %s \n", System.currentTimeMillis() - a);
    }
}