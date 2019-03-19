public class Main {
    public static void main(String[] args) {
        // write testcode here
        Counter first = new Counter(3, true);
        first.increase();
        first.decrease();
        first.value();
        first.decrease();
        first.decrease();
        first.decrease();
        first.decrease();
        first.value();
    }
}
