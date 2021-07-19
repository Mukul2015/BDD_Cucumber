package signinpage;

public class SignInPageWebElements {
	
	 public static final String signIn = "//*[contains(text(),'Hello, Sign in')]";
	    public static final String sendMail = "//*[@name='email']";
	    public static final String continueElement = "//*[@id='continue']";
	    public static final String passWord = "//*[@id='ap_password']";
	    public static final String submit = "//*[@id='signInSubmit']";

	    public static final String wrongSignIn ="//h4[normalize-space()='There was a problem']";

}
