public class BinarySearch {
	static int bs(int[] arr, int target){
		int low=0, high=arr.length-1;
		while(low<=high){
			int mid=low+(high-low)/2;
			if(arr[mid]==target)return mid;
			else if(arr[mid]>target)high=mid-1;
			else low=mid+1;
		}
		return -1;
	}
	public static void main(String[] args){
		int []arr={1,2,3,4,5};
		int target=2;
		int ans=bs(arr,target);
		if(ans==-1) System.out.print("not found");
		else System.out.print("found at "+ans);
	}
}
