package com.psk.web;

import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.*;

import com.psk.domain.AppUser;
import com.psk.domain.Employee;
import com.psk.domain.MaterialType;
import com.psk.domain.Matter;
import com.psk.manager.AppUserManager;
import com.psk.manager.EmployeeManager;
import com.psk.manager.MaterialTypeManager;
import com.psk.manager.MatterManager;
import com.psk.service.EmployeeService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.psk.service.PskService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PskController {
	private final Logger logger = LoggerFactory.getLogger(PskController.class);

	@Autowired
	private AppUserManager appUserManager;

	@Autowired
	private MaterialTypeManager materialTypeManager;

    @Autowired
    private MatterManager matterManager;

	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String openWindow(Map<String, Object> model, HttpServletRequest request) {
		try {

		} catch (Exception e) {

		}
		return "window";
	}

	@RequestMapping(value = "/test/{name}/{lastName}", produces = "text/html")
	public ModelAndView openWindow(@PathVariable("name") String name, @PathVariable("lastName") String lastName, ModelAndView model, Principal principal, HttpServletRequest request) {
		try {
			String path = request.getRealPath("./resources/core/report/");
			JRCsvDataSource ds = new JRCsvDataSource(new File(path + "/Data.csv"));
			ds.setColumnNames(new String[] {"id", "name", "salary"});
			String fileName = path + "/demo.jasper";
			Map map = new HashMap();
			map.put("name", name);
			map.put("lastName", lastName);
//			JasperReport ir = JasperCompileManager.compileReport(fileName);
//			JasperPrint jasperPrint = JasperFillManager.fillReport(ir, map,ds);
			JasperPrint jasperPrint = JasperFillManager.fillReport(fileName, map,ds);

			String pathPdf = request.getRealPath("./resources/fileOutPutPDF/");
			String pdfLink = pathPdf + "/kopeeno/output.pdf";
			File pdf = new File(pdfLink);
			pdf.getParentFile().mkdirs();
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
			String urlPdf = "kopeeno/output.pdf";
			model.addObject("urlPdf", urlPdf);
		} catch (Exception e) {
			addLogin(model);
		}
		model.setViewName("window");
		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView model, Principal principal, HttpServletRequest request) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/appuser",params = "form", method = RequestMethod.GET)
	public ModelAndView appUserCreate(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {

		}
		model.setViewName("appusers/create");
		return model;
	}

	@RequestMapping(value = "/appuser/list", method = RequestMethod.GET)
	public ModelAndView appUserList(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {

		}
		model.setViewName("appusers/list");
		return model;
	}

	@RequestMapping(value = "/appuser/edit/{id}", produces = "text/html")
	public ModelAndView engViewApprove(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
		try {
			model.addObject("appuser", appUserManager.findAppUser(id));
			addMenuAndName(model, principal);
		} catch (Exception e) {

		}
		model.setViewName("appusers/edit");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		addLogin(model);
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/materialTypePrivate",params = "form", method = RequestMethod.GET)
	public ModelAndView createMatterialType(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		model.setViewName("MTMS/create");
		return model;
	}

	@RequestMapping(value = "/materialType/{id}",params = "list", method = RequestMethod.GET)
	public ModelAndView materialType(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		model.addObject("materials", materialTypeManager.findMaterialType(id).getMatters());
		model.addObject("materialType", materialTypeManager.findMaterialType(id));
		model.setViewName("MTMS/materialList");
		return model;
	}

	@RequestMapping(value = "/materialType",params = "list", method = RequestMethod.GET)
	public ModelAndView materialTypeList(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		List<MaterialType> materialTypes = materialTypeManager.findAllMaterialType();
		for (MaterialType mt : materialTypes) {
			for (Matter m : mt.getMatters()) {
				if (m.getStatus().equals("REMOVE")) {
					mt.getMatters().remove(m);
				}
			}
		}
		model.addObject("materialTypes", materialTypes);
		model.addObject("materialExpired", matterManager.findAllMaterialGe(new Date()));
		model.addObject("materials", matterManager.findAllMatterByStatusAndStatus("CREATE", "UPDATE"));
		model.addObject("materialsDoc", matterManager.findAllMatterByStatus("REQUESTDOC"));
		model.setViewName("MTMS/materialTypeList");
		return model;
	}

	@RequestMapping(value = "/mtms/expired",params = "list", method = RequestMethod.GET)
	public ModelAndView materialExpired(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}

		List<Matter> matters = matterManager.findAllMaterialGe(new Date());
		List<Matter> mattersOut = new ArrayList<Matter>();
		for (Matter m : matters) {
			Calendar calcu = Calendar.getInstance();
			calcu.setTime(new Date());

			Calendar calex3 = Calendar.getInstance();
			calex3.setTime(m.getRohsAlertDateTest());
			if(calcu.compareTo(calex3) > 0) {
				m.setRohs(null);
			}
			Calendar calex4 = Calendar.getInstance();
			calex4.setTime(m.getHalogenAlertDateTest());
			if(calcu.compareTo(calex4) > 0) {
				m.setHalogen(null);
			}
			mattersOut.add(m);
		}
		model.addObject("materialExpired", mattersOut);
		model.setViewName("MTMS/expiredList");
		return model;
	}

	@RequestMapping(value = "/materialPrivate/{id}",params = "form", method = RequestMethod.GET)
	public ModelAndView createMatterialType(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		model.addObject("materialType", materialTypeManager.findMaterialType(id));
		model.setViewName("MTMS/addMaterial");
		return model;
	}

	@RequestMapping(value = "/materialSapPrivate/{id}",params = "form", method = RequestMethod.GET)
	public ModelAndView createMatterialSapType(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		model.addObject("materialType", materialTypeManager.findMaterialType(id));
		model.setViewName("MTMS/addMaterialSap");
		return model;
	}

	@RequestMapping(value = "/material/{id}",params = "list", method = RequestMethod.GET)
	public ModelAndView materialList(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		Matter matter = matterManager.findMatter(id);
		model.addObject("material", matter);
		model.setViewName("MTMS/materialData");
		return model;
	}

	@RequestMapping(value = "/material/request",params = "list", method = RequestMethod.GET)
	public ModelAndView materiaRequestlList(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		model.addObject("materialsDoc", matterManager.findAllMatterByStatus("REQUESTDOC"));
		model.setViewName("MTMS/materialRequestList");
		return model;
	}

	@RequestMapping(value = "/mtms/search", method = RequestMethod.GET)
	public ModelAndView searchMat(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
		} catch (Exception e) {
			addLogin(model);
		}
		model.setViewName("MTMS/search");
		return model;
	}

	@RequestMapping(value = "/materialPrivate",params = "approve", method = RequestMethod.GET)
	public ModelAndView materialListApprove(ModelAndView model, Principal principal) {
		try {
			addMenuAndName(model, principal);
            model.addObject("materials", matterManager.findAllMatterByStatusAndStatus("CREATE", "UPDATE"));
		} catch (Exception e) {
			addLogin(model);
		}
		model.setViewName("MTMS/materialListApprove");
		return model;
	}

    @RequestMapping(value = "/materialPrivate/{id}",params = "approve", method = RequestMethod.GET)
    public ModelAndView materialApprove(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        try {
            addMenuAndName(model, principal);
            model.addObject("material", matterManager.findMatter(id));
        } catch (Exception e) {
            addLogin(model);
        }
        model.setViewName("MTMS/materialApprove");
        return model;
    }

    @RequestMapping(value = "/materialPrivate",params = "listOfRequest", method = RequestMethod.GET)
    public ModelAndView materialPrivateListOfRequest(ModelAndView model, Principal principal) {
        try {
            addMenuAndName(model, principal);
            model.addObject("materialsCreate", matterManager.findAllMatterByStatus("CREATE"));
            model.addObject("materialsReject", matterManager.findAllMatterByStatus("REJECT"));
        } catch (Exception e) {
            addLogin(model);
        }
        model.setViewName("MTMS/listOfRequest");
        return model;
    }

    @RequestMapping(value = "/materialPrivate/{id}",params = "update", method = RequestMethod.GET)
    public ModelAndView materialUpdate(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        try {
            addMenuAndName(model, principal);
            model.addObject("material", matterManager.findMatter(id));
        } catch (Exception e) {
            addLogin(model);
        }
        model.setViewName("MTMS/materialUpdate");
        return model;
    }

	private void addMenuAndName(ModelAndView model, Principal principal) {
		AppUser appUser = appUserManager.findAppUserByName(principal.getName());
		model.addObject("name", appUser.getName());
		model.addObject("logout", "on");
		model.addObject("createUser", "on");
		model.addObject("roleName", appUser.getRoleName());
	}

	private void addLogin(ModelAndView model) {
		model.addObject("login", "on");
	}
}