package at.fhtw.mtcg.model;

public class Card {

    private String name;

    private String elementType;

    private int damage;

    private boolean isSpell;

    public Card(String name, String elementType, int damage, boolean isSpell) {
        setName(name);
        setElementType(elementType);
        setDamage(damage);
        setSpell(isSpell);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpell(boolean spell) {
        isSpell = spell;
    }

    public String getName() {
        return name;
    }

    public String getElementType() {
        return elementType;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isSpell() {
        return isSpell;
    }
}
