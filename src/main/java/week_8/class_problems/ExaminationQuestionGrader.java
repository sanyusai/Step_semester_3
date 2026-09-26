import java.util.Scanner;

abstract class ExamQuestion {

    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public ExamQuestion(String questionText,
                         String correctAnswer,
                         String studentAnswer,
                         double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();

    public abstract String getType();
}

class MCQQuestion extends ExamQuestion {

    public MCQQuestion(String questionText,
                       String correctAnswer,
                       String studentAnswer,
                       double points) {

        super(questionText, correctAnswer, studentAnswer, points);
    }

    public double grade() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TFQuestion extends ExamQuestion {

    public TFQuestion(String questionText,
                      String correctAnswer,
                      String studentAnswer,
                      double points) {

        super(questionText, correctAnswer, studentAnswer, points);
    }

    public double grade() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends ExamQuestion {

    public EssayQuestion(String questionText,
                         String correctAnswer,
                         String studentAnswer,
                         double points) {

        super(questionText, correctAnswer, studentAnswer, points);
    }

    public double grade() {

        String[] keywords = correctAnswer.split(",");

        int matchedKeywords = 0;

        String lowerStudentAnswer =
                studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            String lowerKeyword =
                    keyword.trim().toLowerCase();

            if (lowerStudentAnswer.contains(lowerKeyword)) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75;
        } else if (matchedKeywords == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationQuestionGrader {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ExamQuestion[] questions = new ExamQuestion[n];

        scanner.nextLine();

        for (int i = 0; i < n; i++) {

            String line = scanner.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String pointsText = parts[6].trim();

            double points = Double.parseDouble(pointsText);

            if (type.equals("MCQ")) {

                questions[i] = new MCQQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);

            } else if (type.equals("TF")) {

                questions[i] = new TFQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);

            } else {

                questions[i] = new EssayQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);
            }
        }

        double totalScore = 0;

        for (ExamQuestion question : questions) {

            double score = question.grade();

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);

            totalScore = totalScore + score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        scanner.close();
    }
}

