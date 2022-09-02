import org.junit.After;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteReajusteService {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }
    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        service.concenderReajuste(funcionario,Desempenho.A_DESEJAR);
       Assertions.assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForADesejar() {

        service.concenderReajuste(funcionario,Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForADesejar() {

        service.concenderReajuste(funcionario,Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }
}

