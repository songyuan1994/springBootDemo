package com.example.demo.dao.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Select({
            "select",
            "userId, nickName, passwd, langCode, mobile, smallAvatarUrl, originalAvatarUrl, ",
            "email, qrcodeString, gender, standing,",
            "userStatus,lastPhoneIMEI, lastPhoneBrand, lastPhoneModel, apnsToken,robotStatus,belongId ,remark,welcomeTips, ",
            "dataVersion, createTime,type",
            "from t_user",
            "where userId = #{userId}"
    })
    User getUserById(@Param(value = "userId") String userId);
}
