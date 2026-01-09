package com.twog.shopping.ebproj.service;

import com.twog.shopping.ebproj.dto.MenuDTO;
import com.twog.shopping.ebproj.entity.Menu;
import com.twog.shopping.ebproj.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    // service

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    public MenuDTO findMenuByMenuCode(int menuCode){
        Menu selectMenu = menuRepository.findById(menuCode).get();
        return modelMapper.map(selectMenu, MenuDTO.class);
    }
}
