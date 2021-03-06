package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente getStudente(int m) {
		final String sql = "SELECT * FROM studente WHERE matricola = ? ";
		
		try {
			Studente s = null;
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			// al posto del punto interrogativo ci vado a mettere m
			st.setInt(1, m);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("cds");
			s = new Studente(matricola, cognome, nome, cds);
				
			}
			conn.close();
			return s;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public List<Corso> getCorsiIscritto(int m) {
		List<Corso> lcorsi = new LinkedList<Corso>();
		final String sql = "SELECT corso.* FROM iscrizione, corso WHERE matricola = ? AND iscrizione.codins = corso.codins";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, m);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				Corso s = new Corso(codins, nome, numeroCrediti, periodoDidattico);
				lcorsi.add(s);
			}
			conn.close();
			return lcorsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

	}

}
