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

    public static void main(String[] args) {
        String st = grade(98.5);
        System.out.println(st);
    }

   enum Grades{
       A,B,C,F;
   }

   public static double averageGrade(double [] marks){
        double total = 0;
        for(double m: marks){
            total = total +m;
        }
        double average = total/marks.length;
        return average;
   }

   public static String grade(double av){
        if(av>=90){
            return Grades.A.name();
        }else if(av>=70 && av<90){
            return Grades.B.name();
        }else if(av>=50 && av <70){
            return Grades.C.name();
        }else{
            return Grades.F.name();
        }
   }




}
