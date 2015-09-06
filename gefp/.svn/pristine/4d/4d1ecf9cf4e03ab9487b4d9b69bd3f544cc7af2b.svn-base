package gefp.web.controller;

import gefp.model.Cell;
import gefp.model.Checkpoint;
import gefp.model.Department;
import gefp.model.Plan;
import gefp.model.Runway;
import gefp.model.Stage;
import gefp.model.User;
import gefp.model.dao.CellDao;
import gefp.model.dao.CheckpointDao;
import gefp.model.dao.DepartmentDao;
import gefp.model.dao.PlanDao;
import gefp.model.dao.RunwayDao;
import gefp.model.dao.StageDao;
import gefp.model.dao.UserDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

@Controller
@SessionAttributes("user1")
public class AdminController {
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

	@RequestMapping(value = "/admin/logout.html", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpSession request,
			SessionStatus session) {

		return "redirect:/logout.html";
	}

	@RequestMapping(value = "/admin/admin.html", method = RequestMethod.GET)
	public String Admin(ModelMap model, HttpSession request,
			@RequestParam Long userid) {
		User user = userDao.getuser(userid);
		request.setAttribute("user1", user);
		model.put("department", departmentDao.getDepartmentName());
		model.addAttribute("userid", user.getId());
		return "admin/view";
	}

	@RequestMapping(value = "/admin/home.html", method = RequestMethod.GET)
	public String create(ModelMap model, HttpServletRequest request,
			@RequestParam String username) {
		request.getSession().setAttribute("user1", username);
		model.put("department", departmentDao.getDepartmentName());
		return "admin/view";

	}

	@RequestMapping(value = "/admin/view.html", method = RequestMethod.GET)
	public String Plan(ModelMap model, @RequestParam String dname) {

		model.addAttribute("departmentname", dname);
		model.put("department", departmentDao.getDepartmentName());
		model.put("plan", departmentDao.getPlan(dname));
		return "admin/view";

	}

	@RequestMapping(value = "/admin/profile.html", method = RequestMethod.GET)
	public String Profile(ModelMap model, @RequestParam Long userid) {
		User user = userDao.getuser(userid);

		model.addAttribute("username", userDao.getuser(userid).getUsername());
		model.addAttribute("userid", userid);
		model.addAttribute("userpassword", userDao.getuser(userid)
				.getPassword());
		// model.addAttribute("userdept",
		// userDao.getuser(userid).getMajor().getName());
		return "admin/profile";

	}

	@RequestMapping(value = "/admin/view.html", method = RequestMethod.POST)
	public String DepartmentPlan(ModelMap model,
			@RequestParam String Department, @RequestParam String action,
			@ModelAttribute Department department) {
		if (action.equalsIgnoreCase("Search Plan")) {
			model.put("department", departmentDao.getDepartmentName());
			model.put("plan", departmentDao.getPlan(Department));
			model.addAttribute("departmentname", Department);
			return "admin/view";
		} else
			model.addAttribute("departmentname", Department);
		model.put("departmentid", departmentDao.getIdByName(Department));
		model.put("plan", new Plan());
		return "admin/create";

	}

	@RequestMapping(value = "/admin/plandetail.html")
	public String PlanDetail(ModelMap model, @RequestParam long id,
			@RequestParam String dname) {
		Plan plan = planDao.getPlanDetail(id);
		model.addAttribute("planid", id);
		model.addAttribute("departmentname", dname);
		model.put("plan", planDao.getPlanDetail(id));
		System.out.println(planDao.getPlanDetail(id).getCells().size());
		model.put("planrunway", plan.getRunways());
		model.addAttribute("runwaysize", plan.getRunways().size());
		model.put("planstage", plan.getStages());
		model.addAttribute("stagesize", plan.getStages().size());
		model.put("plancell", plan.getCells());
		model.addAttribute("cellsize", plan.getCells().size());
		System.out.println("cellsize------" + plan.getCells().size());
		return "admin/plandetail";

	}

