package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWs {
    
    private ItemDao dao = new ItemDao();
    
    @WebMethod(operationName="todosOsItens")
    @WebResult(name="itens")
    public ListaItens getItens(@WebParam(name="filtros") Filtros filtros) {
	System.out.println("Chamando getItens()");
	List<Filtro> lista = filtros.getLista();
	return new ListaItens(dao.todosItens(lista));
    }
    
    @WebMethod(operationName="CadastrarItem")
    public Item cadastrarItem(@WebParam(name="token", header=true) TokenUsuario token, 
                              @WebParam(name="item") Item item) throws AutorizacaoException{
	System.out.println("Cadastrando " + item);
	
	if(!new TokenDao().ehValido(token)) {
	    throw new AutorizacaoException("Autorizacao falhou");
	}
	
	new ItemValidador(item).validate();
	
	this.dao.cadastrar(item);
	return item;
    }

}
