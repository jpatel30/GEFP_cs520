package gefp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import gefp.model.User;
import gefp.model.dao.DepartmentDao;
import gefp.model.dao.PlanDao;
import gefp.model.dao.UserDao;

@Controller
@SessionAttributes("user1")
public class LoginController {
	 
	  @Autowired
	  private UserDao userDao;
	  @Autowired
	  private DepartmentDao departmentDao;
	  @Autowired
	  private PlanDao planDao;
	
	  @RequestMapping(value="/login.html",method=RequestMethod.GET)
	  public String login(ModelMap model)
	  {
		  //	model.put("user", new User());
		  	return "login";
	  }
	  @RequestMapping(value="/logout.html",method=RequestMethod.GET)
	  public String logout(ModelMap model,HttpSession request,SessionStatus session)
	  {
		  	//model.put("user", new User());
		  	request.removeAttribute("user1");
		  	session.setComplete();
		  	return "login";
	  } 
	 /* @RequestMapping(value="/home.html",method=RequestMethod.POST)
	  public String login(@ModelAttribute User user,ModelMap model ,HttpSession request )
	  {
		  List<User> validateuser=userDao.getUserlist();
		  for(int i=0 ;i<validateuser.size();i++)
			{
				if(validateuser.get(i).getUsername().equalsIgnoreCase(user.getUsername()))
				{
					if(validateuser.get(i).getPassword().equalsIgnoreCase(user.getPassword()))
					{	
						if(validateuser.get(i).getUserrole().getType().equalsIgnoreCase("administrators"))
						{
							 return "redirect:admin/admin.html?userid="+validateuser.get(i).getId();
						}
						if(validateuser.get(i).getUserrole().getType().equalsIgnoreCase("advisors"))
						{
							 return "redirect:advisor/advisor.html?userid="+validateuser.get(i).getId();
						}
						if(validateuser.get(i).getUserrole().getType().equalsIgnoreCase("students"))
						{
							return "redirect:student/student.html?userid="+validateuser.get(i).getId();
						}
			
					}
				}
			}
		
		  return "login";
	  }*/
	  @RequestMapping(value="/student/student.html",method=RequestMethod.GET)
	  public String student(ModelMap model ,HttpSession request ,@RequestParam Long userid)
	  {
		 User user=userDao.getuser(userid);
		 request.setAttribute("user1", user);
		 model.put("plan", planDao.getPlanDetail(user.getPlan().getId()));
		 model.addAttribute("departmentname",user.getMajor().getName());
		 model.put("userdetail", userDao.getuser(user.getId()));
		 model.addAttribute("userid",user.getId());
		 return "student/studentview";
	  }
	  @RequestMapping(value="/student/studenthome.html",method=RequestMethod.GET)
	  public String studentHome(ModelMap model ,HttpServletRequest request,@RequestParam Long userid)
	  {
		  	 User user=userDao.getuser(userid);
		  	 String username=user.getUsername();
		  	 request.getSession().setAttribute("user1", username);
		  	 model.put("plan", planDao.getPlanDetail(user.getPlan().getId()));
			 model.addAttribute("departmentname",user.getMajor().getName());
			 model.put("userdetail", user);
			 model.addAttribute("userid",user.getId());
			 return "student/studentview";
		 
	  }
	
		 
}
