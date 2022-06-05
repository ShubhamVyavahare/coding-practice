package strings;

/**
 * Write a program to rotate (right/left) a string by given number of times.
 * <p>
 * Output :
 * Original String : shubham --> Count for left rotation : 3 --> Result LeftRotatedString : bhamshu
 * Original String : shubham --> Count for right rotation : 2 --> Result RightRotatedString : amshubh
 */
public class StringRotation {
    public static void main(String[] args) {

        String originalString = "shubham";

        Integer leftRotationCount = 3;
        String leftRotatedString = rotateLeft(originalString, leftRotationCount);
        System.out.println("Original String : " + originalString + " --> Count for left rotation : " + leftRotationCount + " --> Result LeftRotatedString : " + leftRotatedString);

        Integer rightRotationCount = 2;
        String rightRotatedString = rotateRight(originalString, rightRotationCount);
        System.out.println("Original String : " + originalString + " --> Count for right rotation : " + rightRotationCount + " --> Result RightRotatedString : " + rightRotatedString);

    }

    private static String rotateLeft(String originalString, Integer leftRotationCount) {
        return originalString.substring(leftRotationCount) + originalString.substring(0, leftRotationCount);
    }

    private static String rotateRight(String originalString, Integer rightRotationCount) {
        int partition = originalString.length() - rightRotationCount;
        return originalString.substring(partition) + originalString.substring(0, partition);
    }

}
