package com.todo.dao;

import com.todo.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String sql = "select * from members where member_id=? and password=?";
        @Cleanup Connection  connection= ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, mid);
        psmt.setString(2, mpw);
        @Cleanup ResultSet rs = psmt.executeQuery();
        rs.next();
        MemberVO memberVO = MemberVO.builder()
                .mid(rs.getInt("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .build();
        return memberVO;
    }
}
