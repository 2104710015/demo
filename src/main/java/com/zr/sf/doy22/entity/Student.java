package com.zr.sf.doy22.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author 隔壁_老陈
 * 代码风骚、效率恐怖、编译器深深鄙视智商。
 * 千里之外定位问题、瞬间修复依旧风骚……
 * @create 2023-07-13 10:13
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements  Serializable {
/**

*/
private  Integer     id ;

/**

*/
private  String    name ;

/**

*/
private  Integer     age ;


}
