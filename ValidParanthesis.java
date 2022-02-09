import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/*
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
* */
public class ValidParanthesis {

    public static void main(String[] args) {
        String input = "()";
        System.out.println(isValid(input));
    }

    public static boolean isValid(String s) {

        boolean isValid = true;
        Stack<Character> stack  = new Stack<Character>();
        Map<Character,Character> charMap = new HashMap<Character,Character>();
        charMap.put(')','(');
        charMap.put(']','[');
        charMap.put('}','{');

        if(s.length() % 2 != 0 )
            return false;

        for(int i=0 ; i< s.length() ; i++ ) {

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()) {
                    return false;
                }
                if(charMap.get(s.charAt(i)) != stack.peek() ) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty())
            return false;

        return isValid;
    }
}
