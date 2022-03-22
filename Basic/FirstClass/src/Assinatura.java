import java.time.LocalDate;
import java.time.Period;

public class Assinatura extends Produto implements Expiravel
{
	private LocalDate dataExpiracao;
	
	public Period calculaPeriodoAteExpiracao ()
	{
		return Period.between(dataExpiracao, LocalDate.now());
	}
	
	public LocalDate getDataExpiracao ()
	{
		return dataExpiracao;
	}
	
	public void setDataExpiracao (LocalDate dataExpiracao)
	{
		this.dataExpiracao = dataExpiracao;
	}
}
