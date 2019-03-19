public class PrintingLikeBoss {

    // copy or rewrite the method of Assignment 39.1 here
    public static void printStars(int amount) {
        int i = 0;
        while (i < amount) {
            System.out.print("*");
            i++;
        }
        System.out.print("\n");
        
    }

    public static void printWhitespaces(int amount) {
        // 40.1
        int i = 0;
        while (i < amount) {
            System.out.print(" ");
            i++;
        }
    }

    public static void printTriangle(int size) {
        // 40.2
        int i = 1;
        while (i <= size) {
            printWhitespaces(size - i);
            printStars(i);
            i++;
        }
    }

    public static void xmasTree(int height) {
        // 40.3
        int maxWidth = (height * 2) - 1;
        int midpoint = (int)Math.ceil(maxWidth / 2);
        // Tree
        int i = 1;
        int k = midpoint;
        while (i <= height) {
            int width = (i * 2) - 1;
            printWhitespaces(k);
            printStars(width);
            k--;
            i++;
        }
        // Base
        int base = 0;
        while (base < 2) {
            printWhitespaces(midpoint - 1);
            printStars(3);
            base++;
        }
    }

    public static void main(String[] args) {
        // Tests do not use main, yo can write code here freely!

        printTriangle(5);
        System.out.println("---");
        xmasTree(4);
        System.out.println("---");
        xmasTree(10);
    }
}
/*
int i = 1;
while (i <= height) {
    printWhitespaces(height - i);
    printStars(i + (i - 1));
    i++;
}
printWhitespaces(height - 2);
printStars(3);
printWhitespaces(height - 2);
printStars(3);
*/