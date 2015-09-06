package gefp.web.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;



import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gefp.model.Checkpoint;
import gefp.model.User;
import gefp.model.dao.CellDao;
import gefp.model.dao.CheckpointDao;
import gefp.model.dao.DepartmentDao;
import gefp.model.dao.PlanDao;
import gefp.model.dao.RunwayDao;
import gefp.model.dao.StageDao;
import gefp.model.dao.UserDao;










import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class AdvisorController {
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
	
	  @RequestMapping(value="/advisor/advisor.html",method=RequestMethod.GET)
	  public String advisor(ModelMap model ,HttpSession request ,@RequestParam Long userid)
	  {
		 User user=userDao.getuser(userid); 
		 request.setAttribute("user1", user);
		 model.addAttribute("userid",user.getId());
		 return "advisor/advisors"; 
	  }	 
	@RequestMapping(value="/advisor/logout.html",method=RequestMethod.GET)
	  public String logout(ModelMap model,HttpSession request,SessionStatus session)
	  {
		  	return "redirect:/logout.html";
	  } 
	
	@RequestMapping(value = "/advisor/savecheckbox.html", method = RequestMethod.POST)
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

	@RequestMapping(value = "/advisor/deletecheckbox.html", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/advisor/search.html", method = RequestMethod.GET)
	public String Profile(ModelMap model,@RequestParam String term) {
		model.put("studentlist", userDao.searchUsersByPrefix(term));
		return "advisor/advisors";
	}
	
	@RequestMapping(value="/advisor/autocompletesearch.html", method = RequestMethod.GET)
	public  String search(@RequestParam String term, HttpServletResponse response ) throws JSONException, IOException 
	{
		JSONArray jsonArray = new JSONArray();
        List<User> users = userDao.searchUsersByPrefix(term);
        for( User user : users )
        {
        	if(user.getUserrole().getType().equalsIgnoreCase("students"))
        	{	
            Map<String, String> json = new HashMap<String, String>();
            json.put("cin", user.getCIN());
            json.put("name",user.getUsername() );
            json.put("email", user.getEmail());
            json.put( "label", user.getCIN() + " " + user.getUsername());
            jsonArray.put( json );
        	}
        } 
        response.setContentType( "application/json" );
        jsonArray.write( response.getWriter() );
		return null;
	}
	
	@RequestMapping(value="/advisor/studentplanview.html")
	public String viewplan(@RequestParam Long id,@RequestParam String dname,ModelMap model ,@RequestParam Long userid)
	{
		
		//User user = userDao.getuser(id);
		 model.put("plan", planDao.getPlanDetail(id));
		 model.addAttribute("departmentname",dname);
		 model.put("userdetail", userDao.getuser(userid));
		 model.addAttribute("userid",userid);
		 model.addAttribute("term", userDao.getuser(userid).getUsername());
		return"advisor/studentplan";
	}
	@RequestMapping(value="/advisor/advisorhome.html")
	public String Advisorhome(ModelMap model ,@RequestParam Long userid)
	{
		
		//User user = userDao.getuser(id);
		 model.addAttribute("userid",userid);
		 return "advisor/advisors"; 
	}
	@RequestMapping(value = "/advisor/profile.html", method = RequestMethod.GET)
	public String Profile(ModelMap model, @RequestParam Long userid) {
	
	model.addAttribute("username", userDao.getuser(userid).getUsername());
	model.addAttribute("userid", userid);
	model.addAttribute("userpassword", userDao.getuser(userid).getPassword());
	model.addAttribute("userdept", userDao.getuser(userid).getMajor().getName());
	return "advisor/advisorprofile";
	}
}
