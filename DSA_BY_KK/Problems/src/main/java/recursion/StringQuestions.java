package recursion;

public class StringQuestions {

    public static void main(String[] args) {

        System.out.print("remove s from assakdqlwsas without return: ");
        removeChar("assakdqlwsas", new StringBuffer(""), 's');


        System.out.println("remove s from assakdqlwsas with return: "+
                removeChar("assakdqlwsas", 's'));

        System.out.println("remove apple from assakdappleqlwsas with return: "+
                removeWord("assakdappleqlwsas", "apple"));

        System.out.println("remove app from assaappkdappleqlwsasapple but not from apple with return: "+
                removeappNotFromApple("assaappkdappleqlwsasapple", "app"));
    }

    private static String removeappNotFromApple(String processed, String stringToRemove) {
        if (processed.isEmpty()){
            return processed;
        }

        if(processed.startsWith(stringToRemove) && !processed.startsWith("apple")){
            return removeappNotFromApple(processed.substring(stringToRemove.length()),stringToRemove);
        }else {
            return processed.charAt(0) + removeappNotFromApple(processed.substring(1),stringToRemove);
        }
    }

    //remove passed char from the string using processed and unprocessed String
    static void removeChar(String unProcessed, StringBuffer processed, char charToRemove) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char remove = unProcessed.charAt(0);
        if (remove == charToRemove) {
            removeChar(unProcessed.substring(1), processed, charToRemove);
        } else {
            removeChar(unProcessed.substring(1), processed.append(remove), charToRemove);
        }
    }

    //remove passed char from the string and return processed string
    static String removeChar(String processed, char charToRemove){

        if (processed.isEmpty()){
            return processed;
        }

        char remove = processed.charAt(0);

        if(remove == charToRemove){
            return removeChar(processed.substring(1),charToRemove);
        }else {
            return remove + removeChar(processed.substring(1),charToRemove);
        }
    }

    //remove passed word from the string and return processed string
    static String removeWord(String processed, String stringToRemove){

        if (processed.isEmpty()){
            return processed;
        }

        if(processed.startsWith(stringToRemove)){
            return removeWord(processed.substring(stringToRemove.length()),stringToRemove);
        }else {
            return processed.charAt(0) + removeWord(processed.substring(1),stringToRemove);
        }
    }


}
