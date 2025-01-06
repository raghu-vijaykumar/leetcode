class Solution:
    def maxDepth(self, s: str) -> int:

        counter = 0
        maxDepth = 0
        for i in range(len(s)):
            if s[i] == '(':
                counter+=1
            elif s[i] == ')':
                maxDepth = max(maxDepth, counter)
                counter-=1
            else:
                maxDepth = max(maxDepth, counter)

        return maxDepth
