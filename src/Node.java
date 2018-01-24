public class Node {
    char hua;
    Node left, right;

    Node(char c) {
        hua = c;
        left = null;
        right = null;
    }

    public boolean Operator() {
        if (hua == '+' || hua == '-' || hua == '*' || hua == '/') {
            return true;
        } else return false;

    }

    public int toDigit(char ch) {
        return ch - '0';
    }

    public String toString(){
        return String.valueOf(hua);
    }
}
