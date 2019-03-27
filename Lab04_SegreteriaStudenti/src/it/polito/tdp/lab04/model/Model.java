package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {

	CorsoDAO dao = new CorsoDAO();
	
	public List<Corso> getCorsi() {
		
		return dao.getTuttiICorsi();
	}

}
