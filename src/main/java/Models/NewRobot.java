package Models;

public class NewRobot {
    private String name;
    private int health;
    private int attackDamage;
    private int attackRange;
    private int movementRate;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setAttackDamage(int attackDamage){
       this.attackDamage = attackDamage;
    }

    public int getAttackDamage(){
        return attackDamage;
    }

    public int getAttackRange(){
        return attackRange;
    }

    public void setAttackRange(int attackRange){
        this.attackRange = attackRange;
    }

    public int getMovementRate(){
        return movementRate;
    }

    public void setMovementRate(int movementRate){
        this.movementRate = movementRate;
    }
}
