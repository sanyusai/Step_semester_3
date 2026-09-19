class QuizScorecard {

    private boolean[] results;
    private int answersRecorded;

    public QuizScorecard(int questionCount) {

        results = new boolean[questionCount];
        answersRecorded = 0;
    }

    public void recordAnswer(boolean correct) {

        if (answersRecorded >= results.length) {
            System.out.println("Answer rejected: Question limit reached");
            return;
        }

        results[answersRecorded] = correct;
        answersRecorded++;
    }

    public int getScore() {

        int score = 0;

        for (int i = 0; i < answersRecorded; i++) {

            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Scorecard {

    public static void main(String[] args) {

        QuizScorecard sc = new QuizScorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}

