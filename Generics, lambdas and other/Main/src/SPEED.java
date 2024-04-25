public enum SPEED {
    CAR(100), TRUCK(80);
    private int speed;

    SPEED(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
