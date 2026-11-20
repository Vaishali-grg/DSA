package graph;

public class LC733 {
    public static void dfs(int [][]image, int row, int col, int originalcolor, int newcolor){
        int rows = image.length;
        int cols = image[0].length;
        if(row<0 || col <0 || row >=rows || col>=cols){
            return;
        }
        if(image[row][col]!=originalcolor){
            return;
        }
        image[row][col]=newcolor;
        dfs(image,row-1,col,originalcolor,newcolor);
        dfs(image,row+1,col,originalcolor,newcolor);
        dfs(image,row,col-1,originalcolor,newcolor);
        dfs(image,row,col+1,originalcolor,newcolor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor = image[sr][sc];
        if(originalcolor == color){
            return image;
        }
        dfs(image,sr,sc,originalcolor,color);
        return image;
    }
    public static void main(String[] args) {
        LC733 obj = new LC733();
        int [][]image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int [][]result = obj.floodFill(image,sr,sc,color);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}