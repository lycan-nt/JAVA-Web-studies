package digitalinnovation.example.restfull.enums;

public enum Raca {
    HUMANO("Humano"),
    ELFO("Elfo"),
    GUERREIRO("Guerreiro"),
    MAGO("Mago");

    private String value;

    Raca(String value) {
        this.value = value;
    }
}
