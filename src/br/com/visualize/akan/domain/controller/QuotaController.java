/*
 * File: 	QuotaController.java 
 * Purpose: Brings the implementation of class QuotaController.
 */
package br.com.visualize.akan.domain.controller;

import java.util.List;

import org.apache.http.client.ResponseHandler;

import android.content.Context;
import android.util.Log;
import br.com.visualize.akan.api.dao.QuotaDao;
import br.com.visualize.akan.api.helper.JsonHelper;
import br.com.visualize.akan.api.request.HttpConnection;
import br.com.visualize.akan.domain.exception.ConnectionFailedException;
import br.com.visualize.akan.domain.exception.NullCongressmanException;
import br.com.visualize.akan.domain.exception.RequestFailedException;
import br.com.visualize.akan.domain.model.Quota;



/**
 * Serves to define the methods that are responsible for generating actions, 
 * calculate results and everything that is requested by layer 'View' 
 * referring to parliamentary quotas.
 */
public class QuotaController {
	private static QuotaController instanceQuotaController = null;
	private QuotaDao daoQuota = null;
	private static List<Quota> quotaList;
	
	private UrlController urlController;
	private QuotaDao quotaDao;
	
	
	private QuotaController(Context context) {
		urlController = UrlController.getInstance(context);
		quotaDao = QuotaDao.getInstance(context);
	}
	
	/**
	 * Return the unique instance of QuotaController active in the project.
	 * <p>
	 * @return The unique instance of QuotaController.
	 */
	public static QuotaController getInstance(Context context) {
		
		if( instanceQuotaController != null ) {
			/*! Nothing To Do. */
			
		} else {
			instanceQuotaController = new QuotaController(context);
			
		}
		
		return instanceQuotaController;
	}
	
	/**
	 * Inserts in the database quotas, referring to a congressman in particular, 
	 * passed as parameter in the local database of the application.
	 * <p>
	 * @param insertedQuotas List of quotas to be inserted.
	 */
	public void insertQuotasOnCongressman( List<Quota> insertedQuotas ) {
		//daoQuota.insertQuotasOnCongressman( insertedQuotas );
	}
	
	/**
	 * Deletes all quotas of the database relating to the past as parameter 
	 * congressman for his numerical identifier.
	 * <p>
	 * @param idCongressman Numeric identifier of congressman that must have 
	 * 		 					deleted the quotas.
	 */
	public void deleteQuotasFromCongressman( int idCongressman ) {
		daoQuota.deleteQuotasFromCongressman( idCongressman );
	}
	
	/**
	 * Search the database all quotas related to the referenced congressman 
	 * and returns them as a list.
	 * <p>
	 * @param idCongressman Numeric identifier of congressman that must have 
	 * 		 					deleted the quotas.
	 * <p>
	 * @return The list of referenced quotas belonging to the congressman.
	 */
	public List<Quota> getQuotasByIdCongressman( int idCongressman ) {
		List<Quota> foundQuotas = null;
		
		foundQuotas = daoQuota.getQuotasByIdCongressman( idCongressman );
		return foundQuotas;
	}
	
	public List<Quota> getQuotaById(String id,ResponseHandler<String> responseHandler)
			throws ConnectionFailedException, RequestFailedException,
			NullCongressmanException {
		if (responseHandler != null) {
			Log.i("<quota>connection stabilished", "connection stabilished, recieving data...");
			if (quotaDao.checkEmptyLocalDb()) {
				// popula o banco
				Log.i("<quota>dataBase insetition", "Empty database, inserting quota...");
				String url = urlController.quotasWithCongressmanIdUrl(id);
				String jsonQuota = HttpConnection.request(responseHandler, url);

				setQuotaList(JsonHelper
						.listQuotaByIdCongressmanFromJSON(jsonQuota));

				quotaDao.insertQuotasById(getQuotaList());

			} else {
				// nothing here.
			}
		}
		return getQuotaList();
	}
	
	private List<Quota> getQuotaList() {
		return quotaList;
	}

	private static void setQuotaList(
			List<Quota> listQuotaByIdCongressmanFromJSON) {
		QuotaController.quotaList = listQuotaByIdCongressmanFromJSON;
	}
	
}
