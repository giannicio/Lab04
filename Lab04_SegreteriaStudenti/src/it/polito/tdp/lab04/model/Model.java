package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	CorsoDAO corsoDao = new CorsoDAO();
	public List<Corso> getCorsi() {
		
		return corsoDao.getTuttiICorsi();
	}
	
	StudenteDAO studenteDao = new StudenteDAO();
	public Studente getTuttoStudente(int matricola) {
		
		return studenteDao.getStudente(matricola);
	}
	
	CorsoDAO studentiIscrittiDao = new CorsoDAO();
	public List<Studente> getIscritti(Corso corso) {
		
		return studentiIscrittiDao.getStudentiIscrittiAlCorso(corso);
	}
	
	

}
