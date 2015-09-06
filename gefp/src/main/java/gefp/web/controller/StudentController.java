package gefp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import gefp.model.Checkpoint;
import gefp.model.Department;
import gefp.model.Plan;
import gefp.model.User;
import gefp.model.dao.CellDao;
import gefp.model.dao.CheckpointDao;
import gefp.model.dao.DepartmentDao;
import gefp.model.dao.PlanDao;
import gefp.model.dao.RunwayDao;
import gefp.model.dao.StageDao;
import gefp.model.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class StudentController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private PlanDao planDao;
	@Autowired
	private StageDao stageDao;
	@Autowired
	private RunwayDao runwayDao;
	@Autowired
	private CellDao cellDao;
	@Autowired
	private CheckpointDao checkpointDao;

	@Autowired
	@Qualifier("Validate")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	  

	@RequestMapping(value = "/student/savecheckbox.html", method = RequestMethod.POST)
	public @ResponseBody String SaveCheckpoint(ModelMap model,
			@RequestParam String userid, @RequestParam String checkid) {
		System.out.println("hi");
		String returnText;
		User user = userDao.getuser(Long.parseLong(userid));
		Checkpoint check = checkpointDao.getcheckpoint(Long.parseLong(checkid));
		user.getCheckpoints().add(check);
		userDao.saveUser(user);
		returnText = "Checkpoint Saved";
		return returnText;
	}

	@RequestMapping(value = "/student/deletecheckbox.html", method = RequestMethod.POST)
	public @ResponseBody String DeleteCheckpoint(ModelMap model,
			@RequestParam String userid, @RequestParam String checkid) {
		System.out.println("hey");
		String returnText;
		User user = userDao.getuser(Long.parseLong(userid));
		Checkpoint check = checkpointDao.getcheckpoint(Long.parseLong(checkid));
		user.getCheckpoints().remove(check);
		userDao.saveUser(user);
		returnText = "Checkpoint Deleted";
		return returnText;
	}

	@RequestMapping(value = "/student/profile.html", method = RequestMethod.GET)
	public String Profile(ModelMap model, @RequestParam Long userid) {
		User user = userDao.getuser(userid);
			
		model.addAttribute("username", userDao.getuser(userid).getUsername());
		model.addAttribute("userid", userid);
		model.addAttribute("userpassword", userDao.getuser(userid).getPassword());
		model.addAttribute("userdept", userDao.getuser(userid).getMajor().getName());
		return "student/userprofile";
	}

	@RequestMapping(value = "/student/resetpassword.html", method = RequestMethod.GET)
	public String ResetPasswordGet(ModelMap model, @RequestParam Long userid) {
		User user = userDao.getuser(userid);
		model.put("user", user);
		model.addAttribute("userid", userid);
		model.addAttribute("userpassword", userDao.getuser(userid)
				.getPassword());
		return "student/resetpassword";
	}

	@RequestMapping(value = "/student/resetpassword.html", method = RequestMethod.POST)
	public String ResetPasswordPost(@ModelAttribute("user")User user,BindingResult result, ModelMap model,@RequestParam String nwpsd,HttpSession request) {
		//String newpassword=user.getPassword();
		
		System.out.println("user1"+request.getAttribute("user1"));
		User tempuser = (User) request.getAttribute("user1");
		System.out.println(tempuser.getId());
		User user1 = userDao.getuser(tempuser.getId());
		System.out.println(tempuser.getId());
		//user1.setPassword(nwpsd);
		if (nwpsd != "") {
			user1.setPassword(nwpsd);
			validator.validate(user1, result);
			if(result.hasErrors())
			{
				return "student/resetpassword";
			}
			
		}
		userDao.saveUser(user1);
		return "redirect:profile.html?userid="+tempuser.getId() ;
	}
	@RequestMapping(value = "/student/changedepartment.html", method = RequestMethod.GET)
	public String ChangeDeptGet(ModelMap model, @RequestParam Long userid) {
		User user = userDao.getuser(userid);
		model.addAttribute("userid", userid);
		model.put("Department", departmentDao.getDepartmentName());
		return "student/changedepartment";
	}
	
	@RequestMapping(value = "/student/changedepartment.html", method = RequestMethod.POST)
	public String ChangeDeptPost(ModelMap model, @RequestParam Long userid,@RequestParam Long Department) {
		User user = userDao.getuser(userid);
		Department dept=departmentDao.getDepartment(Department);
		Long Planid=dept.getCurrentplan().getId();
		Plan plan=planDao.getPlanDetail(Planid);
		user.setPlan(plan);
		user.setMajor(dept);
		userDao.saveUser(user);
		return "redirect:profile.html?userid=" + userid;
	}
	@RequestMapping(value="/student/logout.html",method=RequestMethod.GET)
	  public String logout(ModelMap model,HttpSession request,SessionStatus session)
	  {
		  	
		  	return "redirect:/logout.html";
	  } 
}
