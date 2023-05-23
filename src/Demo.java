import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        ArrayList<String> listOfValues = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+|[+/*-]");
        Matcher matcher = pattern.matcher(expression);
        while(matcher.find()){
            listOfValues.add(matcher.group());
        }
        System.out.println(listOfValues);
        double result = solve(listOfValues);
        System.out.println(result);
    }
    public static ArrayList<String> multDiv(ArrayList<String> listOfValues){
        for (int i = 0; i < listOfValues.size(); i++) {
            if(listOfValues.get(i).equals("*")){
                double num1 = Double.parseDouble(listOfValues.get(i-1));
                double num2 = Double.parseDouble(listOfValues.get(i+1));
                double result = num1*num2;
                String resultRef = Double.toString(result);
                listOfValues.set(i,resultRef);
                listOfValues.remove(i+1);
                listOfValues.remove(i-1);
                i=0;
            }
            if(listOfValues.get(i).equals("/")){
                double num1 = Double.parseDouble(listOfValues.get(i-1));
                double num2 = Double.parseDouble(listOfValues.get(i+1));
                double result = num1/num2;
                String resultRef = Double.toString(result);
                listOfValues.set(i,resultRef);
                listOfValues.remove(i+1);
                listOfValues.remove(i-1);
                i=0;
            }
        }
        return listOfValues;
    }
    public static ArrayList<String> addSub(ArrayList<String> listOfValues){
        for (int i = 0; i < listOfValues.size(); i++) {
            if (listOfValues.get(i).equals("+")) {
                double num1 = Double.parseDouble(listOfValues.get(i - 1));
                double num2 = Double.parseDouble(listOfValues.get(i + 1));
                double result = num1 + num2;
                String resultRef = Double.toString(result);
                listOfValues.set(i, resultRef);
                listOfValues.remove(i + 1);
                listOfValues.remove(i - 1);
                i = 0;
            }
            if (listOfValues.get(i).equals("-")) {
                double num1 = Double.parseDouble(listOfValues.get(i - 1));
                double num2 = Double.parseDouble(listOfValues.get(i + 1));
                double result = num1 - num2;
                String resultRef = Double.toString(result);
                listOfValues.set(i, resultRef);
                listOfValues.remove(i + 1);
                listOfValues.remove(i - 1);
                i = 0;
            }
        }
        return listOfValues;
    }
    public static Double solve(ArrayList<String> listOfValues){
         ArrayList<String> multDiv = multDiv(listOfValues);
         ArrayList<String> finalIt = addSub(multDiv);
         return Double.parseDouble(finalIt.get(0));
    }
}
