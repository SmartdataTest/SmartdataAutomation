package SmartData_GoogleSheet;


	import com.google.api.client.auth.oauth2.Credential;
	import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
	import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
	import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
	import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
	import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
	import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
	import com.google.api.*;
	import java.awt.color.*;
    import com.google.api.client.http.HttpTransport;
    import com.google.api.client.http.javanet.NetHttpTransport;
	import com.google.api.client.json.JsonFactory;
	import com.google.api.client.json.jackson2.JacksonFactory;
	import com.google.api.client.util.store.FileDataStoreFactory;
	import com.google.api.services.sheets.v4.Sheets;
	import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
	import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.CellFormat;
import com.google.api.services.sheets.v4.model.ClearValuesRequest;
import com.google.api.services.sheets.v4.model.ClearValuesResponse;
import com.google.api.services.sheets.v4.model.Color;
import com.google.api.services.sheets.v4.model.GridRange;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.ValueRange;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
    import java.util.Hashtable;
    import java.util.List;
public class TestGoogleSheet
{
	private static final String APPLICATION_NAME = "Smart Ticket"; // Smart Data
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "C:\\Credentials\\tokens"; // SPREADSHEETS_READONLY

	private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS); 
	
	/*https://www.googleapis
	 * private static String ProjectPath = System.getProperty("user.dir"); private
	 * static final String CREDENTIALS_FILE_PATH =
	 * ProjectPath+"/client_secret.json";
	 */
	 
	private static final String CREDENTIALS_FILE_PATH = "/client_secret.json ";
	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException 
	{
		File initialFile = new File("C:\\Credentials\\client_secret.json");
	    InputStream in = new FileInputStream(initialFile);
		if (in == null) {
			throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
		}
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES)
						.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}
	
	/*public static  Sheets getSheetsService() throws IOException{
		Credential credential = authorize();
		return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
	}*/
	public static List<List<Object>> GetContactUs() throws GeneralSecurityException,IOException{
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		final String spreadsheetId = "1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo";
		final String range= "ContactUs!A2:D";
		
		Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT)).setApplicationName(APPLICATION_NAME).build();
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
			return values;
	}
	public static List<List<Object>> LunchLearn() throws GeneralSecurityException,IOException{
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		final String spreadsheetId = "1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo";
		final String range= "Lunch&Learn!A2:C";
		
		Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT)).setApplicationName(APPLICATION_NAME).build();
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
			return values;
	}
	
	public static List<List<Object>> AboutUs() throws GeneralSecurityException,IOException{
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		final String spreadsheetId = "1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo";
		final String range= "AboutUs!A2:D";
		
		Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT)).setApplicationName(APPLICATION_NAME).build();
		ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
		List<List<Object>> values = response.getValues();
			return values;
	}
	public static void writeValuesIntoSpreadsheet(String spreadsheetId, String range, List<List<Object>> insertValues) throws IOException, GeneralSecurityException
	{
	//Sheets sheetsService = createSheetsService();
	  List<ValueRange> data = new ArrayList<>();
	  data.add(new ValueRange().setRange(range).setValues(insertValues)); // setValueInputOption(InputOption.USER_ENTERED.name()).setData(data);
	  BatchUpdateValuesRequest body = new BatchUpdateValuesRequest().setValueInputOption("RAW").setData(data);
	  Sheets sheetsService = createSheetsService();
	    BatchUpdateValuesResponse request = sheetsService.spreadsheets().values().batchUpdate(spreadsheetId, body).execute();
	}
	
	public static Sheets createSheetsService() throws IOException, GeneralSecurityException 
	{
	    final HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
	    final JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    Credential credential= getCredentials(HTTP_TRANSPORT);
	    /*GoogleCredential credential = new GoogleCredential.Builder()
	            .setTransport(httpTransport)
	            .setJsonFactory(jsonFactory)
	            .setServiceAccountId("vinlingampalli9@gmail.com").setServiceAccountScopes(
	                    Collections.singleton("https://www.googleapis.com/auth/plus.business.manage"))
	            .setServiceAccountPrivateKeyFromP12File(new File("C:\\Users\\Vinod\\Credentials\\modular-embassy-291912-2a2380371760.p12")).setServiceAccountUser("vinod-58@modular-embassy-291912.iam.gserviceaccount.com")
	            .build();*/
	    //credential.refreshToken();
		return new Sheets.Builder(httpTransport, jsonFactory, credential).setApplicationName(APPLICATION_NAME).build();
	}
	  public static void ClearDataInSheet(String SheetID, String rangeValue) throws IOException, GeneralSecurityException 
	  {
		    
		    String spreadsheetId = SheetID;
		    String range = rangeValue; 
		    ClearValuesRequest requestBody = new ClearValuesRequest();
		    Sheets sheetsService = createSheetsService();
		    Sheets.Spreadsheets.Values.Clear request =
		        sheetsService.spreadsheets().values().clear(spreadsheetId, range, requestBody);

		    ClearValuesResponse response = request.execute();

		    // TODO: Change code below to process the `response` object:
		    //System.out.println(response);
		 }
	 
	public static String RepeateCellRequest() throws IOException, GeneralSecurityException 
	{
		List<Request> requestList = new ArrayList<>();

		CellFormat cellFormat = new CellFormat(); //setting cell color
		Color color = new Color();
		//color.setRed(246f);
		color.setGreen(178f);
		//color.setBlue(107f);
		
		cellFormat.setBackgroundColor(color);
		
		CellData cellData = new CellData();
		cellData.setUserEnteredFormat(cellFormat);
		
		GridRange gridRange = new GridRange(); //setting grid that we will paint
		gridRange.setSheetId(1846953344); //you can find it in your URL - param "gid"
		gridRange.setStartRowIndex(5);
		gridRange.setEndRowIndex(5);
		gridRange.setStartColumnIndex(1);
		gridRange.setEndColumnIndex(2);

		BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest = new BatchUpdateSpreadsheetRequest();
		batchUpdateSpreadsheetRequest.setRequests(requestList);
		
		//final Sheets.Spreadsheets.BatchUpdate batchUpdate = sheetsService.
		   //     spreadsheets().batchUpdate("yourSpreadSheetId - find it in URL", batchUpdateSpreadsheetRequest);

		//batchUpdate.execute();
		
		final Sheets.Spreadsheets.BatchUpdate batchUpdate = createSheetsService().spreadsheets().batchUpdate("1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo", batchUpdateSpreadsheetRequest);
		try 
		{
			batchUpdate.execute();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getMessage());
		}
		batchUpdate.execute();
		return null;
		
	}
	/*public Spreadsheet createSpreadsheet(String title, Sheet... sheets) throws IOException
	{
		
	 Sheets sheetsService;
	return sheetsService.spreadsheets().create(new Spreadsheet().setSheets(Arrays.asList(sheets))
	     .setProperties(new SpreadsheetProperties().setTitle(title))).execute();
	}*/

	
	/*private static final String APPLICATION_NAME1 = "SmartTicketUpgrade"; // Smart Data
	private static final JsonFactory JSON_FACTORY1 = JacksonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH1 = "C:\\Credentials\\tokens";

	private static final List<String> SCOPES1 = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY); 
	
	/*https://www.googleapis
	 * private static String ProjectPath = System.getProperty("user.dir"); private
	 * static final String CREDENTIALS_FILE_PATH =
	 * ProjectPath+"/client_secret.json";
	 */
	 
	//private static final String CREDENTIALS_FILE_PATH1 = "/client_secret.json ";
	
	/*private static Credential getCredentials1(final NetHttpTransport HTTP_TRANSPORT) throws IOException, GeneralSecurityException 
	{
		//final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		File initialFile = new File("C:\\Credentials\\client_secret.json");
	    InputStream in = new FileInputStream(initialFile);
		if (in == null) {
			throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH1);
		}
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY1, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY1,
				clientSecrets, SCOPES1)
						.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH1)))
						.setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8080).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}*/
}
	