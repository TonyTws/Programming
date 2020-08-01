package Extra.LeetCodeAugust.Week1;

public class DetectCapital {
    public static void main(String[] args) {
        String[] str = new String[]{"USA","leetcode","Google"};
        for (String s : str) {
            System.out.println(detectCapitalUse(s));
        }
    }

    /**
     * if caps is equal to length of string
     * if caps=1 and the 1st letter in the string is capital
     * if there are no capital letters in the string
     *
     */

    public static boolean detectCapitalUse(String word) {
        int caps  =0;
        for (int i = 0; i < word.length() ; i++) {
            if(word.charAt(i) - 'A' < 26)
                caps++;
        }

        if(caps == word.length()){
            return true;
        }else if(caps ==1 && word.charAt(0) - 'A' < 26){
            return true;
        }else if(caps == 0){
            return true;
        }else{
            return false;
        }
    }
}
