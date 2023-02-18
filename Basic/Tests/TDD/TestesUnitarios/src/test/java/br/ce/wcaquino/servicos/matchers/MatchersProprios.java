package br.ce.wcaquino.servicos.matchers;

public class MatchersProprios {
	
	public static DiaSemanaMatcher caiEm(Integer diaSemana) {
		return new DiaSemanaMatcher(diaSemana);
	}
	
	public static DataDiferencaDiasMatcher ehHojeComDiferencaDias(Integer qtdDias) {
		return new DataDiferencaDiasMatcher(qtdDias);
	}
	
	public static DataDiferencaDiasMatcher ehHoje() {
		return new DataDiferencaDiasMatcher(0);
	}


}
