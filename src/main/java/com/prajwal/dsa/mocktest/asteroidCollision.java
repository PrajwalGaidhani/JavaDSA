package com.prajwal.dsa.mocktest;

import java.util.Stack;

/**
 * So there is just 1 main point that we need to focus on, and that is -: the collision will only happen when top of stack is a +ve number and the element we want to insert is -ve.
 * And the reason for that is,
 *
 * If both elements are of same sign they will continue in that direction itself.
 * If the top is -ve and the element we want to insert is +ve then they will continue in opposite directions.
 * In both of these cases there will be no collision.
 *
 * We will always push on the stack in case the stack is empty.
 * And now the algo is just a peice of cake ig. Because we just need to check 3 conditions i.e
 *
 * All the values below are absolute of the original signed values.
 *
 * If the element we wish to insert is greater than top of stack ---- if (ele > stack[-1])
 * If the element is equal to top of stack ---- if (ele == stack[-1]
 * If the element is smaller than the top of the stack, it will be covered in the else statement eitherways --- if (ele < stack[-1]
 */
public class asteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -ast) stack.pop();       // top explodes
                else if (top == -ast) { stack.pop(); ast = 0; break; } // both explode
                else { ast = 0; break; }            // current explodes
            }
            if (ast != 0) stack.push(ast);
        }
        // convert to array
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }

}
