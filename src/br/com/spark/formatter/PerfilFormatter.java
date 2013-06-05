package br.com.spark.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import br.com.spark.model.Perfil;

public class PerfilFormatter implements Formatter<Perfil>{
	
	@Override
	public String print(Perfil perfil, Locale arg1) {
		return perfil.getDescricao();
	}

	@Override
	public Perfil parse(String perfilId, Locale arg1) throws ParseException {
		Perfil perfil = new Perfil();
		perfil.setId(Integer.valueOf(perfilId));
		
		return perfil;
	}

}
