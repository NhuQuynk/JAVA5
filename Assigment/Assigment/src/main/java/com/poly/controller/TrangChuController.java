package com.poly.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.entity.Heo;
import com.poly.repository.IHeoRepository;
import com.poly.repository.IOrderDetailRepository;
import com.poly.repository.IOrderRepository;
import com.poly.repository.IUserRepository;

@Controller
public class TrangChuController {
	@Autowired
	private IOrderDetailRepository repository;
	@Autowired
	private IHeoRepository heoRepository;
	@Autowired
	private IOrderRepository orderRepository;
	@Autowired
	private IUserRepository userRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("view","/WEB-INF/View/Amin/QLDonHang1.jsp");
		Pageable pageable = PageRequest.of(0, 1);//page,size
		List<Heo> heo = this.repository.getBanChayNgay(pageable);
	
//		if(!heo.isEmpty()) {
//			model.addAttribute("ngay",heo.get(0));//thay the phan tu duoc chi dinh bang 0
//			List<Long> sl = this.repository.getSLBanChayNgay(pageable);
//			model.addAttribute("ngaysl",sl.get(0));
//			model.addAttribute("dtNgay",this.repository.getDTBanChayNgay(pageable).get(0));
//		}
//		List<Heo> heoThang = this.repository.getBanChaythang(pageable);
//		if(!heoThang.isEmpty()) {
//			model.addAttribute("thang",heoThang.get(0));
//			List<Long> slthang = this.repository.getSLBanChaythang(pageable);
//			model.addAttribute("thangsl",slthang.get(0));
//			model.addAttribute("dtThang",this.repository.getDTBanChaythang(pageable).get(0));
//		}
//		List<Heo> heonam = this.repository.getBanChayNam(pageable);
//		if(!heoThang.isEmpty()) {
//			model.addAttribute("nam",heonam.get(0));
//			List<Long> slthang = this.repository.getSLBanChayNam(pageable);
//			model.addAttribute("namsl",slthang.get(0));
//			model.addAttribute("dtnam",this.repository.getDTBanChayNam(pageable).get(0));
//		}
//		long slSP = this.heoRepository.count();
//		model.addAttribute("slSP",slSP);
//		long slDH = this.orderRepository.count();
//		model.addAttribute("slDH",slDH);
//		long slu = this.userRepository.count();
//		model.addAttribute("slu",slu);
		return "Amin/index";
	}
}
