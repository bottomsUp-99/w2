package com.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter //getter, setter, toString, equals, hashCode 컴파일할때 자동 생성해준다.
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class TodoVO {

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
