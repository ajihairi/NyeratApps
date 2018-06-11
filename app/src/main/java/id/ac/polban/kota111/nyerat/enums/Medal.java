package id.ac.polban.kota111.nyerat.enums;

public enum Medal {
    GOLD("GOLD"),SILVER("SILVER"),BRONZE("BRONZE"), BELUMADA("BELUMADA");

    private String medal;

    Medal(String medal) {
        this.medal = medal;
    }

    public String medal() {
        return medal;
    }
}
