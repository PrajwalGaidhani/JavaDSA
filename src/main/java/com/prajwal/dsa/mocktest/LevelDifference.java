package com.prajwal.dsa.mocktest;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class LevelDifference {
    public int levelDifference(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();  // ❌ You used `new Queue<>()` (Queue is an interface, use LinkedList)
        queue.offer(root);

        int level = 1;
        int oddSum = 0;
        int evenSum = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            int tempSum = 0;

            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();  // ❌ You used `pop()` which is not valid for Queue
                tempSum += temp.val;

                if (temp.left != null) queue.offer(temp.left);  // ❌ You forgot `!= null`
                if (temp.right != null) queue.offer(temp.right);
            }

            if (level % 2 == 0) {
                evenSum += tempSum;
            } else {
                oddSum += tempSum;  // ❌ Typo: `odSumSum` should be `oddSum`
            }

            level++;
        }

        return oddSum - evenSum;
    }
}
