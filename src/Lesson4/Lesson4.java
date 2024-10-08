package Lesson4;
import java.util.*;

public class Lesson4 {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static int countDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return 1 + countDigits(n / 10);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void printBinary(int n) {
        if (n > 0) {
            printBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permute(ros, ans + ch);
        }
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, temp);
        }
    }

    public static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, value);
            stack.push(temp);
        }
    }

    // Hàm main với switch-case
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn bài toán muốn thực hiện:");
        System.out.println("1. Tính giai thừa");
        System.out.println("2. Tính Fibonacci");
        System.out.println("3. Đảo ngược chuỗi");
        System.out.println("4. Tính tổng từ 1 đến n");
        System.out.println("5. Đếm số chữ số");
        System.out.println("6. Tìm ước chung lớn nhất (GCD)");
        System.out.println("7. Chuyển đổi số nguyên thành nhị phân");
        System.out.println("8. Tính lũy thừa");
        System.out.println("9. Kiểm tra chuỗi Palindrome");
        System.out.println("10. Tìm hoán vị của chuỗi");
        System.out.println("11. Đảo ngược Stack");

        int choice;
        do{
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhập số n: ");
                    int n1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Giai thừa của " + n1 + " là: " + factorial(n1));
                    break;
                case 2:
                    System.out.print("Nhập số n: ");
                    int n2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Số Fibonacci thứ " + n2 + " là: " + fibonacci(n2));
                    break;

                case 3:
                    System.out.print("Nhập chuỗi: ");
                    String str = sc.next();
                    sc.nextLine();
                    System.out.println("Chuỗi đảo ngược: " + reverseString(str));
                    break;

                case 4:
                    System.out.print("Nhập số n: ");
                    int n4 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Tổng từ 1 đến " + n4 + " là: " + sum(n4));
                    break;

                case 5:
                    System.out.print("Nhập số nguyên dương: ");
                    int n5 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Số chữ số của " + n5 + " là: " + countDigits(n5));
                    break;

                case 6:
                    System.out.print("Nhập hai số nguyên a và b: ");
                    int a = sc.nextInt();
                    sc.nextLine();
                    int b = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + gcd(a, b));
                    break;

                case 7:
                    System.out.print("Nhập số nguyên: ");
                    int n7 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Số nhị phân của " + n7 + " là: ");
                    printBinary(n7);
                    System.out.println();
                    break;

                case 8:
                    System.out.print("Nhập cơ số x và số mũ n: ");
                    int x = sc.nextInt();
                    sc.nextLine();
                    int n8 = sc.nextInt();
                    sc.nextLine();
                    System.out.println(x + "^" + n8 + " = " + power(x, n8));
                    break;

                case 9:
                    System.out.print("Nhập chuỗi: ");
                    String palindrome = sc.nextLine();
                    if (isPalindrome(palindrome)) {
                        System.out.println("Chuỗi là palindrome");
                    } else {
                        System.out.println("Chuỗi không phải là palindrome");
                    }
                    break;

                case 10:
                    System.out.print("Nhập chuỗi: ");
                    String perm = sc.nextLine();
                    System.out.println("Các hoán vị của chuỗi " + perm + " là:");
                    permute(perm, "");
                    break;

                case 11:
                    Stack<Integer> stack = new Stack<>();
                    System.out.print("Nhập số phần tử trong Stack: ");
                    int size = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập các phần tử:");
                    for (int i = 0; i < size; i++) {
                        stack.push(sc.nextInt());
                    }
                    reverseStack(stack);
                    System.out.println("Stack sau khi đảo ngược: " + stack);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }while (choice > 0 && choice < 11);
        sc.close();
    }
}