	@RequestMapping(value = "/admin/create.html", method = RequestMethod.POST)
	public String Create(@ModelAttribute Plan plan,
			@RequestParam long departmentid, @RequestParam String departmentname) {
		System.out.println(departmentid);
		plan = planDao.addplan(plan);
		Department dept = departmentDao.getIdByName(departmentname);
		System.out.println(dept);
		dept.getPlans().add(plan);
		departmentDao.savedept(dept);
		return "redirect:view.html?dname=" + departmentname;

	}

	@RequestMapping(value = "/admin/add.html")
	public String add(ModelMap model, @RequestParam long id,
			@RequestParam String dname) {
		model.addAttribute("departmentname", dname);
		model.put("plan", planDao.getPlanDetail(id));
		return "admin/add";
	}

	@RequestMapping(value = "/admin/addstage.html")
	public String AddStageGet(ModelMap model, @RequestParam long id,
			@RequestParam String dname) {
		System.out.println("@@@@@@" + dname);
		model.addAttribute("planid", id);
		model.addAttribute("departmentname", dname);
		model.put("plan", planDao.getPlanDetail(id));
		model.put("stage", new Stage());
		return "admin/addstage";
	}

	@RequestMapping(value = "/admin/addstage.html", method = RequestMethod.POST)
	public String AddStagePost(@ModelAttribute Stage stage,
			@RequestParam long planid, @RequestParam String dname) {
		System.out.println("-------" + dname);
		System.out.println(planid);
		stage = stageDao.addstage(stage);
		Plan plan = planDao.getPlanDetail(planid);
		plan.getStages().add(stage);
		planDao.saveplan(plan);
		return "redirect:plandetail.html?id=" + planid + "&dname=" + dname;
	}

	@RequestMapping(value = "/admin/addrunway.html")
	public String AddRunwayGet(ModelMap model, @RequestParam long id,
			@RequestParam String dname) {
		model.addAttribute("planid", id);
		model.addAttribute("departmentname", dname);
		model.put("plan", planDao.getPlanDetail(id));
		model.put("runway", new Runway());
		return "admin/addrunway";
	}

	@RequestMapping(value = "/admin/addrunway.html", method = RequestMethod.POST)
	public String AddRunwayPost(@ModelAttribute Runway runway,
			@RequestParam long planid, @RequestParam String dname) {
		System.out.println(planid);
		runway = runwayDao.addrunway(runway);
		Plan plan = planDao.getPlanDetail(planid);
		plan.getRunways().add(runway);
		planDao.saveplan(plan);
		return "redirect:plandetail.html?id=" + planid + "&dname=" + dname;
	}

	@RequestMapping(value = "/admin/addcheckpoint.html")
	public String AddCheckpointGet(ModelMap model, @RequestParam long id,
			@RequestParam String dname) {
		model.addAttribute("planid", id);
		model.addAttribute("departmentname", dname);
		model.put("plan", planDao.getPlanDetail(id));
		model.put("checkpoint", new Checkpoint());
		return "admin/addcheckpoint";
	}

	@RequestMapping(value = "/admin/addcheckpoint.html", method = RequestMethod.POST)
	public String AddCheckpointPost(@ModelAttribute Checkpoint checkpoint,
			@RequestParam long planid, @RequestParam String dname,
			@RequestParam String stage, @RequestParam String runway) {

		checkpoint = checkpointDao.addcheckpoint(checkpoint);
		Plan plan = planDao.getPlanDetail(planid);
		Runway runwayobj = runwayDao.getrunway(runway);
		Stage stageobj = stageDao.getstage(stage);
		List<Cell> cell = cellDao.getcelldetail(plan, runwayobj, stageobj);
		Cell tempCell;
		if (cell == null) {
			tempCell = new Cell();
			tempCell.setPlan(plan);
			tempCell.setRunway(runwayobj);
			tempCell.setStage(stageobj);

		} else {
			tempCell = cell.get(0);

		}

		tempCell.getCheckpoints().add(checkpoint);
		tempCell = cellDao.savecell(tempCell);
		plan.getCells().add(tempCell);
		planDao.saveplan(plan);
		return "redirect:plandetail.html?id=" + planid + "&dname=" + dname;
	}

