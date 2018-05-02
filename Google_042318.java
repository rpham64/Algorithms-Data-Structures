
public class Google_042318 {
//	Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.
//
//	Button -> Click creates Implicit Intent
//		-> Sends to Play Store to bind to Play Store’s service.
//		-> Play Store’s service does work to find the proper app.
//		-> Play Store sends data back to Activity
//		-> Create IntentService (bounded to Activity) to download app from Play Store
//		-> If successful, pass data from IntentService to Activity and display successful Toast message.
//		-> If not successful, use AlarmManager to re-create IntentService after some duration of time.

	public class PlayStoreService extends Service implements Binder {
		// 1) Check if package name is legit
		// 2) Check if input is not broken.
		// 3) Do business logic of finding package and sending back.
		void onBind(String packageName, Object input) {
			// Checks 1 and 2
			if (isLegit(context) && isValid(packageName) && !isNotBroken(input)) {
				// Case 3 - Do GET request to get package and APK from server
				Object apk = NetworkService.getPackage(packageName);
				install(apk);  // Install apk in Play Store
				callback(apk);	
			} else {
				// Error Handling - display in UI for activity
				callback(errorMessage);
			}
		}
		
		void onUnbind() {
			// Error handling - Only called if something breaks.
			
		}
	}
}
