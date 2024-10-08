package Lesson5;
import java.util.*;

public class Lesson5 {
    //Bài 1
    public static boolean checkBrackets(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) return false;
            }
        }
        return stack.isEmpty();
    }

    //Bài 2
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String expr) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    //Bài 3
    static class QueueUsingStacks {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void enqueue(int value) {
            stack1.push(value);
        }

        public int dequeue() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

    //Bài 4
    public static boolean isPalindrome(int num) {
        String str = Integer.toString(num);
        Deque<Character> deque = new LinkedList<>();

        for (char ch : str.toCharArray()) {
            deque.add(ch);
        }

        while (!deque.isEmpty()) {
            if (deque.remove() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    //Bài 5
    public static int findMostFrequent(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int mostFrequent = arr[0];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }

    //Bài 6
    public static HashMap<Character, Integer> countCharacterFrequency(String str) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        return charCountMap;
    }

    //Bài 7
    public static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fibonacciMemo(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);

        int result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        memo.put(n, result);
        return result;
    }

    //Bài 8
    static class LRUCache {
        private final int capacity;
        private LinkedHashMap<Integer, Integer> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }

    //Bài 9
    public static HashMap<String, Integer> gcdMemo = new HashMap<>();

    public static int gcdMemoization(int a, int b) {
        String key = a + "," + b;
        if (gcdMemo.containsKey(key)) return gcdMemo.get(key);

        if (b == 0) return a;
        int result = gcdMemoization(b, a % b);
        gcdMemo.put(key, result);
        return result;
    }

    //Bài 10
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) return;

        int front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Kiểm tra ngoặc đúng trong biểu thức toán học");
            System.out.println("2. Chuyển đổi từ Infix sang Postfix");
            System.out.println("3. Triển khai Queue bằng hai Stack");
            System.out.println("4. Kiểm tra tính đối xứng của số bằng Queue");
            System.out.println("5. Tìm phần tử xuất hiện nhiều nhất trong mảng");
            System.out.println("6. Đếm số lần xuất hiện của ký tự trong chuỗi");
            System.out.println("7. Phân tích dãy Fibonacci bằng HashMap và Đệ quy");
            System.out.println("8. Hệ thống Cache LRU (Least Recently Used)");
            System.out.println("9. Đệ quy và HashMap để tìm số ước chung lớn nhất");
            System.out.println("10. Đảo ngược Queue bằng Đệ quy");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập biểu thức để kiểm tra ngoặc: ");
                    String expr1 = sc.nextLine();
                    System.out.println("Kết quả kiểm tra: " + checkBrackets(expr1));
                    break;

                case 2:
                    System.out.print("Nhập biểu thức Infix: ");
                    String expr2 = sc.nextLine();
                    System.out.println("Biểu thức Postfix: " + infixToPostfix(expr2));
                    break;

                case 3:
                    QueueUsingStacks queue = new QueueUsingStacks();
                    queue.enqueue(10);
                    queue.enqueue(20);
                    System.out.println("Enqueue: 10, 20");
                    System.out.println("Dequeue: " + queue.dequeue());
                    System.out.println("Dequeue: " + queue.dequeue());
                    break;

                case 4:
                    System.out.print("Nhập số nguyên để kiểm tra đối xứng: ");
                    int number = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Kết quả: " + isPalindrome(number));
                    break;

                case 5:
                    System.out.print("Nhập kích thước mảng: ");
                    int size = sc.nextInt();
                    sc.nextLine();
                    int[] array = new int[size];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < size; i++) {
                        array[i] = sc.nextInt();
                        sc.nextLine();
                    }
                    System.out.println("Phần tử xuất hiện nhiều nhất: " + findMostFrequent(array));
                    break;

                case 6:
                    System.out.print("Nhập chuỗi để đếm ký tự: ");
                    String str = sc.nextLine();
                    System.out.println("Số lần xuất hiện của mỗi ký tự: " + countCharacterFrequency(str));
                    break;

                case 7:
                    System.out.print("Nhập số n để tính Fibonacci: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Số Fibonacci thứ " + n + " là: " + fibonacciMemo(n));
                    break;

                case 8:
                    LRUCache lruCache = new LRUCache(2);
                    lruCache.put(1, 1);
                    lruCache.put(2, 2);
                    System.out.println("Cache sau khi put(1, 1) và put(2, 2): " + lruCache.cache);
                    lruCache.get(1);
                    System.out.println("Cache sau khi get(1): " + lruCache.cache);
                    lruCache.put(3, 3);
                    System.out.println("Cache sau khi put(3, 3): " + lruCache.cache);
                    break;

                case 9:
                    System.out.print("Nhập hai số để tính GCD: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + gcdMemoization(a, b));
                    break;

                case 10:
                    Queue<Integer> queueToReverse = new LinkedList<>();
                    queueToReverse.add(1);
                    queueToReverse.add(2);
                    queueToReverse.add(3);
                    System.out.println("Queue ban đầu: " + queueToReverse);
                    reverseQueue(queueToReverse);
                    System.out.println("Queue sau khi đảo ngược: " + queueToReverse);
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

            System.out.println();
        } while (choice > 0 && choice <= 10);
        sc.close();
    }
}
