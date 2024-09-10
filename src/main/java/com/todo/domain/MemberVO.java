package com.todo.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private Integer mid;
    private String mpw;
    private String mname;
}
