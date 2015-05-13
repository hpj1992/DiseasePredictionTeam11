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
import org.springframework.web.servlet.ModelAndView;

import com.cmpe239.team11.DAO.DNAAverageDistanceDAO;
import com.cmpe239.team11.Manager.DNAAverageDistanceManager;
import com.cmpe239.team11.Manager.DNAManager;
import com.cmpe239.team11.Manager.PatientDataManager;
import com.cmpe239.team11.Manager.UserProfileManager;
import com.cmpe239.team11.Model.DNA;
import com.cmpe239.team11.Model.PatientData;
import com.cmpe239.team11.Model.UserProfile;
import com.cmpe239.team11.Utility.ApplicationConstants;
import com.cmpe239.team11.Utility.LifestyleModel;
import com.cmpe239.team11.Utility.MongoConfig;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	private static String mammography="";
	private static String bmi="";
	private static String username="";
	private static String isAlchohol="";
	private static String isHormone="";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req,Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		DNAAverageDistanceDAO.generateAverageDistance(ApplicationConstants.NORMAL_GENE);
		//getPredictionFromGene(req,model,"CCCCGCCCCCGCGACAGTCACCCGTTCCCCCGCCCCCGCGACAGTCGCCCGTTCCCCCGGCCCCGCGACA");
		//GeneModel.uploadFileDataToServer();
		
		return "home";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	   public String FirstPage(Model model)
	   {
	      model.addAttribute("username", username);	
	      setRecommendations(model);
	      return "dashboard";
	   }
	
	@RequestMapping(value = "/Charts", method = RequestMethod.GET)
	   public String ChartPage(Model model)
	   {
	      model.addAttribute("username", username);	      
	      return "Charts";
	   }
	
	@RequestMapping(value = "/Tables", method = RequestMethod.GET)
	   public String TablePage(Model model)
	   {
	      model.addAttribute("username", username);	      
	      return "Tables";
	   }
	
	@RequestMapping(value = "/percent", method = RequestMethod.GET)
	   public String percentPage(Model model)
	   {
	      model.addAttribute("username", username);	      
	      return "percent";
	   }
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	   public ModelAndView LoginPage()
	   {
	      ModelAndView mav = new ModelAndView("Login");
	      return mav;
	   }
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	   public ModelAndView RegisterPage()
	   {
	      ModelAndView mav = new ModelAndView("register");
	      return mav;
	   }
	
	@RequestMapping(value = "/lifestyle", method = RequestMethod.GET)
	   public String LifestylePage(Model model)
	   {
	      model.addAttribute("username", username);	      
	      return "lifestyle";
	   }
	
	@RequestMapping(value = "/geneGraph", method = RequestMethod.GET)
	   public String genePage(Model model)
	   {
	      model.addAttribute("username", username);	      
	      return "geneGraph";
	   }
	
	@RequestMapping(value = "/Extras", method = RequestMethod.GET)
	   public String ProfilePage(Model model)
	   {
	      model.addAttribute("username", username);	      
	      return "Extras";
	   }
	
	@RequestMapping(value = "/weka", method = RequestMethod.GET)
	   public String WekaPage(Model model)
	   {
	     // model.addAttribute("username", username);	      
	      return "weka";
	   }
	
	@RequestMapping(value = "/notLoggedIn", method = RequestMethod.GET)
	   public ModelAndView notLoggedInPage()
	   {
	      ModelAndView mav = new ModelAndView("notLoggedIn");
	      return mav;
	   }
	
	@RequestMapping(value = "/existingUser", method = RequestMethod.GET)
	   public ModelAndView existingUserPage()
	   {
	      ModelAndView mav = new ModelAndView("existingUser");
	      return mav;
	   }
	
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(HttpServletRequest req, Model model, String email,
	    String password, String confirmPassword, String firstName, String lastName, String birthDate, String gender) {
		UserProfile user = new UserProfile();
		System.out.println(password);
		user.setEmail(email);
		user.setGender(gender);
		user.setFirstName(firstName);
		user.setLastname(lastName);
		user.setPassword(password);
		user.setBirthDate(birthDate);
		if (UserProfileManager.isExistingUser(email)) {
			// Existing user case.
			System.out.println("Existing user");
			return "existingUser";
		} else {
			UserProfileManager.AddNewUser(user);
			HttpSession session = req.getSession();
			session.setAttribute(ApplicationConstants.USER_ID_SESSION,
					user.getEmail());
			username = user.getFirstName();
			//setRecommendations(model);
			resetRecommendations(model);
			return "dashboard";
		}
	}

	@RequestMapping(value = "/saveUpdatedProfile", method = RequestMethod.POST)
	public String updateProfile(HttpServletRequest req, Model model,
			String firstName, String lastName,	String birthDate) {

		if (!checkUserLoggedIn(req.getSession())) {
			return "notLoggedIn";
		} else {
			UserProfile user = new UserProfile();
			user.setEmail(getLoggedInUser(req.getSession()));
			user.setFirstName(firstName);
			user.setLastname(lastName);
			user.setBirthDate(birthDate);
			UserProfileManager.updateuserProfile(user);
			model.addAttribute("username", username);	  
			return "dashboard";
		}
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String signIn(HttpServletRequest req, Model model, String email,
			String password) {
		UserProfile user = UserProfileManager.GetAuthenticatedUser(email,
				password);
		if (user != null) {
			// Success
			HttpSession session = req.getSession();
			session.setAttribute(ApplicationConstants.USER_ID_SESSION,
					user.getEmail());
			username = user.getFirstName();
			setRecommendations(model);
			return "dashboard";
		} else {
			if (UserProfileManager.isExistingUser(email)) {
				// wrong password
				return "Login";
			} else {
				// New user
				return "notLoggedIn";
			}
		}
	}

	@RequestMapping(value = "/getPredictionFromLifeStyle", method = RequestMethod.POST)
	public String processPatientData(HttpServletRequest req, Model model,String age,String menopause,String ageMenarche,String height,String weight,String race,String alcohol,String hormone) {
		if (!checkUserLoggedIn(req.getSession())) {
			return "notLoggedIn";
		} else {
			
				
				PatientData patient=new PatientData();
				patient.setEmail(getLoggedInUser(req.getSession()));
				patient.setAge(age);
				patient.setAgeMenarche(ageMenarche);
				patient.setBMI(Double.toString(LifestyleModel.getBMI(Double.valueOf(weight), Double.valueOf(height))));
				patient.setMenopause(menopause);
				patient.setRace(race);
				String value1=req.getParameter("alcohol");
				String value2=req.getParameter("hormone");
				if(value1==null){
					patient.setAlchoholConsumption(false);
				}else{
					patient.setAlchoholConsumption(true);
				}
				if(value2==null){
					patient.setHormone(false);
				}
				else{
					patient.setHormone(true);
				}
				PatientDataManager.addPatientData(patient);
				System.out.println(patient.isAlchoholConsumption());
				System.out.println(patient.isHormone());
				boolean isCancerPossilbe=PatientDataManager.processPatientData(patient);
				System.out.println(isCancerPossilbe);
				double percent=PatientDataManager.getPercent();
				if(isCancerPossilbe){
					model.addAttribute("yesPercent", percent);
					model.addAttribute("noPercent", (100 - percent));
					PatientData curPatient=PatientDataManager.getPatientData(getLoggedInUser(req.getSession()));
					if(curPatient.isAlchoholConsumption()){
						isAlchohol="100";
					}
					else{
						isAlchohol="0";
					}
					if(curPatient.isHormone()){
						isHormone="100";
					}
					else{
						isHormone="0";
					}
				}
				else{
					model.addAttribute("yesPercent", (percent));
					model.addAttribute("noPercent", (100-percent));
				}
				
				System.out.println(percent);
				bmi = Double.toString(LifestyleModel.idealBMI(Double.valueOf(weight), Double.valueOf(height)));
				setRecommendations(model);
				/*model.addAttribute("yesPercent", percent);
				model.addAttribute("noPercent", (100 - percent));*/
				return "percent";
		}
	}

	@RequestMapping(value = "/getPredictionFromGene")
	public String getPredictionFromGene(HttpServletRequest req, Model model,
			String sequence) {
		if (!checkUserLoggedIn(req.getSession())) {
			return "notLoggedIn";
		} else {
			DNA dna = new DNA();
			dna.dnaSequence = sequence;
			dna = DNAManager.generateCount(dna);
			boolean isCancerPossible = DNAAverageDistanceManager
					.getDNAClusterAndUpdateDatabase(dna);
			double percent = DNAAverageDistanceManager.getPercent() * 100;
			mammography = Double.toString(percent);
			System.out.println(isCancerPossible);
			if (isCancerPossible) {
				dna.geneType = ApplicationConstants.AFFECTED_GENE;
				model.addAttribute("yesPercent", percent);
				model.addAttribute("noPercent", (100 - percent));
			} else {
				dna.geneType = ApplicationConstants.NORMAL_GENE;
				model.addAttribute("yesPercent", (100 - percent));
				model.addAttribute("noPercent", (percent));
			}
			System.out.println(dna.geneType+ " "+isCancerPossible);
			System.out.println("Mammography:" + mammography);
			
			DNAManager.addNewData(dna);
			setRecommendations(model);
			return "percent";
		}
	}

	// Session Management =============================================
	public boolean checkUserLoggedIn(HttpSession session) {
		String userId = getLoggedInUser(session);
		if (userId.isEmpty())
			return false;
		else
			return true;
	}

	public String getLoggedInUser(HttpSession session) {
		if (session != null) {
			Object userId = session
					.getAttribute(ApplicationConstants.USER_ID_SESSION);
			if (userId == null)
				return "";
			else
				return String.valueOf(userId);
		} else
			return "";
	}
	
	public void setRecommendations(Model model){
		model.addAttribute("Mammography", mammography);
		model.addAttribute("BMI", bmi);
		model.addAttribute("username", username);
		model.addAttribute("Alcohol", isAlchohol);
		model.addAttribute("Hormone", isHormone);
	}
	public void resetRecommendations(Model model){
		model.addAttribute("Mammography", "");
		model.addAttribute("username", username);
		model.addAttribute("BMI", "");
		model.addAttribute("Alcohol", "");
		model.addAttribute("Hormone", "");
	}
}
