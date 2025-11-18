/**
 * @author bhavishya
 * @Since 18/11/25
 **/
class StormTrooper extends Trooper {
    private String name = "";
    private static int soldierCount = 0;

    public StormTrooper(String unit, int number) {
        super(unit, number);
        soldierCount++;
        this.trooperKind = "StormTrooper";
        this.marchModifier = 1.10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount() {
        return soldierCount;
    }

    public static void setSoldierCount(int soldierCount) {
        StormTrooper.soldierCount = soldierCount;
    }

    @Override
    public double march(double duration){
        return getMarchSpeed() * duration * getMarchModifier();
    }
    @Override
    public String toString() {
        return (name == null ? "" : name) + "(" + super.toString() + ") a " + this.trooperKind;
    }
}
