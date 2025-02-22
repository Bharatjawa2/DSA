class Solution {
    public List<List<Integer>> DFSTraversal(TreeNode root) {
        return Arrays.asList(preorderTraversal(root), inorderTraversal(root), postorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        return list;
    }

    // Postorder using one stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) { 
                stack.push(curr); 
                curr = curr.left; // Go left
            } else {
                TreeNode peekNode = stack.peek();
                // If right child exists and not visited, move to right
                if (peekNode.right != null && peekNode.right != lastVisited) {
                    curr = peekNode.right;
                } else {
                    list.add(peekNode.val); // Process node
                    lastVisited = stack.pop();
                }
            }
        }
        return list;
    }
}
