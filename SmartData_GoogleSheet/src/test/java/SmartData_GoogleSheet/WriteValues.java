package SmartData_GoogleSheet;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

public class WriteValues
{

	public static void main(String[] args) throws IOException, GeneralSecurityException  
	{
	    ValueRange requestBody = new ValueRange();
	    Object a1 = new Object();
	    a1 = "TEST Row 1 Column A";
	  
	    List<List<Object>> list = new ArrayList<>();
	    List<String> a = new ArrayList<>();
	    a.add("Hi");
	    
		writeValuesIntoSpreadsheet("1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo", "SmartData!A1", list);
	}
	public static void writeValuesIntoSpreadsheet(String spreadsheetId, String range, List<List<Object>> insertValues) throws IOException, GeneralSecurityException
	{
	//Sheets sheetsService = createSheetsService();
	  List<ValueRange> data = new ArrayList<>();
	  data.add(new ValueRange().setRange(range).setValues(insertValues)); // setValueInputOption(InputOption.USER_ENTERED.name()).setData(data);
	  BatchUpdateValuesRequest body = new BatchUpdateValuesRequest().setValueInputOption("RAW").setData(data);
	  Sheets sheetsService = createSheetsService();
	    BatchUpdateValuesResponse request =

	  sheetsService.spreadsheets().values().batchUpdate(spreadsheetId, body).execute();
	}
	public static Sheets createSheetsService() throws IOException, GeneralSecurityException 
	{
		
	    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
	    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
	    GoogleCredential credential = new GoogleCredential.Builder()
	            .setTransport(httpTransport)
	            .setJsonFactory(jsonFactory)
	            .setServiceAccountId("vinlingampalli9@gmail.com").setServiceAccountScopes(
	                    Collections.singleton("https://www.googleapis.com/auth/plus.business.manage"))
	            .setServiceAccountPrivateKeyFromP12File(new File("C:\\Users\\Vinod\\Credentials\\modular-embassy-291912-2a2380371760.p12")).setServiceAccountUser("vinod-58@modular-embassy-291912.iam.gserviceaccount.com")
	            .build();
	    credential.refreshToken();
		
		return createSheetsService();
	}
	


}
