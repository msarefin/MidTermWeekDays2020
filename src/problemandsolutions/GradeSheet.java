package problemandsolutions;

public class GradeSheet {
    // Write a Java program that determines a student’s grade.
    //The program will read three types of scores(quiz, mid-term, and final scores) and determine the grade based on
    // the following rules:
    //- if the average score >=90% =>grade=A
    //- if the average score >= 70% and <90% => grade=B
    //- if the average score>=50% and <70% =>grade=C
    //- if the average score<50% =>grade=F
    //
    //See the example output below:
    //
    //Quiz score: 80
    //
    //Mid-term score: 68
    //
    //Final score: 90
    //
    //Your grade is B.


    public int getQuiz() {
        System.out.println("Quiz Score:");
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getMidterm() {
        System.out.println("Midterm Score:");
        return midterm;
    }

    public void setMidterm(int midterm) {
        this.midterm = midterm;
    }

    public int getFinals() {
        System.out.println("Finals Score:");
        return finals;
    }

    public void setFinals(int finals) {
        this.finals = finals;
    }

    int quiz, midterm, finals;

    public static void main(String[] args) {

    }
    enum grades{
        A,B,C,F;
    }
    public static void grade(){
        GradeSheet gs = new GradeSheet();
        int quiz = gs.getQuiz();
        int midterm = gs.getMidterm();
        int finals = gs.getFinals();
        gradeCalculator(AverageScores(quiz, midterm, finals));
    }


    public static double AverageScores(int quiz, int midterm, int finals){
        double av = (quiz+midterm+finals)/3;
        return av;
    }

    public static String gradeCalculator(double av) {
        if (av >= 90) {
            return grades.A.toString();
        } else if (av < 90 && av >= 70) {
            return grades.B.toString();
        } else if (av < 70 && av >= 50) {
            return grades.C.toString();
        } else {
            return grades.F.toString();
        }
    }






}
