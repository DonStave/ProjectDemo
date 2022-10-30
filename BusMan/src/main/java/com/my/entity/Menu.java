package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 *
 * 菜单
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Menu {
    private String id;
    private String resourceName;
    private String url;
    private String icon;
    private String pid;
    private String sort;
    private String identity;
    /**
     * 定义二级菜单
     */
    private List<Menu> menuList;
}
