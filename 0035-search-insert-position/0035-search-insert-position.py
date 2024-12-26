class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = int((start + end)/2)
            print(start, end, mid)
            if mid == 0 and target <= nums[0]:
                return 0
            if mid == len(nums) - 1 and target > nums[len(nums) -1]:
                return len(nums)
            if target == nums[mid]:
                return mid;
            if target < nums[mid]:
                if target > nums[mid-1]:
                    return mid;
                else: 
                    end = mid - 1

            if target > nums[mid]:
                if target < nums[mid+1]: 
                    return mid + 1
                else:
                    start = mid + 1
        