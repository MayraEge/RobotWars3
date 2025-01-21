package Models;

public class Robot {
    private String robotName;
    private int x;
    private int y;
    private Coordinates coordinates;
    private int health;
    private int movementRate;
    private int attackDamage;
    private int attackRange;
    private boolean knockedOut;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getRobotName() {
        return this.robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int setAttackDamage(int attackDamage) {
        return attackDamage;
    }

    public boolean isKnockedOut() {
        return knockedOut;
    }

    public void setKnockedOut(boolean knockedOut) {
        this.knockedOut = knockedOut;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMovementRange() {
        return movementRate;
    }

    public void setMovementRange(int movementRange) {
        this.movementRate = movementRange;
    }


    public Robot(String robotName, int x, int y, int health, int movementRange, int damage, int attackRange, boolean knockedOut) {
        this.robotName = robotName;
        this.x = x;
        this.y = y;
        this.health = health;
        this.movementRate = movementRange;
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.knockedOut = knockedOut;
    }

    public void move() {

    }

    public static void attack(Robot player, Robot target) {
        target.setHealth(target.getHealth() - player.getAttackDamage());
    }
}
