package com.tsn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author tsn
 * @since 2021-07-08
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer userId;

    private String title;

    private String description;

    private String content;

    private LocalDateTime created;

    private Integer status;


}