	@RequestMapping(value = "/admin/edit.html")
	public String EditGet(ModelMap model, @RequestParam long pid,
			@RequestParam long sid, @RequestParam long cid,
			@RequestParam long rid, @RequestParam String dname) {
		model.addAttribute("planid", pid);
		model.addAttribute("departmentname", dname);
		model.addAttribute("runwayname", runwayDao.getrunwaybyId(rid).getName());
		model.addAttribute("runwayid", runwayDao.getrunwaybyId(rid).getId());
		model.addAttribute("stagename", stageDao.getstagebyId(sid).getName());
		model.addAttribute("stageid", stageDao.getstagebyId(sid).getId());
		model.put("plan", planDao.getPlanDetail(pid));
		model.put("stage", stageDao.getstage());
		model.put("runway", runwayDao.getrunway());
		model.put("checkpoint", checkpointDao.getnamebyId(cid));
		return "admin/edit";
	}

	@RequestMapping(value = "/admin/edit.html", method = RequestMethod.POST)
	public String EditPost(ModelMap model, @RequestParam long pid,
			@RequestParam long sid, @RequestParam long cid,
			@RequestParam long rid, @RequestParam String action,
			@RequestParam String checkpoint, @RequestParam long cellid,
			@RequestParam String Stage, @RequestParam String Runway,
			@RequestParam String dname) {

		
			System.out.println(cellid);
			Plan plan = planDao.getPlanDetail(pid);
			Runway runway = runwayDao.getrunwaybyId(Long.parseLong(Runway));
			Stage stage = stageDao.getstagebyId(Long.parseLong(Stage));

			Checkpoint check = checkpointDao.getcheckpoint(cid);
			Checkpoint checkduplicate = check;
			Cell cell = cellDao.getcellbyId(cellid);
			cell.getCheckpoints().remove(checkduplicate);
			if (cell.getCheckpoints().size() < 1)
				plan.getCells().remove(cell);

			check.setDescription(checkpoint);
			check = checkpointDao.savecheckpoint(check);

			Cell tempCell = cellDao.getcell(plan, runway, stage);

			if (tempCell == null) {
				tempCell = new Cell();
				tempCell.setPlan(plan);
				tempCell.setRunway(runway);
				tempCell.setStage(stage);

			}

			tempCell.getCheckpoints().add(check);
			tempCell = cellDao.savecell(tempCell);
			plan.getCells().add(tempCell);
			planDao.saveplan(plan);
			return "redirect:plandetail.html?id=" + pid + "&dname=" + dname;
		

	}
	
	@RequestMapping(value = "/admin/delete.html")
	public String Delete(ModelMap model, @RequestParam long pid,
			 @RequestParam long cid, @RequestParam long cellid,@RequestParam String dname) {
		Plan plan = planDao.getPlanDetail(pid);
	

		Checkpoint check = checkpointDao.getcheckpoint(cid);
		Checkpoint checkduplicate = check;
		Cell cell = cellDao.getcellbyId(cellid);
		cell.getCheckpoints().remove(checkduplicate);
		cellDao.savecell(cell);
		if (cell.getCheckpoints().size() < 1)
			plan.getCells().remove(cell);

		return "redirect:plandetail.html?id=" + pid + "&dname=" + dname;
	}


	@RequestMapping(value = "/admin/assign.html")
	public String Assign(ModelMap model, @RequestParam String dname,
			@RequestParam long id) {
		Department dept = departmentDao.getIdByName(dname);
		Plan plan = planDao.getPlanDetail(id);
		dept.setCurrentplan(plan);
		departmentDao.savedept(dept);
		return "redirect:view.html?dname=" + dname;
	}

	@RequestMapping(value = "/admin/editRunway.html")
	public String EditRunway(ModelMap model, @RequestParam String dname,
			@RequestParam Long rid, @RequestParam Long pid) {

		Department dept = departmentDao.getIdByName(dname);
		Plan plan = planDao.getPlanDetail(pid);
		Runway runway = runwayDao.getrunwaybyId(rid);
		model.addAttribute("departmentname", dept.getName());
		model.addAttribute("planid", plan.getId());
		model.put("runway", runway.getName());
		model.addAttribute("runwayid", runway.getId());
		return "admin/editRunway";

	}

