package com.poly.service;


import java.util.List;

import org.springframework.data.domain.Page;
import com.poly.model.HeoDTO;
import com.poly.model.HeoDTOForm;

public interface IHeoService {
    Page<HeoDTO> getpage(String direction,String fiel,Integer page,String name);
    int pagetotal();
    HeoDTO save(HeoDTOForm productdto);
    HeoDTO update(HeoDTOForm productdto);
    HeoDTO findByID(Integer id);
    List<HeoDTO> featuredHeo();
    List<HeoDTO> getRecent();
    Page<HeoDTO> getPrice(Integer min,Integer max);
    List<HeoDTO> getProductByCategory(String category);
    
}
