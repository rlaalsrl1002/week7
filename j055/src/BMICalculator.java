import java.util.Scanner;

public class BMICalculator {
    int height, weight;
    double bmi;
    int level;
    String name;

    // 생성자
    public BMICalculator(String name) {
        this.name = name;
    }

    // 이름, 신장, 체중을 입력받아 비만도와 비만등급을 계산
    public void getHW(int height, int weight) {
        this.height = height;
        this.weight = weight;
        double heightInMeter = height / 100.0; // 신장을 미터로 변환
        this.bmi = weight / (heightInMeter * heightInMeter);

        if (bmi < 18.5) {
            level = 1;
        } else if (bmi < 25) {
            level = 2;
        } else if (bmi < 30) {
            level = 3;
        } else {
            level = 4;
        }
    }

    // 이름, 신장, 체중, 비만도, 비만등급 출력
    public void printBMI() {
        System.out.println("이름: " + name);
        System.out.println("신장(cm): " + height);
        System.out.println("체중(kg): " + weight);
        System.out.println("비만도: " + bmi);
        switch (level) {
            case 1:
                System.out.println("비만등급: Underweight");
                break;
            case 2:
                System.out.println("비만등급: Healthy Weight");
                break;
            case 3:
                System.out.println("비만등급: Overweight");
                break;
            case 4:
                System.out.println("비만등급: Obesity");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("신장(cm)을 입력하세요: ");
        int height = scanner.nextInt();

        System.out.print("체중(kg)을 입력하세요: ");
        int weight = scanner.nextInt();

        BMICalculator calculator = new BMICalculator(name);
        calculator.getHW(height, weight);
        calculator.printBMI();

        scanner.close();
    }
}
