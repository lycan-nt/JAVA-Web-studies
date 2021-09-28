package osn.study.coesao;

public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorCento()),
    DBA(new QuinzeOuVinteCincoPorCento()),
    TESTER(new QuinzeOuVinteCincoPorCento());
    private RegraDeCalculo regra;
    Cargo(RegraDeCalculo regra) {
        this.regra = regra;
    }
    public RegraDeCalculo getRegra() {
        return regra;
    }
}
