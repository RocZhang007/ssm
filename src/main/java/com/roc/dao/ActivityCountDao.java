package com.roc.dao;

import com.roc.domain.Count;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface ActivityCountDao {
    /*@Update("update hb_activity_count set number = #{number} where id = #{id}")*/
    void updateNumber(Count count);

    /*@Insert("insert into hb_activity_count values (#{id},#{act_name},#{type_name},#{number})")*/
    void saveNumber(Count count);
}
