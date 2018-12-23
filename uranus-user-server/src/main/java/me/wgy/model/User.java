package me.wgy.model;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 *
 * @author
 */
@Data
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private String identity;

}