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

package com.tencent.bk.codecc.defect.service.impl;

import com.tencent.bk.codecc.defect.dao.defect.mongorepository.LintStatisticRepository;
import com.tencent.bk.codecc.defect.model.statistic.LintStatisticEntity;
import com.tencent.bk.codecc.defect.service.IQueryStatisticBizService;
import com.tencent.devops.common.api.analysisresult.BaseLastAnalysisResultVO;
import com.tencent.devops.common.api.analysisresult.LintLastAnalysisResultVO;
import com.tencent.devops.common.api.analysisresult.NotRepairedAuthorVO;
import com.tencent.devops.common.api.analysisresult.ToolLastAnalysisResultVO;
import com.tencent.devops.common.constant.ComConstants;
import com.tencent.devops.common.util.BeanUtils;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Lint类查询分析统计结果的业务逻辑类
 *
 * @version V1.0
 * @date 2019/6/8
 */
@Slf4j
@Service("LINTQueryStatisticBizService")
public class LintQueryStatisticBizServiceImpl implements IQueryStatisticBizService {

    @Autowired
    private LintStatisticRepository lintStatisticRepository;

    @Override
    public BaseLastAnalysisResultVO processBiz(ToolLastAnalysisResultVO arg, boolean isLast) {
        long taskId = arg.getTaskId();
        String toolName = arg.getToolName();
        String buildId = arg.getBuildId();

        LintStatisticEntity statisticEntity;
        if (isLast) {
            statisticEntity = lintStatisticRepository.findFirstByTaskIdAndToolNameOrderByTimeDesc(taskId, toolName);
        } else {
            statisticEntity = lintStatisticRepository.findFirstByTaskIdAndToolNameAndBuildId(taskId, toolName, buildId);
        }
        LintLastAnalysisResultVO lastAnalysisResultVO = new LintLastAnalysisResultVO();
        if (statisticEntity != null) {
            BeanUtils.copyProperties(statisticEntity, lastAnalysisResultVO);

            if (!CollectionUtils.isEmpty(statisticEntity.getAuthorStatistic())) {
                lastAnalysisResultVO.setAuthorStatistic(
                        statisticEntity.getAuthorStatistic().stream().map(source -> {
                            NotRepairedAuthorVO targetVO = new NotRepairedAuthorVO();
                            BeanUtils.copyProperties(source, targetVO);
                            return targetVO;
                        }).collect(Collectors.toList())
                );
            }

            if (!CollectionUtils.isEmpty(statisticEntity.getExistAuthorStatistic())) {
                lastAnalysisResultVO.setExistAuthorStatistic(
                        statisticEntity.getExistAuthorStatistic().stream().map(source -> {
                            NotRepairedAuthorVO targetVO = new NotRepairedAuthorVO();
                            BeanUtils.copyProperties(source, targetVO);
                            return targetVO;
                        }).collect(Collectors.toList())
                );
            }
        }

        lastAnalysisResultVO.setPattern(ComConstants.ToolPattern.LINT.name());

        return lastAnalysisResultVO;
    }
}
