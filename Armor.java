abstract class Armor {
    String name;
    int def=0;
    public Armor(String name, int def){
        this.name = name;
        this.def = def;
    }
    public int getDef(){
        return def;
    }
    abstract void getInfo();
    abstract int getHealth();
}

class Shoes extends Armor{
    public Shoes(String name, int  def){
        super(name, def);
    }
    public int getHealth(){
        return def;
    }
    public void getInfo(){
        System.out.println("Shoes : " + name + " Def : "+ def);
    }
}

class Gauntlet extends Armor{
    public Gauntlet(String name, int  def){
        super(name, def);
    }
    public int getHealth(){
        return def*2;
    }
    public void getInfo(){
        System.out.println("Gauntlet : " + name + " Def : "+ def);
    }
}