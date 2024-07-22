class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[][] people = new String[n][2];    
        for (int i = 0; i < n; i++) {
            people[i][0] = names[i];
            people[i][1] = String.valueOf(heights[i]);
        }
        Arrays.sort(people, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
            }
        });
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i][0];
        }
        return sortedNames;
    }
}