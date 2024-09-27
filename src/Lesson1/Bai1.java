package Lesson1;

public class Bai1 {
    public static Node findChild(Node parent, String name) {
        if (parent == null) {
            return null;
        }
        if (parent.getData().equals(name)) {
            return parent;
        }
        Node left = findChild(parent.getLeft(), name);
        if (left != null) {
            return left;
        }
        return findChild(parent.getRight(), name);
    }

    public static void printTree(Node node, int level) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.getData());
        printTree(node.getLeft(), level + 1);
        printTree(node.getRight(), level + 1);
    }

    public static void main(String[] args) {
        String[][] categories = {
                {"electronic", "Phones"},
                {"electronic", "Laptops"},
                {"Home", "Furniture"},
                {"Home", "Applicant"},
        };

        Node root = new Node("root");
        for (String[] category : categories) {;
            Node parent = root;
            for (String name : category) {
                Node child = findChild(parent, name);
                if (child == null) {
                    child = new Node(name);
                    if (parent.getLeft() == null) {
                        parent.setLeft(child);
                    } else {
                        parent.setRight(child);
                    }
                }
                parent = child;
            }
        }


        printTree(root, 0);

    }

}
