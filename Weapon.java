public class Weapon {
    private int atk=0;
    private String name;

    public Weapon(String name, int atk){
        this.name = name;
        this.atk = atk;
    }

    public int getAtk(){
        return atk;
    }

    public void getInfo(){
        System.out.println("Weapon Name: " + name);
        System.out.println("Attack Power: " + atk);
    }
}
