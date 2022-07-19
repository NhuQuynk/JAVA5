package com.poly.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.poly.entity.Heo;
import com.poly.mapper.HeoMapper;
import com.poly.model.CategoryDTO;
import com.poly.model.HeoDTO;
import com.poly.model.UserDTO;
import com.poly.model.UserDTORegister;
import com.poly.service.ICategorySerrvice;
import com.poly.service.IHeoService;
import com.poly.service.IUserService;

//RequestMapping cho tất cả các đường dẫn mapping bên trong,
//sử dụng để ánh xạ (Method , URL và Parameter) với một phương thức
//@RequestParam nhận các tham số từ ng dùng
@Controller
public class HomeController {
	@Autowired //khởi tạo đối tượng lên respository
	private IHeoService productService;
	@Autowired
	private ICategorySerrvice cateService;
	@Autowired
	private IUserService service;
	@Autowired
	private HeoMapper mapper;
	@Autowired
	private JavaMailSender sender;
   @GetMapping("/login")//@GetMapping được sử dụng để xử lý loại phương thức yêu cầu GET
    public String login(Model model,@ModelAttribute("user") UserDTORegister dto) {
	   model.addAttribute("view","/WEB-INF/View/User/login.jsp");
	   return "User/index";
   }
   @PostMapping("/login")//@PostMapping được sử dụng để xử lý loại phương thức yêu cầu POST
   public String checkLogin(Model model,@ModelAttribute("user") UserDTORegister dto,
		   @RequestParam("email") String username,
		   @RequestParam("password") String password,@RequestParam(value = "remember",defaultValue = "false") boolean remember) {
	   UserDTO check = this.service.checklogin(username, password, remember);


	   if(check != null) {
		   return  "redirect:/trangchu";
	   }
	   model.addAttribute("view","/WEB-INF/View/User/login.jsp");
   	return "User/index";  
   }
    @PostMapping("/register")
    public String register(Model model,@Valid @ModelAttribute("user") UserDTORegister dto,
    		BindingResult result) {
    	 if(result.hasErrors()) {
    		 System.out.println(result.getAllErrors());
    		
    	 }else if(!dto.getPassword().equals(dto.getConfirmPassword())) {
    		 model.addAttribute("confirmPassword","Mat khau xac nhan khong chinh xac");
    	 }else if(!service.checkEmailforgot(dto.getEmail())) {
    		 model.addAttribute("email","Email da ton tai");
    	 }else {
    		 this.service.register(dto);
    		 model.addAttribute("alert","Đăng ký thành công");
    	 }
    	 model.addAttribute("view","/WEB-INF/View/User/login.jsp");
    	return "User/index";
    }
   @GetMapping("/trangchu")
   public String index(Model model) {
	   List<HeoDTO> heos = this.productService.featuredHeo();
	   model.addAttribute("featured",heos); //62 user.trangchu
	   model.addAttribute("recent", this.productService.getRecent());///111
	   model.addAttribute("view","/WEB-INF/View/User/trangchu.jsp");  //user/index
	   return "User/index";
   }
  
    
    @PostMapping("/forgot-password")
    public String forgotpassword(Model model,@RequestParam("emailforgot") String emailforgot,@ModelAttribute("user") UserDTORegister dto) {
    	if(this.service.checkEmailforgot(emailforgot)) {
    		model.addAttribute("forgotmail","Email không chính xác");
    	}else {
    		SimpleMailMessage ms = new SimpleMailMessage();
    		ms.setSubject(" QUÊN MẬT KHẨU");
    		ms.setTo(emailforgot);
    		String newPass = this.service.getPasswordForgot(emailforgot);
    		ms.setText("Mật khẩu mới của bạn là : " + newPass);
    		sender.send(ms);
    		model.addAttribute("alert","Mat khau moi da duoc gui ve mail");
    	}
    	   model.addAttribute("view","/WEB-INF/View/User/login.jsp");
    	   return "User/index";
    	
    }
 
}
