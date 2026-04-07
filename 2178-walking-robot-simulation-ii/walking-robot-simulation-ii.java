class Robot {
    private ArrayList<int[]> pos;
    private String[] dir;
    private int i;
    private boolean isOrigin;
    public Robot(int width, int height) {
        pos = new ArrayList<>();
        dir = new String[width * 2 + height * 2 - 4];
        pos.add(new int[]{0, 0});
        dir[0] = "South";
        int k = 1;
        for (int i = 1; i < width; i++) {
            pos.add(new int[]{i, 0});
            dir[k++] = "East";
        }
        for (int j = 1; j < height; j++) {
            pos.add(new int[]{width - 1, j});
            dir[k++] = "North";
        }
        for (int i = width - 2; i >= 0; i--) {
            pos.add(new int[]{i, height - 1});
            dir[k++] = "West";
        }
        for (int j = height - 2; j > 0; j--) {
            pos.add(new int[]{0, j});
            dir[k++] = "South";
        }
        isOrigin = true;
        i = 0;
    }
    
    public void step(int num) {
        isOrigin = false;
        i = (i + num) % pos.size();
    }
    
    public int[] getPos() {
        return pos.get(i);
    }
    
    public String getDir() {
        return isOrigin ? "East" : dir[i];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */