public class heroi {
    private final String nome;
    private final String power;

    public heroi(String nome, String power) {
        this.nome = nome;
        this.power = power;
    }

    public String getNome() {
        return nome;
    }

    public String getPoder() {
        return power;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        heroi heroi = (heroi) obj;
        return nome.equalsIgnoreCase(heroi.nome);
    }

    @Override
    public int hashCode() {
        return nome.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Herói: " + nome + ", Poder: " + power;
    }
}
