package br.com.spark.formatter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

import br.com.spark.dao.impl.PerfilDao;
import br.com.spark.model.Aparelho;
import br.com.spark.model.Perfil;
import br.com.spark.model.Usuario;

@Component
public class FormattingConverters extends FormattingConversionServiceFactoryBean {
	
	@Autowired
	PerfilDao perfilDao;
 
    @Override
    public void installFormatters(FormatterRegistry registry) {
        super.installFormatters(registry);
        registry.addFormatterForFieldType(Usuario.class, new UsuarioFormatter());
        registry.addFormatterForFieldType(Perfil.class, new PerfilFormatter());
        registry.addFormatterForFieldType(Aparelho.class, new AparelhoFormatter());
        registry.addFormatterForFieldType(Date.class, new DateFormatter("dd/MM/yyyy HH:mm:ss"));
        
    }
}