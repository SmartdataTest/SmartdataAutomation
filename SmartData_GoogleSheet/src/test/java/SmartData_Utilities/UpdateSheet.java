package SmartData_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

public class UpdateSheet {
	private static final String APPLICATION_NAME = "SmartTicketUpgrade";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "C:\\Credentials\\tokens";
	private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS, SheetsScopes.DRIVE);
	private static final String CREDENTIALS_FILE_PATH = "/client_secret.json ";
	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
		File initialFile = new File("C:\\Credentials\\client_secret.json");
	    InputStream in = new FileInputStream(initialFile);
		if (in == null) {
			throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
		}
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES)
						.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}
	public static void main(String[] args) throws GeneralSecurityException,IOException{
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		final String spreadsheetId = "1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo";
		final String range= "SmartData!A7:E13";
		Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT)).setApplicationName(APPLICATION_NAME).build();
		 List<List<Object>> arrData = getData();

	        ValueRange oRange = new ValueRange();
	        oRange.setRange(range); 
	        oRange.setValues(arrData);

	        List<ValueRange> oList = new ArrayList<>();
	        oList.add(oRange);

	        BatchUpdateValuesRequest oRequest = new BatchUpdateValuesRequest();
	        oRequest.setValueInputOption("RAW");
	        oRequest.setData(oList);

	        BatchUpdateValuesResponse oResp1 = service.spreadsheets().values().batchUpdate(spreadsheetId, oRequest).execute();
	   }

	public static List<List<Object>> getData() {

		List<Object> data1 = new ArrayList<Object>();
		data1.add("jagadeesh");
		data1.add("jagadeesh");
		data1.add("jagadeesh");

		List<Object> data2 = new ArrayList<Object>();
		data2.add("jagadeesh");
		data2.add("jagadeesh");
		data2.add("jagadeesh");

		List<List<Object>> data = new ArrayList<List<Object>>();
		data.add(data1);
		data.add(data2);

		return data;
	}
}
	
	
