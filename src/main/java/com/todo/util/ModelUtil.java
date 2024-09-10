package com.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public enum ModelUtil {
    INSTANCE;
    private ModelMapper modelMapper;
    //enum 사용이유 : 정해진 수만큼 객체를 생성할 수 있다.
    //TodoService.INSTANCE(한 개의 서비스 객체를 사용하겠다는 뜻)
    // -> 싱글톤패턴을 적용하여 서비스하겠다.
    //여러개의 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고받는 구조로 만들기 위해 객체를 하나만 생성

    ModelUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper get() {
        return modelMapper;
    }
}
