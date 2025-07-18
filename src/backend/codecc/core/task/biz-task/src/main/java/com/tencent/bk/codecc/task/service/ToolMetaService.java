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

package com.tencent.bk.codecc.task.service;

import com.tencent.bk.codecc.task.vo.gongfeng.ToolVersionExtVO;
import com.tencent.devops.common.api.BKToolBasicInfoVO;
import com.tencent.devops.common.api.RefreshDockerImageHashReqVO;
import com.tencent.devops.common.api.ToolMetaDetailVO;
import com.tencent.devops.common.constant.ComConstants;
import com.tencent.devops.common.constant.ComConstants.ToolIntegratedStatus;

import java.util.List;

/**
 * 工具元数据注册接口
 *
 * @version V1.0
 * @date 2019/4/25
 */
public interface ToolMetaService {
    /**
     * 蓝盾批量注册工具
     *
     * @param userName
     * @param toolMetaDetailVO
     * @return
     */
    ToolMetaDetailVO register(String userName, ToolMetaDetailVO toolMetaDetailVO);

    /**
     * 根据工具名查询工具元数据
     * @return
     */
    List<ToolMetaDetailVO> queryToolMetaDataList(String projectId, Long taskId);

    Boolean validateToolType(String toolType);

    Boolean validateLanguage(List<String> languages);

    ToolMetaDetailVO obtainToolMetaData(String toolName);

    /**
     * 刷新工具镜像版本
     *
     * @param refreshDockerImageHashReqVO
     */
    Boolean refreshDockerImageHash(RefreshDockerImageHashReqVO refreshDockerImageHashReqVO);

    String updateToolMetaToStatus(
            String toolName,
            String toolImageTag,
            ToolIntegratedStatus fromStatus,
            ToolIntegratedStatus toStatus,
            String username
    );

    String revertToolMetaStatus(String toolName, ComConstants.ToolIntegratedStatus status, String username);

    /**
     * 查询所有工具元数据
     * @return
     */
    List<ToolMetaDetailVO> queryAllToolMetaDataList();


    /**
     * 获取preci自动语言过滤器
     *
     * @return
     */
    String getSCCLangFilterForPreCI();

    /**
     * 获取工具基本信息 (for 蓝鲸插件开发者中心)
     *
     * @date 2024/10/9
     * @param toolName
     * @return com.tencent.devops.common.api.BKToolBasicInfoVO
     */
    BKToolBasicInfoVO getBKToolBasicInfo(String toolName);

    Boolean updateOpenSourceToolVersionInfo(ToolVersionExtVO reqVO, String userName);

    List<ToolMetaDetailVO> getToolsByPattern(String pattern);

    List<ToolMetaDetailVO> getToolsByType(String type);

    /**
     * 根据工具名称列表获取工具详情
     * @param toolNameList
     * @return
     */
    List<ToolMetaDetailVO> getToolsByToolName(List<String> toolNameList);

    /**
     * 根据 t_tool_meta 的 lang 字段解析出工具支持的语言(cloc lang name)列表
     *
     * @date 2024/10/9
     * @param langDigits
     * @return java.util.List<java.lang.String>
     */
    List<String> getLangNamesByLangDigits(Long langDigits);

}
