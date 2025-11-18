/**
 * @author bhavishya
 * @Since 18/11/25
 **/
class RebelTrooper extends Trooper {
    private String name = "Rebel";
    private static int soldierCount = 0;

    public RebelTrooper(String unit, int number, String name) {
        super(unit, number);
        soldierCount++;
        this.trooperKind = "pilot";
        this.marchModifier = 0.75;
        this.name = name;
    }

    // Getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public static int getSoldierCount() { return soldierCount; }

    @Override
    public double march(double duration) {
        return getMarchSpeed() * duration * getMarchModifier();
    }

    @Override
    public String toString() {
// name + "(" + parent toString + ") a " + trooperKind
        return (name == null ? "" : name) + "(" + super.toString() + ") a " + this.trooperKind;
    }
}
