public class MeregeSort {
    
    public static void mergeSort(int[] arr,int low,int high){
        if(low>=high) return;
        int mid=low+(high-low)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    static void merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int left=low;
        int right=mid+1;
        int k=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right])temp[k++]=arr[left++];
            else temp[k++]=arr[right++];
        }
        while(left<=mid)temp[k++]=arr[left++];
        while(right<=high)temp[k++]=arr[right++];
        for(int i=low;i<=high;i++){
            arr[i]=temp[i-low];
        }
    }
    public static void main(String[] args) {
        // System.out.println("Start small. Ship something.");
        int[]arr={28,59,17,3,67,39,12};
        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }
}