/**
 * An example of the Singleton pattern.
 * 
 * An implementation of the singleton pattern must:
 * 		1)	Ensure that only ONE instance of the singleton class ever exists
 * 		2)	Provide GLOBAL ACCESS to that instance
 * 
 * @author rpham
 *
 */
public class Singleton {

	/**
	 * Private and static, in order to prevent outside classes from modifying sInstance
	 */
	private static Singleton sInstance;
	
	private String mField;
	
	/**
	 * Private constructor, since you don' want to re-initialize 
	 * the object again outside this class
	 */
	private Singleton() {
		mField = "Some Singleton field";
	}
	
	/**
	 * Public, in order to be called outside class.
	 * Static, since sInstance is a STATIC field
	 * 
	 * @return
	 */
	public static Singleton getInstance() {
		if (sInstance == null) {
			sInstance = new Singleton();
		}
		return sInstance;
	}
	
	public String getField() {
		return mField;
	}
	
	public void setField(String field) {
		this.mField = field;
	}
}
