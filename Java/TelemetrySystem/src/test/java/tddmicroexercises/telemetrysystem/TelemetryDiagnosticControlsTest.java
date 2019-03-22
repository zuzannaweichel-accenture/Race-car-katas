package tddmicroexercises.telemetrysystem;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TelemetryDiagnosticControlsTest {
    
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        String message = "OK";
        TelemetryClient telemetryClientMock = mock(TelemetryClient.class);
        when(telemetryClientMock.getOnlineStatus()).thenReturn(true);
        when(telemetryClientMock.receive()).thenReturn("OK");
        TelemetryDiagnosticControls diagnosticControls = new TelemetryDiagnosticControls(telemetryClientMock);

        assertEquals(message, diagnosticControls.checkTransmission());
	}

	@Test
    public void checkTransmission_retryConnection3Times_ifOnlineStatusFalse(){
        TelemetryClient telemetryClientMock = mock(TelemetryClient.class);
        when(telemetryClientMock.getOnlineStatus()).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(false);
        TelemetryDiagnosticControls diagnosticControls = new TelemetryDiagnosticControls(telemetryClientMock);
        String eMessage = "";
        try{
           String diagnosticsInfo =  diagnosticControls.checkTransmission();
        }catch (Exception e){
            eMessage = e.getMessage();
        }
        assertEquals("Unable to connect.", eMessage);
    }
}
