[LeetCode 3373-(!3372)] : (https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/description/?envType=problem-list-v2&envId=2c9wy0k3)

### Problem Logic Explanation

In this problem, the key requirement is to **count the number of nodes that are at odd distances and even distances**.  

The main logic comes from the **graph coloring (bipartite) idea**:

- We can think of the tree as being "painted" using **two colors**, where each depth level alternates between the two colors.  
  - Depth 0 → Color 1  
  - Depth 1 → Color 2  
  - Depth 2 → Color 1  
  - Depth 3 → Color 2  
  - … and so on.  

- This alternating coloring helps because:  
  - If two nodes share the **same color**, the distance between them will always be **even**.  
  - If two nodes have **different colors**, the distance between them will always be **odd**.  

So, by splitting the tree nodes into two groups based on depth parity (even-depth nodes vs odd-depth nodes),  
we can directly compute the required counts of nodes at odd/even distances.  



``` java
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj1.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj2.add(new ArrayList<>());
        }

        for (int[] i : edges1) {
            adj1.get(i[0]).add(i[1]);
            adj1.get(i[1]).add(i[0]);
        }
        for (int[] i : edges2) {
            adj2.get(i[0]).add(i[1]);
            adj2.get(i[1]).add(i[0]);
        }

        int[] req2 = new int[2];
        int[] req1 = new int[2];

        boolean[] par1 = new boolean[n];
        boolean[] par2 = new boolean[m];

        rohan1(true, -1, 0, adj1, req1, par1);
        rohan1(true, -1, 0, adj2, req2, par2);

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (par1[i]) {
                ans[i] = req1[0] + Math.max(req2[0], req2[1]);
            } else {
                ans[i] = req1[1] + Math.max(req2[0], req2[1]);
            }
        }

        return ans;
    }

    private void rohan1(boolean isOdd, int par, int node, List<List<Integer>> adj, int[] req, boolean[] pari) {
        if (isOdd) {
            req[0]++;
            pari[node] = true;
        } else {
            req[1]++;
        }
        for (int i : adj.get(node)) {
            if (i != par) {
                rohan1(!isOdd, node, i, adj, req, pari);
            }
        }
    }
}
```
[Longest path  in DAG] :(https://leetcode.com/problems/longest-string-chain/description/?envType=problem-list-v2&envId=2c9wy0k3)

***MEMO : DP : Longest Path in a Graph***

``` java

        boolean [] vis = new boolean [words.length];
        int [] len = new int [words.length];

        for(int i = 0 ; i < vis.length ; i++){
            if(!vis[i]){
                rohan(i,vis,len,adj);
            }
        }

        int max = 1;

        for(int i : len){
            if(i > max){
                max = i;
            }
        }

        return max;

private int rohan(int curr , boolean [] vis , int [] len , List<List<Integer>> adj ){
        len[curr]++;
        vis[curr] = true;
        int max = 0;
        for(int i : adj.get(curr)){
            if(vis[i]){
                max = Math.max(len[i],max);
            }
            else{
                max = Math.max(max,rohan(i,vis,len,adj));
            }
        }
        len[curr] += max;

        return len[curr];
    }

```


*** Binary Search Revise for Interviews Always ***
Striver Sheat all questions +

[Min of MAX LC 2616] :(https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/) 



