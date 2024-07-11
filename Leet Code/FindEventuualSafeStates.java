class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> status = new HashMap<>();

        for(int node = 0; node < graph.length; node++){
            map.put(node, new ArrayList<>());
            for(int neighbour = 0; neighbour < graph[node].length; neighbour++){
                map.get(node).add(graph[node][neighbour]);
            }
        }

        for(int node = 0; node < graph.length; node++){
            if(dfs(node, map, list, status)){
                list.add(node);
            }
        }

        return list;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> map, List<Integer> list, Map<Integer, Boolean> status){
        if(status.containsKey(node)){
            return status.get(node);
        }
        status.put(node, false);
        boolean ans = true;
        for(int neighbour : map.get(node)){
            if(!dfs(neighbour, map, list, status)){
                return false;
            }
        }
        status.put(node, true);
        return true;
    }
}
