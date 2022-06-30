package scenariobased.demo16;

import java.util.Stack;

/**
 * Write a program
 * input: my name is shubham
 * expected output: ym eman si mahbuhs
 */
public class Demo16 {

    public static void main(String[] args) {

        String str = "my name is shubham";
        method1(str);
        method2(str);
    }

    public static void method1(String str) {
        char[] chars = str.toCharArray();

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                characterStack.push(chars[i]);
            } else {
                while (!characterStack.empty()) {
                    System.out.print(characterStack.pop());
                }
                System.out.print(" ");
            }
        }

        while (!characterStack.empty()) {
            System.out.print(characterStack.pop());
        }
    }

    public static void method2(String str) {

        String[] words = str.split(" ");

        StringBuilder finalStringBuilder = new StringBuilder();

        for (String word : words) {
            StringBuilder builder = new StringBuilder(word);
            finalStringBuilder.append(builder.reverse());
            finalStringBuilder.append(" ");
        }

        System.out.println("\nMethod 2 : " + finalStringBuilder);
    }
}
