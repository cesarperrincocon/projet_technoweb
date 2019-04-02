/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.sql.DataSource;

/**
 *
 * @author psandre
 */

// Interface représentant une « source de données ». Cette « source de données » est en fait une simple fabrique de connexions vers la source de données physique.

public class DataSourceFactory {

	public enum DriverType {
		embedded, server
	};
        /** Deux type de Driver : 
         *- Embedded : L’application inclut son propre SGBD
         *- Server :  Communication client-serveur entre l’application et le SGBD 
         *  Choix du type de driver
        */
       
	private static final DriverType TYPE = DriverType.server;
	/**
	 * Renvoie la source de données (server ou embbeded)
	 * @return  la source de données
	 */
	public static DataSource getDataSource() {
		DataSource result;

		switch (TYPE) {
			case server: // Derby mode serveur, doit être démarré indépendamment
				org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
				ds.setDatabaseName("sample");
				ds.setUser("app");
				ds.setPassword("app");
				// L'hote sur lequel le serveur réseau s'exécute
				ds.setServerName("localhost");
				// Port sur lequel le serveur réseau écoute
				ds.setPortNumber(1527);
				result = ds;
				break;
			default: // Derby mode embedded, démarré automatiquement avec l'application
				org.apache.derby.jdbc.EmbeddedDataSource es = new org.apache.derby.jdbc.EmbeddedDataSource();
				es.setCreateDatabase("create");
				es.setDatabaseName("embedded_sample");
				result = es;
		}

		return result;
	}

}

