import java.util.Scanner;

public class Score {
    int count;
    int[][] jumsu;
    int[] sum_student;
    double[] average_student;

    // 생성자
    public Score(int count) {
        this.count = count;
        jumsu = new int[count][3];
        sum_student = new int[count];
        average_student = new double[count];
    }

    // 점수 입력 및 총점, 평균 계산
    public void getScore(int[][] scores) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 3; j++) {
                jumsu[i][j] = scores[i][j];
                sum_student[i] += jumsu[i][j];
            }
            average_student[i] = (double) sum_student[i] / 3;
        }
    }

    // 특정 학생의 점수, 총점, 평균 출력
    public void printScore(int num) {
        System.out.printf("학생 %d의 점수, 총점, 평균:\n", num);
        System.out.printf("국어: %d, 영어: %d, 수학: %d\n", jumsu[num - 1][0], jumsu[num - 1][1], jumsu[num - 1][2]);
        System.out.printf("총점: %d, 평균: %.2f\n", sum_student[num - 1], average_student[num - 1]);
    }

    // 등급 계산
    private char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = 5;
        int[][] studentScores = new int[studentCount][3];

        for (int i = 0; i < studentCount; i++) {
            System.out.printf("학생 %d의 국어, 영어, 수학 점수를 입력하세요: ", i + 1);
            for (int j = 0; j < 3; j++) {
                studentScores[i][j] = scanner.nextInt();
            }
        }

        Score score = new Score(studentCount);
        score.getScore(studentScores);
        System.out.println();
        System.out.print("특정 학생의 번호를 입력하세요: ");
        int studentNum = scanner.nextInt();
        score.printScore(studentNum); // 특정 학생의 점수, 총점, 평균 출력
        scanner.close();
    }
}
