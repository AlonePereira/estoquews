package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.caelum.estoque.adapters.DateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

    private String mensagem;
    
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;

    public InfoFault(String mensagem, Date date) {
	this.mensagem = mensagem;
	this.date = date;
    }
    
    public InfoFault(){}

}
