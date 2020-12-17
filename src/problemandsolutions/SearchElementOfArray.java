package problemandsolutions;

public class SearchElementOfArray {
    // By using the sequential search algorithm,
    // write a Java program to search for an element of an integer array of 10 elements.


    public static void main(String[] args) {

    }

    public static void elementSearch(int num, int [] arr){
        for(int i = 0; i< arr.length; i++) {
            if(num==arr[i]){
                System.out.println(num+" Found At index "+i);
            }else{
                System.out.println(num+" was not found within the array");
            }
        }
    }
}
