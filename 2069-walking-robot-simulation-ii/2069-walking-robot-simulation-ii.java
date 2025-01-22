class Robot {

    int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int dirIndex = 0; // Start facing "East"
    int[] currentPos = new int[] { 0, 0 };
    int width;
    int height;
    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height - 2); // Total steps in one complete cycle
    }

    public void step(int num) {
        // Compute effective steps using modulo
        num %= perimeter;

        if (num == 0) {
            // Special case: Full cycle completed
            if (currentPos[0] == 0 && currentPos[1] == 0) {
                dirIndex = 3; // If at (0, 0), direction is "South"
            }
            return; // Position remains the same
        }

        while (num > 0) {
            // Calculate the steps to the next boundary in the current direction
            int stepsToBoundary = stepsToEdge();
            int steps = Math.min(num, stepsToBoundary); // Take the smaller of num or stepsToBoundary
            currentPos[0] += steps * directions[dirIndex][0];
            currentPos[1] += steps * directions[dirIndex][1];
            num -= steps;

            if (num > 0) {
                // Rotate if we hit the boundary
                rotate();
            }
        }
    }

    private int stepsToEdge() {
        if (dirIndex == 0) return width - 1 - currentPos[0]; // East
        if (dirIndex == 1) return height - 1 - currentPos[1]; // North
        if (dirIndex == 2) return currentPos[0]; // West
        return currentPos[1]; // South
    }

    public void rotate() {
        dirIndex = (dirIndex + 1) % 4; // Rotate to the next direction
    }

    public int[] getPos() {
        return currentPos;
    }

    public String getDir() {
        switch (dirIndex) {
            case 0: return "East";
            case 1: return "North";
            case 2: return "West";
            case 3: return "South";
            default: return "";
        }
    }
}
