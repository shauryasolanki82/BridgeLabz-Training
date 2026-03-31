package searching;

public class Comparison {

    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = (endTimeBuffer - startTimeBuffer) / 1_000_000;
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = (endTimeBuilder - startTimeBuilder) / 1_000_000;
        System.out.println("StringBuffer Time: " + durationBuffer + " ms");
        System.out.println("StringBuilder Time: " + durationBuilder + " ms");
        if (durationBuilder < durationBuffer) {
            System.out.println("Conclusion: StringBuilder is faster.");
        }
    }
}
