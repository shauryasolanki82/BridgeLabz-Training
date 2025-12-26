package methods;

public class RandomNumberArray {
	public int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int)(Math.random() * 9000) + 1000;
        }
        return numbers;
    }

    public double[] findAverageMinMax(int[] numbers) {
    	double[] temp = new double[3];
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double average = sum / numbers.length;
        temp[0] = average;
        temp[1] = (double)min;
        temp[2] = (double)max;
        return temp;
    }

    public static void main(String[] args) {
        RandomNumberArray rs = new RandomNumberArray();
        int[] randomNumbers = rs.generate4DigitRandomArray(5);
        System.out.println("Generated Numbers:");
        for (int num : randomNumbers) {
            System.out.print(num+" ");
        }
        System.out.println();
        double[] results = rs.findAverageMinMax(randomNumbers);
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + (int)results[1]);
        System.out.println("Maximum: " + (int)results[2]);
    }
}