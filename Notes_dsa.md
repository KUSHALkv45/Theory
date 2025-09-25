[LeetCode 3373-(!3372)] : (https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/description/?envType=problem-list-v2&envId=2c9wy0k3)

Here in this question there is a solid requirement that is needed that we are needed to count no nodes which are odd distances and even distances So : 

Main Logic is the coloring problem like we color a depth as one color and the next depth with 2nd color and next with 1st so we are using only 2 colors to paint the tree each depth one color 

so from same color to same color the distance will be even and odd with differet color  so this can be used here


<code>```java</code> 
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

        // int odd = 0;
        // int even = 0;

        int [] req2 = new int [2];

        rohan(true,-1,0,adj2,req2);

        int [] req1 = new int [2];

        

        boolean [] par1 = new boolean [n];

        rohan1(true,-1,0,adj1,req1,par1);

        int [] ans = new int [n];

        for(int i = 0 ; i < n ; i++){
            if(par1[i]){
                ans[i] = req1[0] + Math.max(req2[0],req2[1]);
            }
            else{
                ans[i] = req1[1] + Math.max(req2[0],req2[1]);
            }
        }

        // System.out.println(Arrays.toString(req1));
        // System.out.println(Arrays.toString(req2));
        // System.out.println(Arrays.toString(par1));

        return ans ;

        
    }
    private void rohan(boolean isOdd , int par , int node , List<List<Integer>> adj , int [] req){
        if(isOdd){
            req[0]++;
        }
        else{
            req[1]++;
        }
        for(int i : adj.get(node)){
            if(i != par){
                rohan(!isOdd,node,i,adj,req);
            }
        }
    }

    private void rohan1(boolean isOdd , int par , int node , List<List<Integer>> adj , int [] req , boolean [] pari){
        if(isOdd){
            req[0]++;
            pari[node] = true;
        }
        else{
            req[1]++;
        }
        for(int i : adj.get(node)){
            if(i != par){
                rohan1(!isOdd,node,i,adj,req,pari);
            }
        }
    } 
}
<code>```</code> 




