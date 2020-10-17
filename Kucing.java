import java.util.Random;
interface MakhlukHidup {
    void eat();
    void sleep();
}
public class Kucing implements MakhlukHidup{
    private String nickname;
    private int health = 100;
    private int attack = 15;
    private int level = 1;
    private final int health2 = 10;
    private final int attack2 = 5;
    private int exp=0;
    private int sleepy=0;

    Armor armor;
    Weapon weapon;
    Shoes shoes;
    Gauntlet gauntlet;

    public Kucing (String nickname){
        this.nickname = nickname;
    }
    public void setArmor(Gauntlet gauntlet, Shoes shoes){
        this.gauntlet = gauntlet;
        this.shoes = shoes;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public int maxHealth(){
        return health + shoes.getHealth() + level * health2;
    }
    public int maxAttack(){
        return attack + weapon.getAtk() + level * attack2;
    }
    public void levelUp(){
        System.out.println("Level Up!!");
        level++;
    }
    public String getName(){
        return nickname;
    }
    public void getInfo(){
        System.out.println("Nickname: " + nickname);
        System.out.println("Health: " + health + "HP\nAttack Power: "+ attack);
        System.out.println("Max Health: " + maxHealth() + "\nMax Attack Power: "+ maxAttack());
        System.out.println("Level: " + level + "\nExp: " + exp + "\n");
        System.out.println("Armor");
        gauntlet.getInfo();
        shoes.getInfo();
    }
    public void attack(Kucing enemy){
        System.out.println( nickname +" attacks " + enemy.getName() + " with " + maxAttack() + " damage.");
        exp+=50;
        if(exp%100==0){
            levelUp();
        }
        int maxatk = maxAttack();
        enemy.defense(maxatk);
    }
    public void defense(int atk){
        int def = shoes.getDef() + gauntlet.getDef();
        int damage = def - atk;
        health -= Math.abs(damage);
        if (health<0){
            System.out.println(nickname + " is dead.\nWaiting for ressurection.");
            health = 100;
        }
        else{
            System.out.println(nickname + " gets " + damage + " damage.\n" + health + " HP remaining\n");
        }
    }

    //interface
    public void eat(){
        System.out.println("Nom..nom..! 5exp gained.");
        exp+=5;
        sleepy+=25;
        if (sleepy%75==0){
            sleep();
        }
        if(exp%100==0){
            levelUp();
        }
    }
    public void sleep(){
        System.out.println("You fall asleep for 5 minutes. Theres 1/3 chance to be attacked");
        Random rand = new Random();
        int chance = rand.nextInt(4); 
        if (chance==1){
            health-=25;
            System.out.println("You were attacked. " + health + "HP remaining.");
        }
    }
}    
