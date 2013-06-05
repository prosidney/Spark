package br.com.spark.authenticator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import br.com.spark.dao.impl.UsuarioDao;
import br.com.spark.model.Usuario;
import br.com.spark.util.Util;

public class MyAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	public boolean supports ( Class<? extends Object> authentication ) {
		return true;
	}

	@Transactional(readOnly = true)
	public Authentication authenticate ( Authentication authentication ) throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth = null ;
		try{
			String passMD5 = new Util().createMD5(authentication.getCredentials().toString());
			Usuario usuario = usuarioDao.findByUsuario(authentication.getName(), passMD5);
			
			if(usuario == null){
				throw new UsernameNotFoundException("Usuário não encontrado");
			}
			if(!usuario.getSenha().equals(passMD5)){
				throw new BadCredentialsException("Senha invalida");
			}
			
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new GrantedAuthorityImpl("ROLE_ACCESS"));
			
			auth = new UsernamePasswordAuthenticationToken(
					authentication, 
					authentication.getCredentials(), 
					authorities);
			
			auth.setDetails(usuario);
		}catch (NoSuchAlgorithmException e) {
			throw new AuthenticationServiceException(e.getMessage(), e);
		}
			
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		return auth;
	}
	
	public static void main(String[] args) {
		String senha = "sidney";
		
		MessageDigest md = null;
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));	
        String s2 = hash.toString(16);
        
        System.out.println(s2);         
	}
}