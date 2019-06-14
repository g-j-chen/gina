import java.util.ArrayList;


public class ExamScores {
    private ArrayList<Integer> examScores;
    private int[] scoreDistribution;
    
    public ExamScores(int... scores) {
        this.examScores = new ArrayList<Integer>();
        for (int score : scores) {
            this.examScores.add(score);
        }
    }

    
    public void addScore(int score) {
        examScores.add(score);
    }
    
    public void scoreDistribution() {
        scoreDistribution = new int[6];
        for (int i = 0; i < examScores.size(); i++) {
            if (0 <= examScores.get(i) && examScores.get(i) <= 29) {
                scoreDistribution[0]++;
            } else if (30 <= examScores.get(i) && examScores.get(i) <= 34) {
                scoreDistribution[1]++;
            } else if (35 <= examScores.get(i) && examScores.get(i) <= 39) {
                scoreDistribution[2]++;
            } else if (40 <= examScores.get(i) && examScores.get(i) <= 44) {
                scoreDistribution[3]++;
            } else if (45 <= examScores.get(i) && examScores.get(i) <= 49) {
                scoreDistribution[4]++;
            } else if (50 <= examScores.get(i) && examScores.get(i) <= 60) {
                scoreDistribution[5]++;
            }
        }
    }
    
    public void printSingleDistribution(int grade) {
        for (int j = 0; j < scoreDistribution[grade]; j++) {
            System.out.print("*");
        }
    }
    
    public void printScoreDistribution() {
        System.out.println("Grade distribution:");
        scoreDistribution();
        for (int k = 5; k >= 0; k--) {
            System.out.print(k + ": ");
            printSingleDistribution(k);
            System.out.println();
        }
    }
    
    public void acceptancePercentage() {
        int total = 0;
        for (int examScore : examScores) {
            if (examScore > 29) {
                total++;
            }
        }
        System.out.println("Acceptance percentage: " + (double) 100 * total / examScores.size());
    }
}

        
        
        
        
        
        


