public class CountOccurencesBinarySearch {
	static int FirstOccurence(int[] arr, int target){
		int low=0, high=arr.length-1;
		int ans=-1;
		while(low<=high){
			int mid=low+(high-low)/2;
			if(arr[mid]==target){
				ans=mid;
				high=mid-1;
			}
			else if(arr[mid]>target)high=mid-1;
			else low=mid+1;
		}
		return ans;
	}
	static int LastOccurence(int[] arr, int target){
		int low=0, high=arr . length-1;
		int ans=-1;
		while(low<=high){
			int mid=low+(high-low)/2;
			if(arr[mid]==target){
				ans=mid;
				low=mid+1;
			}
			else if(arr[mid]>target)high=mid-1;
			else low=mid+1;
		}
		return ans;
	}
	public static void main(String[] args){
		int []arr={1,2,2,2,3,4,5};
		int target=2;
		int first=FirstOccurence(arr,target);
		int last=LastOccurence(arr,target);
		if(first==-1) System.out.print("not found");
		else System.out.print("count "+(last-first+1));
	}
}