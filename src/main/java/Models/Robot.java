public class Robot {
    private int movementRate;
    private int attackStrength;
    private int attackRange;
    private int health;
    private int x, y;

    public Robot(int movementRate, int attackStrength, int attackRange, int health) {
        this.movementRate = movementRate;
        this.attackStrength = attackStrength;
        this.attackRange = attackRange;
        this.health = health;
        this.x = 0;
        this.y = 0;
    }

    public void move(Character direction) {
        switch (direction) {
            case 'w':
                y += movementRate;
                break;
            case 'q':
                x -= movementRate;
                y += movementRate;
                break;
            case 'e':
                x += movementRate;
                y += movementRate;
                break;
            case 'a':
                x -= movementRate;
                break;
            case 'd':
                x += movementRate;
                break;
            case 's':
                y -= movementRate;
                break;
            default:
                System.out.println("Ungültige Richtung!");
                break;

        }
    }
}
