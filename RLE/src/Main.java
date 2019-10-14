import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] argc)
    {
        System.out.println("Enter the String:");
        Scanner cin=new Scanner(System.in);
        String code=cin.next().trim();
        print(code);
    }


    private static void print(String str){
        String result=rleCod(str);
        System.out.println("Run Length Code");
        System.out.println("Origin String："+str);
        System.out.println("Compression："+result);
        System.out.println("DeCompression："+rleDecod(result));
    }

    private static String rleCod(String str){
        str = str + " ";
        List<String> res = new ArrayList<String>();
        List<Character> temp = new ArrayList<Character>();
        char origin = str.charAt(0);

        for (int i = 1; i < str.length();i++){
            if (str.charAt(i) == origin){
                temp.add(origin);
            }
            else{
                if (temp.size() >= 3){
                    res.add(temp.get(0) + " " + (temp.size()+1)+" ");
                }
                else {
                    if (temp.isEmpty()){
                        res.add(String.valueOf(origin));
                    }
                    else {
                        StringBuilder temp2 = new StringBuilder();
                        temp2.append(temp.get(0));
                        for (int j = 1; j < temp.size();j++){
                            temp2.append(temp.get(j));
                        }
                        temp2.append(origin);
                        res.add(temp2.toString());
                    }
                }
                temp = new ArrayList<Character>();
            }
            origin = str.charAt(i);
        }

        StringBuilder answer = new StringBuilder(res.get(0));
        for (int i = 1; i < res.size(); i++ ){
            answer.append(res.get(i));
        }
        return answer.toString();
    }

    private static String rleDecod(String str){
        char origin = str.charAt(0);
        StringBuilder res = new StringBuilder();

        for (int i = 1; i < str.length(); i++){

            if (str.charAt(i) == ' '){
                StringBuilder temp = new StringBuilder();
                i++;

                while (str.charAt(i) != ' '){
                    temp.append(str.charAt(i));
                    i++;
                }

                int length = Integer.parseInt(temp.toString());

                for (int j = 0; j<length; j++){
                    res.append(origin);
                }
                if(i < str.length() - 1){
                    origin = str.charAt(++i);
                    if (i == str.length() - 1){
                        res.append(origin);
                    }
                }

            }
            else{
                res.append(origin);
                origin = str.charAt(i);
                if(i == str.length() -1){
                    res.append(origin);
                }
            }

        }
        return res.toString();
    }
}
