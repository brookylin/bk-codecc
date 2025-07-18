/*
 * Tencent is pleased to support the open source community by making BK-CODECC 蓝鲸代码检查平台 available.
 *
 * Copyright (C) 2019 Tencent.  All rights reserved.
 *
 * BK-CODECC 蓝鲸代码检查平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.bk.codecc.task.dao.mongorepository;

import com.tencent.bk.codecc.task.model.BaseDataEntity;
import com.tencent.devops.common.api.BaseDataVO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 基础数据持久化接口
 *
 * @version V1.0
 * @date 2019/4/24
 */
@Repository
public interface BaseDataRepository extends MongoRepository<BaseDataEntity, ObjectId> {
    /**
     * 根据基础数据类型查询对应基础数据信息
     *
     * @param paramType
     * @return
     */
    BaseDataEntity findFirstByParamType(String paramType);

    /**
     * 根据基础数据类型查询全量基础数据信息
     *
     * @param paramType
     * @return
     */
    List<BaseDataEntity> findAllByParamType(String paramType);

    /**
     * 根据基础数据类型查询全量基础数据信息
     *
     * @param paramCode
     * @return
     */
    BaseDataEntity findFirstByParamCode(String paramCode);

    List<BaseDataEntity> findByParamCodeInAndParamType(List<String> paramCodeList, String paramType);

    /**
     * 根据参数类型查询信息
     *
     * @param paramTypes
     * @return
     */
    List<BaseDataEntity> findByParamTypeIn(List<String> paramTypes);

    /**
     * 根据参数类型和扩展字段查询信息
     *
     * @param paramTypes
     * @return
     */
    List<BaseDataEntity> findByParamTypeInOrderByParamExtend3(List<String> paramTypes);

    /**
     * 根据参数类型和参数代码查询信息
     *
     * @param paramType
     * @param paramCode
     * @return
     */
    List<BaseDataEntity> findAllByParamTypeAndParamCode(String paramType, String paramCode);

    /**
     * 根据参数类型，参数代码和参数值查询信息
     * @param paramType
     * @param paramCode
     * @param paramValue
     * @return
     */
    List<BaseDataEntity> findAllByParamTypeAndParamCodeAndParamValue(String paramType, String paramCode, String paramValue);

    /**
     * 根据参数类型和参数代码查询信息
     *
     * @param paramType
     * @param paramCode
     * @return
     */
    BaseDataEntity findFirstByParamTypeAndParamCode(String paramType, String paramCode);

    /**
     * 根据参数类型，参数代码和参数名称查询信息
     * @param paramType
     * @param paramCode
     * @param paramName
     * @return
     */
    BaseDataEntity findFirstByParamTypeAndParamCodeAndParamName(String paramType, String paramCode, String paramName);

    /**
     * 根据参数类型，参数代码和参数值查询信息
     *
     * @param preciCheckerSet
     * @param paramCode
     * @param paramValue
     * @return
     */
    BaseDataEntity findFirstByParamTypeAndParamCodeAndParamValue(String preciCheckerSet, String paramCode,
                                                                 String paramValue);

    /**
     * 根据参数类型，参数代码和参数值删除信息
     *
     * @param paramType
     * @paramparamValue
     * @return
     */

    BaseDataEntity findFirstByParamTypeAndParamValue(String paramType, String paramValue);

    /**
     * 根据参数类型查询參数值
     * @param paramType 参数类型
     * @return entity
     */
    @Query(fields = "{'param_value': 1}")
    List<BaseDataEntity> findParamValueByParamType(String paramType);

    /**
     * 根据实体id和参数类型获取指定实体对象
     *
     * @param entityId  实体id
     * @param paramType 参数类型
     * @return
     */
    BaseDataEntity findFirstByEntityIdAndParamType(String entityId, String paramType);

    void deleteByParamTypeAndParamName(String paramType, String paramName);

    /**
     * 根据实体id查询指定实体对象
     * @param entityId id
     * @return 实体对象
     */
    BaseDataEntity findByEntityId(String entityId);
}
