package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;

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

}
