import java.util.*;
public class SameDashes {
    public static void main(String[] args) {
        System.out.println(sameDashes("a-b-c", "a-b-c"));
        System.out.println(sameDashes("hi-there-you.", "12--(134)-7539"));
        System.out.println(sameDashes("-15-389", "-xy-zzy"));
        System.out.println(sameDashes("criminal-plan", "(206)555-1384"));
        System.out.println(sameDashes("abc", "9.8"));
        System.out.println(sameDashes("a-b-c", "a-b c"));
        System.out.println(sameDashes("left-handed", "fifty-fifty"));
        System.out.println(sameDashes("open-and-shut", "123-456-78901"));
        System.out.println(sameDashes("a-b-cd", "a-b-c"));
        System.out.println(sameDashes("a-b-c-", "a-b-c"));
        System.out.println(sameDashes("1st-has-more characters", "2nd-has-less"));
        System.out.println(sameDashes("1st-has-more-characters", "2nd-has-less"));
        System.out.println(sameDashes("------", "------"));
        System.out.println(sameDashes("------", "----"));             
    }

    public static boolean sameDashes(String input1, String input2){
        int [] firstString = new int [input1.length()]; 
        int [] secondString = new int [input2.length()];
        
        for(int i = 0; i <= input1.length() - 1; i++){
            char curr = firstString [i];
            if(curr == '-'){
                firstString[i]++;
            }
        }

        for(int i = 0; i <= input2.length() - 1; i++){
            char curr = secondString [i];
            if(curr == '-'){
                secondString[i]++;
            }
        }
        if(firstString[i] == (secondString[i])){
            return true;
        }
    }
}
