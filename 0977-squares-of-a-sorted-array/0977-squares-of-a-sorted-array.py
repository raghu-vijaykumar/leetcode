class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        sqrnum=[]
        for i in nums:
            sqrnum.append(i*i)
        sqrnum.sort()
        return sqrnum
        