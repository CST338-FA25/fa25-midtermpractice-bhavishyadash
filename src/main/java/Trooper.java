import java.util.*;
import java.util.Objects;
/**
 * @author bhavishya
 * @Since 18/11/25
 **/
public class Trooper {
    private String unit;
    private int number;

    protected double marchSpeed;
    protected double marchModifier;
    protected String trooperKind;

    public Trooper(String unit, int number) {
        this.unit = unit;
        this.number = number;
        this.marchSpeed = 5.0;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    public double getMarchModifier() {
        return marchModifier;
    }

    public void setMarchModifier(double marchModifier) {
        this.marchModifier = marchModifier;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper t) {
        if (t == null || units == null) return;
        String key = t.getUnit();
        if (key == null) return;
        units.computeIfAbsent(key, k -> new ArrayList<>()).add(t);
    }

    public abstract double march(double duration);

    public boolean attack(Trooper target, int roll) {
// Always print these two lines first
        System.out.println(this + " is attacking " + target);
        System.out.println(this + " rolled a " + roll);

// Self-target or natural 1
        if (this == target || roll == 1) {
            System.out.println(this + " is targeting itself...");
            System.out.println(this + " rolled a " + roll + " and hurt itself in the confusion.");
            return true;
        }

        boolean isStorm = this instanceof StormTrooper;
        boolean isRebel = this instanceof RebelTrooper;
        boolean targetStorm = target instanceof StormTrooper;
        boolean targetRebel = target instanceof RebelTrooper;

        if (isStorm) {
            if (targetRebel) {
                System.out.println("Rolled a " + roll + " against the rebel scum.");
                return roll > 10 && (roll % 2 == 0);
            } else if (targetStorm) {
                System.out.println("No treason in the ranks!");
                return false;
            } else {
                System.out.println("Acceptable Collateral Damage!");
                return roll > 10 || (roll % 2 == 0);
            }
        }

        if (isRebel) {
            if (targetRebel) {
                System.out.println("Imperial Spy!");
                return false;
            } else if (targetStorm) {
                System.out.println("Rolled a " + roll + " against the imperial scum.");
                return roll > 5 || (roll % 2 == 1);
            } else {
                System.out.println("Rebels target an innocent bystander");
                return roll >= 18 && (roll % 2 == 0);
            }
        }

// Fallback for any other Trooper subtype not specified
        return roll >= 10;
    }

    @Override
    public String toString() {
        return (unit == null ? "" : unit) + number + ": ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trooper trooper = (Trooper) o;
        return number == trooper.number
                && Double.compare(trooper.marchSpeed, marchSpeed) == 0
                && Double.compare(trooper.marchModifier, marchModifier) == 0
                && Objects.equals(unit, trooper.unit)
                && Objects.equals(number, trooper.number);


    }
    @Override
    public int hashCode() {
        return Objects.hash(unit, number, marchSpeed, marchModifier);
    }
}
