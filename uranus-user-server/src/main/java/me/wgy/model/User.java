package me.wgy.model;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * user
 *
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@Document(collection = "user")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private String identity;

}