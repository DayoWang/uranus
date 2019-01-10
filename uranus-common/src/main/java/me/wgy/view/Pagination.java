package me.wgy.view;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 分页对象
 *
 * @author wgy
 * @date 2019/1/10
 */
@Data
@AllArgsConstructor
public class Pagination<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 当前页号
   */
  private int pageNum;
  /**
   * 每页记录数
   */
  private int pageSize;
  /**
   * 总记录数
   */
  private long totalCount = 0;
  /**
   * 实体对象列表
   */
  private List<T> pageList;
}
