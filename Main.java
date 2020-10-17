import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Shoes wornshoes = new Shoes("Worn Armor(S)", 3);
        Shoes windshoes = new Shoes("Wind Armor(S)", 5);
        Shoes samaelshoes = new Shoes("Samael's Armor(S)", 10);
        Gauntlet worngauntlet = new Gauntlet("Worn Armor(G)", 8);
        Gauntlet windgauntlet = new Gauntlet("Wind Armor(G)", 16);
        Gauntlet samaelgauntlet = new Gauntlet("Samael's Armor(G)", 20);
        Weapon metaldagger = new Weapon("Metal Dagger",15);
        Weapon cupidsbow = new Weapon("Cupid's Bow",21);
        Weapon maceofjustice = new Weapon("Mace of Justice",27);
        Kucing kucing1 = new Kucing("DumCat");
        kucing1.setArmor(windgauntlet,windshoes);
        kucing1.setWeapon(metaldagger);
        kucing1.levelUp();

        String nickname;
        int choice=0;

        Scanner scan = new Scanner(System.in);
        System.out.print("Nickname: ");
        nickname = scan.nextLine();

        Kucing kucing2 = new Kucing(nickname);
        System.out.println("\n\nWelome to CatSims Online, "+ nickname +"!");
        while(choice!=1 && choice!=2){
            System.out.println("Do you want to be a cat?\n1.Yes\n2.Meow");
            choice = scan.nextInt();
        }

        System.out.println("\nGreat Choice! You are a cat now:) Isn't that amazing?\n");
        System.out.println("Worn Armor(S), Worn Armor(G), Mace of Justice(W) obtained.");
        kucing2.setArmor(worngauntlet, wornshoes);
        kucing2.setWeapon(maceofjustice);

        choice=0;
        while(choice!=1&&choice!=2){
            System.out.println("Look at that sleeping cat-\n1. Attack\n2. Sleep Together");
            choice = scan.nextInt();
        }
        if(choice==1){
            kucing2.attack(kucing1);
            System.out.println("Oh no it's gonna attack u!\n");
            kucing1.attack(kucing2);
        }
        else if(choice==2){
            kucing2.sleep();
        }

        choice=0;
        outer:
        while(choice!=6){
            System.out.println("\n1. Attack\n2. Sleep\n3. Eat\n4. GetInfo\n5. Armory\n6. Close");
            choice = scan.nextInt();
        if(choice==1){
            kucing2.attack(kucing1);
            System.out.println("Oh no it's gonna attack u!\n");
            kucing1.attack(kucing2);
        }
        else if(choice==2){
            kucing2.sleep();
        }
        else if(choice==3){
            kucing2.eat();
        }
        else if(choice==4){
            kucing2.getInfo();
        }
        else if(choice==5){
            System.out.println("Armors Available: \n");
            System.out.println("1. Samael's Armor(S) \n2. Cupid's Bow\n3. Close");
            int pilih = scan.nextInt();
            if(pilih==1&&pilih==2){
                System.out.println("Equip?\n1. Yes\n2. No");
                if(pilih==1){
                    kucing2.setArmor(samaelgauntlet, samaelshoes);
                }
                if(pilih==2){
                    kucing2.setWeapon(cupidsbow);
                }
                System.out.println("Equipped.\n");
            }
            else{
                continue outer;
            }
        }
    }
        System.out.println("Thanks for playing CatSims, "+nickname);
        scan.close();
    }
}
