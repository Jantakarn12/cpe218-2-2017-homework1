import java.util.Stack ;
import javax.swing.*;

public class Homework1 extends JFrame {
	static Stack st = new Stack();
	static Node root;

	public static void main(String[] args) {
		//------------------------------------------------------------------------
		 if (args.length == 0) {
			String input = "251-*32*+";
			for(int i=0;i<input.length();i++){
				Node node = new Node(input.charAt(i));
				infix(node);
				root = node;
			}

			System.out.println(inorder(root)+"="+calculate(root));
			 TreeIconDemo2.main(root);
		}
	}

	public static void infix(Node n){

		if(n.Operator()) {
			n.right = (Node)st.pop();
			n.left = (Node)st.pop();
			st.push(n);
		} else {
			st.push(n);
		}
	}
	public static String inorder(Node n){
		String txt = "";
		if(n != root && n.Operator()) txt += ('(');
		if(n.left != null) txt += inorder(n.left);
		txt += (n.hua);
		if(n.right != null) txt += inorder(n.right);
		if(n != root && n.Operator()) txt += (')');
		return txt;
	}

	public static int calculate(Node n){
			int result;
			switch (n.hua) {
				case '+':
					result = calculate(n.left)+calculate(n.right);
					break;
				case '-':
					result = calculate(n.left)-calculate(n.right);
					break;
				case '*':
					result = calculate(n.left)*calculate(n.right);
					break;
				case '/':
					result = calculate(n.left)/calculate(n.right);
					break;
				default:
					result = n.toDigit(n.hua);
					break;
			}
			return result;
		}
}