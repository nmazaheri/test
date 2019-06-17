package dataStructures;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(int[] sortedArr) {
        root = addToTree(sortedArr, 0, sortedArr.length - 1);
    }

    public TreeNode addToTree(int[] sortedArr, int start, int end) {
        if (end < start)
            return null;

        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(sortedArr[mid]);
        treeNode.leftChild = addToTree(sortedArr, start, mid - 1);
        treeNode.rightChild = addToTree(sortedArr, mid + 1, end);
        return treeNode;
    }

    public void addNode(int key) {
        TreeNode newNode = new TreeNode(key);
        TreeNode focusNode = root;

        if (focusNode == null) {
            root = newNode;
            return;
        }

        TreeNode parent;
        while (true) {
            parent = focusNode;

            if (key < focusNode.data) {
                focusNode = focusNode.leftChild;
                if (focusNode == null) {
                    parent.leftChild = newNode;
                    return;
                }

            } else {
                focusNode = focusNode.rightChild;
                if (focusNode == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void inOrderTraverseTree() {
        inOrderTraverseTree(root);
    }

    private void inOrderTraverseTree(TreeNode focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.print(focusNode.toString());
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree() {
        preOrderTraverseTree(root);
    }

    private void preOrderTraverseTree(TreeNode focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.toString());
            inOrderTraverseTree(focusNode.leftChild);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree() {
        postOrderTraverseTree(root);
    }

    private void postOrderTraverseTree(TreeNode focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            inOrderTraverseTree(focusNode.rightChild);
            System.out.print(focusNode.toString());
        }
    }

    public int getMinimum(TreeNode focusNode) {
        if (focusNode == null) {
            return 0;
        }
        while (focusNode.leftChild != null) {
            focusNode = focusNode.leftChild;
        }
        return focusNode.data;
    }

    public int getMaximum(TreeNode focusNode) {
        if (focusNode == null) {
            return 0;
        }
        while (focusNode.rightChild != null) {
            focusNode = focusNode.rightChild;
        }
        return focusNode.data;
    }

    public boolean isBalanced() {
        return 1 >= getMaxHeight(root) - getMinHeight(root);
    }

    public int getMaxHeight(TreeNode focusNode) {
        if (focusNode == null)
            return 0;

        return 1 + Math.max(getMaxHeight(focusNode.leftChild), getMaxHeight(focusNode.rightChild));
    }

    public int getMinHeight(TreeNode focusNode) {
        if (focusNode == null)
            return 0;

        return 1 + Math.min(getMaxHeight(focusNode.leftChild), getMaxHeight(focusNode.rightChild));
    }

    public TreeNode findNode(int key) {
        TreeNode focusNode = root;

        while (focusNode.data != key) {
            if (focusNode.data > key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null)
                return null;
        }
        return focusNode;

    }

    public boolean removeNode(int key) {
        TreeNode focusNode = root;
        TreeNode parent = root;

        boolean previouslyMovedLeft = true;

        while (focusNode.data != key) {
            parent = focusNode;
            if (key < focusNode.data) {
                previouslyMovedLeft = true;
                focusNode = focusNode.leftChild;
            } else {
                previouslyMovedLeft = false;
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                // cannot find node
                return false;
            }
        }

        // NODE found
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root)
                root = null;
            else if (previouslyMovedLeft)
                parent.leftChild = null;
            else
                parent.rightChild = null;

        } else if (focusNode.rightChild == null) {
            if (focusNode == root)
                root = focusNode.leftChild;
            else if (previouslyMovedLeft)
                parent.leftChild = focusNode.leftChild;
            else
                parent.rightChild = focusNode.leftChild;

        } else if (focusNode.leftChild == null) {
            if (focusNode == root)
                root = focusNode.rightChild;
            else if (previouslyMovedLeft)
                parent.leftChild = focusNode.rightChild;
            else
                parent.rightChild = focusNode.rightChild;
        } else {
            // two children involved
            TreeNode replacement = getReplacementNode(focusNode);
            if (focusNode == root)
                root = replacement;
            else if (previouslyMovedLeft)
                parent.leftChild = replacement;
            else
                parent.rightChild = replacement;

            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    private TreeNode getReplacementNode(TreeNode replacedNode) {
        TreeNode replacementParent = replacedNode;
        TreeNode replacement = replacedNode;
        TreeNode focusNode = replacedNode.rightChild;

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }

    private class TreeNode {
        public int data;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return this.data + " ";
        }
    }
}
