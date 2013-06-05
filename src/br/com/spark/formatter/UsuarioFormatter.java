package br.com.spark.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import br.com.spark.model.Usuario;

public class UsuarioFormatter implements Formatter<Usuario>{

	@Override
	public String print(Usuario usuario, Locale arg1) {
		return usuario.getNome();
	}

	@Override
	public Usuario parse(String usuarioId, Locale arg1) throws ParseException {
		Usuario usuario = new Usuario();
		usuario.setId(Integer.valueOf(usuarioId));
		
		return usuario;
	}

}
