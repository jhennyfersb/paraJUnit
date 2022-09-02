import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class TestaBonusService {



    @Test
        void bonus(){
            BonusService service = new BonusService();
            BigDecimal bonus =service.calcularBonus (new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("1000")));
            Assertions.assertEquals(new BigDecimal("100.00"), bonus);
        }
    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus (new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        Assertions.assertEquals(new BigDecimal("1000.00"),bonus);

    }
    @Test
    void bonusDevceriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        /*assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));*/
        try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
            fail ("Não deu a exception!");
        } catch (Exception e) {
            assertEquals("Funcionario com salario maior do que R$10000 nao pode receber bonus!", e.getMessage());
        }

    }


}
