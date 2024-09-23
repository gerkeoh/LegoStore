public class LegoSet extends Product {
    private String theme;

    public LegoSet(String name, double price, String theme) {
        super(name, price);
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String getName() {
        return theme + " - " + super.getName();
    }
}
