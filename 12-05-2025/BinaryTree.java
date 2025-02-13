// Given the in-order and post-order traversals of a binary tree, construct 
// the original binary tree. For the given Q number of queries, 
// each query consists of a lower level and an upper level. 
// The output should list the nodes in the order they appear in a level-wise.

// Input Format:
// -------------
// An integer N representing the number nodes.
// A space-separated list of N integers representing the similar to in-order traversal.
// A space-separated list of N integers representing the similar to post-order traversal.
// An integer Q representing the number of queries.
// Q pairs of integers, each representing a query in the form:
// Lower level (L)
// Upper level (U)

// Output Format:
// For each query, print the nodes in order within the given depth range

// Example
// Input:
// 7
// 4 2 5 1 6 3 7
// 4 5 2 6 7 3 1
// 2
// 1 2
// 2 3
// Output:
// [1, 2, 3]
// [2, 3, 4, 5, 6, 7]

// Explanation:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7
// Query 1 (Levels 1 to 2): 1 2 3
// Query 2 (Levels 2 to 3): 2 3 4 5 6 7


import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree(Node root) {
        this.root = root;
    }

    public static Node buildTree(int[] inOrd, int[] postOrd, int ins, int ine, int posts, int poste) {
        if (ins > ine || posts > poste) {
            return null;
        }
        int key = postOrd[poste];
        Node root = new Node(key);
        int rooi = 0;
        for (int i = ins; i <= ine; i++) {
            if (inOrd[i] == key) {
                rooi = i;
                break;
            }
        }
        int leftsublen = rooi - ins;
        root.left = buildTree(inOrd, postOrd, ins, rooi - 1, posts, posts + leftsublen - 1);
        root.right = buildTree(inOrd, postOrd, rooi + 1, ine, posts + leftsublen, poste - 1);
        return root;
    }

    public static List<Integer> getNodesInLevelRange(Node root, int lowerLevel, int upperLevel) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (level >= lowerLevel && level <= upperLevel) {
                    currentLevel.add(current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (level >= lowerLevel && level <= upperLevel) {
                result.addAll(currentLevel);
            }
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inOrd = new int[n];
        int[] postOrd = new int[n];
        for (int i = 0; i < n; i++) {
            inOrd[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            postOrd[i] = sc.nextInt();
        }
        int nq = sc.nextInt();
        int[][] queries = new int[nq][2];
        
        for (int i = 0; i < nq; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        Node root = buildTree(inOrd, postOrd, 0, n - 1, 0, n - 1);
        for (int i = 0; i < nq; i++) {
            int lowerLevel = queries[i][0];
            int upperLevel = queries[i][1];
            List<Integer> nodesInRange = getNodesInLevelRange(root, lowerLevel, upperLevel);
            System.out.println(nodesInRange);
        }

        sc.close();
    }
}