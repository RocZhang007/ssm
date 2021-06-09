package com.roc.dao;

import com.roc.domain.ActivityCount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ActivityCountDao {
    @Update("update hb_activity_count set number = #{number} where id = #{id}")
    void update(ActivityCount res);

    @Insert("insert into hb_activity_count values (#{id},#{act_name},#{type_name},#{number})")
    void save(ActivityCount res);
}
