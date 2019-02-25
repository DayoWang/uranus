package me.wgy.model;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;

/**
 * user
 *
 * @author
 */
@Data
@ApiModel
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private String identity;

}