	@RequestMapping(value = "/admin/editRunway.html", method = RequestMethod.POST)
	public String EditRunwayPost(ModelMap model, @RequestParam String dname,
			@RequestParam Long planid, @RequestParam Long runwayid,
			@RequestParam String newrunway) {

		Department dept = departmentDao.getIdByName(dname);
		Plan plan = planDao.getPlanDetail(planid);
		Runway runway = runwayDao.getrunwaybyId(runwayid);
		if (newrunway != null) {
			runway.setName(newrunway);
		}
		runwayDao.saveRunway(runway);
		return "redirect:plandetail.html?id=" + planid + "&dname=" + dname;

	}

	@RequestMapping(value = "/admin/editStage.html")
	public String EditStage(ModelMap model, @RequestParam String dname,
			@RequestParam Long sid, @RequestParam Long pid) {

		Department dept = departmentDao.getIdByName(dname);
		Plan plan = planDao.getPlanDetail(pid);
		Stage stage = stageDao.getstagebyId(sid);
		model.addAttribute("departmentname", dept.getName());
		model.addAttribute("planid", plan.getId());
		model.put("stage", stage.getName());
		model.addAttribute("stageid", stage.getId());
		return "admin/editStage";

	}

	@RequestMapping(value = "/admin/editStage.html", method = RequestMethod.POST)
	public String EditStagePost(ModelMap model, @RequestParam String dname,
			@RequestParam Long planid, @RequestParam Long stageid,
			@RequestParam String newstage) {

		Department dept = departmentDao.getIdByName(dname);
		Plan plan = planDao.getPlanDetail(planid);
		Stage stage = stageDao.getstagebyId(stageid);
		if (newstage != null) {
			stage.setName(newstage);
		}
		stageDao.saveStage(stage);
		return "redirect:plandetail.html?id=" + planid + "&dname=" + dname;

	}

	// -----------drag and drop ---------------//

	@RequestMapping(value = "/admin/savecolumn.html", method = RequestMethod.POST)
	public String SaveCol(ModelMap model, HttpServletRequest request,
			@RequestParam Long planid,
			HttpServletResponse response) throws IOException {
		System.out.println("hi");
		Plan plan = planDao.getPlanDetail(planid);
		String [] runways = request.getParameterValues("runways[]");
		plan.setRunways(new ArrayList<Runway>());
		for(String rid : runways) {
			System.out.println(rid);
			if(rid!="")
			{
				Long ridl = Long.parseLong(rid);
				plan.getRunways().add(runwayDao.getrunwaybyId(ridl));
			}
		}
		planDao.saveplan(plan);
		response.setContentType("text/plain");
		response.getWriter().print("");

		return null;
	}

	@RequestMapping(value = "/admin/saverow.html", method = RequestMethod.POST)
	public String SaveRow(ModelMap model, HttpServletRequest request,
			@RequestParam Long planid,
			HttpServletResponse response) throws IOException {
		System.out.println("hi");
		Plan plan = planDao.getPlanDetail(planid);
		String [] stages = request.getParameterValues("stages[]");
		plan.setStages(new ArrayList<Stage>());
		for(String sid : stages) {
			System.out.println(sid);
			Long sidl = Long.parseLong(sid);
			plan.getStages().add(stageDao.getstagebyId(sidl));
		}
		planDao.saveplan(plan);
		response.setContentType("text/plain");
		response.getWriter().print("");

		return null;
	}

	@RequestMapping(value = "/admin/saveck.html", method = RequestMethod.POST)
	public String Savechk(ModelMap model, HttpServletRequest request,@RequestParam Long cellid,
			@RequestParam Long planid,
			HttpServletResponse response) throws IOException {
		System.out.println("hi");
		String [] ckids = request.getParameterValues("ckid[]");
		Cell cell = cellDao.getcellbyId(cellid);
		System.out.println("cellidddd" +cell.getId() );
		cell.setCheckpoints(new ArrayList<Checkpoint>());
		System.out.println("cell" +cell.getCheckpoints().size());
		for(String ckid : ckids) {
			System.out.println(ckid);
			Long ckidl = Long.parseLong(ckid);
			cell.getCheckpoints().add(checkpointDao.getcheckpoint(ckidl));
		}
		cellDao.savecell(cell);
		response.setContentType("text/plain");
		response.getWriter().print("");

		return null;
	}
}
