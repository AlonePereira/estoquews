package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWs {

    public static void main(String[] args) {
	EstoqueWs service = new EstoqueWs();
	String url = "http://localhost:8080/estoquews";
	
	System.out.println("EstoqueWS rodando: " + url + "?wsdl");
	
	Endpoint.publish(url, service);
	
    }
    
}
