import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assinatura assinatura = new Assinatura ();
		assinatura.setDescricao ("Assinatura MVP");
		assinatura.setCodigo (123);
		assinatura.setPreco (69);
		assinatura.setDataExpiracao (LocalDate.parse("2022-01-13"));
		
		Programa programa = new Programa ();
		programa.exibirDiasAteExpirar(assinatura);
	}

}
