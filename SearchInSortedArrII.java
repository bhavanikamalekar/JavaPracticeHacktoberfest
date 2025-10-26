class SearchInSortedArrII{
    public boolean search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return true;
            }
            if(arr[low] == arr[mid] && arr[mid]==arr[high]){
                low++ ;
                high--;
                continue;
            }

            // Check if left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1; // Target lies in the left half
                } else {
                    low = mid + 1; // Target lies in the right half
                }
            }
            // Right half is sorted
            else {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1; // Target lies in the right half
                } else {
                    high = mid - 1; // Target lies in the left half
                }
            }
        }

        return false; // Target not found
    }
}
