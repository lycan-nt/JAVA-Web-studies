package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Usuario;

public interface IEmailService {
	
	void notificicarAtraso(Usuario usuario);
	
}
