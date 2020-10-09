import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = "";
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            name = name.concat(input.nextLine());
        }
        System.out.println("The name generated is " +generateName(name));
    }
    public static String generateName(String names){
        System.out.println(names);
        String name = " ";
        String[] temp = names.split(",");
        String a = temp[0];
        String b = temp[1];
        temp = b.split(" ");
        name = name.concat(temp[1]);
        temp = a.split(" ");
        name = name.concat(reverse(a));
        return name;
    }
    public static String reverse(String a){
        StringBuilder input1 = new StringBuilder();
        input1.append(a);
        input1 = input1.reverse();
        return String.valueOf(input1);
    }
}