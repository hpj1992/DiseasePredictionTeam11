package com.cmpe239.team11;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmpe239.team11.Manager.UserProfileManager;
import com.cmpe239.team11.Model.PatientData;
import com.cmpe239.team11.Model.UserProfile;
import com.cmpe239.team11.Utility.ApplicationConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	public HttpSession loggedInEmail;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public void signUp(HttpServletRequest req,Model model, String email, String password,
			String firstName, String lastName, String birthDate) {
		UserProfile user = new UserProfile();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastname(lastName);
		user.setPassword(password);
		user.setBirthDate(birthDate);
		if (UserProfileManager.isExistingUser(email)) {
			// Existing user case.
		} else {
			UserProfileManager.AddNewUser(user);
			HttpSession session = req.getSession();
			session.setAttribute(ApplicationConstants.USER_ID_SESSION, user.getEmail());
		}
	}
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public void signIn(HttpServletRequest req,Model model,String email,String password){
		UserProfile user=UserProfileManager.GetAuthenticatedUser(email, password);
		if(user!=null){
			//Success
			loggedInEmail.setAttribute("email", user.getEmail());
			HttpSession session = req.getSession();
			session.setAttribute(ApplicationConstants.USER_ID_SESSION, user.getEmail());
		}
		else{
			if(UserProfileManager.isExistingUser(email))
			{
				//wrong password
			}
			else{
				//New user
			}
		}
	}
	
	@RequestMapping(value="/processPatientData")
	public String processPatientData(HttpServletRequest req){
		
		if(!checkUserLoggedIn(req.getSession())){
			return "home";
		}
		else{
			
		}
		return "";
	}

	// =========================================================
	public void processPatientData(PatientData patient) {

		if (Integer.valueOf(patient.getAge()) <= 39) {

			if (Integer.valueOf(patient.getAgeMenarche()) == 2) {
				// 12-13
				// YES
			} else {
				if (Integer.valueOf(patient.getBMI()) == 2) {
					// YES
				} else {
					// NO
				}
			}
		} else {
			if(Integer.valueOf(patient.getMenopause())==2){
				//YES
			}
			else{
				if(Integer.valueOf(patient.getRace())==1){
					//YES
				}else{
					//NO
				}
			}

		}

	}
	
	//Session Management =============================================
	public boolean checkUserLoggedIn(HttpSession session){
		String userId = getLoggedInUser(session);
		if(userId.isEmpty())
			return false;
		else
			return true;
	}
	
	public String getLoggedInUser(HttpSession session){
		if(session != null){
			Object userId = session.getAttribute(ApplicationConstants.USER_ID_SESSION);
			if(userId == null)
				return "";
			else
				return String.valueOf(userId);
		}else
			return "";
	}
}
