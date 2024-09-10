package com.todo.dao;

import com.todo.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String sql = "select * from tbl_member where mid=? and mpw=?";
        @Cleanup Connection  connection= ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, mid);
        psmt.setString(2, mpw);
        @Cleanup ResultSet rs = psmt.executeQuery();
        rs.next();
        MemberVO memberVO = MemberVO.builder()
                .mid(rs.getString(1))
                .mpw(rs.getString(2))
                .mname(rs.getString(3))
                .build();
        return memberVO;
    }
}
