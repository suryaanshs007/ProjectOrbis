interface Moving{
    void move();
}
interface Flying{
    void fly();
}
interface Attacking{
    void attack(Attackable obj);
}
interface Attackable{
    void takeDamage(int unit);
}
interface Healing{
    void heal(PlayableCharacter p);
}

abstract class Entity{
    String name;
    int health;
}
abstract class PlayableCharacter extends Entity implements Moving,Attacking,Attackable{
    public void move(){
        System.out.println("The player moves");
    }
}
class Mage extends PlayableCharacter implements Healing{
    int mana;
    int healingpower;

    public void attack(Attackable obj){
        System.out.println("Mage casts the spell and attacks");
        obj.takeDamage(this.mana);
    }
    public void takeDamage(int unit){
        System.out.println("Mage takes damage");
        this.health -= unit;
    }
    public void heal(PlayableCharacter p){
        p.health += this.healingpower;
    }
}
//class Kinight extends PlayableCharacter{

//}
class Dragon extends Entity implements Flying, Moving, Attacking{
    public void fly(){
        System.out.println("The dragon flies");
    }
    public void move(){
        System.out.println("The dragon moves");
    }
    public void attack(Attackable c){
        System.out.println("The dragon attacks the player");
        c.takeDamage(100);
    }
}
//class HealingFoundain implements Healing{

//}
//class Arrow implements Moving,Flying,Attacking{

//}

class GameEngine{
    void renderFlight(Flying obj){
        System.out.println("Now rendering flight...");
        obj.fly();
    }
    void processMovement(Moving obj){
        System.out.println("Processing Movement....");
        obj.move();
    }
}
public class ProjectOrbisBase{

    public static void main(String args[]){
        GameEngine gameInstance = new GameEngine();
        Dragon toothless = new Dragon();
        gameInstance.renderFlight(toothless);
        Mage merlin = new Mage();
        gameInstance.processMovement(merlin);
    }

}