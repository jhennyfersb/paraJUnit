import java.math.BigDecimal;

public class ReajusteService {
    public void concenderReajuste(Funcionario funcionario, Desempenho desempenho) {

        BigDecimal percentual = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(reajuste);
    }
}
