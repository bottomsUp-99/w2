package com.todo.service;

import com.todo.dao.MemberDAO;
import com.todo.domain.MemberVO;
import com.todo.dto.MemberDTO;
import com.todo.util.ModelUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;
    private MemberDAO dao;
    private ModelMapper modelMapper;
    MemberService() {
        dao = new MemberDAO();
        modelMapper = ModelUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = dao.getWithPassword(mid, mpw);
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);
        return dto;
    }
}
