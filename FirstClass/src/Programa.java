
public class Programa {
	public void exibirDiasAteExpirar (Expiravel expiravel)
	{
		System.out.println("Dias Restantes: "
				+ expiravel.calculaPeriodoAteExpiracao().getDays());
	}
}
