package SmartData_GoogleSheet;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.apache.commons.collections4.map.StaticBucketMap;

public class SheetsExample 
{
  private static final Object Object = null;
private static final String GoogleCredential = null;

public static void main(String args[]) throws IOException, GeneralSecurityException 
{
   
    String spreadsheetId = "1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo"; 
    String range = "A1"; 
    String valueInputOption = "RAW"; 

    ValueRange requestBody = new ValueRange();
    Object a1 = new Object();
    a1 = "TEST Row 1 Column A";
    Object b1 = new Object();
    b1 = "TEST Row 1 Column B";

    Object a2 = new Object();
    a2 = "TEST Row 2 Column A";
    Object b2 = new Object();
    b2 = "TEST Row 2 Column B";

    ValueRange valueRange = new ValueRange();
    valueRange.setValues(
            Arrays.asList(
                    Arrays.asList(a1, b1),
                    Arrays.asList(a2, b2)));

    Sheets sheetsService = createSheetsService();
    Sheets.Spreadsheets.Values.Update request =
        sheetsService.spreadsheets().values().update(spreadsheetId, range, requestBody);
    request.setValueInputOption(valueInputOption);
    
    UpdateValuesResponse response = request.execute();
   
    // TODO: Change code below to process the `response` object:
    System.out.println(response);
  }

  public static Sheets createSheetsService() throws IOException, GeneralSecurityException 
  {
    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

    // TODO: Change placeholder below to generate authentication credentials. See
    // https://developers.google.com/sheets/quickstart/java#step_3_set_up_the_sample
    //
    // Authorize using one of the following scopes:
    //   "https://www.googleapis.com/auth/drive"
    //   "https://www.googleapis.com/auth/drive.file"
    //   "https://www.googleapis.com/auth/spreadsheets"  setServiceAccountUser
    GoogleCredential credential = new GoogleCredential.Builder()
            .setTransport(httpTransport)
            .setJsonFactory(jsonFactory)
            .setServiceAccountId("").setServiceAccountScopes(
                    Collections.singleton("https://www.googleapis.com/auth/plus.business.manage"))
            .setServiceAccountPrivateKeyFromP12File(new File("key.p12")).setServiceAccountUser("")
            .build();
    credential.refreshToken();
   // return credential;
	return null;



    //final String TOKENS_DIRECTORY_PATH = "C:\\Users\\Vinod\\Credentials\\tokens";
    //GoogleCredential credential = new GoogleCredential().setAccessToken(TOKENS_DIRECTORY_PATH);
   
    /*GoogleCredential credential =
    	      new GoogleCredential(Arrays.asList(UrlshortenerScopes.URLSHORTENER));
    	  return new Urlshortener.Builder(new UrlFetchTransport(), JacksonFactory.getDefaultInstance(), credential)
    	      .build();*/


    /*return new Sheets.Builder(httpTransport, jsonFactory, credential)
        .setApplicationName("Google-SheetsSample/0.1")
        .build();*/
  }
}
