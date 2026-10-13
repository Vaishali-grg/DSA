package stack;
import java.util.Stack;
import java.util.Arrays;

public class AsteroidCollisionLC735 {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int ast : asteroids) {
            boolean destroyed = false;
            while (!st.isEmpty() && ast < 0 && st.peek() > 0) {
                if (st.peek() < -ast) {
                    st.pop();
                    continue;
                } else if (st.peek() == -ast) {
                    st.pop();
                }
                destroyed = true;
                break;
            }
            if (!destroyed) {
                st.push(ast);
            }
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}