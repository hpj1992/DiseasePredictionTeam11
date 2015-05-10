package com.cmpe239.team11;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.model.AbstractPersistentProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.cmpe239.team11.DAO.DNAAverageDistanceDAO;
import com.cmpe239.team11.DAO.DNADAO;
import com.cmpe239.team11.Manager.DNAAverageDistanceManager;
import com.cmpe239.team11.Manager.DNAManager;
import com.cmpe239.team11.Manager.PatientDataManager;
import com.cmpe239.team11.Manager.UserProfileManager;
import com.cmpe239.team11.Model.DNA;
import com.cmpe239.team11.Model.PatientData;
import com.cmpe239.team11.Model.UserProfile;
import com.cmpe239.team11.Utility.ApplicationConstants;
import com.cmpe239.team11.Utility.GeneModel;
import com.cmpe239.team11.Utility.LifestyleModel;
import com.cmpe239.team11.Utility.MongoConfig;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

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
		//DNAAverageDistanceDAO.generateAverageDistance(ApplicationConstants.NORMAL_GENE);
		//getPredictionFromGene(req,model,"CCCCGCCCCCGCGACAGTCACCCGTTCCCCCGCCCCCGCGACAGTCGCCCGTTCCCCCGGCCCCGCGACA");
		//GeneModel.uploadFileDataToServer();
		/*
		 * DNA dna=new DNA(); dna.dnaSequence="AGCTAGCTAGCT"; dna.A=10;
		 * dna.G=40; dna.C=50; dna.T=60;
		 * dna.geneType=ApplicationConstants.NORMAL_GENE;
		 * MongoConfig.getMongoOperationsObj().save(dna);
		 */

		/*
		 * try { ConfigurationBuilder cb = new ConfigurationBuilder();
		 * cb.setDebugEnabled(true)
		 * .setOAuthConsumerKey("Gb1lLnlcZld1NYPF61AmHvdW4")
		 * .setOAuthConsumerSecret
		 * ("7SXIQPS6xW3ihjZjNnI1axhAFYHnXF253A3AOjdho5u2ybbOAl")
		 * .setOAuthAccessToken
		 * ("2751880163-Yz9B1BBfvE4olNFZYyEpSYb8gFhdhJOJeX4ugZR")
		 * .setOAuthAccessTokenSecret
		 * ("F1qKJ1plEmCD16qvOLXvx0orGoN2QClG72HDxfCFWWZO9"); TwitterFactory tf
		 * = new TwitterFactory(cb.build()); Twitter twitter = tf.getInstance();
		 * Query query = new Query("#breastcancer"); QueryResult result; result
		 * = twitter.search(query); for (Status status : result.getTweets()) {
		 * System.out.println("@" + status.getUser().getScreenName() + ":" +
		 * status.getText()); } } catch (TwitterException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		return "home";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public void signUp(HttpServletRequest req, Model model, String email,
			String password, String firstName, String lastName, String birthDate) {
		UserProfile user = new UserProfile();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastname(lastName);
		user.setPassword(password);
		user.setBirthDate(birthDate);
		if (UserProfileManager.isExistingUser(email)) {
			// Existing user case.
			System.out.println("Existing user");
		} else {
			UserProfileManager.AddNewUser(user);
			HttpSession session = req.getSession();
			session.setAttribute(ApplicationConstants.USER_ID_SESSION,
					user.getEmail());
			// redirect to dashboard logic comes here
		}
	}

	@RequestMapping(value = "/saveUpdatedProfile", method = RequestMethod.POST)
	public String updateProfile(HttpServletRequest req, Model model,
			String firstName, String lastName,	String birthDate) {

		if (!checkUserLoggedIn(req.getSession())) {
			return "home";
		} else {
			UserProfile user = new UserProfile();
			user.setEmail(getLoggedInUser(req.getSession()));
			user.setFirstName(firstName);
			user.setLastname(lastName);
			user.setBirthDate(birthDate);
			UserProfileManager.updateuserProfile(user);
		}
		return "";

	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public void signIn(HttpServletRequest req, Model model, String email,
			String password) {
		UserProfile user = UserProfileManager.GetAuthenticatedUser(email,
				password);
		if (user != null) {
			// Success
			HttpSession session = req.getSession();
			session.setAttribute(ApplicationConstants.USER_ID_SESSION,
					user.getEmail());
		} else {
			if (UserProfileManager.isExistingUser(email)) {
				// wrong password
			} else {
				// New user
			}
		}
	}

	@RequestMapping(value = "/getPredictionFromLifeStyle")
	public String processPatientData(HttpServletRequest req, Model model,String age,String menopause,String ageMenarche,String height,String weight,String race) {

		if (!checkUserLoggedIn(req.getSession())) {
			return "home";
		} else {
				PatientData patient=new PatientData();
				patient.setEmail("hpj1992@gmail.com");
				patient.setAge(age);
				patient.setAgeMenarche(ageMenarche);
				patient.setBMI(Double.toString(LifestyleModel.getBMI(Double.valueOf(weight), Double.valueOf(height))));
				patient.setMenopause(menopause);
				patient.setRace(race);
				PatientDataManager.addPatientData(patient);
				boolean isCancerPossilbe=PatientDataManager.processPatientData(patient);
				System.out.println(isCancerPossilbe);
				
		}
		return "";
	}

	@RequestMapping(value = "/getPredictionFromGene")
	public String getPredictionFromGene(HttpServletRequest req, Model model,
			String sequence) {
		if (!checkUserLoggedIn(req.getSession())) {
			return "home";
		} else {
			DNA dna = new DNA();
			dna.dnaSequence = sequence;
			dna = DNAManager.generateCount(dna);
			boolean isCancerPossible = DNAAverageDistanceManager
					.getDNAClusterAndUpdateDatabase(dna);
			double percent = DNAAverageDistanceManager.getPercent();
			if (isCancerPossible) {
				dna.geneType = ApplicationConstants.AFFECTED_GENE;
			} else {
				dna.geneType = ApplicationConstants.NORMAL_GENE;
			}
			System.out.println(dna.geneType+ " "+isCancerPossible);
			DNAManager.addNewData(dna);

		}
		return "";
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

}
