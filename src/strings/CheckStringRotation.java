package strings;

/**
 * Write a program to Check the given string is right or left rotated of original string or not ?
 * <p>
 * Output :
 * Checking ubhamsh is right rotated string : true
 * Checking amshubh is left rotated string : true
 * Checking shuhbam is right/left rotated string : false
 */
public class CheckStringRotation {
    public static void main(String[] args) {
        String originalString = "shubham";
        String rightRotatedStringToBeChecked = "ubhamsh";
        String leftRotatedStringToBeChecked = "amshubh";
        String swapCharsAndCheckRotation = "shuhbam";

        System.out.println("Checking " + rightRotatedStringToBeChecked + " is right rotated string : " + checkRotation(originalString, rightRotatedStringToBeChecked));
        System.out.println("Checking " + leftRotatedStringToBeChecked + " is left rotated string : " + checkRotation(originalString, leftRotatedStringToBeChecked));
        System.out.println("Checking " + swapCharsAndCheckRotation + " is right/left rotated string : " + checkRotation(originalString, swapCharsAndCheckRotation));

    }

    private static Boolean checkRotation(String originalString, String rotatedStringToBeChecked) {
        String concatenatedString = originalString + originalString;
        if (concatenatedString.contains(rotatedStringToBeChecked))
            return true;
        return false;
    }
}
