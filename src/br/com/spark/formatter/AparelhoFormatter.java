package br.com.spark.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import br.com.spark.model.Aparelho;

public class AparelhoFormatter implements Formatter<Aparelho>{
	
	@Override
	public String print(Aparelho aparelho, Locale arg1) {
		return aparelho.getNome();
	}

	@Override
	public Aparelho parse(String aparelhoId, Locale arg1) throws ParseException {
		Aparelho aparelho = new Aparelho();
		aparelho.setId(Integer.valueOf(aparelhoId));
		return aparelho;
	}

}
