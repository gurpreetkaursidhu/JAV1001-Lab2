import java.util.Scanner;
import java.util.Arrays;

public class ArrayTools{

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select any one option below: -");
        System.out.println("1. Ceaser Cipher");
        System.out.println("2. Array Reverse");
        System.out.println("3. Find Number");
        System.out.println("4. Array Average");

        int userInput = sc.nextInt();

        if(userInput == 1) {
            System.out.println("Please enter string for Ceaser Cipher");
            String normalStr = sc.nextLine();
            normalStr = sc.nextLine();
            System.out.println("Please enter offset value");
            int offset = sc.nextInt();
            String encStr = cypher(normalStr, offset);
            System.out.println(encStr);
        } else {
            if (userInput == 2 || userInput == 3 || userInput == 4) {
                System.out.println("Please enter length of array you want to input");
                int arrayLength = sc.nextInt();
                int[] myArray = new int[arrayLength];
                System.out.println("Please enter array numbers one by one");
                for(int i = 0; i < arrayLength; i++) {
                    myArray[i] = sc.nextInt();
                }
                switch(userInput) {
                    case 2:
                        int[] revArr = reverse(myArray);
                        System.out.println("Reversed array is");
                        for(int i = 0; i < revArr.length; i++){
                            System.out.println(revArr[i]);
                        }
                        break;
                    case 3:
                        System.out.println("Please enter number to find");
                        int num = sc.nextInt();
                        boolean found = findNumber(myArray, num);
                        System.out.println(found == true ? "Number found" : "Number not found");
                        break;
                    case 4:
                        double avg = findAverage(myArray);
                        System.out.println("Array average is : " + avg);
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("Oops Wrong selection.");
            }
        }
    }

    public static double findAverage(int[] array) {
        double sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        double avg = sum / array.length;
        return avg;
    }

    public static boolean findNumber(int[] array, int num) {
        boolean found = false;
        for(int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                found = true;
            }
        }
        return found;
    }

    public static int[] reverse(int[] array) {
        int[] revArr = new int[array.length];
        for(int i = 0; i < array.length; i++){
            revArr[i] = array[array.length - i -1];
        }
        return revArr;
    }

    public static String cypher(String message, int offset) {
        String result = new String();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalPos = character - 'a';
                int newPos = (originalPos + offset) % 26;
                char encryptedChar = (char) ('a' + newPos);
                result += encryptedChar;
            } else {
                result += character;
            }
        }
        return result;
    }
}
