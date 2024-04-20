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

    // 학생들의 점수 출력
    public void printScore() {
        System.out.println("학생들의 점수:");
        for (int i = 0; i < count; i++) {
            System.out.printf("학생 %d: 국어 %d, 영어 %d, 수학 %d\n", i + 1, jumsu[i][0], jumsu[i][1], jumsu[i][2]);
        }
        System.out.println();
        System.out.println("각 과목별 총점과 평균 점수:");
        int[] sum_subject = new int[3];
        double[] average_subject = new double[3];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 3; j++) {
                sum_subject[j] += jumsu[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            average_subject[i] = (double) sum_subject[i] / count;
            System.out.printf("과목 %d: 총점 %d, 평균 %.2f\n", i + 1, sum_subject[i], average_subject[i]);
        }
        System.out.println();
        System.out.println("각 학생별 총점과 평균점수, 등급:");
        for (int i = 0; i < count; i++) {
            char grade = calculateGrade(average_student[i]);
            System.out.printf("학생 %d: 총점 %d, 평균 %.2f, 등급 %c\n", i + 1, sum_student[i], average_student[i], grade);
        }
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
        score.printScore();

        scanner.close();
    }
}
