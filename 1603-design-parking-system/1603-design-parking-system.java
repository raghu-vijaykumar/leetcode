class ParkingSystem {
    int BIG_CAPACITY;
    int MEDIUM_CAPACITY;
    int SMALL_CAPACITY;

    public ParkingSystem(int big, int medium, int small) {
        this.BIG_CAPACITY = big;
        this.MEDIUM_CAPACITY = medium;
        this.SMALL_CAPACITY = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (this.BIG_CAPACITY == 0)
                return false;
            this.BIG_CAPACITY--;
            return true;
        } else if (carType == 2) {
            if (this.MEDIUM_CAPACITY == 0)
                return false;
            this.MEDIUM_CAPACITY--;
            return true;
        } else {
            if (this.SMALL_CAPACITY == 0)
                return false;
            this.SMALL_CAPACITY--;
            return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */