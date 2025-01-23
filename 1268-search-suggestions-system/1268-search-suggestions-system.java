class Solution {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    // Method to list a limited number of words starting with a given prefix
    public List<String> wordsWithPrefix(String prefix, int limit) {
        List<String> result = new ArrayList<>();
        TrieNode current = root;

        // Navigate to the node corresponding to the prefix
        for (char c : prefix.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return result; // Prefix not found, return empty list
            }
        }

        // Perform DFS to find all words from this node
        dfs(current, new StringBuilder(prefix), result);
        Collections.sort(result);
        return result.size() > 3 ? result.subList(0, 3) : result;
    }

    // Helper method to perform DFS and collect words with a limit
    private void dfs(TrieNode node, StringBuilder prefix, List<String> result) {
        if (node.isEndOfWord) {
            result.add(prefix.toString());
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            prefix.append(entry.getKey());
            dfs(entry.getValue(), prefix, result);
            prefix.deleteCharAt(prefix.length() - 1); // Backtrack
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        for (String product : products) {
            insert(product);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            sb.append(searchWord.charAt(i));
            List<String> sub = wordsWithPrefix(sb.toString(), 3);
            res.add(sub);
        }
        return res;
    }
}