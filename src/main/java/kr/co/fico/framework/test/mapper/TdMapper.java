package kr.co.fico.framework.test.mapper;

import java.util.List;

import kr.co.fico.framework.test.model.dto.SelectItembyUserNoParameter;
import kr.co.fico.framework.test.model.dto.SelectItembyUserNoResult;

import org.apache.ibatis.annotations.Mapper;

/**
 * TdMapper
 *
 * @since 2024.04.09
 * <pre>
 * Auto Generated Class by FICO Framework
 * PLEASE DO NOT MODIFY THIS FILE YOURSELF
 * </pre>
 */
@Mapper
public interface TdMapper {

    /**
     * 관심종목조회
     *
     * @author fico-admin
     */
    public List<SelectItembyUserNoResult> selectItembyUserNo(SelectItembyUserNoParameter param);

}
