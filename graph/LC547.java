package graph;

public class LC547 {
    static void dfs(int city,int [][]isConnected,boolean []visited){
        visited[city]=true;
        for(int n=0;n<isConnected.length;n++){
            if(isConnected[city][n]==1 && !visited[n]){
                dfs(n,isConnected,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean []visited = new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                provinces++;
                dfs(i,isConnected,visited);
            }
        }
        return provinces;
    }
    public static void main(String[] args) {
        LC547 obj = new LC547();
        int [][]isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(obj.findCircleNum(isConnected));
    }
}